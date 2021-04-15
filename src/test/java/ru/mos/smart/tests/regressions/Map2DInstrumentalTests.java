package ru.mos.smart.tests.regressions;

import io.qameta.allure.AllureId;
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
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Базовый функционал 2D")
public class Map2DInstrumentalTests extends TestBase {

    @Test
    @AllureId("4020")
    @DisplayName("Открытие приложения карта")
    @Tag("regressions")
    void openTheTsifrovoyDvoynik() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).shouldBe(visible).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(15)).click();
        });
    }

    @Test
    @AllureId("3734")
    @Description()
    @DisplayName("Проверка наличия инструментов измерений")
    @Tag("regressions")
    void checkingAvailabilityOfInstruments() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(15)).click();
        });

        step("Проверить наличие инструментов измерений: линейка, квадрат, многоугольник", () -> {
            $((".fas.fa-ruler")).shouldBe(visible);
            $((".fas.fa-square-full")).shouldBe(visible);
            $((".fal.fa-draw-polygon")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("3736")
    @Description()
    @DisplayName("Проверка наличия строки адресного поиска")
    @Tag("regressions")
    void checkingAvailabilityOfAddressSearch() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).shouldBe(visible).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(15)).click();
        });

        step("Проверить наличие строк адресного поиска и найти слой", () -> {
            $(".form-control").shouldBe(visible);
        });
    }

    @Test
    @AllureId("3737")
    @Description()
    @DisplayName("Проверка наличия инструментов масштабирования")
    @Tag("regressions")
    void checkingAvailabilityOfScalingTools() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).shouldBe(visible).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(15)).click();
        });

        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $((".fal.fa-plus")).shouldBe(visible);
            $((".fal.fa-minus")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("3738")
    @Description()
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    @Tag("regressions")
    void checkingAvailabilityOfMyLocationTool() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).shouldBe(visible).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(10)).click();
        });

        step("Проверить наличия инструмента Мое местоположение", () -> {
            $((".fas.fa-location-arrow")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("3735")
    @Description()
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tag("regressions")
    void checkingAvailabilityOfInitialPositionTool() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).shouldBe(visible).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(10)).click();
        });

        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $((".fas.fa-home-alt")).shouldBe(visible);
        });
    }
}