package ru.mos.smart.tests.regressions;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Меню Госуслуги и функции")
public class OpenPageTests extends TestBase {

    @Test
    @AllureId("3753")
    @DisplayName("Открытие меню возможности")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheActionsPage() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());
        NavigatorPage.goToActions();
        step("Проверяем, что строка поиска доступна", () -> {
            $(byName("common")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("3752")
    @DisplayName("Открытие меню Задачи")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheTasksPage() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());
        NavigatorPage.goToTasks();
    }

    @Test
    @AllureId("3751")
    @DisplayName("Открытие меню Реестр")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheReestrPage() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());
        NavigatorPage.goToRegister();
        step("Проверка, что реестр доступен", () -> {
            $(byName("candidateSearchValue")).shouldBe(visible);
            $(byText("Название реестра")).shouldBe(visible);
        });
        step("Проверка, что в реестре присутствуют записи", () ->
                Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                        $$(".table-striped").size() > 0));
    }

    @Test
    @AllureId("3754")
    @DisplayName("Открытие меню справочник")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheSpravochnikPage() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());
        NavigatorPage.goToSpravochnik();
        step("Проверка, что справочник доступен", () -> {
            $(byName("filterinput")).shouldBe(visible);
            $(byText("Системные справочники")).shouldBe(visible);
        });
        step("Проверка, что в справочнике присутствуют записи", () ->
                Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                        $$(".float-e-margins").size() > 0));
    }
}