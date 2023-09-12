package ru.mos.smart.tests.oasirx.crd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTERS;
import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.CRD_URL;

@Owner("Soldatov")
@Layer("web")
@Epic("Проверки реестров по подсистемам")
@Feature("ОАСИРХ")
@Story("Реестр")
public class CrdRegisterTests extends TestBase {

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @DisplayName("Проверка наличия данных и перехода в реестр Согласование документов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToRegisterCrd() {
        List<String> columnNames = Arrays.asList("Номер", "Дата", "Название", "Инициатор", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        sidebarPage.goToSection(CRD_URL);
/*        reestrPage.searchField();
        reestrPage.checkFieldData(CRD_URL, columnNames);*/
    }

    @Test
    @DisplayName("Наличие заявок в реестре СД")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkAvailabilityApplication() {
        oasirxProjectsPage.checkAvailabilityApplication(CRD_URL);
    }

    @Test
    @DisplayName("Переход в карточку заявления")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToRequestCardCd() {
        oasirxProjectsPage.goToCard();
    }

    @Test
    @DisplayName("Заголовки в реестре СД")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkHeadersTables() {
    }
}
