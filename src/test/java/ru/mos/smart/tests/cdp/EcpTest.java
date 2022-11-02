package ru.mos.smart.tests.cdp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Layer("web")
@Epic("CDP (ЕЦП_платформа)")

public class EcpTest extends TestBase {

    final String reestrPage = "https://smart-predprod.mos.ru/main/#/app/catalog-registers";

    @Test
    @DisplayName("Проверка открытия реестра")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ecp")})
    void openReestr() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        step("Проверить переход на страницу реестры" + reestrPage + ";", () -> {
            $(byText("Реестры"))
                    .shouldBe(Condition.visible);
            assertEquals(reestrPage, WebDriverRunner.url());
        });
    }
}