package ru.mos.smart.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static WebConfig webConfig() {
        if (System.getProperty("environment") == null) System.setProperty("environment", "predprod"); // prod, preprod

        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}


