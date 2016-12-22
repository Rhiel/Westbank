package org.westbank.network.channel.group.list;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jacob on 12/9/2016.
 */
public class ChannelGroupList extends ChannelList {

    public ChannelGroupList() {

    }

    private Map<String, Map> grouped_channel_list = new ConcurrentHashMap<>();

    /**
     * Adds a new {@link java.util.Map.Entry} to the grouped channel list.
     * @param group_name
     * @return
     */
    public Map add(String group_name) {
        Map<Object, Object> channels = new ConcurrentHashMap<>();
        for(Map.Entry defined_channel : getChannelList().entrySet())
            channels.putIfAbsent(defined_channel.getKey(), defined_channel.getValue());
        return getGroupedChannelList().putIfAbsent(group_name, channels);
    }

    /**
     * Removes a desired {@link Channel} from the selected {@link Map}.
     * @param group_name The name of the channel group.
     * @param channel_name The name of the channel to be removed from the channel group.
     * @return
     */
    public boolean remove(String group_name, String channel_name) {
        if(check(channel_name)) remove(channel_name);
        for(Map.Entry grouped_channels : getGroupedChannelList().entrySet()) {
            if(grouped_channels.getKey() == group_name)
                return getGroupedChannelList().replace(group_name, (Map) grouped_channels.getValue(), getChannelList());
        }
        return false;
    }

    /**
     * Returns the grouped channel list.
     * @return
     */
    public Map<String, Map> getGroupedChannelList() {
        return grouped_channel_list;
    }

}
