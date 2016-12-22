package org.westbank.configuration.impl;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import org.westbank.configuration.Configuration;
import org.westbank.network.servlet.Servlet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jacob on 11/30/2016.
 */
public class NetworkConfiguration extends Configuration {

    public NetworkConfiguration() {
        this("network_configuration.xml");
    }

    public NetworkConfiguration(String file_name) {
        configuration_file = getConfigurationFile(file_name);
    }

    @Override
    public Object initialize() {

        System.out.println("initializing network config.");

        stream.alias("network_configuration", this.getClass());

        stream.processAnnotations(this.getClass());

        stream.processAnnotations(Servlet.class);

        return stream.fromXML(configuration_file);

    }

    @Override
    public Configuration configure() {
        configuration_variable_list = new ConcurrentHashMap<>();
        configuration_variable_list.putIfAbsent("network_address" , address);
        //configuration_variable_list.putIfAbsent("application_build", application_build);
        return this;
    }

    @XStreamImplicit(itemFieldName = "server")
    public List<Servlet> server = new LinkedList<>();

    @XStreamAsAttribute
    protected String address;

    public String getAddress() { return address; }

    public String get() {
        Map<String, Servlet> map = new ConcurrentHashMap<>();
        for(Servlet s : server) {
            map.put(s.getServletName(), s);
            System.out.println(map.get("worldserver").getAddress());
        }
        return Arrays.toString(server.toArray());
    }

}
