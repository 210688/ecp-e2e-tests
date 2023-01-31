package ru.mos.smart.tests.oasirx.crd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.RegisterObjectType.CRD;

@Layer("web")
@Epic("OASIRX")
@Feature("CRD (Согласование документов)")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("regressions")})
public class CrdRegisterTests extends TestBase {

    private final SelenideElement heading = $(".ng-binding");
    @Test
    @DisplayName("Переход в реестр Согласование документов")
    @Description("Проверить переход в реестр")
    void goToRegisterCrd() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToCrd();
        heading.shouldHave(text("СД"));
    }

    @Test
    @DisplayName("Наличие заявок в реестре СД")
    @Description("Проверить наличие заявок в реестре")
    void checkAvailabilityApplication() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToCrd();
        oasirxProjectsPage.checkAvailabilityApplication(CRD);
    }

    @Test
    @Disabled
    @DisplayName("Переход в карточку заявления")
    @Description("Проверить переход в карточку заявления")//TODO prod нет заявок
    void goToRequestCardCd() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToCrd();
        oasirxProjectsPage.goToCard();
    }

    @Test
    @DisplayName("Заголовки в реестре СД")
    @Description("Проверить, что присутствуют наименования колонок")
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("В работе", "Все", "Созданные мной", "Мои");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToCrd();
        reestrPage.searchField(CRD);
        oasirxProjectsPage.checkFilter(CRD, tableColumnList);
    }













    @Test
    @DisplayName("Открытие реестра СД")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("crd")})
    void openingTheRegisterCRD() {

        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
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
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("oasirx"), @Tag("crd")})
    void searchingCrdCardByNumber() {

        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
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
