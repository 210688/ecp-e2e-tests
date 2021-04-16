package ru.mos.smart.config;

import org.aeonbits.owner.Config;

//@Config.LoadPolicy(Config.LoadType.MERGE)/
@Config.Sources({
        //"system.properties",
        "classpath:${environment}.properties",
        "classpath:config/predprod.properties",
        "classpath:resources/predprod.properties",
        "src/test/resources/predprod.properties"
})
/**
 * Конфиг с учётными записями для авторизации
 */

public interface WebConfig extends Config {

    @Key("web.url")
    String webUrl();

    /**
     * Учетная запись для регрессионного тестирования
     */
    @Key("user.login.regress")
    String login_regress();

    @Key("user.password.regress")
    String password_regress();

    /**
     * Учетная запись для СУДИР
     */
    @Key("user.login.sudir")
    String login_sudir();

    @Key("user.password.sudir")
    String password_sudir();

    /**
     * Учетная запись для подсистем
     */
    @Key("user.login.podsistem")
    String login_podsistem();

    @Key("user.password.podsistem")
    String password_podsistem();
}