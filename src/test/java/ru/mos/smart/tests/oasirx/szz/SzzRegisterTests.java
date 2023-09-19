package ru.mos.smart.tests.oasirx.szz;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Epic("OASI")
@Feature("ОАСИРХ")
@Story("szz")
@Component("Реестр")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class SzzRegisterTests extends TestBase {

    @Test
    @AllureId("17055")
    @DisplayName("Просмотр реестра СЗЗ")
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
    @AllureId("17054")
    @DisplayName("Поиск карточки реестра СЗЗ по номеру")
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
