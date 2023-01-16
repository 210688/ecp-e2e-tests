package ru.mos.smart.tests.regressions.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.UrlObjectType.ACTIONS_URL;
import static ru.mos.smart.data.UrlObjectType.REGISTER_URL;


@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Меню Госуслуги и функции")
public class OpenPageTests extends TestBase {

    ElementsCollection fileTableActions = $$("table.search-result-table tr");
    SelenideElement searchLine = $(byName("common"));

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regressionsProd")})
    @DisplayName("Переход в меню возможности")
    @Step("Переход в меню возможности")
    void goToActionsPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        open(ACTIONS_URL);
        step("Проверить, что меню возможности присутствует список задач", () ->
                fileTableActions.shouldHave(sizeGreaterThan(0)));
        searchLine.shouldBe(visible);
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regressionsProd")})
    @DisplayName("Открытие меню Задачи")
    void openTheTasksPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToTasks();
        step("Проверяем, что присутствуют задачи в списке", () ->
                $$("#my-task-showcase").size() > 0);
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regressionsProd")})
    @DisplayName("Переход в меню Реестр")
    void goToRegister() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        open(REGISTER_URL);
        step("Проверить, что реестр доступен", () -> {
            $(byName("candidateSearchValue")).shouldBe(visible);
            $(byText("Название реестра")).shouldBe(visible);
        });
        step("Проверить заполненность  реестра данными", () ->
                Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                        $$(".table-striped").size() > 0));
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regressionsProd")})
    @DisplayName("Открытие меню справочник")
    void openTheSpravochnikPage() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
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