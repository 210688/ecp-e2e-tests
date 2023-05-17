package ru.mos.smart.tests.oasirx.crd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.RegisterObjectType.CRD;

@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Oasirx")
@Story("Crd (Согласование документов)")
@Owner("Soldatov")
@Layer("web")
public class CrdRegisterTests extends TestBase {

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @AllureId("12532")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("regressions")})
    @DisplayName("Переход в реестр Согласование документов")
    void goToRegisterCrd() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToCrd();
        heading.shouldHave(text("СД"));
    }

    @Test
    @AllureId("12531")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("regressions")})
    @DisplayName("Наличие заявок в реестре СД")
    void checkAvailabilityApplication() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToCrd();
        oasirxProjectsPage.checkAvailabilityApplication(CRD);
    }

    @Test
    @AllureId("12529")
    @Disabled
    @DisplayName("Переход в карточку заявления")
    void goToRequestCardCd() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToCrd();
        oasirxProjectsPage.goToCard();
    }

    @Test
    @AllureId("12530")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("regressions")})
    @DisplayName("Заголовки в реестре СД")
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("В работе", "Все", "Созданные мной", "Мои");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToCrd();
        reestrPage.searchField();
        oasirxProjectsPage.checkFilter(CRD, tableColumnList);
    }
}
