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
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Базовый функционал 2D")
public class Map2DProdInstrumentalTests extends TestBase {

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @DisplayName("Переход на карту")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressionsProd")})
    void goToMaps() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        mapsPage.checkForMapsBox();
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @DisplayName("Наличие инструментов измерений на карте 2D")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressionsProd")})
    void checkAvailabilityInstruments() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        $("button[title='Измерение расстояния']").shouldBe(visible, Duration.ofSeconds(20));
        $("button[title='Измерение площади']").shouldBe(visible, Duration.ofSeconds(20));
        $("button[title='Измерение периметра']").shouldBe(visible, Duration.ofSeconds(20));
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Наличие строки адресного поиска на карте 2D")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressionsProd")})
    void checkAvailabilityAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        $("input[placeholder='Поиск']").shouldBe(visible);
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия строки поиска слоя")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressionsProd")})
    void checkAvailabilityOfLayerSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        step("Проверить наличие строки  поиска слоя", () -> {
            $("input[placeholder='Найти слой']").shouldBe(visible, Duration.ofSeconds(20));
            $("input[placeholder='Найти слой']").setValue("Аэрофотосъемка");
            $(byText("Ортофотопланы, аэрофотосъемка")).shouldBe(visible);
        });
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @DisplayName("Проверка работы поиска в адресной строке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressionsProd")})
    void checkingAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        step("Проверка, что адрес находится", () -> {
            $("input[placeholder='Поиск']").setValue("Есенинский").shouldBe(visible);
        });
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressionsProd")})
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $("div[title='Приблизить']").shouldBe(visible);
            $("div[title='Отдалить']").shouldBe(visible);
        });
    }

    @Test
    @Owner("soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressionsProd")})
    void checkingAvailabilityOfMyLocationTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        step("Проверить наличия инструмента Мое местоположение", () -> {
            $((".fa-location-arrow")).shouldBe(visible);
        });
    }

    @Test
    @Owner("soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressionsProd")})
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $((".fa-home-alt")).shouldBe(visible);
        });
    }
}