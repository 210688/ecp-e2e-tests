package ru.mos.smart.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:predprod.properties")
public interface WebDriverConfig extends Config {

    @Key("login.reestr")
    String username();

    @Key("password.reestrs")
    String password();
}
