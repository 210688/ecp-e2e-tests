package ru.mos.smart.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static ApiConfig getConfig() {
        return ConfigFactory.newInstance().create(ApiConfig.class, System.getProperties());
    }

    public static WebConfig webConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

    public static final WebConfig WEB_CONFIG = ConfigFactory.newInstance()
            .create(WebConfig.class, System.getProperties());

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

    public static String getLogin_services() {
        return getConfig().login_services();
    }

    public static String getPassword_services() {
        return getConfig().password_services();
    }

    public static String getEnoList() {
        return getConfig().enoList();
    }

    public static String getDateList() {
        return getConfig().dateList();
    }

    public static String getPguSystem() {
        return getConfig().pguSystem();
    }

    public static String getPguForText() {
        return getConfig().PguForText();
    }
}


