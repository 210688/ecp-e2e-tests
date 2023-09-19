package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.enums.Sidebar.*;

@Owner("Soldatov")
@Epic("OASI")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class OpenPageTests extends TestBase {

    @Test
    @AllureId("17027")
    @Feature("LCS")
    @DisplayName("В возможностях пользователя присутствует список возможностей")
    @Description("Проверить, что в возможностях пользователя присутствуетсписок возможностей")
    void goToActionsPage() {
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, OPPORTUNITIES);
        actionsPage.checkActionsTask();
    }

    @Test
    @AllureId("17028")
    @Feature("CDP")
    @DisplayName("В задачах пользователя присутствует список задач")
    @Description("Проверить, что в задачах пользователя присутствует список задач")
    void checkListTasksPage() {
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.checkUserTask();
    }


    @Test
    @AllureId("17029")
    @Feature("CDP")
    @DisplayName("Наличие списка реестров на странице Реестр")
    @Description("Проверить, что отображается список реестров на странице Реестр")
    void goToRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.checkReestrTask();
    }

    @Test
    @AllureId("16906")
    @Feature("CDP")
    @DisplayName("Наличие списка реестров на странице Реестр")
    @Description("Проверить, что отображается список реестров на странице Реестр")
    void checkListInformation() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.checkInformationMenuContainsRegistries();
    }

    @Test
    @AllureId("17030")
    @Feature("CDP")
    @DisplayName("В справочнике присутствует список элементов")
    @Description("Проверить, что в справочнике присутсвует список элементов")
    void goToOpenSpravochnik() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictsPage.checkDicts();
    }
}
