package ru.mos.smart.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static WebConfig user() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}


