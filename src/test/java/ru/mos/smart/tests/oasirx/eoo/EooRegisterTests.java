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

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.EOO_URL;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationAPI;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class EooRegisterTests extends TestBase {

        @Test
        @AllureId("17071")
        @Story("EOO")
        @Component("Реестр")
        @DisplayName("Наличия данных и перехода в раздел Общеcтвенные обcуждения")
        @Description("Проверить, что есть данные и происходит переход в раздел - Общественные обсуждения")
        void goToRegisterEoo() {
            List<String> columnNames = Arrays.asList("Дата", "Номер", "Округ", "Районы", "Адрес","Исполнитель", "Статус");
            openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
            sidebarPage.goToSection(EOO_URL);
        }

    @Test
    @AllureId("17070")
    @DisplayName("Наличие заявок в реестре")
    @Description("Проверить, что есть заявки в реестре")
    void checkAvailabilityApplication() {
        oasirxProjectsPage.checkAvailabilityApplication(EOO_URL);
    }

    @Test
    @AllureId("17069")
    @DisplayName("Переход в карточку заявки")
    @Description("Проверить, что происходит переход в карточку заявки")
    void goToRequestCard() {
        List<String> tableColumnList = Arrays.asList("Этап", "Результаты", "Сроки");
        oasirxProjectsPage.goToCardEoo(tableColumnList);
    }
}