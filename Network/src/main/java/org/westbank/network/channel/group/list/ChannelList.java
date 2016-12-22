package org.westbank.network.channel.group.list;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jacob on 12/9/2016.
 */
public abstract class ChannelList {

    public ChannelList() {

    }

    protected Map<String, Channel> channel_map = new ConcurrentHashMap<>();

    /**
     * Returns whether or not the {@link Map} contains the channel.
     * @param channel_name Defines the channel we are searching for.
     * @return
     */
    public boolean check(String channel_name) {
        return getChannelList().containsKey(channel_name);
    }

    /**
     * Adds the channel object to the {@link Map}.
     * @param channel_name The name of the channel.
     * @param channel The {@link Channel} object.
     * @return
     */
    public Channel add(String channel_name, Channel channel) {
        return getChannelList().putIfAbsent(channel_name, channel);
    }

    /**
     * Removes the {@link Channel} from the {@link Map}.
     * @param channel_name The defined {@link Channel} object.
     * @return
     */
    public Channel remove(String channel_name) {
        return getChannelList().remove(channel_name);
    }

    /**
     * Returns the {@link Channel} being searched.
     * @param channel_name The name of the channel.
     * @return
     */
    public Channel get(String channel_name) {
        for(Map.Entry identifier : getChannelList().entrySet()) {
            Object key = identifier.getKey();
            Object value = identifier.getValue();
            if(key == channel_name) return (Channel) value;
        }
        return null;
    }

    /**
     * Returns the {@link Map} of the channels.
     * @return
     */
    public Map<String, Channel> getChannelList() {
        return channel_map;
    }

}
