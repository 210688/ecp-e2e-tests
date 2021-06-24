package ru.mos.smart.tests.gis2d;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

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
    @DisplayName("Проверка наличия инструментов измерений")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("gis2d")})
    void checkingAvailabilityOfInstruments() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(10));
        });

        step("Проверить наличие инструментов измерений: линейка, квадрат, многоугольник", () -> {
            $((".fas.fa-ruler")).shouldBe(visible);
            $((".fas.fa-square-full")).shouldBe(visible);
            $((".fal.fa-draw-polygon")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка наличия строки адресного поиска")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("gis2d")})
    void checkingAvailabilityOfAddressSearch() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(10));
        });

        step("Проверить наличие строки адресного поиска", () -> {
            $x("//div/input[contains(@class,'form-control')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка наличия инструментов масштабирования")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("gis2d")})
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(10));
        });

        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $((".fal.fa-plus")).shouldBe(visible);
            $((".fal.fa-minus")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("gis2d")})
    void checkingAvailabilityOfMyLocationTool() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(10));
        });

        step("Проверить наличия инструмента Мое местоположение", () -> {
            $((".fas.fa-location-arrow")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("gis2d")})
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(10));
        });

        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $((".fas.fa-home-alt")).shouldBe(visible);
        });
    }
}
