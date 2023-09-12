package ru.mos.smart.tests.ugd.oati;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.Registers.UGD_OATI;

@Layer("web")
@Epic("UGD (УГД)")
@Feature("Информация")
@Component("Реестры")
class RegistersUvedomleniaTests extends TestBase {

    @Test
    @DisplayName("Проверка открытия реестров")
    @Description("Проверить, что реестр открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void openRegisterUvedomlenia() {
        reestrPage
                .goToRegister(UGD_OATI);

        step("Открыть реестр ОАТИ. Уведомления", () -> {
            $(byName("candidateSearchValue")).setValue("ОАТИ. Уведомления").pressEnter();
        });

        step("Проверить, что реестр открылся", () -> {
            $(byText("ОАТИ. Уведомления"))
                    .shouldBe(visible);
        });
    }
}


