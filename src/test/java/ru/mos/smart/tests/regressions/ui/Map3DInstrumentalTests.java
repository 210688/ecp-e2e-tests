package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.*;
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
    @AllureId("12365")
    @DisplayName("Проверка перехода на карту Цифровой двойник")
<<<<<<< HEAD
    @Description("Проверить, что открывается карта - Цифровой двойник")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void goToMapsCd() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkForMapsBox();

    }

    @Test
    @AllureId("8268")
    @DisplayName("Проверка отображения панели слоев")
<<<<<<< HEAD
    @Description("Проверить, что отображается панели слоев")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void checkingTheDisplayOfLayersPanel() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkLayerSearch();
    }

    @Test
    @AllureId("8274")
    @DisplayName("Проверка работы поиска в адресной строке")
<<<<<<< HEAD
    @Description("Проверить, что раотает поиск в адресной строке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
=======
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    void checkingAddressSearch() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, MAPS3D);
        maps3DPage.checkSearchAddresses();
    }

    @Test
<<<<<<< HEAD
    @Feature("Map3D")
    @AllureId("8270")
    @DisplayName("Проверка отображения строки адресного поиска")
    @Description("Проверить, что отображаются строки адресного поиска")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        step("Проверка наличия строки адресного поиска");
        navigatorPage
                .goToMapsCD();
        step("Проверка наличия кнопок масштабирования на карте");
        $((".far.fa-plus")).shouldBe(visible);
        $((".far.fa-minus")).shouldBe(visible);

    }

    @Test
    @Feature("Map3D")
=======
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
    @AllureId("8275")
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Description("Проверить, что отображается инструмент - Первоначальная позиция")
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

<<<<<<< HEAD
    @Test
    @Feature("Map3D")
    @AllureId("8271")
    @DisplayName("Проверка наличия инструментов  линейка, треугольник, выбор подложки")
    @Description("Проверить, что отображается инструменты - линейка, треугольник, выбор подложки")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfInstruments() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToMapsCD();
        step("Проверка наличия инструментов: линейка, треугольник, выбор подложки", () -> {
            $((".fas.fa-ruler")).shouldBe(visible);
            $((".fas.fa-ruler-triangle")).shouldBe(visible);
            $((".fas.fa-map")).shouldBe(visible);
        });
    }
}
=======
    }
>>>>>>> b493f22c52f64fc74f5618d1ad4492c56b694f86
