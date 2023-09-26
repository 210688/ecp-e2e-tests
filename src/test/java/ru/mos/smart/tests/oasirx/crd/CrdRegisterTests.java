package ru.mos.smart.tests.oasirx.crd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;
import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.CRD_URL;

@Owner("Soldatov")
@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class CrdRegisterTests extends TestBase {

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @AllureId("17077")
    @Story("CRD")
    @Component("Реестр")
    @DisplayName("Наличия данных и перехода в реестр Согласование документов")
    @Description("Проверить, что присутствуют данные и есть переход в реестр Согласование документов")
    void goToRegisterCrd() {
        List<String> columnNames = Arrays.asList("Номер", "Дата", "Название", "Инициатор", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        sidebarPage.goToSection(CRD_URL);
    }

    @Test
    @AllureId("17075")
    @Story("CRD")
    @Component("Реестр")
    @DisplayName("Наличие заявок в реестре СД")
    @Description("Проверить, что присутствуют заявки в реестре СД")
    @Tag("regres")
    void checkAvailabilityApplication() {
        oasirxProjectsPage.checkAvailabilityApplication(CRD_URL);
    }

    @Test
    @AllureId("17073")
    @Story("CRD")
    @Component("Реестр")
    @DisplayName("Переход в карточку заявления")
    @Description("Проверить, что происходит переход в карточку заявления")
    void goToRequestCardCd() {
        oasirxProjectsPage.goToCard();
    }

    @Test
    @AllureId("17074")
    @Story("CRD")
    @Component("Реестр")
    @DisplayName("Заголовки в реестре СД")
    @Description("Проверить, что есть заголовки в реестре СД")
    void checkHeadersTables() {
    }
}
