package ru.mos.smart.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.mos.smart.helpers.CustomListener;
import ru.mos.smart.pages.*;

import static ru.mos.smart.config.ConfigHelper.*;
import static ru.mos.smart.helpers.DriverSettings.configureSelenide;

@ExtendWith(CustomListener.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    public ReestrPage reestrPage = new ReestrPage();
    public TaskPage taskPage = new TaskPage();
    public SidebarPage sidebarPage = new SidebarPage();
    public ActionsPage actionsPage = new ActionsPage();
    public VriPage vriPage = new VriPage();
    public MkapmiiPage mkapmiiPage = new MkapmiiPage();
    public MkasdprvPage mkasdprvPage = new MkasdprvPage();
    public RinrifPage rinrifPage = new RinrifPage();
    public MapsPage mapsPage = new MapsPage();
    public UrlPage urlPage = new UrlPage();
    public OasirxProjectsPage oasirxProjectsPage = new OasirxProjectsPage();
    public DictsPage dictsPage = new DictsPage();

    @BeforeAll
    static void beforeAll() {
        configureSelenide();
    }

    @BeforeEach
    void authorizeBeforeTest() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
    }
}
//AuthorizationPage.openUrlWithAuthorizationUI(getWebSecureUrl(), getLoginRegress(), getPasswordRegress());
//* String login = getLoginRegress();
//String password = getPasswordRegress();
//AuthorizationPage.openUrlWithAuthorizationAPI(login, password);*//*
