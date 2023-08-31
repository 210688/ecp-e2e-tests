package ru.mos.smart.tests.regressions.ui;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.ExpectedResult;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.tests.TestBase;

@Owner("Soldatov")
@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Меню Госуслуги и функции")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class OpenPageTests extends TestBase {

    @Test
    @Description("Раскрытие списка Госуслуги и функции")
    @DisplayName("Проверка наличия элементов в меню Госуслуги и функции")
    void checkMenuServicesAndFunctions() {
        String[] expectedTexts = {
                "Задачи",
                "Задачи v2",
                "Возможности",
        };
        sidebarPage.clickSidebarMenu("Госуслуги и функции");
        sidebarPage.checkSubMenuList("Госуслуги и функции", expectedTexts);
    }

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("reg")})
    @Description("Раскрытие списка Информация")
    @DisplayName("Проверка наличия элементов в меню Информация")
    @ExpectedResult("В меню информация присутствуют элементы")
    void checkMenuInformationPage() {
        sidebarPage.clickSidebarMenu("Информация");
    }

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @Description("Открытие страницы Задачи")
    @DisplayName("Проверка перехода на страницу Задачи")
    void openTheTasksPage() {
        sidebarPage.clickSidebarMenu("Госуслуги и функции");
        sidebarPage.clickSubMenuList("Госуслуги и функции", "Задачи");
    }

    @Test
    @Description("Наличие списка задач пользователя на странице Задачи")
    @DisplayName("Проверка, что в задачах пользователя присутствует список задач")
    void goToTasksPage() {
        sidebarPage.clickSidebarMenu("Госуслуги и функции");
        sidebarPage.clickSubMenuList("Госуслуги и функции", "Задачи");
        taskPage.checkUserTask();
    }

    @Test
    @Description("Наличие списка возможностей на странице Возможности")
    @DisplayName("Проверка, что присутствует список возможностей")
    void goToActionsPage() {
        sidebarPage.clickSidebarMenu("Госуслуги и функции");
        sidebarPage.clickSubMenuList("Госуслуги и функции", "Возможности");
        actionsPage.checkActionsTask();
    }

    @Test
    @Description("Наличие списка элементов на странице Реестр")
    @DisplayName("Проверка, что в реестре присутствует список")
    void goToRegister() {
        sidebarPage.clickSidebarMenu("Информация");
        sidebarPage.clickSubMenuList("Информация", "Реестры");
        reestrPage.checkReestrTask();
    }

    @Test
    @Description("Открытие меню справочника")
    @DisplayName("Проверка открытия меню справочника")
    void openTheSpravochnikPage() {
        sidebarPage.clickSidebarMenu("Настройки");
        sidebarPage.clickSubMenuList("Настройки", "Справочники");
        dictsPage.checkDicts();
    }

}