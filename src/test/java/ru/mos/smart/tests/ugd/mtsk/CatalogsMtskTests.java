package ru.mos.smart.tests.ugd.mtsk;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("UGD (УГД)")
@Owner("Soldatovks")
@Feature("MTSK (Московский территориальный строительный каталог)")
@Story("Автотесты")
class CatalogsMtskTests extends TestBase {

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("ugd"), @Tag("mtsk")})
    @DisplayName("Проверка наличия каталогов МТСК")
    void checkCatalogsMtsk() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginUgd(), webConfig().passwordUgd());

        step("Развернуть в навигаторе блок МТСК", () -> $(byLinkText("МТСК"))
                .click());

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
