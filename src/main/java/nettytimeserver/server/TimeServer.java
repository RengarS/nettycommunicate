package nettytimeserver.server;import io.netty.bootstrap.ServerBootstrap;import io.netty.channel.ChannelFuture;import io.netty.channel.ChannelInitializer;import io.netty.channel.ChannelOption;import io.netty.channel.EventLoopGroup;import io.netty.channel.nio.NioEventLoopGroup;import io.netty.channel.socket.SocketChannel;import io.netty.channel.socket.nio.NioServerSocketChannel;import nettytimeserver.utils.Const;/** * @author aries */public class TimeServer {    public void bind(int port) throws Exception {        EventLoopGroup bossGroup = new NioEventLoopGroup();        EventLoopGroup workGroup = new NioEventLoopGroup();        try {            ServerBootstrap bootstrap = new ServerBootstrap();            bootstrap.group(bossGroup, workGroup)                    .channel(NioServerSocketChannel.class)                    .option(ChannelOption.SO_BACKLOG, 1024)                    .childHandler(new ChildChannelHandler());            ChannelFuture future = bootstrap.bind(port).sync();            Const.serverChannel = future.channel();            future.channel().closeFuture().sync();        } finally {            bossGroup.shutdownGracefully();            workGroup.shutdownGracefully();        }    }    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {        @Override        protected void initChannel(SocketChannel socketChannel) throws Exception {            socketChannel.pipeline().addLast(new TimeServerHandler());        }    }    public static void main(String[] args) throws Exception {        int port = 8888;        new TimeServer().bind(port);    }}