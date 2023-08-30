package ru.mos.smart.tests.oasirx.szz;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("SZZ (СЗЗ)")

public class SzzRegisterTests extends TestBase {
    @Test
    @AllureId("3705")
    @DisplayName("Просмотр реестра СЗЗ")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("szz")})
    void openingTheRegisterSzz() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
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
    @AllureId("7703")
    @DisplayName("Поиск карточки реестра СЗЗ по номеру")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("oasirx"), @Tag("szz")})
    void searchingSzzCardByNumber() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
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
