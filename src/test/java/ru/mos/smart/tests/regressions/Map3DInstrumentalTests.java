package ru.mos.smart.tests.regressions;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Базовый функционал Цифровой двойник")
public class Map3DInstrumentalTests extends TestBase {

    @Test
    @DisplayName("Открытие приложения Цифровой двойник")
    @Tag("regressions")
    void openTheTsifrovoyDvoynik() {
        LoginPage.openUrlWithAuthorization("", webConfig().login(), webConfig().passwords());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(30)).click();
        });
    }

    @Test
    @DisplayName("Проверка отображения панели слоев")
    @Tag("regressions")
    void checkingTheDisplayOfLayersPanel() {
        LoginPage.openUrlWithAuthorization("", webConfig().login(), webConfig().passwords());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(30)).click();
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

    @Test
    @Description("")
    @DisplayName("Проверка наличия строки адресного поиска")
    @Tag("regressions")
    void checkingAvailabilityOfAddressSearch() {
        LoginPage.openUrlWithAuthorization("", webConfig().login(), webConfig().passwords());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20)).click();
        });

        step("Проверить наличие строки адресного поиска", () -> {
            $x("//div/input[contains(@class,'form-control')]").shouldBe(visible);
        });
    }

    @Test
    @Description("")
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    @Tag("regressions")
    void checkingAvailabilityOfScalingTools() {
        LoginPage.openUrlWithAuthorization("", webConfig().login(), webConfig().passwords());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20)).click();
        });

        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $((".far.fa-plus")).shouldBe(visible);
            $((".far.fa-minus")).shouldBe(visible);
        });
    }

    @Test
    @Description("")
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tag("regressions")
    void checkingAvailabilityOfInitialPositionTool() {
        LoginPage.openUrlWithAuthorization("", webConfig().login(), webConfig().passwords());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20)).click();
        });

        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $((".fas.fa-home-alt")).shouldBe(visible);
        });
    }

    @Test
    @Description("")
    @DisplayName("Проверка наличия инструментов")
    @Tag("regressions")
    void checkingAvailabilityOfInstruments() {
        LoginPage.openUrlWithAuthorization("", webConfig().login(), webConfig().passwords());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20)).click();
        });

        step("Проверить наличие инструментов: линейка, треугольник, выбор подложки", () -> {
            $((".fas.fa-ruler")).shouldBe(visible);
            $((".fas.fa-ruler-triangle")).shouldBe(visible);
            $((".fas.fa-map")).shouldBe(visible);
        });
    }
}