package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Epic("OASI")
@Feature("GIS")
@Owner("Soldatov")
@Layer("web")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("maps")})
public class Map2DInstrumentalTests extends TestBase {

    @Test
    @Story("Что-то из функционала")
    @AllureId("12361")
    @Description("Переход на карту")
    @DisplayName("Проверить наличия подложки на карте")
    void goToMaps() {
        sidebarPage.clickSidebarMenu("Информация");
        sidebarPage.clickSubMenuList("Информация", "Карта");
        mapsPage.checkForMapsBox();
    }

    @Test
    @AllureId("12364")
    @Description("Отображение инструментов  на 2D карте")
    @DisplayName("Проверить наличие инструментов  на 2D карте")
    void checkAvailabilityInstruments() {
        String[] expectedTexts = {
                "3D режим",
                "Пробки",
                "Панорамы",
                "Рисование",
                "Измерение",
                "Условные обозначения",
                "Информация"
        };
        sidebarPage.clickSidebarMenu("Информация");
        sidebarPage.clickSubMenuList("Информация", "Карта");
        mapsPage.checkInstrumentsMaps(expectedTexts);
    }

    @Test
    @AllureId("12360")
    @Description("Отображение адресного поиска на карте 2D")
    @DisplayName("Проверить наличие адресного поиска на карте 2D")
    void checkAvailabilityAddressSearch() {
        sidebarPage.clickSidebarMenu("Информация");
        sidebarPage.clickSubMenuList("Информация", "Карта");
        mapsPage.checkAddressSearch();
    }

    @Test
    @AllureId("12362")
    @Description("Отображение поиска слоя на карте 2D")
    @DisplayName("Проверить наличие поиска слоя на карте 2D")
    void checkAvailabilityOfLayerSearch() {
        sidebarPage.clickSidebarMenu("Информация");
        sidebarPage.clickSubMenuList("Информация", "Карта");
        mapsPage.checkLayerSearch();
    }

    @Test
    @AllureId("8298")
    @Description("Поиск адреса в адресной строке")
    @DisplayName("Проверить работу поиска в адресной строке")
    void checkingAddressSearch() {
        sidebarPage.clickSidebarMenu("Информация");
        sidebarPage.clickSubMenuList("Информация", "Карта");
        mapsPage.checkSearchAddresses();
    }

    @Test
    @AllureId("8269")
    @Description("Инструменты масштабирования")
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    void checkingAvailabilityOfScalingTools() {
        sidebarPage.clickSidebarMenu("Информация");
        sidebarPage.clickSubMenuList("Информация", "Карта");
        mapsPage.checkScalingTools();
    }

    @Test
    @AllureId("8266")
    @Description("Инструменты Мое местоположение")
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    void checkingAvailabilityOfMyLocationTool() {
        sidebarPage.clickSidebarMenu("Информация");
        sidebarPage.clickSubMenuList("Информация", "Карта");
        mapsPage.checkMyLocationTool();
    }

    @Test
    @AllureId("8276")
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    void checkingAvailabilityOfInitialPositionTool() {
        sidebarPage.clickSidebarMenu("Информация");
        sidebarPage.clickSubMenuList("Информация", "Карта");
        mapsPage.checkInitialPositionTool();
    }
}