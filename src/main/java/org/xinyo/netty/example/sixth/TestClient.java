package org.xinyo.netty.example.sixth;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TestClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new TestClientInitializer());

            ChannelFuture future = bootstrap.connect("localhost", 8090).sync();
            future.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }
}
