package ru.mos.smart.tests.ugd.mtsk;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Layer("web")
@Epic("UGD (УГД)")
@Feature("MTSK (Московский территориальный строительный каталог)")
@Story("Информация")
@Component("Реестры")
@Owner("Soldatovks")
class CatalogsMtskTests extends TestBase {

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("ugd"), @Tag("mtsk")})
    @DisplayName("Проверка наличия каталогов МТСК")
    @Description("Проверить, что каталог открывается")
    void checkCatalogsMtsk() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());

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
