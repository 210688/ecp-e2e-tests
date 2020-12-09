package ru.mos.smart.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getUsername() {
        return getConfig().username();
    }

    public static String getPassword() {
        return getConfig().password();
    }

    public static String getPas() {
        return getConfig().pass();
    }

    public static String getUsers() {
        return getConfig().users();
    }
    private static WebDriverConfig getConfig() {
        return ConfigFactory.newInstance().create(WebDriverConfig.class, System.getProperties());
    }
}
