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
@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Меню Госуслуги и функции")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class OpenPageTests extends TestBase {

    @Test
    @AllureId("15149")
    @Description("Раскрытие списка Госуслуги и функции")
    @DisplayName("Проверка наличия элементов в меню Госуслуги и функции")
    void checkMenuServicesAndFunctions() {
        String[] expectedTexts = {
                "Задачи",
                "Задачи v2",
                "Возможности",
        };
        sidebarPage.clickSidebarMenu(SERVICESANDFUNCTION);
        sidebarPage.checkSubMenuList(SERVICESANDFUNCTION, expectedTexts);
    }

    @Test
    @AllureId("15150")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("reg")})
    @Description("Раскрытие списка Информация")
    @DisplayName("Проверка наличия элементов в меню Информация")
    void checkMenuInformationPage() {
        sidebarPage.clickSidebarMenu(INFORMATION);
    }

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @Description("Открытие страницы Задачи")
    @DisplayName("Проверка перехода на страницу Задачи")
    void openTheTasksPage() {
        sidebarPage.clickSidebarMenu(SERVICESANDFUNCTION);
        sidebarPage.clickSubMenuList(SERVICESANDFUNCTION, TASK);
    }

    @Test
    @AllureId("8265")
    @Description("Наличие списка задач пользователя на странице Задачи")
    @DisplayName("Проверка, что в задачах пользователя присутствует список задач")
    void goToTasksPage() {
        sidebarPage.clickSidebarMenu(SERVICESANDFUNCTION);
        sidebarPage.clickSubMenuList(SERVICESANDFUNCTION, TASK);
        taskPage.checkUserTask();
    }

    @Test
    @AllureId("12322")
    @Description("Наличие списка возможностей на странице Возможности")
    @DisplayName("Проверка, что присутствует список возможностей")
    void goToActionsPage() {
        sidebarPage.clickSidebarMenu(SERVICESANDFUNCTION);
        sidebarPage.clickSubMenuList(SERVICESANDFUNCTION, ACTIONS);
        actionsPage.checkActionsTask();
    }

    @Test
    @AllureId("12325")
    @Description("Список реестров пользователя")
    @DisplayName("Наличие списка реестров на странице Реестр")
    void goToRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        reestrPage.checkReestrTask();
    }

    @Test
    @AllureId("8262")
    @Description("Открытие меню справочника")
    @DisplayName("Проверка открытия меню справочника")
    void goToOpenSpravochnik() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCEBOOKS);
        dictsPage.checkDicts();
    }

    @Test
    @Description("Наличие списка элементов на странице Реестр")
    @DisplayName("Проверка, что в реестре присутствует список")
    public void goToOpenRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        reestrPage.goToRegister("Данные аэрофотосъемки");
    }
}