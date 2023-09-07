package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Owner("Soldatov")
@Layer("web")
@Epic("OASI")



public class OpenPageTests extends TestBase {

    @Test
    @Feature("LCS")
    @AllureId("12322")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка перехода в меню возможности")
    void goToActionsPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        //open("/app/lcs/constructor/main/#/app/forms/FORM_MAIN_PAGE");
        navigatorPage.goToOpportunities();
        navigatorPage.checkOpportunitiesTask();
    }

    @Test
    @Feature("CDP")
    @AllureId("8265")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка открытия меню Задачи")
    void openTheTasksPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        open("/app/lcs/constructor/main/#/app/forms/FORM_MAIN_PAGE");
        navigatorPage.goToTasks();
        //navigatorPage.checkUserTask(); //Не понятное поведение
    }

    @Test
    @Feature("CDP")
    @AllureId("12325")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка перехода в меню Реестр")
    void goToRegister() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        open("/app/lcs/constructor/main/#/app/forms/FORM_MAIN_PAGE");
        navigatorPage.goToSection("Реестры");
        navigatorPage.checkRegisterTask();
    }


    @Test
    @Feature("CDP")
    @AllureId("8262")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка открытия меню справочник")
    void openTheSpravochnikPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        open("/app/lcs/constructor/main/#/app/forms/FORM_MAIN_PAGE");
        navigatorPage
                .goToSpravochnik();
    }
}