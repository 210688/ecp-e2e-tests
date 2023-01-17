package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.RegisterObjectType.EOO;

@Epic("OASIRX")
@Feature("EOO (Общественные обсуждения)")
public class EooRegisterTests extends TestBase {

    @Test
    @DisplayName("Переход в реестр Общественные обсуждения")
    @Description("Проверка перехода в реестр")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("eoo")})
    void goToRegisterEoo() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();
        eooPage.checkHeading(EOO);
    }

        @Test
        @DisplayName("Наличие заявок в реестре")
        @Description("Проверить наличие заявок в реестре")
        @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("eoo")})
        void checkAvailabilityApplication() {
            AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
            urlPage.goToEoo();
            eooPage.checkAvailabilityApplication();
        }

    @Test
    @DisplayName("Переход в карточку заявки")
    @Description("Проверка перехода в карточку заявления")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("eoo")}) //TODO EOO
    void goToRequestCard() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();
        eooPage.goToCard();
    }

/*        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся колонки: 'ЭОО в работе', 'Вcе ЭОО', 'Мои ЭОО', 'Предложения'", () -> {
            $(".nav-tabs").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Дата",
                    "Номер",
                    "Округ",
                    "Районы",
                    "Адрес",
                    "Исполнитель",
                    "Статус"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });*//*

    @Test
    @AllureId("3691")
    @DisplayName("Поиск карточки реестра ЭОО по номеру")
    @Tags({@Tag("stage"), @Tag("eoo"), @Tag("oasirx"), @Tag("predprod")})
    @Story("Реестр ЭОО")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void searchingEooCardByNumber() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo(EOO_URL);
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
                $x("//div/h2[contains(text(),'" + card.get() + "')]").shouldBe(visible));
    }

    @Test
    @AllureId("3285")
    @DisplayName("Открытие карточки ЭОО")
    @Tags({@Tag("stage"), @Tag("eoo"), @Tag("oasirx"), @Tag("predprod")})
    @Story("Реестр ЭОО")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void openCardEooTest() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();

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
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();

        step("В реестре есть вкладки", () ->
                $(".nav-tabs").$$(".nav-item").shouldHave(sizeGreaterThan(0)));

        step("Отображается список", () ->
                $(".viewtable table").$$("tr").shouldHave(sizeGreaterThan(0)));
    }*/
}
