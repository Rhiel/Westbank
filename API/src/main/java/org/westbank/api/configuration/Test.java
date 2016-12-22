package org.westbank.api.configuration;

import org.westbank.api.APIBootstrap;

/**
 * Created by jacob on 11/15/2016.
 */
public class Test {

    public static void main(String[] args) {

        APIBootstrap api_bootstrap = new APIBootstrap();

        api_bootstrap.getConfigurationAPI().populate();

        api_bootstrap.getConfigurationAPI().getServerConfiguration().configure();

        api_bootstrap.getConfigurationAPI().getNetworkConfiguration().configure();

        System.out.println(api_bootstrap.getConfigurationAPI().getNetworkConfiguration().get());

        api_bootstrap.getChannelAPI().create();

        //System.out.println(api_bootstrap.getConfigurationAPI().hierarchy("server.application_name"));

        //System.out.println("Test:" + api_bootstrap.getConfigurationAPI().getConfiguration("server").getConfigurationVariable("application_name"));

       // System.out.println(api_bootstrap.getConfigurationAPI().getServerConfiguration().getApplicationName());


    }

}
