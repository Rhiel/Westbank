package org.westbank.api.configuration.network;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.westbank.network.channel.group.ServletChannelGroup;

/**
 * Created by Jacob on 12/11/2016.
 */
public class ChannelAPI {

    public ChannelAPI() {
    }

    private ServletChannelGroup channel_group = new ServletChannelGroup("test");

    public void create() {

        ServerBootstrap bootstrap = new ServerBootstrap();

        EventLoopGroup group = new NioEventLoopGroup();

        channel_group.add("sloot", new NioServerSocketChannel());

        channel_group.createChannelGroup();

        System.out.println(channel_group.getChannelList().toString());
        System.out.println(channel_group.getGroupedChannelList().toString());
    }

}
