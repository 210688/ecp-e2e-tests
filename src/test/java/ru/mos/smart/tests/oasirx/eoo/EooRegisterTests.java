package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeOasirx.EOO_URL;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationAPI;


@Epic("Проверки реестров по подсистемам")
@Feature("ОАСИРХ")
@Story("Реестр")
@Layer("web")
@Owner("Soldatov")
public class EooRegisterTests extends TestBase {

        @Test
        @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("oasirxReestr")})
        @DisplayName("Проверка наличия данных и перехода в раздел Общеcтвенные обcуждения")
        void goToRegisterEoo() {
            List<String> columnNames = Arrays.asList("Дата", "Номер", "Округ", "Районы", "Адрес","Исполнитель", "Статус");
            openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
            sidebarPage.goToSection(EOO_URL);
            //reestrPage.searchField();
            //reestrPage.checkFieldData(EOO_URL, columnNames);
        }

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("eoo"), @Tag("oasirxCards")})
    @DisplayName("Наличие заявок в реестре")
    void checkAvailabilityApplication() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        //urlPage.goToEoo();
        oasirxProjectsPage.checkAvailabilityApplication(EOO_URL);
    }

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("eoo"), @Tag("oasirxCards")})
    @DisplayName("Переход в карточку заявки")
    void goToRequestCard() {
        List<String> tableColumnList = Arrays.asList("Этап", "Результаты", "Сроки");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        //urlPage.goToEoo();
        oasirxProjectsPage.goToCardEoo(tableColumnList);
    }
}