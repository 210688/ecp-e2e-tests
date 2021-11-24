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

    @Key("login.regress")
    String login_regress();

    @Key("password.regress")
    String password_regress();

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

    @Key("login.swagger")
    String loginSwagger();

    @Key("password.swagger")
    String passwordSwagger();

    @Key("user.login.oasirx")
    String loginOasirx();

    @Key("user.password.oasirx")
    String passwordOasirx();


}


