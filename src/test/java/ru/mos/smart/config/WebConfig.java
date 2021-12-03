package ru.mos.smart.config;

import org.aeonbits.owner.Config;

//@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        //"system.properties",
        "classpath:config/${environment}.properties"
})
public interface WebConfig extends Config {
    @Key("web.url")
    String webUrl();

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

    @Key("login.api")
    String loginApi();

    @Key("password.api")
    String passwordApi();

    @Key("login.regress")
    String loginRegress();

    @Key("password.regress")
    String passwordRegress();
}


