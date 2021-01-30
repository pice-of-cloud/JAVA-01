package io.lvxy.gateway.v2.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class HeadRequestFilter implements RequestFilter{
    @Override
    public void filter(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx) {
        fullHttpRequest.headers().set("netty-test","v2");
        ctx.writeAndFlush(fullHttpRequest);
    }
}
