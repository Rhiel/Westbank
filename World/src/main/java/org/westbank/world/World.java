package org.westbank.world;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Created by Jacob on 11/30/2016.
 */
public abstract class World {

    public World() {

    }

    public World(int world_id, String world_address, WorldStatus world_status) {
        this.world_id = world_id;
        this.world_address = world_address;
        this.world_status = world_status;
    }

    @XStreamAlias("world_id")
    private int world_id;

    @XStreamAlias("world_address")
    private String world_address;

    @XStreamAlias("world_status")
    private WorldStatus world_status;

    public int getWorldID() {
        return world_id;
    }

    public String getWorldAddress() {
        return world_address;
    }

    public WorldStatus getWorldStatus() {
        return world_status;
    }

}