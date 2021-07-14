
package ru.mos.smart.tests;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.mos.smart.extensions.AllureAttachmentsAfterTestExecutionCallback;
import ru.mos.smart.pages.ActionsPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.pages.PersonalCard;
import ru.mos.smart.pages.ReestrPage;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static ru.mos.smart.helpers.DriverHelper.configureSelenide;


@ExtendWith(AllureAttachmentsAfterTestExecutionCallback.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    protected ReestrPage reestrPage = new ReestrPage();
    protected PersonalCard personalCard = new PersonalCard();
    protected NavigatorPage navigatorPage = new NavigatorPage();
    protected ActionsPage actionsPage = new ActionsPage();


    @BeforeAll
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        configureSelenide();
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}