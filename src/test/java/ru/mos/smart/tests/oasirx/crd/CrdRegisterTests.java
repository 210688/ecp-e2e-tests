package ru.mos.smart.tests.oasirx.crd;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.SD;

@Owner("Soldatov")
@Epic("OASI")
@Feature("Оасирх")
public class CrdRegisterTests extends TestBase {

    @Test
    @AllureId("17075")
    @Story("CRD")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре СД")
    @Description("Проверить, что реестр СД корректно открывается, " +
            "включая проверку порядка отображения заголовков")
    @Tag("regres")
    void checkAvailabilityApplication() {
        List<String> tableColumnList = Arrays.asList("Номер", "Дата", "Название", "Инициатор", "Статус");
        sidebarPage.clickSidebarMenu(SD);
        oasirxPage.registryContainsCardsHeadersCheck(SD, tableColumnList);
    }

    @Test
    @AllureId("17073")
    @Story("CRD")
    @Component("Реестр")
    @DisplayName("Переход в карточку заявления")
    @Description("Проверить, что происходит переход в карточку заявления")
    @Tag("regres")
    void goToRequestCardCd() {
        sidebarPage.clickSidebarMenu(SD);
    }

    @Test
    @AllureId("17074")
    @Story("CRD")
    @Component("Реестр")
    @DisplayName("Заголовки в реестре СД")
    @Description("Проверить, что есть заголовки в реестре СД")
    void checkHeadersTables() {
        sidebarPage.clickSidebarMenu(SD);

    }
}
