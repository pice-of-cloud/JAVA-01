package javaTest.nio.server.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {
	 public void run(int port) throws Exception {
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
				.childHandler(new ChildChannelHandler());
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
	    public static void main(String[] args) throws Exception {
	         new DiscardServer().run(8804);
	    } 
}
