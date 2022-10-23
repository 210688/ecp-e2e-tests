
package ru.mos.smart.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.mos.smart.helpers.AllureAttachments;
import ru.mos.smart.helpers.DriverUtils;
import ru.mos.smart.helpers.ExtendedListener;
import ru.mos.smart.pages.*;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static ru.mos.smart.helpers.DriverSettings.configureSelenide;


@ExtendWith({AllureJunit5.class})
public class TestBase {

    protected ReestrPage reestrPage = new ReestrPage();
    protected PersonalCard personalCard = new PersonalCard();
    public NavigatorPage navigatorPage = new NavigatorPage();
    protected ActionsPage actionsPage = new ActionsPage();
    protected  VriPage vriPage = new VriPage();





    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new ExtendedListener());
        configureSelenide();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();
        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();
        closeWebDriver();
    }
}