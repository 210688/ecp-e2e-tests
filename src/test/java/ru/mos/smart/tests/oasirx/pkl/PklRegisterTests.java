package ru.mos.smart.tests.oasirx.pkl;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.PKL;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class PklRegisterTests extends TestBase {

    @Test
    @AllureId("17673")
    @Story("PKL")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра ПКЛ по номеру")
    @Description("Проверить открытия и заполнения карточки после поиска в реестре ПКЛ")
    void searchingPklCardByNumber() {
        sidebarPage.clickSidebarMenu(PKL);
        oasirxPage.searchToCardInRegistry();
    }

    @Test
    @AllureId("17674")
    @Story("PKL")
    @Component("Реестр")
    @DisplayName("Просмотр реестра ПКЛ")
    @Description("Проверить корректности отображения заголовков и наличие карточек в реестре ПКЛ")
    void openingTheRegisterPkl() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Название", "Управление", "Этап", "Статус");
        sidebarPage.clickSidebarMenu(PKL);
        oasirxPage.registryContainsCardsHeadersCheck(PKL, tableColumnList);
    }
}
