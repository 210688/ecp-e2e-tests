package ru.mos.smart.tests.oasirx.szz;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("SZZ (СЗЗ)")
public class SzzRegisterTests extends TestBase {

    @Test
    @DisplayName("Просмотр реестра СЗЗ")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void openingTheRegisterSzz() {
        sidebarPage
                .goToSzz();

        step("Открыт раздел СЗЗ", () ->
                $("h2").shouldHave(text("Реестр CЗЗ")));

        step("В разделе присутствуют вкладки:", () ->
                $$(".nav-item").shouldHave(textsInAnyOrder(
                        "СЗЗ в работе",
                        "Вcе СЗЗ",
                        "Мои СЗЗ",
                        "Мои задачи",
                        "СЗЗ в ожидании"
                )));
    }

    @Test
    @DisplayName("Поиск карточки реестра СЗЗ по номеру")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void searchingSzzCardByNumber() {
        sidebarPage
                .goToSzz();

        step("Открыт раздел СПРИТ", () ->
                $("h2").shouldHave(text("Реестр CЗЗ")));

        step("В строке поиска ввести номер карточки", () ->
                $("input.form-control").setValue("СЗЗ-000271-2020").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("СЗЗ-000271-2020")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $("h2").shouldHave(text("СЗЗ-000271-2020")));
    }
}
