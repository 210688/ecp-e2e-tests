package ru.mos.smart.tests.ugd.upsd;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

@Epic("Платформа ЕЦП")
@Feature("UGD (УГД)")
@Story("Проверка доступности реестров УПСД")
@Tag("ugd")
@Tag("upsd")
class RegistersUpsdTests extends TestBase {

    @Test
    @Disabled()
    @DisplayName("Проверка доступности реестра \"УПСД. Подведомственные организации, утверждающие проектную документацию\"")
    void registerUpsdViewing() {
        LoginPage.openUrlWithAuthorization("", smart().logins(), smart().password());
        MainPage.InformaciyaAndReestr();

        step("Найти реестр и перейти в него", () -> {

        });

        step("Проверка открытия реестра", () -> {

        });
    }
}