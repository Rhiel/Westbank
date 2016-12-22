package org.westbank.api;

import org.westbank.api.configuration.ConfigurationAPI;
import org.westbank.api.configuration.network.ChannelAPI;
import org.westbank.configuration.impl.ServerConfiguration;

/**
 * Created by jacob on 11/15/2016.
 */
public class APIBootstrap {

    public APIBootstrap() {

        //TODO: Change ASAP


    }

    private final RequisiteAPI requisite_api = new RequisiteAPI();

    private final ConfigurationAPI configuration_api = new ConfigurationAPI();

    public ConfigurationAPI getConfigurationAPI() { return configuration_api; }

    public RequisiteAPI getRequisiteAPI() { return requisite_api; }

    public ChannelAPI channel_api = new ChannelAPI();

    public ChannelAPI getChannelAPI() { return channel_api; }

}
