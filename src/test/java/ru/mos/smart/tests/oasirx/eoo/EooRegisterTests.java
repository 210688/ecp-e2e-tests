package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.RegisterObjectType.EOO;

@Epic("OASIRX")
@Feature("EOO (Общественные обсуждения)")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("eoo"), @Tag("regressions")})
public class EooRegisterTests extends TestBase {

    @Test
    @DisplayName("Переход в реестр Общественные обсуждения")
    @Description("Проверить переход в реестр")
    void goToRegisterEoo() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();
        eooPage.checkHeading(EOO);
    }

    @Test
    @DisplayName("Наличие заявок в реестре")
    @Description("Проверить наличие заявок в реестре")
    void checkAvailabilityApplication() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();
        oasirxProjectsPage.checkAvailabilityApplication(EOO);
    }

    @Test
    @DisplayName("Переход в карточку заявки")
    @Description("Проверить переход в карточку заявления")
    void goToRequestCard() {
        List<String> tableColumnList = Arrays.asList("Этап", "Результаты", "Сроки");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToEoo();
        oasirxProjectsPage.goToCardEoo(tableColumnList);
    }
}