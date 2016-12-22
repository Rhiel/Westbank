package org.westbank.network.servlet;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import io.netty.bootstrap.ServerBootstrap;

/**
 * Created by Jacob on 12/1/2016.
 */
public class Servlet extends ServerBootstrap {

    public Servlet(String servlet_name, String address) {
        this.address = address;
        this.servlet_name = servlet_name;
    }

    @XStreamAsAttribute
    private final String servlet_name;

    @XStreamAsAttribute
    private final String address;

    public String getAddress() { return address; }

    public String getServletName() { return servlet_name; }


}
