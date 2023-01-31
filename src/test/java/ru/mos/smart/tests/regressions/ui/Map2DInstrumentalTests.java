package ru.mos.smart.tests.regressions.ui;

import com.codeborne.selenide.ElementsCollection;
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

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Базовый функционал 2D")
public class Map2DInstrumentalTests extends TestBase {

    ElementsCollection checkLayerField = $$("gis-plugin-layers-tree div");

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @DisplayName("Переход на карту")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToMaps() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        mapsPage.checkForMapsBox();
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @DisplayName("Наличие инструментов измерений на карте 2D")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkAvailabilityInstruments() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        mapsPage.checkInstrumentsMaps();
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @Description()
    @DisplayName("адресный поиск на карте 2D")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkAvailabilityAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        mapsPage.checkAddressSearch();
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @Description()
    @DisplayName("поиск слоя на карте 2D")
    @Tag("sendStatusForPgu")
    void checkAvailabilityOfLayerSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        mapsPage.checkLayerSearch();
        checkLayerField.shouldHave(sizeGreaterThan(0));
    }

    @Test
    @Owner("Soldatovks")
    @Layer("web")
    @DisplayName("Проверка работы поиска в адресной строке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        mapsPage.checkSearch();
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $(("button[tooltip-right='Приблизить']")).shouldBe(visible);
            $(("button[tooltip-right='Отдалить']")).shouldBe(visible);
        });
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfMyLocationTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        step("Проверить наличия инструмента Мое местоположение", () -> {
            $(("button[tooltip-right='Мое местоположение']")).shouldBe(visible);
        });
    }

    @Test
    @Owner("Soldatov")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMaps();
        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $(("button[tooltip-right='Первоначальная позиция']")).shouldBe(visible);
        });
    }
}