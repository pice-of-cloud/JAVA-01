package io.lvxy.gateway.v2;

import io.lvxy.gateway.v1.server.netty.DiscardServer;
import io.lvxy.gateway.v2.server.InboundServer;

/**
 * curl http://localhost:8804/server01
 * curl http://localhost:8804/server02
 */
public class NettyMain {
    public static void main(String[] args) throws Exception {
        new InboundServer().run(8804);

    }
}
