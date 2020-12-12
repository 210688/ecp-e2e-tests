package ru.mos.smart.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system.properties",
        "classpath:${environment}.properties"
})


public interface WebConfig extends Config {

    @Key("user.login.reestr")
    String login();

    @Key("user.pass.reestrs")
    String pass();

    @Key("user.login.process")
    String logins();

    @Key("user.pass.process")
    String password();
}