package ru.mos.smart.tests.gis3d;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("GIS 3D (Картографическое обеспечение, Конструктор)")
@Feature("Базовый функционал")
public class Map3dTests extends TestBase {

    @Test
    @DisplayName("Открытие приложения Цифровой двойник")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    void openTheTsifrovoyDvoynik() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).click();
            $x("//a[@href='/map3d/#/map3d']").click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").waitUntil(visible, 10000);
        });
    }

    @Test
    @DisplayName("Проверка отображения панели слоев")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    void checkingTheDisplayOfLayersPanel() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).click();
            $x("//a[@href='/map3d/#/map3d']").click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").waitUntil(visible, 10000);
        });

        step("В левой боковой панели открыть Дерево слоев 2D", () -> {
            $((".fas.fa-layer-group")).click();
        });

        step("Разворачивается панель Дерево слоев 2D", () -> {
            $((".main-left-panel")).shouldBe(visible);
            $x("//div/span[contains(text(),'Дерево слоёв 2D')]").shouldBe(visible);
        });

        step("Закрыть панель Дерево слоев 2D", () -> {
            $((".fas.fa-layer-group")).click();
        });

        step("В левой боковой панели открыть Дерево слоев 3D", () -> {
            $((".fas.fa-cube")).click();
        });

        step("Разворачивается панель Дерево слоев 3D", () -> {
            $((".main-left-panel")).shouldBe(visible);
            $x("//div/span[contains(text(),'Дерево слоёв 3D')]").shouldBe(visible);
        });

        step("Закрыть панель Дерево слоев 3D", () -> {
            $((".fas.fa-cube")).click();
        });

        step("Проверить, что боковая панель закрыта", () -> {
            $((".main-left-panel")).shouldNotBe(visible);
        });
    }
}
