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

    @Key("user.login.process")
    String logins();

    @Key("user.pass.process")
    String password();

    @Key("user.login.sudir")
    String login_sudir();

    @Key("user.password.sudir")
    String password_sudir();

    @Key("user.login.drone")
    String loginDrone();

    @Key("user.password.drone")
    String passwordDrone();

    @Key("user.login.ugd")
    String loginUgd();

    @Key("user.password.ugd")
    String passwordUgd();

    @Key("user.login.oasirx")
    String loginOasirx();

    @Key("user.password.oasirx")
    String passwordOasirx();

    @Key("user.login.mr")
    String loginMr();

    @Key("user.password.mr")
    String passwordMr();

    @Key("login.api")
    String loginApi();

    @Key("password.api")
    String passwordApi();

    @Key("login.regress")
    String loginRegress();

    @Key("password.regress")
    String passwordRegress();

    @Key("login.geoserver")
    String loginGeoserver();

    @Key("password.geoserver")
    String passwordGeoserver();
}


