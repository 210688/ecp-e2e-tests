package ru.mos.smart.tests.oasirx.fcd;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.FCD;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class FcdRegisterTests extends TestBase {

    @Test
    @Story("FCD")
    @Component("Реестр")
    @DisplayName("Наличия данных и перехода в раздел Фасады")
    @Description("Проверить, что есть данные и происходит переход в раздел Фасады")
    void goToRegisterEoo() {
        List<String> columnNames = Arrays.asList("Дата", "Номер", "Номер ПГУ", "Адрес", "Исполнитель", "Тип запроса", "Статус");
        sidebarPage.clickSidebarMenu(FCD);
        oasirxPage.registryContainsCardsHeadersCheck(FCD, columnNames);
    }

    @Test
    @Story("FCD")
    @Component("Реестр")
    @DisplayName("Поиск карточки")
    @Description("Проверить, что поиск карточки в реестре Фасады работает корректно")
    void checkHeadersTables() {
        sidebarPage.clickSidebarMenu(FCD);
        oasirxPage.searchToCardInRegistry();
    }
}
