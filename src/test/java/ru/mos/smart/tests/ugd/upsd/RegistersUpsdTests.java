package ru.mos.smart.tests.ugd.upsd;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.Registers.UGD_UPSD;

@Epic("UGD")
@Feature("UPSD")
@Story("Информация")
@Component("Реестры")
class RegistersUpsdTests extends TestBase {

    @Test
    @DisplayName("Проверка доступности реестра \"УПСД. Подведомственные организации, утверждающие проектную документацию\"")
    @Description("Проверить, что реестр открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void registerUpsdViewing() {
        reestrPage
                .goToRegister(UGD_UPSD);

        step("Найти реестр и перейти в него", () -> {

        });

        step("Проверка открытия реестра", () -> {

        });
    }
}