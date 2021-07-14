package ru.mos.smart.tests.oasirx.crd;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("CRD (Согласование документов)")
@Story("Работа с реестром и карточкой СД")
public class CrdRegisterTests extends TestBase {

    @Test
    @AllureId("3266")
    @DisplayName("Открытие реестра СД")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("crd")})
    void openingTheRegisterCRD() {

        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginOasirx(), webConfig().passwordOasirx());
        reestrPage
                .goToSdCard();

        step("Отображается список согласований. Присутствуют разделы:", () -> {
            $(byText("В работе")).shouldBe(visible);
            $(byText("Все")).shouldBe(visible);
            $(byText("Созданные мной")).shouldBe(visible);
            $(byText("Мои")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("4175")
    @DisplayName("Поиск карточки реестра СД по номеру")
    @Tags({@Tag("predprod"), @Tag("oasirx"), @Tag("crd")})
    void searchingCrdCardByNumber() {

        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginOasirx(), webConfig().passwordOasirx());
        reestrPage
                .goToSdCard();

        step("В строке поиска ввести номер карточки", () ->
                $x("//input[@type='search']").setValue("СД-0061-2021").pressEnter());

        step("Открыть найденную карточку", () ->
                $(byText("СД-0061-2021")).click());
        step("Проверить, что карточка открылась", () ->
                $(byText("СД-0061-2021")).shouldBe(visible));
    }
}
