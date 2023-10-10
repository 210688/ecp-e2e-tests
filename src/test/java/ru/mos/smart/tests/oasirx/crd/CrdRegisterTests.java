package ru.mos.smart.tests.oasirx.crd;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.SD;

@Owner("Soldatov")
@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class CrdRegisterTests extends TestBase {

    @Test
    @Story("CRD")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре СД")
    @Description("Проверить, что реестр СД корректно открывается, " +
            "включая проверку порядка отображения заголовков")
    void checkAvailabilityApplication() {
        List<String> tableColumnList = Arrays.asList("Номер", "Дата", "Название", "Инициатор", "Статус");
        sidebarPage.clickSidebarMenu(SD);
        oasirxPage.registryContainsCardsHeadersCheck(SD, tableColumnList);
    }

    @Test
    @Story("CRD")
    @Component("Реестр")
    @DisplayName("Поиск карточки в реестре СД")
    @Description("Проверить, что происходит поиск карточки реестра СД")
    void goToRequestCardCd() {
        sidebarPage.clickSidebarMenu(SD);
        oasirxPage.searchToCardInRegistry();
    }
}
