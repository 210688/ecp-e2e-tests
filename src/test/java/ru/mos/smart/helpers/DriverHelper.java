package ru.mos.smart.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.mos.smart.drivers.CustomWebDriver;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.logging.LogType.BROWSER;
import static ru.mos.smart.helpers.EnvironmentHelper.webUrl;


public class DriverHelper {

    public static void configureSelenide() {
        Configuration.browser = CustomWebDriver.class.getName();
//        Configuration.browser = FIREFOX;
//        Configuration.browser = OPERA;
        Configuration.baseUrl = webUrl;
        Configuration.timeout = 10000;
    }


    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid","");
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}