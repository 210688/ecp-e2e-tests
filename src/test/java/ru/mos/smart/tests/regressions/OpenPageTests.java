package ru.mos.smart.tests.regressions;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.annotations.Owner;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;


@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Меню Госуслуги и функции")
public class OpenPageTests extends TestBase {

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Открытие меню возможности")
    void openTheActionsPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToActions();
        step("Проверяем, что строка поиска доступна", () -> {
            $(byName("common")).shouldBe(visible);
        });
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Открытие меню Задачи")
    void openTheTasksPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToTasks();
        step("Проверяем, что присутствуют задачи в списке", () ->
                $$("#my-task-showcase").size() > 0);
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Открытие меню Реестр")
    void openTheReestrPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToRegister();
        step("Проверка, что реестр доступен", () -> {
            $(byName("candidateSearchValue")).shouldBe(visible);
            $(byText("Название реестра")).shouldBe(visible);
        });
        step("Проверка, что в реестре присутствуют записи", () ->
                Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                        $$(".table-striped").size() > 0));
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Открытие меню справочник")
    void openTheSpravochnikPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToSpravochnik();
        step("Проверка, что справочник доступен", () -> {
            $(byName("filterinput")).shouldBe(visible);
            $(byText("Системные справочники")).shouldBe(visible);
        });
        step("Проверка, что в справочнике присутствуют записи", () ->
                Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                        $$(".float-e-margins").size() > 0));
    }
}