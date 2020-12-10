package ru.mos.smart.tests.ugd.oati;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("UGD (УГД)")
@Feature("OATI (Уведомления ОАТИ)")
class RegistersUvedomleniaTests extends TestBase {

    @Test
    @DisplayName("Проверка открытия реестров")
    @Tag("allModules")
    @Tag("prod")
    void openRegisterUvedomlenia() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());
        MainPage.InformaciyaAndReestr();

        step("Открыть реестр ОАТИ. Уведомления", () -> {
            $(byName("candidateSearchValue")).setValue("ОАТИ. Уведомления").pressEnter();
        });

        step("Проверить, что реестр открылся", ()-> {
            $(byText("ОАТИ. Уведомления"))
                    .shouldBe(visible);
        });
    }
}


