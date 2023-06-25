package ru.mos.smart.helpers;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
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

        //DesiredCapabilities capabilities = new DesiredCapabilities();
        if (!projectConfig().remoteDriverUrl().equals("")) {
            Configuration.remote = projectConfig().remoteDriverUrl();
            Configuration.browserCapabilities.setCapability("enableVNC", true);
        }

        switch (projectConfig().browserName()) {
            case "chrome":
                Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions()
                        .addArguments("--user-agent=" + userAgentValue)
                        .setPageLoadStrategy(PageLoadStrategy.EAGER));
                //Configuration.browserCapabilities.setCapability("goog:loggingPrefs", logging);
                break;
            case "firefox":
                Configuration.browserCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, new FirefoxOptions());
                break;
        }
    }
}

