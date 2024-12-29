package com.i2i.datadito.hazelcast.configurations;

import com.hazelcast.client.config.ClientConfig;
import com.i2i.datadito.hazelcast.constants.StringConstants;

public class Configuration {
    public static ClientConfig getConfig(){
        ClientConfig config = new ClientConfig();
        config.setProperty("hazelcast.logging.type","slf4j");
        config.getNetworkConfig().addAddress(StringConstants.hazelcastUrl);
        return config;
    }
}
