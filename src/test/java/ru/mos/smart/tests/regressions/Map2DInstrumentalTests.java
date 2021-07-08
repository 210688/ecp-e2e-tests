package ru.mos.smart.tests.regressions;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.annotations.AutoMember;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@AutoMember("soldatovks")
@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Базовый функционал 2D")
public class Map2DInstrumentalTests extends TestBase {

    @Test
    @AllureId("4020")
    @DisplayName("Открытие приложения карта")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheMaps() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());
        NavigatorPage.goToMaps();
        switchTo().window(1);
        step("Проверяем, что карта открылась в новой вкладке");
        $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(20));

        step("Проверяем, что на карте присутсвуют слои", () -> {
            Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                    $$(".ng-star-inserted").size() > 0);
        });
    }

    @Test
    @AllureId("3734")
    @Description()
    @DisplayName("Проверка наличия инструментов измерений")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfInstruments() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(20)).click();
        });

        step("Проверить наличие инструментов измерений: линейка, квадрат, многоугольник", () -> {
            $((".fas.fa-ruler")).shouldBe(visible, Duration.ofSeconds(10));
            $((".fas.fa-square-full")).shouldBe(visible, Duration.ofSeconds(10));
            $((".fal.fa-draw-polygon")).shouldBe(visible, Duration.ofSeconds(10));
        });
    }

    @Test
    @AllureId("3736")
    @Description()
    @DisplayName("Проверка наличия строки адресного поиска")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfAddressSearch() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

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
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

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
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfMyLocationTool() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

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
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().login_regress(), webConfig().password_regress());

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