package ru.mos.smart.tests.gis2d;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
@Epic("GIS 2D (Картографическое обеспечение, Реинформ)")
@Feature("Базовый функционал 2D")
public class Map2DInstrumentTests extends TestBase {

    @Test
    @Description("Используется тестовый пользователь с правами группы GIS")
    @DisplayName("Проверка наличия инструментов измерений")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void checkingAvailabilityOfInstruments() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").waitUntil(visible, 15000);
        });

        step("Проверить наличие инструментов измерений: линейка, квадрат, многоугольник", () -> {
            $((".fas.fa-ruler")).shouldBe(visible);
            $((".fas.fa-square-full")).shouldBe(visible);
            $((".fal.fa-draw-polygon")).shouldBe(visible);
        });
    }

    @Test
    @Description("Используется тестовый пользователь с правами группы GIS")
    @DisplayName("Проверка наличия строки адресного поиска")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void checkingAvailabilityOfAddressSearch() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").waitUntil(visible, 15000);
        });

        step("Проверить наличие строки адресного поиска", () -> {
            $x("//div/input[contains(@class,'form-control')]").shouldBe(visible);
        });
    }

    @Test
    @Description("Используется тестовый пользователь с правами группы GIS")
    @DisplayName("Проверка наличия инструментов масштабирования")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").waitUntil(visible, 15000);
        });

        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $((".fal.fa-plus")).shouldBe(visible);
            $((".fal.fa-minus")).shouldBe(visible);
        });
    }

    @Test
    @Description("Используется тестовый пользователь с правами группы GIS")
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void checkingAvailabilityOfMyLocationTool() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").waitUntil(visible, 15000);
        });

        step("Проверить наличия инструмента Мое местоположение", () -> {
            $((".fas.fa-location-arrow")).shouldBe(visible);
        });
    }

    @Test
    @Description("Используется тестовый пользователь с правами группы GIS")
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").waitUntil(visible, 15000);
        });

        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $((".fas.fa-home-alt")).shouldBe(visible);
        });
    }
}
