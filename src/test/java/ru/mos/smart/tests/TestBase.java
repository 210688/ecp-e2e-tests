
package ru.mos.smart.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.mos.smart.helpers.CustomListener;
import ru.mos.smart.helpers.ExtendedListener;
import ru.mos.smart.pages.*;

import static ru.mos.smart.helpers.DriverSettings.configureSelenide;

@ExtendWith(CustomListener.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    public ReestrPage reestrPage = new ReestrPage();
    public PersonalCard personalCard = new PersonalCard();
    public NavigatorPage navigatorPage = new NavigatorPage();
    public ActionsPage actionsPage = new ActionsPage();
    public VriPage vriPage = new VriPage();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new ExtendedListener());
        configureSelenide();
    }
}