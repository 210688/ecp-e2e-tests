package ru.mos.smart.tests.cdp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("web")
@Epic("CDP (ЕЦП_платформа)")

public class EcpTest extends TestBase {

    final String reestrPage = "https://smart-predprod.mos.ru/main/#/app/catalog-registers";

    @Test
    @AllureId("2324")
    @DisplayName("Проверка открытия реестра")
    @Tag("allModules")
    @Tag("prod")
    void openReestr() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());
        MainPage.InformaciyaAndReestr();

        step("Проверить переход на страницу реестры" + reestrPage + ";", () -> {
            $(byText("Реестры"))
                    .shouldBe(Condition.visible);
            assertEquals(reestrPage, WebDriverRunner.url());
        });
    }
}