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

    @Key("user.login.tests")  // учётка для регрессионных тестов
    String login();

    @Key("user.password.tests") // учётка для регрессионных тестов
    String passwords();

    @Key("user.login.process")
    String logins();

    @Key("user.pass.process")
    String password();

    @Key("user.login.podsistem") // учётка для тестов по подсистемам
    String login_();

    @Key("user.pass.podsistem")
    String password_(); // учётка для тестов по подсистемам
}