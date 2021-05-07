package ru.mos.smart.config;

import org.aeonbits.owner.Config;

//@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        //"system.properties",
        "classpath:${environment}.properties"
})
public interface WebConfig extends Config {
    @Key("web.url")
    String webUrl();

    @Key("user.login.process")
    String logins();

    @Key("user.pass.process")
    String password();

    @Key("user.login.regress")
    String login_regress();

    @Key("user.password.regress")
    String password_regress();

    @Key("user.login.sudir")
    String login_sudir();

    @Key("user.password.sudir")
    String password_sudir();

    @Key("browser.name")
    String getBrowserName();
}