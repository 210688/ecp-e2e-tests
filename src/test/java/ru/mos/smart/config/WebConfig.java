package ru.mos.smart.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:/opt/platform/config/${environment}.properties",
        "file:f:/Java_prj/prs/config/${environment}.properties"

})
public interface WebConfig extends Config {
    @Key("web.url")
    String webUrl();
    @Key("web.secure.url")
    String webSecureUrl();
    @Key("user.login.sudir")
    String login_sudir();
    @Key("user.password.sudir")
    String password_sudir();
    @Key("login.regress")
    String loginRegress();
    @Key("password.regress")
    String passwordRegress();
    @Key("login.geoserver")
    String loginGeoserver();
    @Key("password.geoserver")
    String passwordGeoserver();
}


