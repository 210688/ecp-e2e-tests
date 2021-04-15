package ru.mos.smart.tests.regressions;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Меню Госуслуги и функции")
public class OpenPageTests extends TestBase {

    @Test
    @DisplayName("Открытие меню возможности")
    @Tag("regressions")
    void openTheActionsPage() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());
        MainPage.ActionsPage();
        step("Найти и открыть Возможности", () -> {
            $(byText("Возможности")).shouldBe(visible);
            $(byName("common")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Открытие меню Задачи")
    @Tag("regressions")
    void openTheTasksPage() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());
        step("Найти и открыть меню Задачи", () -> {
            $(byText("Госуслуги и функции")).shouldBe(visible).click();
            $x("//a[@href='/main/#/app/tasks']").shouldBe(visible).click();
            $x("//input[@placeholder='Найти задачу']")
                    .should(visible, Duration.ofSeconds(20)).click();
        });
    }

    @Test
    @DisplayName("Открытие меню Реестр")
    @Tag("regressions")
    void openTheReestrPage() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());
        step("Найти и открыть меню реестр", () -> {
            $(byText("Информация")).shouldBe(visible).click();
            $x("//a[@href='/main/#/app/catalog-registers']").shouldBe(visible).click();
        });
        step("Проверка, что реестр доступен", () -> {
            $(byName("candidateSearchValue")).shouldBe(visible);
            $(byText("Название реестра")).shouldBe(visible);
            Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                    $$(".table-striped").size() > 0);
            //table-striped
        });
    }

    @Test
    @DisplayName("Открытие меню справочник")
    @Tag("regressions")
    void openTheSpravochnikPage() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());
        step("Найти и открыть меню справочник", () -> {
            $(byText("Настройки")).shouldBe(visible).click();
            $x("//a[@href='/main/#/app/dicts/system']")
                    .shouldBe(visible, Duration.ofSeconds(10)).click();
            $(byName("filterinput")).shouldBe(visible);
            $(byText("Системные справочники")).shouldBe(visible);
        });
    }
}
