package org.westbank.api.configuration;

import org.westbank.configuration.Configuration;
import org.westbank.configuration.ConfigurationStatus;
import org.westbank.configuration.impl.NetworkConfiguration;
import org.westbank.configuration.impl.ServerConfiguration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jacob on 11/15/2016.
 */
public class ConfigurationAPI {

    public ConfigurationAPI() {

    }

    /**
     * Populates the configuration_list. TODO: Temporary?
     * @return {@link ConfigurationAPI}.
     */
    public ConfigurationAPI populate() {
        addConfiguration("server",  server_configuration);
        addConfiguration("network", network_configuration);
        return this;
    }

    /**
     * Adds a {@link Configuration} type to the configurations list.
     * @param configuration_ctx
     * @param configuration
     * @return
     */
    public Configuration addConfiguration(String configuration_ctx, Configuration configuration) {
        return configuration_list.putIfAbsent(configuration_ctx, configuration);
    }

    /**
     * Returns the {@link Configuration} type.
     * @param configuration_ctx
     * @return {@link Configuration} type.
     */
    public ConfigurationAPI getConfiguration(String configuration_ctx) {
        this.configuration_ctx  = configuration_ctx;
        this.configuration_type = getConfigurationClass(configuration_ctx);
        return this;
    }

    /**
     * Returns the {@link Configuration} object.
     * @param configuration_ctx
     * @return {@link Configuration} object.
     */
    private Configuration getConfigurationClass(String configuration_ctx) {
        for(Map.Entry configuration : configuration_list.entrySet()) {
            Configuration config = (Configuration) configuration.getValue();
            if (configuration.getKey().equals(configuration_ctx)) return config;
        }
        return null;
    }

    /**
     * Returns a variable from the {@link Configuration}.
     * @param argument
     * @return {@link Configuration} variable.
     */
    public Object getConfigurationVariable(String argument) {
        for(Map.Entry variable : configuration_type.getConfigurationVariables().entrySet())
            if (variable.getKey().equals(argument)) return variable;
        return null;
    }

    /**
     * Sets a variable to the given {@link Configuration}.
     * @param configuration
     * @param variable
     * @return the updated variable.
     */
    public Object setConfigurationVariable(String configuration, Object variable) {
        for(Map.Entry var : configuration_type.getConfigurationVariables().entrySet())
            if(var.getKey().equals(configuration))
                return configuration_type.getConfigurationVariables().replace(configuration, var.getValue(), variable);
        return null;
    }

    /**
     * Parses through a given {@link String} to gather the variable from the {@link Configuration} object in one {@link String}.
     * @param hierarchy
     * @return The given variable from the {@link Configuration} object.
     */
    public Object hierarchy(String hierarchy) {
        StringBuilder builder  = new StringBuilder(hierarchy);
        String first_index     = builder.substring(0, builder.indexOf("."));
        String secondary_index = builder.substring(builder.indexOf(".") + 1);
        if(secondary_index != null) return getConfiguration(first_index).getConfigurationVariable(secondary_index);
        else return getConfiguration(first_index);
    }

    public Object setConfigurationStatus(ConfigurationStatus status) {
        return null;
    }

    private String configuration_ctx;

    private Configuration configuration_type;

    private final Map<String, Configuration> configuration_list = new ConcurrentHashMap<>();

    private final ServerConfiguration server_configuration = (ServerConfiguration) new ServerConfiguration().initialize();

    private final NetworkConfiguration network_configuration = (NetworkConfiguration) new NetworkConfiguration().initialize();

    protected ServerConfiguration getServerConfiguration() { return server_configuration; }

    protected NetworkConfiguration getNetworkConfiguration() { return network_configuration; }

}
