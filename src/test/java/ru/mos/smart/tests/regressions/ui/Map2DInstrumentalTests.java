package ru.mos.smart.tests.regressions.ui;

<<<<<<< HEAD
import com.codeborne.selenide.ElementsCollection;
=======
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
import io.qameta.allure.*;
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
    @AllureId("12361")
<<<<<<< HEAD
    @DisplayName("Проверка перехода на карту")
    @Description("Проверить, что происходит переход на карту")

    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
    @Description("Переход на карту")
    @DisplayName("Наличие подложки на карте")
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void goToMaps() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkForMapsBox();
    }

    @Test
    @AllureId("12364")
<<<<<<< HEAD
    @DisplayName("Проверка наличия инструментов измерений на карте 2D")
    @Description("Проверить, что инструменты измерения отображаются на карте 2D")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
    @Description("Отображение инструментов  на 2D карте")
    @DisplayName("Наличие инструментов  на 2D карте")
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
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
    @AllureId("12360")
<<<<<<< HEAD
    @DisplayName("Проверка адресного поиска на карте 2D")
    @Description("Проверить, что поиск есть на карте 2D")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
    @Description("Адресный поиск на карте 2D")
    @DisplayName("Наличие поля ввода адресного поиска на карте 2D")
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void checkAvailabilityAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkAddressSearch();
    }

    @Test
    @AllureId("12362")
<<<<<<< HEAD
    @DisplayName("Проверка поиска слоя на карте 2D")
    @Description("Проверить, что поиск слоя происходит на карте 2D")
    @Tag("sendStatusForPgu")
=======
    @Description("Поиск слоя на карте 2D")
    @DisplayName("Наличие поля ввода поиска слоя на карте 2D")
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void checkAvailabilityOfLayerSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkLayerSearch();
    }

    @Test
    @AllureId("8298")
<<<<<<< HEAD
    @DisplayName("Проверка работы поиска в адресной строке")
    @Description("Проверить, что работает поиск в адресной строке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
    @Description("Поиск адреса в адресной строке")
    @DisplayName("Поиск адреса на карте 2D")
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void checkingAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkSearchAddresses();
    }

    @Test
    @AllureId("8269")
    @Description("Инструменты масштабирования")
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
<<<<<<< HEAD
    @Description("Проверить, что отображаются кнопки + и -")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void checkingAvailabilityOfScalingTools() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAP);
        mapsPage.checkScalingTools();
    }

    @Test
    @AllureId("8266")
    @Description("Инструменты Мое местоположение")
    @DisplayName("Проверка наличия инструмента Мое местоположение")
<<<<<<< HEAD
    @Description("Проверить, что отображается инструмент - Моё местоположение")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void checkingAvailabilityOfMyLocationTool() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        mapsPage.checkMyLocationTool();
    }

    @Test
    @AllureId("8276")
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
<<<<<<< HEAD
    @Description("Проверить, что отображается инструмент - Первоначальная позиция")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void checkingAvailabilityOfInitialPositionTool() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        mapsPage.checkInitialPositionTool();
    }
}