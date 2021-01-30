package io.lvxy.gateway.v2.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.ArrayList;
import java.util.List;

public class InboundServer {
	 public void run(int port) throws Exception {
	 		List<String> proxyServe = new ArrayList<>() ;
			proxyServe.add("http://localhost:8801");
			proxyServe.add("http://localhost:8802");

	        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
	        EventLoopGroup workerGroup = new NioEventLoopGroup(2);
	        System.out.println("netty准备运行端口：" + port);
	        try {
	            ServerBootstrap b = new ServerBootstrap();
				b.option(ChannelOption.SO_BACKLOG, 128)
						.option(ChannelOption.TCP_NODELAY, true)
						.option(ChannelOption.SO_KEEPALIVE, true)
						.option(ChannelOption.SO_REUSEADDR, true)
						.option(ChannelOption.SO_RCVBUF, 32 * 1024)
						.option(ChannelOption.SO_SNDBUF, 32 * 1024)
						.option(EpollChannelOption.SO_REUSEPORT, true)
						.childOption(ChannelOption.SO_KEEPALIVE, true)
						.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

				b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
				.childHandler(new InboundInitializer(proxyServe));
	            //绑定端口，同步等待成功
	            ChannelFuture f = b.bind(port).sync();
	            //等待服务监听端口关闭
	            f.channel().closeFuture().sync();
	        } finally {
	            //退出，释放线程资源
	            workerGroup.shutdownGracefully();
	            bossGroup.shutdownGracefully();
	        }
	    }

}
