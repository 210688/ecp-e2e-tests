package ru.mos.smart.tests.oasirx.sb;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.SB;

@Epic("OASI")
@Feature("OASIRX")
@Tags({@Tag("oasirx"), @Tag("regres")})
public class SbRegisterTests extends TestBase {

    @Test
    @AllureId("17671")
    @Story("Sb")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре Самострой")
    @Description("Проверить, что реестр Самострой корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void openingTheRegisterSb() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Округ", "Адрес", "Тип объекта", "Исполнитель", "Статус");
        sidebarPage.clickSidebarMenu(SB);
        oasirxPage.registryContainsCardsHeadersCheck(SB, tableColumnList);
    }

    @Test
    @AllureId("17670")
    @Story("Sb")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра Самострой по номеру")
    @Description("Проверить, что происходит поиск карточки реестра Самострой по номеру")
    void searchingSbCardByNumber() {
        sidebarPage.clickSidebarMenu(SB);
        oasirxPage.searchToCardInRegistry();
    }
}