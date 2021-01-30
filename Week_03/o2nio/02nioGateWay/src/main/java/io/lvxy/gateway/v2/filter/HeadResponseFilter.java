package io.lvxy.gateway.v2.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class HeadResponseFilter implements ReponseFilter{
    @Override
    public void filter(FullHttpResponse fullHttpResponse) {
        fullHttpResponse.headers().set("netty-nio-res","come on girls !");
    }
}
