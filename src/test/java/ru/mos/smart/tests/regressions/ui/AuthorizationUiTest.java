package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.config.ConfigHelper.*;

public class AuthorizationUiTest extends TestBase {

    @Test
    @Epic("Регрессионные тесты для проверки базового функционала")
    @Feature("Меню Госуслуги и функции")
    @Owner("soldatovks")
    @Layer("web")
    @DisplayName("Проверить авторизацию через UI")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("regressionsProd")})
    @Step("Проверить авторизацию через UI")
    void authorizationEcpViaUi() {
        AuthorizationPage.openUrlWithAuthorizationUI(getWebSecureUrl(), getLoginRegress(), getPasswordRegress());
        navigatorPage.checkPageTask();
    }
}