package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.EOO;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regres")})
public class EooRegisterTests extends TestBase {

        @Test
        @AllureId("17071")
        @Story("EOO")
        @Component("Реестр")
        @DisplayName("Наличия данных и перехода в раздел Общеcтвенные обcуждения")
        @Description("Проверить, что есть данные и происходит переход в раздел - Общественные обсуждения")
        void goToRegisterEoo() {
            List<String> columnNames = Arrays.asList("Дата", "Номер", "Округ", "Районы", "Адрес","Исполнитель", "Статус");
            sidebarPage.clickSidebarMenu(EOO);
        }

    @Test
    @AllureId("17070")
    @Story("EOO")
    @Component("Реестр")
    @DisplayName("Наличие заявок в реестре")
    @Description("Проверить, что есть заявки в реестре")
    void checkAvailabilityApplication() {
        sidebarPage.clickSidebarMenu(EOO);
    }

    @Test
    @AllureId("17069")
    @Story("EOO")
    @Component("Реестр")
    @DisplayName("Переход в карточку заявки")
    @Description("Проверить, что происходит переход в карточку заявки")
    void goToRequestCard() {
        List<String> tableColumnList = Arrays.asList("Этап", "Результаты", "Сроки");
        sidebarPage.clickSidebarMenu(EOO);
    }
}