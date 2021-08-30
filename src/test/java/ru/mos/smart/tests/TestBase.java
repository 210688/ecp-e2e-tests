
package ru.mos.smart.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.mos.smart.api.mkapmii.Mkapmii;
import ru.mos.smart.extensions.AllureAttachmentsAfterTestExecutionCallback;
import ru.mos.smart.helpers.ExtendedListener;
import ru.mos.smart.pages.*;

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
    protected VriPage vriPage = new VriPage();
    protected Faker faker = new Faker();
    protected Mkapmii mkapmii = new Mkapmii();


    @BeforeAll
    public static void beforeAll() {
        addListener("AllureSelenide", new ExtendedListener());
        configureSelenide();
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}