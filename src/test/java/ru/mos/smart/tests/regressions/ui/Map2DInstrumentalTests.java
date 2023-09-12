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
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.Sidebar.*;

@Owner("Soldatov")
@Layer("web")
@Epic("OASI")
@Feature("GIS")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("maps")})
public class Map2DInstrumentalTests extends TestBase {

    @Test
    @Description("Переход на карту")
    @DisplayName("Наличие подложки на карте")
    void goToMaps() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkForMapsBox();
    }

    @Test
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
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkInstrumentsMaps(expectedTexts);
    }

    @Test
    @Description("Адресный поиск на карте 2D")
    @DisplayName("Наличие поля ввода адресного поиска на карте 2D")
    void checkAvailabilityAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkAddressSearch();
    }

    @Test
    @Description("Поиск слоя на карте 2D")
    @DisplayName("Наличие поля ввода поиска слоя на карте 2D")
    void checkAvailabilityOfLayerSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkLayerSearch();
    }

    @Test
    @Description("Поиск адреса в адресной строке")
    @DisplayName("Поиск адреса на карте 2D")
    void checkingAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkSearchAddresses();
    }

    @Test
    @Description("Инструменты масштабирования")
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    void checkingAvailabilityOfScalingTools() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkScalingTools();
    }

    @Test
    @Description("Инструменты Мое местоположение")
    @DisplayName("Проверка наличия инструмента Мое местоположение")
    void checkingAvailabilityOfMyLocationTool() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        mapsPage.checkMyLocationTool();
    }

    @Test
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    void checkingAvailabilityOfInitialPositionTool() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        mapsPage.checkInitialPositionTool();
    }
}