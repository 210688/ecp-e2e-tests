package ru.mos.smart.tests.regressions;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.AutoMember;
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
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6549")
    @DisplayName("Авторизация через UI")
    @Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
    @Feature("Меню Госуслуги и функции")
    void authorizationEcpViaUi() {

        AuthorizationPage.openUrlWithAuthorizationUI("", webConfig().login_regress(), webConfig().password_regress());
        step("В навигаторе присутствует надпись  Правительство Москвы", () ->
                $("h3").shouldHave(text("Правительство Москвы")).shouldBe(visible));
    }
}
