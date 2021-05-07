
package ru.mos.smart.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.mos.smart.drivers.CustomWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;
import static ru.mos.smart.config.ConfigHelper.webConfig;


public class DriverHelper {

    public static void configureSelenide() {
        System.out.println(System.getProperty("tag"));
        Configuration.browser = CustomWebDriver.class.getName();
        Configuration.baseUrl = webConfig().webUrl();
        Configuration.timeout = 6000;
    }


    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid", "");
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}
