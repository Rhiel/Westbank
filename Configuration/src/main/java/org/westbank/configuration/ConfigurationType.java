package org.westbank.configuration;

/**
 * Created by Jacob on 11/28/2016.
 */
public class ConfigurationType {

    public ConfigurationType(ConfigurationStatus configuration_status) {

        this.configuration_status = configuration_status;

    }

    private ConfigurationStatus configuration_status;

    public ConfigurationStatus getConfigurationStatus() { return configuration_status; }

    public ConfigurationStatus setConfigurationStatus(ConfigurationStatus status) { return configuration_status = status; }

}
