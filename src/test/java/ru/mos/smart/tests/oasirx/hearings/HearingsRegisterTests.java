package ru.mos.smart.tests.oasirx.hearings;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.HEARINGS;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class HearingsRegisterTests extends TestBase {

    @Test
    @AllureId("12534")
    @Story("Hearings")
    @Component("Реестр")
    @DisplayName("Переход в реестр Публичные слушания")
    @Description("Проверить, что происходит переход в реестр - Публичные слушания")
    void goToRegisterHearing() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Район", "Описание", "Статус", "Начало этапа");
        sidebarPage.clickSidebarMenu(HEARINGS);
        oasirxPage.registryContainsCardsHeadersCheck(HEARINGS, tableColumnList);
    }

    @Test
    @AllureId("12535")
    @Story("Hearings")
    @Component("Реестр")
    @DisplayName("Поиск в реестре")
    @Description("Проверить, что поиск карточки в реестре Публичные слушания работает корректно")
    void checkHeadersTables() {
        sidebarPage.clickSidebarMenu(HEARINGS);
        oasirxPage.searchToCardInRegistry();
    }
}
