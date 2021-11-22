package ru.mos.smart.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getAuthorizationURL() {
        return getConfig().authorizationUrl();
    }

    public static String getApplicationUrl() {
        return getConfig().applicationUrl();
    }

    public static String getWebUrl() {
        return getConfig().webUrl();
    }


    public static String getUsername() {
        return getConfig().username();
    }

    public static String getPassword() {
        return getConfig().password();
    }

    public static String getClientSecret() {
        return getConfig().clientSecret();
    }

    private static ApiConfig getConfig() {
        return ConfigFactory.newInstance().create(ApiConfig.class, System.getProperties());
    }

    public static WebConfig webConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}


