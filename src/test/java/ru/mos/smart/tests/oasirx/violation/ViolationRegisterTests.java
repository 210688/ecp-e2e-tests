package ru.mos.smart.tests.oasirx.violation;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.VIOLATION;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class ViolationRegisterTests extends TestBase {

    @Test
    @AllureId("17664")
    @Story("Violation")
    @Component("Реестр")
    @DisplayName("Просмотр раздела Нарушения ОГД")
    @Description("Проверить, что открывается раздел Нарушения ОГД")
    void openingTheRegisterViolation() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер АП", "Документ", "Срок истекает", "Статус", "Исполнители");
        sidebarPage.clickSidebarMenu(VIOLATION);
        oasirxPage.registryContainsCardsHeadersCheck(VIOLATION, tableColumnList);
    }

    @Test
    @AllureId("17665")
    @Story("Violation")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра Нарушения ОГД по номеру")
    @Description("Проверить, что происходит поиск карточки реестра Нарушения ОГД по номеру")
    void searchingViolationCardByNumber() {
        sidebarPage.clickSidebarMenu(VIOLATION);
        oasirxPage.searchToCardInRegistry();
    }
}
