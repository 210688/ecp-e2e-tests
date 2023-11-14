package ru.mos.smart.tests.map2D;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.MAP;

@Owner("Soldatov")
@Epic("OASI")
@Feature("GIS")
@Tags({@Tag("map2D"), @Tag("regres")})
public class Map2DInstrumentalTests extends TestBase {

    @Test
    @AllureId("17036")
    @Story("Gis")
    @Component("Карта")
    @DisplayName("Наличие подложки на карте")
    @Description("Проверить, что отображается подложка на карте")
    void goToMaps() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkForMapsBox();
    }

    @Test
    @AllureId("17042")
    @Story("Gis")
    @Component("Карта")
    @DisplayName("Наличие инструментов  на 2D карте")
    @Description("Проверить, что присутствуют инструменты на карте 2D")
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
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkInstrumentsMaps(expectedTexts);
    }

    @Test
    @AllureId("17035")
    @Story("Gis")
    @Component("Карта")
    @DisplayName("Наличие поля ввода адресного поиска на карте 2D")
    @Description("Проверить, что отображается поле ввода адресного поиска на карте 2D")
    void checkAvailabilityAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkAddressSearch();
    }

    @Test
    @AllureId("17037")
    @Story("Gis")
    @Component("Карта")
    @DisplayName("Наличие поля ввода поиска слоя на карте 2D")
    @Description("Проверить, что отображается поле ввода поиска слоя на карте 2D")
    void checkAvailabilityOfLayerSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkLayerSearch();
    }

    @Test
    @AllureId("17040")
    @Story("Gis")
    @Component("Карта")
    @DisplayName("Поиск адреса на карте 2D")
    @Description("Проверить, что есть возиожность поиска адреса на карте 2D")
    void checkingAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkSearchAddresses();
    }

    @Test
    @AllureId("17039")
    @Story("Gis")
    @Component("Карта")
    @DisplayName("Наличия инструментов масштабирования: кнопок + и -")
    @Description("Проверить, что отображаются инструменты масштабирования: кнопок + и -")
    void checkingAvailabilityOfScalingTools() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkScalingTools();
    }

    @Test
    @AllureId("17038")
    @Story("Gis")
    @Component("Карта")
    @DisplayName("Наличия инструмента - Моё местоположение")
    @Description("Проверить, что отображается инструмент - Моё местоположение")
    void checkingAvailabilityOfMyLocationTool() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkMyLocationTool();
    }

    @Test
    @AllureId("17041")
    @Story("Gis")
    @Component("Карта")
    @DisplayName("Наличия инструмента - Первоначальная позиция")
    @Description("Проверить, что отображается инструмент - Первоначальная позиция")
    void checkingAvailabilityOfInitialPositionTool() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkInitialPositionTool();
    }
}
