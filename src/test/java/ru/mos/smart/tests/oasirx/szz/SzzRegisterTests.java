package ru.mos.smart.tests.oasirx.szz;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.SZZ;

@Epic("OASI")
@Feature("OASIRX")
@Tags({@Tag("oasirx"), @Tag("regres")})
public class SzzRegisterTests extends TestBase {

    @Test
    @AllureId("17667")
    @Story("SZZ")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре СЗЗ")
    @Description("Проверить, что реестр СЗЗ корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void openingTheRegisterSzz() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Адрес", "Категория", "Заявитель", "Этап");
        sidebarPage.clickSidebarMenu(SZZ);
        oasirxPage.registryContainsCardsHeadersCheck(SZZ, tableColumnList);

    }

    @Test
    @AllureId("17666")
    @Story("SZZ")
    @Component("Реестр")
    @DisplayName("Поиск карточки")
    @Description("Проверить, что поиск карточки в реестре СЗЗ работает корректно")
    void searchingSzzCardByNumber() {
        sidebarPage.clickSidebarMenu(SZZ);
        oasirxPage.searchToCardInRegistry();
    }
}
