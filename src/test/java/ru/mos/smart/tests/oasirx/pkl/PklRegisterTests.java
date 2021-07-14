package ru.mos.smart.tests.oasirx.pkl;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("PKL")

public class PklRegisterTests extends TestBase {
    @Test
    @AllureId("3699")
    @DisplayName("Просмотр реестра ПКЛ")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("pkl")})
    void openingTheRegisterPkl() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginOasirx(), webConfig().passwordOasirx());
        navigatorPage
                .goToPkl();

        step("Открыт раздел ПКЛ", () ->
                $x("//div/h2[contains(text(),'ПКЛ')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//a/span[contains(text(),'В работе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Все')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Ожидает')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Статистика')]").shouldBe(visible);
        });
    }

    @Test
    @AllureId("3700")
    @DisplayName("Поиск карточки реестра ПКЛ по номеру")
    @Tags({@Tag("predprod"), @Tag("oasirx"), @Tag("pkl")})
    void searchingPklCardByNumber() {

        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginOasirx(), webConfig().passwordOasirx());
        navigatorPage
                .goToPkl();

        step("Открыт раздел ПКЛ", () ->
                $x("//div/h2[contains(text(),'ПКЛ')]").shouldBe(visible));

        AtomicReference<String> card = new AtomicReference<>("");

        step("Получаем номер существующей карточки", () -> {
            $(".viewtable").$$("tr").shouldHave(sizeGreaterThan(0));
            card.set($(".viewtable").$("a").getText());
        });

        step("В строке поиска ввести номер карточки", () ->
                $("input.form-control").setValue(card.get()).pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText(card.get())).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $("h2").shouldHave(text(card.get())));
    }
}
