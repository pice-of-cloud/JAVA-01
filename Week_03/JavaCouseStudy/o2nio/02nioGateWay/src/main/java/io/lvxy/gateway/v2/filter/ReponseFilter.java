package io.lvxy.gateway.v2.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface ReponseFilter {
    void filter(FullHttpResponse fullHttpResponse);
}
