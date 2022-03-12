package ru.mos.smart.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:/opt/platform/config/${environment}.properties"
        //"file:f:\\Java_prj\\prs\\config"

})
public interface ApiConfig extends Config {
    @Key("authorization.url")
    String authorizationUrl();

    @Key("application.url")
    String applicationUrl();

    @Key("web.url")
    String webUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("client.secret")
    String clientSecret();
}