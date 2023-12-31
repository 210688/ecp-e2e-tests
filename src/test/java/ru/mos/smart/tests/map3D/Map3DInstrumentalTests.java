package ru.mos.smart.tests.map3D;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.MAPS3D;

@Epic("Цифровой двойник")
@Feature("Map3D")
@Tags({@Tag("mapСD"), @Tag("regres")})
public class Map3DInstrumentalTests extends TestBase {

    @Test
    @AllureId("17031")
    @Owner("Soldatov")
    @DisplayName("Переход на карту Цифровой двойник")
    @Description("Проверить, что происходит переход на карту Цифровой двойник")
    void goToMapsCd() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkForMapsBox();

    }

    @Test
    @AllureId("17032")
    @Owner("Soldatov")
    @DisplayName("Отображения панели слоев")
    @Description("Проверить, что отображаются панели слоев")
    void checkingTheDisplayOfLayersPanel() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkLayerSearch();
    }

    @Test
    @AllureId("17033")
    @Owner("Soldatov")
    @DisplayName("Работа поиска в адресной строке")
    @Description("Проверить, что работает поиск в адресной строке")
    void checkingAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkSearchAddresses();
    }

    @Test
    @AllureId("17034")
    @Owner("Soldatov")
    @DisplayName("Наличия инструмента - Первоначальная позиция")
    @Description("Проверить, что отображается инструмент - Первоначальная позиция")
    void checkingAvailabilityOfInitialPositionTool() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkInitialPositionTool();

    }
    @Test
    @AllureId("16907")
    @Owner("Soldatov")
    @DisplayName("Наличия кнопок масштабирования на карте")
    @Description("Проверить, что отображаются кнопки масштабирования на карте")
    void checkingAvailabilityOfScalingTools() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkScalingTools();
    }

}
