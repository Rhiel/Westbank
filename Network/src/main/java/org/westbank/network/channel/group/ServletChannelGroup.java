package org.westbank.network.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutor;
import org.westbank.network.channel.group.list.ChannelGroupList;

import java.util.Map;

/**
 * Created by Jacob on 12/11/2016.
 */
public class ServletChannelGroup extends DefaultChannelGroup {

    public ServletChannelGroup(String group_name, EventExecutor executor) {
        super(group_name, executor);
        this.group_name = group_name;
    }

    /**
     * Creates a new {@link ChannelGroup} if there is one to create.
     * @return
     */
    public Map createChannelGroup() {
        return getChannelGroupList().add(getGroupName());
    }

    /**
     * Adds a {@link Channel} to the {@link ChannelGroup}.
     * @param channel_name
     * @param channel
     * @return
     */
    public boolean addChannel(String channel_name, Channel channel) {
        getChannelGroupList().add(channel_name, channel);
        return add(channel);
    }

    /**
     * Removes the {@link Channel} from the {@link ChannelGroup}.
     * @param channel_name
     * @return
     */
    public boolean removeChannel(String channel_name) {
        getChannelGroupList().remove(channel_name);
        return remove(getChannelGroupList().get(channel_name));
    }

    private String group_name;

    public String getGroupName() { return group_name; }

    public ChannelGroupList channel_group_list = new ChannelGroupList();

    public ChannelGroupList getChannelGroupList() { return channel_group_list; }

}
