package org.westbank.configuration;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jacob on 11/14/2016.
 */
public abstract class Configuration {

    public Configuration() {
        stream.alias("configuration", this.getClass());
    }

    protected URL getConfigurationFile(String file_name) {
        URL file = null;
        try {
            file = this.getClass().getResource("/configuration/" + file_name);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public Object initialize() { return configure(); }

    public abstract Configuration configure();

    protected Map<String, Object> configuration_variable_list = new ConcurrentHashMap<>();

    public Map<String, Object> getConfigurationVariables() { return configuration_variable_list; }

    protected final XStream stream = new XStream();

    protected URL configuration_file;

}
