package ru.mos.smart.tests.ugd.upsd;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("UGD (УГД)")
@Story("Проверка доступности реестров УПСД")
@Tag("ugd") @Tag("upsd")
class RegistersUpsdTests extends TestBase {

    @Test
    @DisplayName("Проверка доступности реестра \"УПСД. Подведомственные организации, утверждающие проектную документацию\"")
    void registerUpsdViewing() {
        openUrlWithAuthorization("", LOGIN_UGD, PASSWORD_UGD);

        step("Перейти \"Информация\" -> \"Реестры\"", () -> {
            $(byLinkText("Информация")).click();
            $(byLinkText("Реестры")).click();
        });

        step("Найти реестр и перейти в него", () -> {

        });

        step("Проверка открытия реестра", () -> {

        });
    }
}