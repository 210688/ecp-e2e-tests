package ru.mos.smart.tests.ugd.mtsk;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Epic("UGD (УГД)")
@Feature("MTSK (Московский территориальный строительный каталог)")
@Tag("ugd") @Tag("mtsk") @Tag("all_tests")
class CatalogsMtskTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия каталогов МТСК")
    void checkCatalogsMtsk() {
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
