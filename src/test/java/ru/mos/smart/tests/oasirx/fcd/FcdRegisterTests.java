package ru.mos.smart.tests.oasirx.fcd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.data.enums.Registers.OASI_BLAGO_PRO;
import static ru.mos.smart.data.enums.Sidebar.FCD;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class FcdRegisterTests extends TestBase {

    @Test
    @AllureId("17068")
    @Story("FCD")
    @Component("Реестр")
    @DisplayName("Наличия данных и перехода в раздел Фасады нежильё")
    @Description("Проверить, что есть данные и происходит переход в раздел Фасады нежильё")
    void goToRegisterEoo() {
        List<String> columnNames = Arrays.asList("Дата", "Номер", "Номер ПГУ", "Адрес", "Исполнитель", "Тип запроса", "Статус");
        sidebarPage.clickSidebarMenu(FCD);
    }

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @AllureId("17067")
    @Story("FCD")
    @Component("Реестр")
    @DisplayName("Переход в реестр Фасады")
    @Description("Проверить, что происходит переход в реестр Фасады")
    void goToFacades() {
        sidebarPage.clickSidebarMenu(FCD);
        $(byText("Фасады нежильё")).should(visible);
    }

    @Test
    @AllureId("17066")
    @Story("FCD")
    @Component("Реестр")
    @DisplayName("Заголовки колонок в реестре Фасады")
    @Description("Проверить, что есть заголовки колонок в реестре Фасады")
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("В работе", "Все", "Мои", "Статистика");
        sidebarPage.clickSidebarMenu(FCD);
        generalPage.registryContainsCardsHeadersCheck(OASI_BLAGO_PRO, tableColumnList);
    }
}
