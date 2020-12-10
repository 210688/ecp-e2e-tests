package ru.mos.smart.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:predprod.properties")
public interface WebDriverConfig extends Config {

    @Key("login.reestr") //учетка для тестов с реестрами
    String username();

    @Key("password.reestrs") //учетка для тестов с реестрами
    String password();

    @Key("login.zadachi") //учетка для тестов с реестрами
    String users();

    @Key("password.zadachi") //учетка для тестов с реестрами
    String pass();
}
