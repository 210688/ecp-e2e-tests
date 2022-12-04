package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Базовый функционал 2D")
public class Map2DInstrumentalTests extends TestBase {

    @Test
    @Owner("soldatov")
    @Layer("web")
    @DisplayName("Открытие приложения карта")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void openTheMaps() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToMaps();
        step("Проверка: На карте присутствуют слои", () -> {
            Wait().withTimeout(Duration.ofSeconds(20)).until(driver ->
                    $$(".ng-star-inserted").size() > 0);
        });
    }

    @Test
    @Owner("soldatov")
    @Layer("web")
    @DisplayName("Проверка наличия инструментов измерений")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfInstruments() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToMaps();
        step("Проверить наличие инструментов измерений: Измерение расстояния, Измерение площади, Измерение периметра", () -> {
            $(("button[tooltip-right='Измерение расстояния']")).shouldBe(visible, Duration.ofSeconds(20));
            $(("button[tooltip-right='Измерение площади']")).shouldBe(visible, Duration.ofSeconds(20));
            $(("button[tooltip-right='Измерение периметра']")).shouldBe(visible, Duration.ofSeconds(20));
        });
    }

    @Test
    @Owner("soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия строки адресного поиска")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkAvailabilityOfAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToMaps();
        step("Проверить наличие строки адресного поиска и найти слой", () -> {
            $("input[placeholder='Найти слой']").shouldBe(visible, Duration.ofSeconds(20));
        });
    }

    @Test
    @Owner("soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия строки поиска слоя")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkAvailabilityOfLayerSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToMaps();
        step("Проверить наличие строки  поиска слоя", () -> {
            $("input[placeholder='Найти слой']").shouldBe(visible, Duration.ofSeconds(20));
            $("input[placeholder='Найти слой']").setValue("Аэрофотосъемка");
            $(byText("Ортофотопланы, аэрофотосъемка")).shouldBe(visible);
        });
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @DisplayName("Проверка работы поиска в адресной строке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToMaps();
        step("Проверка, что адрес находится", () -> {
            $("input[placeholder='Поиск']").setValue("Есенинский");
            //$(".result.ng-star").shouldBe(visible, Duration.ofSeconds(30));
        });
    }

    @Test
    @Owner("soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToMaps();
        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $(("button[tooltip-right='Приблизить']")).shouldBe(visible);
            $(("button[tooltip-right='Отдалить']")).shouldBe(visible);
/*            $(("button[tooltip-right='Приблизить']")).click();
            $(".alt-zoom-value").shouldHave(type("10.5"));*/
        });
    }

    @Test
    @Owner("soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfMyLocationTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToMaps();
        step("Проверить наличия инструмента Мое местоположение", () -> {
            $(("button[tooltip-right='Мое местоположение']")).shouldBe(visible);
        });
    }

    @Test
    @Owner("soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToMaps();
        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $(("button[tooltip-right='Первоначальная позиция']")).shouldBe(visible);
        });
    }
}