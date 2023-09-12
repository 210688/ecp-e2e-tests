package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.MAPS3D;

@Owner("Soldatov")
@Layer("web")
@Epic("Цифровой двойник")
@Feature("Map3D")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("maps")})
public class Map3DInstrumentalTests extends TestBase {

    @Test
    @DisplayName("Проверка перехода на карту Цифровой двойник")
    void goToMapsCd() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkForMapsBox();

    }

    @Test
    @DisplayName("Проверка отображения панели слоев")
    void checkingTheDisplayOfLayersPanel() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkLayerSearch();
    }

    @Test
    @DisplayName("Проверка работы поиска в адресной строке")
    void checkingAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkSearchAddresses();
    }

    @Test
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfInitialPositionTool() {
            sidebarPage.clickSidebarMenu(INFORMATION);
            sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
            maps3DPage.checkInitialPositionTool();

    }
        @Test
        @DisplayName("Проверка наличия кнопок масштабирования на карте")
        void checkingAvailabilityOfScalingTools() {
            sidebarPage.clickSidebarMenu(INFORMATION);
            sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
            maps3DPage.checkScalingTools();
        }

    }