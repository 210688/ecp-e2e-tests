package ru.mos.smart.tests.ugd.oati;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
@Epic("UGD (УГД)")
@Feature("OATI (Уведомления ОАТИ)")
@Tag("ugd") @Tag("oati")
class RegistersUvedomleniaTests extends TestBase {

    @Test
    @DisplayName("Проверка открытия реестров")
    void OpenRegisterUvedomlenia() {
        openUrlWithAuthorization("", LOGIN_UGD, PASSWORD_UGD);

        step("Открытие в навигаторе Информация > Реестры", () -> {
            $(byLinkText("Информация")).click();
            $(byLinkText("Реестры")).click();
        });

        step("Открыть реестр ОАТИ. Уведомления", () -> {
            $(byName("candidateSearchValue")).setValue("ОАТИ. Уведомления").pressEnter();
        });

        step("Проверка, что реестр открылся", ()-> {
            $(byText("ОАТИ. Уведомления")).shouldBe(visible);
        });
    }
}


