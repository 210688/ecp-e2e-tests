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


    private static final Logger LOGGER = LoggerFactory.getLogger(DriverSettings.class);
    private static final String DEFAULT_USER_AGENT = "selenoid-SFT1T";


    public static void configureSelenide() {
        LOGGER.info("Environment: {}", projectConfig().environment());
        LOGGER.info("Threads: {}", projectConfig().threads());
        LOGGER.info("Remote driver url: {}", projectConfig().remoteDriverUrl());
        LOGGER.info("Base url: {}", getWebUrl());
        LOGGER.info("Browser name: {}", projectConfig().browserName());
        LOGGER.info("Browser version: {}", projectConfig().browserVersion());
        LOGGER.info("Browser size: {}", projectConfig().browserSize());
        LOGGER.info("User-Agent: {}", DEFAULT_USER_AGENT);

        Configuration.baseUrl = getWebUrl();
        Configuration.browser = projectConfig().browserName();
        Configuration.browserVersion = projectConfig().browserVersion();
        Configuration.browserSize = projectConfig().browserSize();
        Configuration.pageLoadTimeout = 120000;
        Configuration.remoteReadTimeout = 120000;
        Configuration.timeout = 10000;
        RestAssured.baseURI = getWebUrl();

        if (!projectConfig().remoteDriverUrl().equals("")) {
            //System.setProperty("webdriver.http.factory", "jdk");
            Configuration.remote = projectConfig().remoteDriverUrl();
        }
        switch (projectConfig().browserName()) {
            case "chrome":
                //ChromeOptions options = new ChromeOptions();
                var capabilities = new ChromeOptions();
                var selenoidOptions = Map.<String, Object>of("enableVNC", true);
                capabilities.setCapability("selenoid:options", selenoidOptions);
                capabilities
                        //.addArguments("--user-agent=" + DEFAULT_USER_AGENT);
                .setPageLoadStrategy(PageLoadStrategy.EAGER);
                Configuration.browserCapabilities = capabilities;

                break;
            case "firefox":
                var firefoxOptions = new FirefoxOptions();
                Configuration.browserCapabilities = firefoxOptions;
                break;
        }
    }
}



