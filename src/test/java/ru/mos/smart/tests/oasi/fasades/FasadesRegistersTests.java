package ru.mos.smart.tests.oasi.fasades;

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
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("FASADES (ОАСИ Фасады)")
public class FasadesRegistersTests extends TestBase {

    @Test
    @DisplayName("Проверка перехода к реестру Проекты изменений фасадов зданий (жилые)")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasi"), @Tag("fasades")})
    void openRegisterFasadesZhil() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());
        NavigatorPage.goToRegister();
        ReestrPage.open("Проекты изменений фасадов зданий (жилые)");
        step("Реестр открывается, присутствует список", () -> {
            $(byText("Проекты изменений фасадов зданий (жилые)")).shouldBe(visible);
        });
    }
}