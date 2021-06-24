package ru.mos.smart.tests.oasi.blago;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.pages.ReestrPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("BLAGO (ОАСИ Благоустройство)")
public class BlagoRegistersTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия реестров")
    @Tags({@Tag("preprod"), @Tag("prod"), @Tag("regres"), @Tag("oasi"), @Tag("blago")})
    void checkingBlagoRegisters() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());
        NavigatorPage.goToRegister();
        ReestrPage.open("Проекты благоустройства");
        $(byText("Реестры")).shouldBe(visible);
    }
}
