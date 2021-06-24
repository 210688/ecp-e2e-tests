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
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

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
    @Tags({@Tag("preprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("eoo")})
    void addCartEoo() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginOasirxEoo(), webConfig().passwordOasirxEoo());
        NavigatorPage.goToEoo();
        step("В открывшейся форме выбрать Добавить ЭОО", () ->
                $(byText("Добавить ЭОО")).click());
        step("В открывшейся форме заполнить обязательные поля:", () -> {
            step("Описание проекта – ввести текстовое описание, например, Проект планировки территории.");
            $("#description-ctr").setValue("тестовая заявка");
            step("Округ – выбрать и справочника Округов, может быть выбрано несколько вариантов, например, СЗАО, ЦАО.");
            $("#prefect-ctr").click();
            $(byText("САО")).click();
            step("Район – выбрать из справочника районов, может быть выбрано несколько вариантов, например, Капотня, Замоскворечье.");
            $("#district-ctr").click();
            $(byText("Коптево")).click();
            step("Адресный ориентир – вести текстовое описание адресного ориентира, например, пр-т Мира, д. 123.");
            $("#address-ctr").setValue("Ломоносовский проспект");
            step("Тип исходного проекта – выбрать из справочника одно значение, например, ППТ.");
            $("#source_type-ctr").click();
            $(byText("ППТ")).click();
            step("Ответственное управление – выбрать из списка управлений одно значение, например, УППТ.");
            $("#responsibleExecutor_code-ctr").click();
            $(byText("УППТ")).click();
            step("Исполнитель – выбрать пользователя из списка, этот пользователь становится ответственным исполнителем по проекту, и следующая задача процесса должна быть назначена ему.");
            $("#responsibleExecutor_login-ctr").click();
            $(byText("Учетная для автотестов (autotest_eoo)")).click();
        });
        step("Нажатие кнопки Сохранить и перейти к формированию процесса.", () ->
                $("#assign").click());
        step("Осуществляется переход в задачу ЭОО", () ->
                $(byText("Этап")));
    }

    @Test
    @AllureId("3691")
    @DisplayName("Поиск карточки реестра ЭОО по номеру")
    @Tags({@Tag("eoo"), @Tag("oasirx"), @Tag("preprod")})
    @Story("Реестр ЭОО")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void searchingEooCardByNumber() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginOasirxEoo(), webConfig().passwordOasirxEoo());
        NavigatorPage.goToEoo();

        step("Открыт раздел Общественные обсуждения", () ->
                $x("//div/h2[contains(text(),'Общеcтвенные обcуждения')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("ПЗЗ-00016-2021-ЭОО").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("ПЗЗ-00016-2021-ЭОО")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'ПЗЗ-00016-2021-ЭОО')]").shouldBe(visible));
    }

    @Test
    @AllureId("3285")
    @DisplayName("Открытие карточки ЭОО")
    @Story("Реестр ЭОО")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void openCardEooTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginOasirxEoo(), webConfig().passwordOasirxEoo());
        NavigatorPage.goToEoo();

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
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("allModules"), @Tag("regress")})
    @Story("Реестр ЭОО")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    void registerEooTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginOasirxEoo(), webConfig().passwordOasirxEoo());
        NavigatorPage.goToEoo();

        step("В реестре есть вкладки", () ->
                $(".nav-tabs").$$(".nav-item").shouldHave(sizeGreaterThan(0)));

        step("Отображается список", () ->
                $(".viewtable table").$$("tr").shouldHave(sizeGreaterThan(0)));
    }
}
