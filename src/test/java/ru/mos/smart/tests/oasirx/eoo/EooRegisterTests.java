package ru.mos.smart.tests.oasirx.eoo;

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

import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("EOO (Электронные общественные обсуждения)")
@Story("Реестр ЭОО")
public class EooRegisterTests extends TestBase {

    @Test
    @AllureId("920")
    @DisplayName("01. Добавление ЭОО")
    @Story("PPT (modules)")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("eoo")})
    void addCartEoo() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToEoo();
        step("В открывшейся форме выбрать Добавить ЭОО", () ->
                $(byText("Запрос на ЭОО")).click());
        step("В открывшейся форме заполнить обязательные поля:", () -> {
            step("Описание проекта – ввести текстовое описание, например, Проект планировки территории.");
            $("#description-ctr").setValue("тестовая заявка");
            step("Округ – выбрать и справочника Округов, может быть выбрано несколько вариантов, например, СЗАО, ЦАО.");
            $("#prefect-ctr").click();
            $(byText("САО")).click();
            step("Район – выбрать из справочника районов, может быть выбрано несколько вариантов, например, Капотня, Замоскворечье.");
            $("#district-ctr").click();
            $(byText("Аэропорт")).click();
        });
    }

    @Test
    @AllureId("3691")
    @DisplayName("Поиск карточки реестра ЭОО по номеру")
    @Tags({@Tag("stage"), @Tag("eoo"), @Tag("oasirx"), @Tag("predprod")})
    @Story("Реестр ЭОО")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void searchingEooCardByNumber() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToEoo();
        AtomicReference<String> card = new AtomicReference<>("");

        step("Получаем номер существующей карточки", () -> {
            $(".viewtable").$$("tr").shouldHave(sizeGreaterThan(0));
            card.set($(".viewtable").$("a").getText());
        });

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue(card.get()).pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText(card.get())).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'" + card.get() +  "')]").shouldBe(visible));
    }

    @Test
    @AllureId("3285")
    @DisplayName("Открытие карточки ЭОО")
    @Tags({@Tag("stage"), @Tag("eoo"), @Tag("oasirx"), @Tag("predprod")})
    @Story("Реестр ЭОО")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void openCardEooTest() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToEoo();

        step("Открыть любую карточку", () ->
                $("[uisref='app.eoo.eoo']").click());

        step("В карточке присутствуют блоки:", () -> {
            step("Общая информация (шапка карточки)", () ->
                    $(".title-panel.cardtpanel").shouldBe(visible));
            step("Дополнительная информация", () ->
                    $(byText("Дополнительная информация")).shouldBe(visible));
            step("Этапы", () ->
                    $(".stage.header").shouldHave(text("Этап")));
            step("Вкладки Карточка, Статистика, Материалы, Предложения, Настройки", () -> {
                $(".mobilecardbtns").$$("button").shouldHave(textsInAnyOrder(
                        "Карточка",
                        "Статистика",
                        "Материалы",
                        "Предложения"
                ));
                $(".dropdown").shouldBe(visible);
            });
        });
    }

    @Test
    @AllureId("3690")
    @DisplayName("Просмотр реестра ЭОО")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("allModules"), @Tag("regress")})
    @Story("Реестр ЭОО")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void registerEooTest() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToEoo();

        step("В реестре есть вкладки", () ->
                $(".nav-tabs").$$(".nav-item").shouldHave(sizeGreaterThan(0)));

        step("Отображается список", () ->
                $(".viewtable table").$$("tr").shouldHave(sizeGreaterThan(0)));
    }
}
