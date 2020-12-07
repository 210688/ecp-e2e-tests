package ru.mos.smart.tests.dsp;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("DSP (Портал ДС)")
@Feature("Шаблоны")
public class ShablonyTests extends TestBase {

    @Test
    @AllureId("2690")
    @DisplayName("Проверка открытия вкладки Шаблоны")
    @Tag("allModules")
    @Tag("prod")
    void openShablony() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());

        step("Открыть раздел Портал ДС -> Документы -> Шаблоны", () -> {
            $(byLinkText("Портал ДС")).click();
            $(byLinkText("Документы")).click();
            $(byLinkText("Шаблоны")).click();
        });

        step("Раздел открывается", () -> $(byText("Реестр шаблонов"))
                .shouldBe(visible));
    }
}
