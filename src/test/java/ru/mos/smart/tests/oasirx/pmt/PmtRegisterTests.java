package ru.mos.smart.tests.oasirx.pmt;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.PMT;

@Epic("OASI")
@Feature("OASIRX")
@Tags({@Tag("oasirx"), @Tag("regres")})
class PmtRegisterTests extends TestBase {

    @Test
    @AllureId("17672")
    @Story("PMT")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре Межевание территорий")
    @Description("Проверить корректности отображения заголовков и наличие карточек в реестре СЗЗ")
    void openingTheRegisterPMT() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Округ", "Районы", "Адрес",
                "Название работы", "Цель проекта", "Исполнитель", "Статус");
        sidebarPage.clickSidebarMenu(PMT);
        oasirxPage.registryContainsCardsHeadersCheck(PMT, tableColumnList);
    }

    @Test
    @Story("PMT")
    @Component("Реестр")
    @DisplayName("Поиск ПМТ по номеру")
    @Description("Проверить открытия и заполнения карточки после поиска в реестре Межевание территорий")
    void searchingPmtCardByNumber() {
        sidebarPage.clickSidebarMenu(PMT);
        oasirxPage.searchToCardInRegistry();

    }
}
