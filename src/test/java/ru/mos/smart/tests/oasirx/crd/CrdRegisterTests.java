package ru.mos.smart.tests.oasirx.crd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTER;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeOasirx.CRD_URL;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationAPI;

@Owner("Soldatov")
@Layer("web")
@Epic("Проверки реестров по подсистемам")
@Feature("ОАСИРХ")
@Story("Реестр")
public class CrdRegisterTests extends TestBase {

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @AllureId("12532")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("oasirxReestr")})
    @DisplayName("Проверка наличия данных и перехода в реестр Согласование документов")
    void goToRegisterCrd() {
        List<String> columnNames = Arrays.asList("Номер", "Дата", "Название", "Инициатор", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        sidebarPage.goToSection(CRD_URL);
/*        reestrPage.searchField();
        reestrPage.checkFieldData(CRD_URL, columnNames);*/
    }

    @Test
    @AllureId("12531")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("oasirxCard")})
    @DisplayName("Наличие заявок в реестре СД")
    void checkAvailabilityApplication() {
        openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        //urlPage.goToCrd();
        oasirxProjectsPage.checkAvailabilityApplication(CRD_URL);
    }

    @Test
    @AllureId("12529")
    @Disabled
    @DisplayName("Переход в карточку заявления")
    void goToRequestCardCd() {
        openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        //urlPage.goToCrd();
        oasirxProjectsPage.goToCard();
    }

    @Test
    @AllureId("12530")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("oasirxCard")})
    @DisplayName("Заголовки в реестре СД")
    void checkHeadersTables() {
/*        List<String> tableColumnList = Arrays.asList("В работе", "Все", "Созданные мной", "Мои");
        openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToCrd();
        reestrPage.searchField();
        oasirxProjectsPage.checkFilter(CRD_URL, tableColumnList);*/
    }
}
