package ru.mos.smart.config;

import org.aeonbits.owner.Config;

//@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        //"system.properties",
        "classpath:${environment}.properties"
})


public interface WebConfig extends Config {

    @Key("user.login.tests")
    String login();

    @Key("user.password.tests")
    String passwords();

    @Key("user.login.process")
    String logins();

    @Key("user.pass.process")
    String password();
}