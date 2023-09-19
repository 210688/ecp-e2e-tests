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
@Feature("ОАСИРХ")
@Story("crd")
@Component("Реестр")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class CrdRegisterTests extends TestBase {

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @AllureId("17077")
    @DisplayName("Проверка наличия данных и перехода в реестр Согласование документов")
    void goToRegisterCrd() {
        List<String> columnNames = Arrays.asList("Номер", "Дата", "Название", "Инициатор", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        sidebarPage.goToSection(CRD_URL);
    }

    @Test
    @AllureId("17075")
    @DisplayName("Наличие заявок в реестре СД")
    void checkAvailabilityApplication() {
        oasirxProjectsPage.checkAvailabilityApplication(CRD_URL);
    }

    @Test
    @AllureId("17073")
    @DisplayName("Переход в карточку заявления")
    void goToRequestCardCd() {
        oasirxProjectsPage.goToCard();
    }

    @Test
    @AllureId("17074")
    @DisplayName("Заголовки в реестре СД")
    void checkHeadersTables() {
    }
}
