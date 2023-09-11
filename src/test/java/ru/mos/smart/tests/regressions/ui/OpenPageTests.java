package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.Sidebar.*;

@Owner("Soldatov")
@Layer("web")
@Epic("OASI")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class OpenPageTests extends TestBase {

    @Test
    @AllureId("12322")
<<<<<<< HEAD
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка перехода в меню возможности")
    @Description("Проверить, что открывается меню возможности")
=======
    @Feature("LCS")
    @Description("Наличие списка возможностей на странице Возможности")
    @DisplayName("В возможностях пользователя присутствует список возможностей")
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void goToActionsPage() {
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, ACTIONS);
        actionsPage.checkActionsTask();
    }

    @Test
    @AllureId("8265")
<<<<<<< HEAD
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка открытия меню Задачи")
    @Description("Проверить, что открывается меню - Задачи")
    void openTheTasksPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        open("/app/lcs/constructor/main/#/app/forms/FORM_MAIN_PAGE");
        navigatorPage.goToTasks();
        //navigatorPage.checkUserTask(); //Не понятное поведение
=======
    @Feature("CDP")
    @Description("Наличие списка задач пользователя на странице Задачи")
    @DisplayName("В задачах пользователя присутствует список задач")
    void checkListTasksPage() {
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.checkUserTask();
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    }


    @Test
<<<<<<< HEAD
    @Feature("LCS")
    @AllureId("12325")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка перехода в меню Реестр")
    @Description("Проверить, что открывается меню Реестр")
=======
    @AllureId("12325")
    @Feature("CDP")
    @Description("Список реестров пользователя")
    @DisplayName("Наличие списка реестров на странице Реестр")
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void goToRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.checkReestrTask();
    }

    @Test
    @Feature("CDP")
<<<<<<< HEAD
    @AllureId("8262")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка открытия меню справочник")
    @Description("Проверить, что открывается меню справочник")
    void openTheSpravochnikPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        open("/app/lcs/constructor/main/#/app/forms/FORM_MAIN_PAGE");
        navigatorPage
                .goToSpravochnik();
=======
    @Description("Список реестров пользователя")
    @DisplayName("Наличие списка реестров на странице Реестр")
    void checkListInformation() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.checkInformationMenuContainsRegistries();
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    }

    @Test
    @AllureId("8262")
    @Feature("CDP")
    @Description("Список справочника")
    @DisplayName("В справочнике присутствует список элементов")
    void goToOpenSpravochnik() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictsPage.checkDicts();
    }
}
