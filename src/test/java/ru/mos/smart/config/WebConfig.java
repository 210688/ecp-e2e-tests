package ru.mos.smart.config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system.properties",
        "classpath:${env}.properties"
})


public interface WebConfig extends Config {

    @Key("user.login.reestr")
    String login();
    @Key("user.pass.reestrs")
    String pass();
}