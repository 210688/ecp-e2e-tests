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
import static ru.mos.smart.data.RegisterObjectType.EOO;

@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Oasirx")
@Story("EOO (Общественные обсуждения)")
@Owner("Soldatov")
@Layer("web")
public class EooRegisterTests extends TestBase {

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("eoo"), @Tag("regressions")})
    @DisplayName("Переход в реестр Общественные обсуждения")
    void goToRegisterEoo() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();
        eooPage.checkHeading(EOO);
    }

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("eoo"), @Tag("regressions")})
    @DisplayName("Наличие заявок в реестре")
    void checkAvailabilityApplication() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();
        oasirxProjectsPage.checkAvailabilityApplication(EOO);
    }

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("eoo"), @Tag("regressions")})
    @DisplayName("Переход в карточку заявки")
    void goToRequestCard() {
        List<String> tableColumnList = Arrays.asList("Этап", "Результаты", "Сроки");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();
        oasirxProjectsPage.goToCardEoo(tableColumnList);
    }
}