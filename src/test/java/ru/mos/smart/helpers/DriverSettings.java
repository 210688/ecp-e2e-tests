package ru.mos.smart.helpers;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static ru.mos.smart.config.ConfigHelper.getWebUrl;
import static ru.mos.smart.config.ConfigHelper.projectConfig;

public class DriverSettings {


    private static final Logger LOG = LoggerFactory.getLogger(DriverSettings.class);
    private static final String DEFAULT_USER_AGENT = "selenoid-SFT1T";


    public static void configureSelenide() {
        LOG.info("Environment: {}", projectConfig().environment());
        LOG.info("Threads: {}", projectConfig().threads());
        LOG.info("Remote driver url: {}", projectConfig().remoteDriverUrl());
        LOG.info("Base url: {}", getWebUrl());
        LOG.info("Browser name: {}", projectConfig().browserName());
        LOG.info("Browser version: {}", projectConfig().browserVersion());
        LOG.info("Browser size: {}", projectConfig().browserSize());
        LOG.info("User-Agent: {}", DEFAULT_USER_AGENT);

        Configuration.baseUrl = getWebUrl();
        //Configuration.browser = projectConfig().browserName();
        //Configuration.browserVersion = projectConfig().browserVersion();
        Configuration.browserSize = projectConfig().browserSize();
        Configuration.pageLoadTimeout = 60000;
        Configuration.remoteReadTimeout = 120000;
        Configuration.timeout = 10000;
        RestAssured.baseURI = getWebUrl();

        if (!projectConfig().remoteDriverUrl().equals("")) {
            Configuration.remote = projectConfig().remoteDriverUrl();
        }
        switch (projectConfig().browserName()) {
            case "chrome":
                Configuration.browser = projectConfig().browserName();
                Configuration.browserVersion = projectConfig().browserVersion();
                var capabilities = new ChromeOptions();
                var selenoidOptions = Map.<String, Object>of("enableVNC", true);
                capabilities.setCapability("selenoid:options", selenoidOptions);
                capabilities
                        //.addArguments("--user-agent=" + DEFAULT_USER_AGENT);
                .setPageLoadStrategy(PageLoadStrategy.EAGER);
                LOG.info("Browser options: {}", capabilities);
                Configuration.browserCapabilities = capabilities;
                break;
            case "firefox":
                Configuration.browser = projectConfig().browserName();
                Configuration.browserVersion = projectConfig().browserVersion();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                LOG.info("Browser options: {}", firefoxOptions);
                Configuration.browserCapabilities = firefoxOptions;
                break;
        }
    }
}



