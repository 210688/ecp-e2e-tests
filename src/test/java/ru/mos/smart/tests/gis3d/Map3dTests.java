package ru.mos.smart.tests.gis3d;

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
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("GIS 3D (Картографическое обеспечение, Конструктор)")
@Feature("Базовый функционал")
public class Map3dTests extends TestBase {

    @Test
    @DisplayName("Открытие приложения Цифровой двойник")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("gis3d")})
    void openTheTsifrovoyDvoynik() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).click();
            $x("//a[@href='/map3d/#/map3d']").click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").waitUntil(visible, 15000);
        });
    }

    @Test
    @DisplayName("Проверка отображения панели слоев")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("gis3d")})
    void checkingTheDisplayOfLayersPanel() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).click();
            $x("//a[@href='/map3d/#/map3d']").click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").waitUntil(visible, 15000);
        });

        step("В левой боковой панели открыть Дерево слоев 2D", () -> $((".fas.fa-layer-group"))
                .click());

        step("Разворачивается панель Дерево слоев 2D", () -> {
            $((".main-left-panel")).shouldBe(visible);
            $x("//div/span[contains(text(),'Дерево слоёв 2D')]").shouldBe(visible);
        });

        step("Закрыть панель Дерево слоев 2D", () -> $((".fas.fa-layer-group"))
                .click());

        step("В левой боковой панели открыть Дерево слоев 3D", () -> $((".fas.fa-cube"))
                .click());

        step("Разворачивается панель Дерево слоев 3D", () -> {
            $((".main-left-panel")).shouldBe(visible);
            $x("//div/span[contains(text(),'Дерево слоёв 3D')]").shouldBe(visible);
        });

        step("Закрыть панель Дерево слоев 3D", () -> $((".fas.fa-cube"))
                .click());

        step("Проверить, что боковая панель закрыта", () -> $((".main-left-panel"))
                .shouldNotBe(visible));
    }
}
