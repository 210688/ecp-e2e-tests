package ru.mos.smart.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.mos.smart.helpers.CustomListener;
import ru.mos.smart.pages.*;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.helpers.DriverSettings.configureSelenide;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationAPI;

@ExtendWith(CustomListener.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    public ReestrPage reestrPage = new ReestrPage();
    public TaskPage taskPage = new TaskPage();
    public SidebarPage sidebarPage = new SidebarPage();
    public ActionsPage actionsPage = new ActionsPage();
    public MkapmiiPage mkapmiiPage = new MkapmiiPage();
    public MkasdprvPage mkasdprvPage = new MkasdprvPage();
    public RinrifPage rinrifPage = new RinrifPage();
    public MapsPage mapsPage = new MapsPage();
    public Maps3DPage maps3DPage = new Maps3DPage();
    public OasirxPage oasirxPage = new OasirxPage();
    public DictPage dictPage = new DictPage();
    public NewUser newUser = new NewUser();
    public DronePage dronePage = new DronePage();
    public GeneralPage generalPage = new GeneralPage();

    public MydistrictPage mydistrictPage = new MydistrictPage();

    public UgdPage ugdPage = new UgdPage();
    public UserPage userPage = new UserPage();


    @BeforeAll
    static void beforeAll() {
        configureSelenide();
    }

    @BeforeEach
    void authorizeBeforeTest() {
        openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
    }
}
