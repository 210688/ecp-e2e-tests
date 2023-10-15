package ru.mos.smart.tests.oasirx.itmka;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.ITMKA;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class ItmkaRegisterTests extends TestBase {

    @Test
    @AllureId("17675")
    @Story("Itmka")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре Управление информатизацией МКА")
    @Description("Проверить, что реестр Управление информатизацией МКА корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void openingTheRegisterItmka() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Название", "Статус", "Назначено");
        sidebarPage.clickSidebarMenu(ITMKA);
        oasirxPage.registryContainsCardsHeadersCheck(ITMKA, tableColumnList);
    }

    @Test
    @AllureId("17676")
    @Story("Itmka")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра заявок Управление ИТ МКА по номеру")
    @Description("Проверить, что происходит поиск карточки реестра заявок - Управление ИТ МКА по номеру")
    void searchingItmkaCardByNumber() {
        sidebarPage.clickSidebarMenu(ITMKA);
        oasirxPage.searchToCardInRegistry();
    }
}
