package ru.mos.smart.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:/opt/platform/config/${environment}.properties",
        "file:f:/Java_prj/prs/config/${environment}.properties",
        "file:c:/Java_prj/config/${environment}.properties"

})
public interface AppConfig extends Config {
    @Key("authorization.url")
    String authorizationUrl();

    @Key("application.url")
    String applicationUrl();

    @Key("web.url")
    String webUrl();

    @Key("client.secret")
    String clientSecret();

    @Key("login_services")
    String login_services();

    @Key("password_services")
    String password_services();

    @Key("eno.list")
    String enoList();

    @Key("date.list")
    String dateList();

    @Key("pgu.text")
    String PguForText();

    @Key("pgu.system")
    String pguSystem();
}