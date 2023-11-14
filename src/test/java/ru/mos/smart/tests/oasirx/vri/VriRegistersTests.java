package ru.mos.smart.tests.oasirx.vri;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.VRI;

@Epic("OASI")
@Feature("OASIRX")
@Tags({@Tag("oasirx"), @Tag("regres")})
public class VriRegistersTests extends TestBase {

    @Test
    @AllureId("17048")
    @Story("Vri")
    @Component("Реестр")
    @DisplayName("Просмотр вкладок в реестре ВРИ")
    @Description("Проверить, что вкладки в реестре ВРИ - открываются")
    void openRegisterVri() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Адр. ориентир", "Кад. номер ЗУ, OKC",
                "Окончание согласования", "Статус", "Решение");
        sidebarPage.clickSidebarMenu(VRI);
        oasirxPage.registryContainsCardsHeadersCheck(VRI, tableColumnList);
    }

    @Test
    @AllureId("17047")
    @Story("Vri")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра ВРИ по номеру")
    @Description("Проверить, что происходит поиск карточки реестра ВРИ по номеру")
    void searchingVriCardByNumber() {
        sidebarPage.clickSidebarMenu(VRI);
        oasirxPage.searchToCardInRegistry();
    }
}