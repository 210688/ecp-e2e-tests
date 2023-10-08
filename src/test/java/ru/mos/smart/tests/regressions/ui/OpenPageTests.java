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
@Epic("Регрессионные тесты платформы")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class OpenPageTests extends TestBase {

    @Test
    @AllureId("17027")
    @Feature("LCS")
    @DisplayName("Проверка доступности Возможностей")
    @Description("Проверка доступности возможностей и проверка отображения задач доступных пользователю")
    void goToActionsPage() {
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, OPPORTUNITIES);
        actionsPage.checkActionsTask();
        actionsPage.checkHeadersAction("Все", "Избранные");
    }

    @Test
    @AllureId("17623")
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
    @Feature("LCS")
    @DisplayName("Наличие списка реестров на странице Реестр")
    @Description("Проверка доступности реестра текущему пользователю")
    void CheckRegistryForTaskList() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.checkListInRegistry(18); //TODO добавить проверку
    }

    @Test
    @AllureId("17030")
    @Feature("CDP")
    @DisplayName("В справочнике присутствует список элементов")
    @Description("Проверить, что в справочнике присутствует список элементов")
    void goToSpravochnik() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictsPage.checkDicts();
    }

    @Test
    @Feature("CDP")
    @DisplayName("Поиск справочника")
    @Description("Проверить, что в справочнике присутствует список элементов")
    void searchSpravochnik() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictsPage.searchDicts();
    }
}
