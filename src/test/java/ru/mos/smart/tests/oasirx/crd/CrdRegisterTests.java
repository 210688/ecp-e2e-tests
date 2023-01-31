package ru.mos.smart.tests.oasirx.crd;

import com.codeborne.selenide.SelenideElement;
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
import static com.codeborne.selenide.Selenide.$;
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
}
