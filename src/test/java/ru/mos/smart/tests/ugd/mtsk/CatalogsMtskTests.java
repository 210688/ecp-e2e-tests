package ru.mos.smart.tests.ugd.mtsk;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("Платформа ЕЦП")
@Feature("UGD (УГД)")
@Story("Каталоги МТСК")
@Tag("ugd") @Tag("mtsk")
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
