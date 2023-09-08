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
    @Feature("LCS")
    @Description("Наличие списка возможностей на странице Возможности")
    @DisplayName("В возможностях пользователя присутствует список возможностей")
    void goToActionsPage() {
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, ACTIONS);
        actionsPage.checkActionsTask();
    }

    @Test
    @AllureId("8265")
    @Feature("CDP")
    @Description("Наличие списка задач пользователя на странице Задачи")
    @DisplayName("В задачах пользователя присутствует список задач")
    void checkListTasksPage() {
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.checkUserTask();
    }


    @Test
    @AllureId("12325")
    @Feature("CDP")
    @Description("Список реестров пользователя")
    @DisplayName("Наличие списка реестров на странице Реестр")
    void goToRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.checkReestrTask();

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
