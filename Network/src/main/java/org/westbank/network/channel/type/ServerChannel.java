package org.westbank.network.channel.type;

import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.westbank.network.channel.ServletChannel;
import org.westbank.network.channel.status.ChannelStatus;


/**
 * Created by Jacob on 12/5/2016.
 */
public abstract class ServerChannel extends ServletChannel {

    public ServerChannel() {
        Channel channel = new NioServerSocketChannel();
    }

    @Override
    public ServletChannel initialize() {
        return null;
    }

    @Override
    public ServletChannel connect() {
        return null;
    }

    @Override
    public ChannelStatus status() {
        return null;
    }

    @Override
    public ServletChannel read() {
        return null;
    }


}
