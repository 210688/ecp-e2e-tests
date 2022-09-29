package ru.mos.smart.helpers;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import ru.mos.smart.drivers.CustomWebDriver;

import static ru.mos.smart.config.ConfigHelper.webConfig;

public class DriverSettings {

    public static void configureSelenide() {
        System.out.println(System.getProperty("tag"));
        Configuration.browser = CustomWebDriver.class.getName();
        Configuration.baseUrl = webConfig().webUrl();
        RestAssured.baseURI = webConfig().webUrl();
        Configuration.timeout = 10000;
    }
}
