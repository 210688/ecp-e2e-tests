package ru.mos.smart.tests.dsp;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("DSP (Портал ДС)")
@Feature("Шаблоны")
@Tag("dsp")

public class ShablonyTests extends TestBase {

    @Test
    @DisplayName("Проверка открытия вкладки \"Шаблоны\"")
    void openShablony() {
        openUrlWithAuthorization("", LOGIN_OSSIG, PASSWORD_OSSIG);

        step("Открыть раздел \"Портал ДС\" -> \"Документы\" -> \"Шаблоны\"", () -> {
            $(byLinkText("Портал ДС")).click();
            $(byLinkText("Документы")).click();
            $(byLinkText("Шаблоны")).click();
        });

        step("Раздел открывается", () -> {
            $(byText("Реестр шаблонов")).shouldBe(visible);
        });
    }
}
