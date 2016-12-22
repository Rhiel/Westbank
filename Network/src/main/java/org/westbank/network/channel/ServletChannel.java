package org.westbank.network.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.pool.ChannelPool;
import org.westbank.network.channel.status.ChannelStatus;

/**
 * Created by Jacob on 12/5/2016.
 */
public abstract class ServletChannel implements Channel {

    /**
     * Default constructor.
     * @throws ChannelException
     */
    public ServletChannel() throws ChannelException {

    }

    public abstract ServletChannel initialize();

    public abstract ServletChannel connect();

    public abstract ChannelStatus status();

    ChannelPool t;

    public abstract ServletChannel read();

}
