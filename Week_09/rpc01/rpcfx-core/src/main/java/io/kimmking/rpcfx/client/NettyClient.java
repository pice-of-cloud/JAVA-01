package io.kimmking.rpcfx.client;

import io.netty.bootstrap.Bootstrap;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class NettyClient {
    private ClientHandler clientHandler = new ClientHandler();
    private String url;
    private String requestBody;
    private URI uri;
    private Bootstrap b = new Bootstrap();
    private Channel channel;
    private EventLoopGroup loopGroup = new NioEventLoopGroup();

    public NettyClient(String requestBody, String url) {
        this.url = url;
        this.requestBody = requestBody;
    }

    public void connect() throws Exception {
        uri = new URI(url);
        b.group(loopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new HttpRequestEncoder())
                                .addLast(new HttpResponseDecoder())
                                .addLast(clientHandler);
                    }
                });
        channel = b.connect(uri.getHost(), uri.getPort() < 0 ? 80 : uri.getPort()).sync().channel();
        while (!channel.isActive()) {
            Thread.sleep(1000);
        }
    }

    public String getBody() throws Exception {
        FullHttpRequest request = new DefaultFullHttpRequest(
                HttpVersion.HTTP_1_1, HttpMethod.POST, uri.getRawPath());

        request.headers().set(HttpHeaders.Names.HOST, uri.getHost());
        request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE); // or HttpHeaders.Values.CLOSE
        request.headers().set(HttpHeaders.Names.ACCEPT_ENCODING, HttpHeaders.Values.GZIP);
        request.headers().add(HttpHeaders.Names.CONTENT_TYPE, "application/json");
        ByteBuf bbuf = Unpooled.copiedBuffer(requestBody, StandardCharsets.UTF_8);
        request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, bbuf.readableBytes());
        request.content().clear().writeBytes(bbuf);

        ChannelPromise promise = clientHandler.sendMessage(request);
        promise.await();
        return clientHandler.getData();
    }

    /**
     * 客户端关闭
     */
    public void close() {
        //关闭客户端套接字
        if (channel != null) {
            channel.close();
        }
        //关闭客户端线程组
        if (loopGroup != null) {
            loopGroup.shutdownGracefully();
        }
    }

}

class ClientHandler extends ChannelInboundHandlerAdapter {
    private ChannelHandlerContext ctx;
    private ChannelPromise promise;
    private String data;
    private long readByte;
    private long contentLength;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        this.ctx = ctx;
    }

    public ChannelPromise sendMessage(Object message) {
        if (ctx == null)
            throw new IllegalStateException();
        promise = ctx.writeAndFlush(message).channel().newPromise();
        return promise;
    }

    public String getData() {
        return data;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            data = content.content().toString(CharsetUtil.UTF_8);
            promise.setSuccess();
        }
    }
}