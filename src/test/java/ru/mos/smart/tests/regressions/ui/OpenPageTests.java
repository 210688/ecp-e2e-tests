package ru.mos.smart.tests.regressions.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.UrlObjectType.ACTIONS_URL;
import static ru.mos.smart.data.UrlObjectType.REGISTER_URL;

@Owner("Soldatov")
@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Меню Госуслуги и функции")
public class OpenPageTests extends TestBase {

    ElementsCollection fileTableActions = $$("table.search-result-table tr");
    SelenideElement searchLine = $(byName("common"));

    @Test
    @AllureId("12322")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка перехода в меню возможности")
    void goToActionsPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        open(ACTIONS_URL);
        step("Проверить, что в меню возможности присутствует список задач", () ->
                fileTableActions.shouldHave(sizeGreaterThan(0)));
        searchLine.shouldBe(visible);
    }

    @Test
    @AllureId("8265")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка открытия меню Задачи")
    void openTheTasksPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToTasks();
        step("Проверить, что задачи присутствуют в списке", () ->
                $$("#my-task-showcase").size() > 0);
    }

    @Test
    @AllureId("12325")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка перехода в меню Реестр")
    void goToRegister() {
        List<String> expectedHeaders = Arrays.asList("Код ЕХД", "Название реестра", "Обладатель информации", "");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        open(REGISTER_URL);
        reestrPage.checkRegistryHeader(expectedHeaders);
    }


    @Test
    @AllureId("8262")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка открытия меню справочник")
    void openTheSpravochnikPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToSpravochnik();
        step("Проверка, что в записи присутствуют в справочнике  ", () ->
                Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                        $$(".float-e-margins").size() > 0));
    }
}