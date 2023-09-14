package ru.mos.smart.tests.oasirx.sprit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("SPRIT (Выдача СПРИТ)")
public class SpritTests extends TestBase {

    @Test
    @DisplayName("Просмотр карточки СПРИТ")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
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
    @DisplayName("Форма карточки: История изменений")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
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
    @DisplayName("Новая форма подачи заявления (новый регламент)")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
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
    @DisplayName("Форма карточки: Процесс")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
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
    @DisplayName("Форма карточки: Материалы")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
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














