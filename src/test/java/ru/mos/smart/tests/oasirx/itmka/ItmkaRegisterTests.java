package ru.mos.smart.tests.oasirx.itmka;

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

import static ru.mos.smart.data.enums.Sidebar.ITMKA;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class ItmkaRegisterTests extends TestBase {

    @Test
    @Story("Itmka")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре Управление информатизацией МКА")
    @Description("Проверить, что реестр Управление информатизацией МКА корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void openingTheRegisterItmka() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Название", "Статус", "Назначено", "Подсистема", "Кол-во новых заявокНовых", "Кол-во заявок в работеВ работе",
                "Кол-во закрытых заявокЗакрытых", "Всего", "Из них просрочены", "Всего", "Из них выполнены в срок", "Из них выполнены не в срок");
        sidebarPage.clickSidebarMenu(ITMKA);
        oasirxPage.registryContainsCardsHeadersCheck(ITMKA, tableColumnList);
    }

    @Test
    @Story("Itmka")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра заявок Управление ИТ МКА по номеру")
    @Description("Проверить, что происходит поиск карточки реестра заявок - Управление ИТ МКА по номеру")
    void searchingItmkaCardByNumber() {
        sidebarPage.clickSidebarMenu(ITMKA);
        oasirxPage.searchToCardInRegistry();
    }
}
