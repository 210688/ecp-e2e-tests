package ru.mos.smart.tests.oasirx.sprit;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class SpritTests extends TestBase {

    @Test
    @AllureId("7709")
    @Story("Sprit")
    @Component("Реестр")
    @DisplayName("Просмотр карточки СПРИТ")
    @Description("Проверить, что в реестре открывается карточка")
    void cardViewSprit() {
        sidebarPage
                .goToSprit();

        step("Открыть любую карточку", () ->
                $(".viewtable").$("a").click());
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
    @AllureId("7707")
    @Story("Sprit")
    @Component("Реестр")
    @DisplayName("Форма карточки: История изменений")
    @Description("Проверить, что форма карточки: История изменений - открывается")
    void historyChangeCard() {
        sidebarPage
                .goToSprit();
        step("Открыть любую карточку", () ->
                $(".viewtable").$("a").click());
        step("Нажать на иконку шестеренка", () ->
                $("#ddm").click());
        step("Выбрать История изменений", () ->
                $(byLinkText("История изменений")).click());
        step("Открывается страница с историей изменений в заявке, отображается информация о смене статуса заявки, авторе и времени", () -> {
        });
    }

    @Test
    @AllureId("7710")
    @Story("Sprit")
    @Component("Реестр")
    @DisplayName("Новая форма подачи заявления (новый регламент)")
    @Description("Проверить, что форма подачи открывается и пристутствуют блоки с записями")
    void newReglament() {
        sidebarPage
                .goToSprit();
        step("Открыть любую карточку", () ->
                $(".viewtable").$("a").click());

        step("В карточке присутствуют блоки:", () -> {
            $(".panel-body").$$("label").shouldHave(sizeGreaterThan(0));
            $(byText("Название заявки:")).shouldBe(visible);
            $(byText("Номер договора:")).shouldBe(visible);
            $(byText("Заявитель:")).shouldBe(visible);
            $(byText("E-mail:")).shouldBe(visible);
        });
        step("Проверка, что блоках есть записи", () ->
                $$("div.panel-body").shouldHave(sizeGreaterThan(0), Duration.ofSeconds(10)));
    }

    @Test
    @AllureId("7708")
    @Story("Sprit")
    @Component("Реестр")
    @DisplayName("Форма карточки: Процесс")
    @Description("Проверить, что карточка: Процесс - открывается")
    void process() {
        sidebarPage
                .goToSprit();
        step("Открыть любую карточку", () ->
                $(".viewtable").$("a").click());
        step("Нажать на иконку шестеренка", () ->
                $("#ddm").click());
        step("В блоке Бизнес процессы нажать на иконку Процесс", () ->
                $(byText("Процесс")).click());
        step("Открывается страница со схемой бизнес-процесса", () ->
                $(byText("Процесс СПРИТ")).shouldBe(visible));
        $$("div[class='m-t-md m-l-md m-b-md']").shouldHave(sizeGreaterThan(0), Duration.ofSeconds(10));
    }

    @Test
    @Story("Sprit")
    @Component("Реестр")
    @DisplayName("Форма карточки: Материалы")
    @Description("Проверить, что карточка: Материалы - открывается")
    void cardMaterialsTest() {
        sidebarPage
                .goToSprit();
        step("Открыть любую катрочку", () ->
                $("[heading='Запросы в работе']").$("a").click());
        step("Нажать на кнопку Материалы", () ->
                $x("//button[contains(text(), 'Материалы')]").click());
        step("Открылась таблица с приложенными материалами", () ->
                $("app-view-stage-materials-table").shouldBe(visible));
    }
}














