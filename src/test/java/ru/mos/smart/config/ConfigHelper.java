package ru.mos.smart.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static AppConfig appConfig() {
        return ConfigFactory.newInstance().create(AppConfig.class, System.getProperties());
    }

    public static WebConfig webConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

    public static String getWebUrl() {
        return webConfig().webUrl();
    }

    public static String getWebSecureUrl() {
        return webConfig().webSecureUrl();
    }

    public static String getAuthorizationURL() {
        return appConfig().authorizationUrl();
    }

    public static String getApplicationUrl() {
        return appConfig().applicationUrl();
    }

    public static String getClientSecret() {
        return appConfig().clientSecret();
    }

    public static String getLoginRegress() {
        return webConfig().loginRegress();
    }

    public static String getPasswordRegress() {
        return webConfig().passwordRegress();
    }

    public static String getLoginGeoserver() {
        return webConfig().loginGeoserver();
    }

    public static String getPasswordGeoserver() {
        return webConfig().passwordGeoserver();
    }

    public static String getLoginServices() {
        return appConfig().login_services();
    }

    public static String getPasswordServices() {
        return appConfig().password_services();
    }


    public static String getEnoList() {
        return appConfig().enoList();
    }

    public static String getDateList() {
        return appConfig().dateList();
    }

    public static String getPguSystem() {
        return appConfig().pguSystem();
    }

    public static String getPguForText() {
        return appConfig().PguForText();
    }

    public static ProjectConfig projectConfig() {
        return ConfigFactory.newInstance()
                .create(ProjectConfig.class, System.getProperties());
    }

}


