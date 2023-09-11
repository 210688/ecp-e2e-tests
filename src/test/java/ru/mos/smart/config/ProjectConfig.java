package ru.mos.smart.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties"})
public interface ProjectConfig extends Config {

    @Config.Key("environment")
    String environment();

    @Config.Key("remote.driver.url")
    @Config.DefaultValue("")
    //@Config.DefaultValue("http://10.15.58.218:8888/wd/hub")
    String remoteDriverUrl();

    @Config.Key("browser.name")
    @Config.DefaultValue("chrome")
    String browserName();

    @Config.Key("browser.version")
    //@Config.DefaultValue("")
    String browserVersion();

    @Config.Key("browser.size")
    @Config.DefaultValue("1280x1024")
    String browserSize();

    @Config.Key("threads")
    @DefaultValue("1")
    Integer threads();
}
