package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.Sidebar.*;

@Epic("OASI")
@Feature("GIS")
@Owner("Soldatov")
@Layer("web")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("maps")})
public class Map2DInstrumentalTests extends TestBase {

    @Test
    @Feature("GIS")
    @AllureId("12361")
    @Description("Переход на карту")
    @DisplayName("Наличие подложки на карте")
    void goToMaps() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS);
        mapsPage.checkForMapsBox();
    }

    @org.testng.annotations.Test
    @Feature("GIS")
    @AllureId("12364")
    @Description("Отображение инструментов  на 2D карте")
    @DisplayName("Наличие инструментов  на 2D карте")
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
        sidebarPage.clickSubMenuList(INFORMATION, MAPS);
        mapsPage.checkInstrumentsMaps(expectedTexts);
    }

    @Test
    @Feature("GIS")
    @AllureId("12360")
    @Description("Адресный поиск на карте 2D")
    @DisplayName("Наличие поля ввода адресного поиска на карте 2D")
    void checkAvailabilityAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS);
        mapsPage.checkAddressSearch();
    }

    @Test
    @Feature("GIS")
    @AllureId("12362")
    @Description("Поиск слоя на карте 2D")
    @DisplayName("Наличие поля ввода поиска слоя на карте 2D")
    void checkAvailabilityOfLayerSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS);
        mapsPage.checkLayerSearch();
    }

    @Test
    @Feature("GIS")
    @AllureId("8298")
    @Description("Поиск адреса в адресной строке")
    @DisplayName("Поиск адреса на карте 2D")
    void checkingAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS);
        mapsPage.checkSearchAddresses();
    }

    @Test
    @Feature("GIS")
    @AllureId("8269")
    @Description("Инструменты масштабирования")
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    void checkingAvailabilityOfScalingTools() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS);
        mapsPage.checkScalingTools();
    }

    @Test
    @Feature("GIS")
    @AllureId("8266")
    @Description("Инструменты Мое местоположение")
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    void checkingAvailabilityOfMyLocationTool() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        mapsPage.checkMyLocationTool();
    }

    @Test
    @Feature("GIS")
    @AllureId("8276")
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    void checkingAvailabilityOfInitialPositionTool() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        mapsPage.checkInitialPositionTool();
    }
}