package io.lvxy.gateway.v1.server.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //socketChannel.pipeline().addLast(new DiscardServerHandler());
        ChannelPipeline p = socketChannel.pipeline();
        p.addLast(new HttpServerCodec());
        //p.addLast(new HttpServerExpectContinueHandler());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        p.addLast(new DiscardServerHandler());
    }
}