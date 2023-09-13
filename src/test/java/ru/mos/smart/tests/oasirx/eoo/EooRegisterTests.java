package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.EOO_URL;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationAPI;


@Epic("Проверки реестров по подсистемам")
@Feature("ОАСИРХ")
@Story("Реестр")
@Owner("Soldatov")
public class EooRegisterTests extends TestBase {

        @Test
        @DisplayName("Проверка наличия данных и перехода в раздел Общеcтвенные обcуждения")
        @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
        void goToRegisterEoo() {
            List<String> columnNames = Arrays.asList("Дата", "Номер", "Округ", "Районы", "Адрес","Исполнитель", "Статус");
            openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
            sidebarPage.goToSection(EOO_URL);
        }

    @Test
    @DisplayName("Наличие заявок в реестре")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkAvailabilityApplication() {
        oasirxProjectsPage.checkAvailabilityApplication(EOO_URL);
    }

    @Test
    @DisplayName("Переход в карточку заявки")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToRequestCard() {
        List<String> tableColumnList = Arrays.asList("Этап", "Результаты", "Сроки");
        oasirxProjectsPage.goToCardEoo(tableColumnList);
    }
}