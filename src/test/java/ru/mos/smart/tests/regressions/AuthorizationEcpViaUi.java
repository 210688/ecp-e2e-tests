package ru.mos.smart.tests.regressions;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class AuthorizationEcpViaUi extends TestBase {


    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
    @Feature("Меню Госуслуги и функции")
    @DisplayName("Проверка авторизации через UI")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void authorizationEcpViaUi() {

        AuthorizationPage.openUrlWithAuthorizationUI("", webConfig().loginRegress(), webConfig().passwordRegress());
        step("В навигаторе присутствует надпись  Правительство Москвы", () ->
                $("h3").shouldHave(text("Правительство Москвы")).shouldBe(visible));
    }
}
