package ru.mos.smart.tests.ugd.mtsk;

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
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("Модуль \"UGD\"")
@Story("Проверка наличия каталогов МТСК")
@Tag("UGD")
@Tag("MTSK")
@Tag("ECP")

class catalogsMTSK extends TestBase {
    @Test
    @Description("Проверка наличия каталогов МТСК")
    void catalogsMTSK() {
        openUrlWithAuthorization("", LOGIN_UGD, PASSWORD_UGD);

        step("Развернуть в навигаторе блок МТСК", () -> {
            $(byLinkText("МТСК")).click();
        });

        step("Проверка наличия каталогов", () -> {
            $(byText("Инновации")).shouldBe(visible);
            $(byText("Документы")).shouldBe(visible);
            $(byText("Услуги")).shouldBe(visible);
            $(byText("Организации")).shouldBe(visible);
            $(byText("Строительные ресурсы")).shouldBe(visible);
            $(byText("Проектные решения")).shouldBe(visible);
        });

    }
}
