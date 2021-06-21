package ru.mos.smart.tests.oasirx.sprit;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class SpritTests extends TestBase {

    @Test
    @AllureId("1043")
    @DisplayName("Просмотр карточки СПРИТ")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("sprit")})
    @Feature("SPRIT (Выдача СПРИТ)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    @Owner("Amidosha")
    void cardViewSprit() {

        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginOasirx(), webConfig().passwordOasirx());
        NavigatorPage.goToSprit();
        step("Открыть любую карточку", () ->
                $(byText("ЛГР-0079-2020")).click());
        step("В карточке присутствуют блоки:", () -> {
            step("Этапы");
            $(byText("Этап")).shouldBe(visible);
            step("Материалы");
            $(byText("Материалы")).shouldBe(visible);
            step("Сроки");
            $(byText("Сроки")).shouldBe(visible);
        });
        step("Проверка, что в карточке присутствуют шаги этапов", () ->
                Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                        $$("div[class='border992']").size() > 0));
    }

    @Test
    @AllureId("3315")
    @DisplayName("Форма карточки: История изменений")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("sprit")})
    @Feature("SPRIT (Выдача СПРИТ)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void historyChangeCard() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginOasirx(), webConfig().passwordOasirx());
        NavigatorPage.goToSprit();
        step("Открыть любую карточку", () ->
                $(byText("ЛГР-0079-2020")).click());
        step("Нажать на иконку шестеренка", () ->
                $("#ddm").click());
        step("Выбрать История изменений", () ->
                $(byLinkText("История изменений")).click());
        step("Открывается страница с историей изменений в заявке, отображается информация о смене статуса заявки, авторе и времени", () -> {
        });
    }

    @Test
    @AllureId("4207")
    @DisplayName("Новая форма подачи заявления (новый регламент)")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("sprit")})
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    @Feature("SPRIT (Выдача СПРИТ)")
    void newReglament() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginOasirx(), webConfig().passwordOasirx());
        NavigatorPage.goToSprit();
        step("Открыть любую карточку", () ->
                $(byText("ЛГР-0079-2020")).click());

        step("В карточке присутствуют блоки:", () -> {
            $(byText("Название заявки:")).shouldBe(visible);
            $(byText("Номер договора:")).shouldBe(visible);
            $(byText("Заявитель:")).shouldBe(visible);
            $(byText("Документ заявителя:")).shouldBe(visible);
            $(byText("Почтовый адрес:")).shouldBe(visible);
            $(byText("Контактный тел.:")).shouldBe(visible);
            $(byText("E-mail:")).shouldBe(visible);
        });
        step("Проверка, что блоках есть записи", () ->
                Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                        $$("div[class='panel-body']").size() > 0));
    }

    @Test
    @AllureId("3313")
    @DisplayName("Форма карточки: Процесс")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("sprit")})
    @Feature("SPRIT (Выдача СПРИТ)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void Process() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginOasirx(), webConfig().passwordOasirx());
        NavigatorPage.goToSprit();
        step("Открыть любую карточку", () ->
                $(byText("ЛГР-0079-2020")).click());
        step("Нажать на иконку шестеренка", () ->
                $("#ddm").click());
        step("В блоке Бизнес процессы нажать на иконку Процесс", () ->
                $(byText("Процесс")).click());
        step("Открывается страница со схемой бизнес-процесса", () ->
                $(byText("Процесс СПРИТ")).shouldBe(visible));
        Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                $$("div[class='m-t-md m-l-md m-b-md']").size() > 0);
    }
}














