package ru.mos.smart.tests.oasirx.sprit;

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

import static ru.mos.smart.data.enums.Sidebar.SPRIT;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class SpritTests extends TestBase {

    @Test
    @Story("Sprit")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре Самострой")
    @Description("Проверить, что реестр Самострой корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void openingTheRegisterSprit() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Округ", "Адрес", "Тип объекта", "Исполнитель", "Статус");
        sidebarPage.clickSidebarMenu(SPRIT);
        oasirxPage.registryContainsCardsHeadersCheck(SPRIT, tableColumnList);
    }

    @Test
    @Story("Sprit")
    @Component("Реестр")
    @DisplayName("Проверка работы поиска в реестре СПРИТ")
    @Description("Проверить открытия и заполнения карточки после поиска в реестре")
    void searchingSpritCardByNumber() {
        sidebarPage.clickSidebarMenu(SPRIT);
        oasirxPage.searchToCardInRegistry();
    }
}














