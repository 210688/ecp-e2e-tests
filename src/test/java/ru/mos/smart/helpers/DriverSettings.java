package ru.mos.smart.helpers;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ru.mos.smart.config.ConfigHelper.getWebUrl;
import static ru.mos.smart.config.ConfigHelper.projectConfig;

public class DriverSettings {


    private static final Logger LOG = LoggerFactory.getLogger("Config properties");
    static String userAgentValue = "selenoid-SFT1T";


    public static void configureSelenide() {
        //LoggingPreferences logging = new LoggingPreferences();
        //logging.enable(String.valueOf(BROWSER), Level.ALL);
        //logging.enable(String.valueOf(LogType.PERFORMANCE), Level.ALL);  // Включаем логирование сетевых запросов
        LOG.info("Environment: {}", projectConfig().environment());
        LOG.info("Threads: {}", projectConfig().threads());
        LOG.info("Remote driver url: {}", projectConfig().remoteDriverUrl());
        LOG.info("Base url: {}", getWebUrl());
        LOG.info("Browser name: {}", projectConfig().browserName());
        LOG.info("Browser version: {}", projectConfig().browserVersion());
        LOG.info("Browser size: {}", projectConfig().browserSize());
        LOG.info("User-Agent: {}", userAgentValue);

        Configuration.baseUrl = getWebUrl();
        Configuration.browser = projectConfig().browserName();
        Configuration.browserVersion = projectConfig().browserVersion();
        Configuration.browserSize = projectConfig().browserSize();
        Configuration.pageLoadTimeout = 120000;
        Configuration.timeout = 10000;
        RestAssured.baseURI = getWebUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (!projectConfig().remoteDriverUrl().equals("")) {
            capabilities.setCapability("enableVNC", true);
            Configuration.remote = projectConfig().remoteDriverUrl();
        }

        switch (projectConfig().browserName()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                break;
        }
        LOG.info("Browser capabilities: {}", capabilities);
        Configuration.browserCapabilities = capabilities;
    }
}

