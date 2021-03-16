package ru.mos.smart.tests.regressions;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Базовый функционал Цифровой двойник")
public class Map3DInstrumentalTests extends TestBase {

    @Test
    @DisplayName("Открытие приложения Цифровой двойник")
    @Tag("regressions")
    void openTheTsifrovoyDvoynik() {
        LoginPage.openUrlWithAuthorization("", smart().login(), smart().passwords());

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
    @Tag("regressions")
    void checkingTheDisplayOfLayersPanel() {
        LoginPage.openUrlWithAuthorization("", smart().login(), smart().passwords());

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
