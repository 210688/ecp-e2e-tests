package ru.mos.smart.tests.regressions;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.AutoMember;
import ru.mos.smart.annotations.Layer;
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
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6540")
    @DisplayName("Открытие меню возможности")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheActionsPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());
        navigatorPage
                .goToActions();
        step("Проверяем, что строка поиска доступна", () -> {
            $(byName("common")).shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6539")
    @DisplayName("Открытие меню Задачи")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheTasksPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());
        navigatorPage
                .goToTasks();
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6538")
    @DisplayName("Открытие меню Реестр")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheReestrPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());
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
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6541")
    @DisplayName("Открытие меню справочник")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheSpravochnikPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());
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