package ru.mos.smart.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.mos.smart.helpers.CustomListener;
import ru.mos.smart.helpers.ScreenshotHelper;
import ru.mos.smart.pages.*;

import static ru.mos.smart.helpers.DriverSettings.configureSelenide;

@ExtendWith(CustomListener.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    public ReestrPage reestrPage = new ReestrPage();
    public TaskPage taskPage = new TaskPage();
    public PersonalCard personalCard = new PersonalCard();
    public NavigatorPage navigatorPage = new NavigatorPage();
    public ActionsPage actionsPage = new ActionsPage();
    public VriPage vriPage = new VriPage();
    public MkapmiiPage mkapmiiPage = new MkapmiiPage();
    public MkasdprvPage mkasdprvPage = new MkasdprvPage();
    public RinrifPage rinrifPage = new RinrifPage();
    public MapsPage mapsPage = new MapsPage();
    public UrlPage urlPage = new UrlPage();
    public EooPage eooPage = new EooPage();
    public HearingPage hearingPage = new HearingPage();
    public OasirxProjectsPage oasirxProjectsPage = new OasirxProjectsPage();
    public ScreenshotHelper screenshotHelper = new ScreenshotHelper();

    @BeforeAll
    static void beforeAll() {
        configureSelenide();
    }
}