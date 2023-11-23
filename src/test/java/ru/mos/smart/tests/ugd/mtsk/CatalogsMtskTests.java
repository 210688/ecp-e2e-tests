package ru.mos.smart.tests.ugd.mtsk;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("UGD")
@Feature("Ugd")
@Owner("Soldatovks")
@Tags({@Tag("ugd"), @Tag("regres")})
class CatalogsMtskTests extends TestBase {

    @Test
    @AllureId("16983")
    @Story("Mtsk")
    @Component("Реестры")
    @DisplayName("Наличия каталогов МТСК")
    @Description("Проверить, что каталог открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkCatalogsMtsk() {
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
