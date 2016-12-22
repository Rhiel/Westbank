package org.westbank.configuration.impl;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import org.westbank.configuration.Configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jacob on 11/14/2016.
 */
public class ServerConfiguration extends Configuration {

    public ServerConfiguration() {
        this("server_configuration.xml");
    }

    public ServerConfiguration(String file_name) {
        configuration_file = getConfigurationFile(file_name);
    }

    @Override
    public Object initialize() {

        System.out.println("initializing");

        stream.alias("server_configuration", this.getClass());

        stream.processAnnotations(this.getClass());

        return stream.fromXML(configuration_file);

    }

    @Override
    public Configuration configure() {
        configuration_variable_list = new ConcurrentHashMap<>();
        configuration_variable_list.putIfAbsent("application_name" , application_name);
        configuration_variable_list.putIfAbsent("application_build", application_build);
        return this;
    }

    @XStreamAlias("application_name")
    protected String application_name;

    @XStreamAlias("application_build")
    protected double application_build;

    @XStreamImplicit(itemFieldName = "requisite")
    protected List<Object> application_prerequisites;

    public String getApplicationName() { return application_name; }

    public List getRequisites() {
        return application_prerequisites;
    }

}
