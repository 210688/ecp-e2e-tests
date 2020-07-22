package ru.mos.smart.tests.ugd;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.helpers.DriverHelper.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("Модуль \"UGD\"")
@Story("Проверка открытия \"реестров\"")
@Tag("UGD")
@Tag("OATI")
@Tag("ECP")
class OpenRegisterUvedomlenia extends TestBase {
    @Test
    @Description("Проверка открытия реестров")
    void OpenRegisterUvedomlenia() {
        step("Авторизация", () -> {
            openUrlWithAuthorization("", LOGIN_UGD, PASSWORD_UGD);
        });

        step("Открытие в навигаторе Информация - Реестры", () -> {
            $(byLinkText("Информация")).click();
            $(byLinkText("Реестры")).click();
        });

        step("Открыть реестр ОАТИ. Уведомления", () -> {
            $(byName("candidateSearchValue")).setValue("ОАТИ. Уведомления").pressEnter();
        });

        step("Проверка, что креестр открылся", ()-> {
            $(byText("ОАТИ. Уведомления")).shouldBe(visible);
        });
    }
}


