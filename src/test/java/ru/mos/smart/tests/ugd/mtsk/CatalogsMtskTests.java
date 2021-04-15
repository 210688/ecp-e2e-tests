package ru.mos.smart.tests.ugd.mtsk;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("UGD (УГД)")
@Feature("MTSK (Московский территориальный строительный каталог)")
class CatalogsMtskTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия каталогов МТСК")
    @Tags({@Tag("mtsk"), @Tag("preprod"), @Tag("prod"), @Tag("ugd")})
    void checkCatalogsMtsk() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());

        step("Развернуть в навигаторе блок МТСК", () -> $(byLinkText("МТСК"))
                .click());

        step("Проверка наличия каталогов", () -> {
            $(byText("Документы")).shouldBe(visible);
            $(byText("Инновации")).shouldBe(visible);
            $(byText("Услуги")).shouldBe(visible);
            $(byText("Строительные ресурсы")).shouldBe(visible);
            $(byText("Проектные решения")).shouldBe(visible);
            $(byText("Организации")).shouldBe(visible);
        });
    }
}
