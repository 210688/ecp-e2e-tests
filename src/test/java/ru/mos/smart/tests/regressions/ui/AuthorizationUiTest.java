package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

@Owner("Soldatov")
@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Авторизация")
public class AuthorizationUiTest extends TestBase {

    @Test
    @AllureId("12310")
    @DisplayName("Проверка авторизации через UI")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void authorizationEcpViaUi() {
        //sidebarPage.checkPageTask();
    }
}