package io.lvxy.gateway.v2.server;

import io.lvxy.gateway.v2.client.HttpClientTest;
import io.lvxy.gateway.v2.filter.HeadRequestFilter;
import io.lvxy.gateway.v2.filter.HeadResponseFilter;
import io.lvxy.gateway.v2.filter.RequestFilter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.ReferenceCountUtil;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HTTP;

import java.util.List;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;


public class InboundAdapter extends ChannelInboundHandlerAdapter {

    private final List<String> proxyServer;
    final private HeadResponseFilter headResponseFilter = new HeadResponseFilter();
    final private RequestFilter filter = new HeadRequestFilter();

    public InboundAdapter(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        //this.handler = new HttpOutboundHandler(this.proxyServer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            String uri = fullRequest.uri();

            if (uri.contains("/server01")) {
                handlerTest(fullRequest, ctx, proxyServer.get(0));
            }else{
                handlerTest(fullRequest, ctx, proxyServer.get(1));
            }

        }  finally {
            ctx.flush();
        }
    }


    private void handlerTest(FullHttpRequest fullRequest, ChannelHandlerContext ctx, String url) {
        FullHttpResponse response = null;
        try {
            String value = "";

            HttpClientTest httpClientTest = new HttpClientTest();
            HttpGet httpGet = new HttpGet(url);

            filter.filter(fullRequest, ctx);
            httpGet.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpGet.setHeader("netty-test",fullRequest.headers().get("netty-test"));
            value = httpClientTest.doGet(httpGet);

            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", response.content().readableBytes());
            headResponseFilter.filter(response);

        } catch (Exception e) {
            System.out.println("处理出错:"+e.getMessage());
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    response.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(response);
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 出现异常就关闭
        cause.printStackTrace();
        ctx.close();
    }

}
