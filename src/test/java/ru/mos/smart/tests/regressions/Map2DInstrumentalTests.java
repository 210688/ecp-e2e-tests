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
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Базовый функционал 2D")
public class Map2DInstrumentalTests extends TestBase {

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6542")
    @DisplayName("Открытие приложения карта")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void openTheMaps() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());
        navigatorPage
                .goToMaps();
        switchTo().window(1);
        step("Проверяем, что карта открылась в новой вкладке");
        $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(20));

        step("Проверяем, что на карте присутсвуют слои", () -> {
            Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                    $$(".ng-star-inserted").size() > 0);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6527")
    @Description()
    @DisplayName("Проверка наличия инструментов измерений")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfInstruments() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).click();
            $(("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(20));
        });

        step("Проверить наличие инструментов измерений: линейка, квадрат, многоугольник", () -> {
            $(("button[title='Измерение расстояния']")).shouldBe(visible, Duration.ofSeconds(20));
            $(("button[title='Измерение площади']")).shouldBe(visible, Duration.ofSeconds(20));
            $(("button[title='Измерение периметра']")).shouldBe(visible, Duration.ofSeconds(20));
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6529")
    @Description()
    @DisplayName("Проверка наличия строки адресного поиска")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).shouldBe(visible).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(20));
        });

        step("Проверить наличие строк адресного поиска и найти слой", () -> {
            $(".form-control").shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6530")
    @Description()
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).shouldBe(visible).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(20));
        });

        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $((".fal.fa-plus")).shouldBe(visible);
            $((".fal.fa-minus")).shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6531")
    @Description()
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfMyLocationTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).shouldBe(visible).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(20));
        });

        step("Проверить наличия инструмента Мое местоположение", () -> {
            $((".fas.fa-location-arrow")).shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6528")
    @Description()
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Карта", () -> {
            $(byLinkText("Информация")).shouldBe(visible).click();
            $(By.cssSelector("a[href='/map/#/map;onMode3D=true']")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").should(visible, Duration.ofSeconds(10));
        });

        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $((".fas.fa-home-alt")).shouldBe(visible);
        });
    }
}