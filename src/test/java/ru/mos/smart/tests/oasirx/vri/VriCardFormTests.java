package ru.mos.smart.tests.oasirx.vri;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.config.ConfigHelper.webConfig;

public class VriCardFormTests extends TestBase {
    @Test
    @AllureId("3312")
    @DisplayName("Форма карточки: История изменений")
    @Story("Работа с реестром и карточкой ВРИ")
    @Feature("VRI (ВРИ)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("vri")})
    void changeHistoryTest() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToVri();

        vriPage
                .openFirstCard()
                .cogWheelChoose("История изменений")
                .checkChangeLogShown();
    }

    @Test
    @AllureId("3311")
    @DisplayName("Форма карточки: Процесс")
    @Story("Работа с реестром и карточкой ВРИ")
    @Feature("VRI (ВРИ)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("vri")})
    void processTest() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToVri();

        vriPage
                .openFirstCard()
                .cogWheelChoose("Процесс")
                .openProcessDiagram();
    }

    @Test
    @AllureId("3326")
    @DisplayName("Форма карточки: Материалы")
    @Story("Работа с реестром и карточкой ВРИ")
    @Feature("VRI (ВРИ)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("vri")})
    void materialsTest() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToVri();

        vriPage
                .openFirstCard()
                .clickButton("Материалы")
                .checkMaterialsShown();
    }
}
