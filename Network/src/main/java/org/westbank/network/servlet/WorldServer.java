package org.westbank.network.servlet;

/**
 * Created by Jacob on 12/1/2016.
 */
public class WorldServer extends Servlet {

    public WorldServer(String address) {
        super("worldserver", "12345");
    }

    protected WorldServer g() {

        return this;
    }

}
