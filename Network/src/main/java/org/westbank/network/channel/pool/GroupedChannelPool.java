package org.westbank.network.channel.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.pool.AbstractChannelPoolMap;
import io.netty.channel.pool.ChannelPoolHandler;
import io.netty.channel.pool.ChannelPoolMap;
import io.netty.channel.pool.SimpleChannelPool;

import java.net.InetSocketAddress;

/**
 * Created by Jacob on 12/22/2016.
 */
public class GroupedChannelPool extends SimpleChannelPool {

    public GroupedChannelPool(Bootstrap bootstrap, ChannelPoolHandler handler) {
        super(bootstrap, handler);
        this.bootstrap = bootstrap;
        this.pool_handler = handler;
    }

    protected ChannelPoolMap<InetSocketAddress, SimpleChannelPool> channel_pool_map = new AbstractChannelPoolMap<InetSocketAddress, SimpleChannelPool>() {
        @Override
        protected SimpleChannelPool newPool(InetSocketAddress inetSocketAddress) {
            return new SimpleChannelPool(getBootstrap().remoteAddress(inetSocketAddress), getChannelPoolHandler());
        }
    };

    private final Bootstrap bootstrap;

    private final ChannelPoolHandler pool_handler;

    protected Bootstrap getBootstrap() {
        return bootstrap;
    }

    protected ChannelPoolHandler getChannelPoolHandler() { return pool_handler; }

}
