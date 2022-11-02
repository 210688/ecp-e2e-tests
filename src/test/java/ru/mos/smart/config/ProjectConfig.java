package ru.mos.smart.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties"})
public interface ProjectConfig extends Config {

    @Config.Key("remote.driver.url")
    @Config.DefaultValue("")
    String remoteDriverUrl();

    @Config.Key("browser.name")
    @Config.DefaultValue("chrome")
    String browserName();

    @Config.Key("browser.version")
    @Config.DefaultValue("96.0")
    String browserVersion();

    @Config.Key("browser.size")
    @Config.DefaultValue("1280x1024")
    String browserSize();

    @Config.Key("threads")
    String threads();
}
