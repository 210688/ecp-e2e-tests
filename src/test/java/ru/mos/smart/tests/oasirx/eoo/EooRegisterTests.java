package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.AllureId;
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

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.EOO_URL;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationAPI;

@Epic("OASI")
@Feature("ОАСИРХ")
@Story("eoo")
@Component("Реестр")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class EooRegisterTests extends TestBase {

        @Test
        @AllureId("17071")
        @DisplayName("Проверка наличия данных и перехода в раздел Общеcтвенные обcуждения")
        void goToRegisterEoo() {
            List<String> columnNames = Arrays.asList("Дата", "Номер", "Округ", "Районы", "Адрес","Исполнитель", "Статус");
            openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
            sidebarPage.goToSection(EOO_URL);
        }

    @Test
    @AllureId("17070")
    @DisplayName("Наличие заявок в реестре")
    void checkAvailabilityApplication() {
        oasirxProjectsPage.checkAvailabilityApplication(EOO_URL);
    }

    @Test
    @AllureId("17069")
    @DisplayName("Переход в карточку заявки")
    void goToRequestCard() {
        List<String> tableColumnList = Arrays.asList("Этап", "Результаты", "Сроки");
        oasirxProjectsPage.goToCardEoo(tableColumnList);
    }
}