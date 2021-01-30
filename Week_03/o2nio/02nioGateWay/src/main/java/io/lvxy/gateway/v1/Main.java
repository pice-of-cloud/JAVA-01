package io.lvxy.gateway.v1;

import io.lvxy.gateway.v1.server.netty.DiscardServer;

/**
 * curl http://localhost:8804/baidu
 */
public class Main {
    public static void main(String[] args) throws Exception {
        new DiscardServer().run(8804);

    }
}
