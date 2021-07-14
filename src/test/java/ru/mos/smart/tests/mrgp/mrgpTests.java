package ru.mos.smart.tests.mrgp;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("MRGP")
public class mrgpTests extends TestBase {
    @Test
    @DisplayName("Проверка открытия реестра")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("mrgp")})
    void openReestr() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().logins(), webConfig().password());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Перечень программ");

        step("Открытие реестра Перечень программ", () -> {
            $(byText("Перечень программ")).shouldBe(visible);
        });
    }
}