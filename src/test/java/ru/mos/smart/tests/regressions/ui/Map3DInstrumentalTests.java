package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Epic("Цифровой двойник")
@Feature("Map3D")
@Owner("Soldatov")
@Layer("web")
public class Map3DInstrumentalTests extends TestBase {

    @Test
    @Feature("Map3D")
    @AllureId("12365")
    @DisplayName("Проверка перехода на карту Цифровой двойник")
    @Description("Проверить, что открывается карта - Цифровой двойник")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToMapsCd() {
        //String testPath = "MapsTests";
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToMapsCd();
        mapsPage.checkForMapsBoxCd();
        /*Screenshot actualImage = new ScreenshotHelper()
                .getActualScreenshot();
        Screenshot expectedImage = new ScreenshotHelper()
                .getExpectedScreenshot();
        ImageDiff diff = new ScreenshotHelper().compareScreenshots(
                actualImage,
                expectedImage,
                15);
        assertFalse(diff.hasDiff(), "Screenshot has difference");*/
    }


    @Test
    @Feature("Map3D")
    @AllureId("8268")
    @DisplayName("Проверка отображения панели слоев")
    @Description("Проверить, что отображается панели слоев")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingTheDisplayOfLayersPanel() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToMapsCD();
        step("В левой боковой панели открыть Дерево слоев", () ->
                $("span[title='Дерево слоёв']")).click();
        step("Проверка, что в дереве слоев присустсвуют слои", () ->
                Wait().withTimeout(Duration.ofSeconds(30)).until(driver ->
                        $$(".layerspanel.scroller").size() > 0));
    }

    @Test@Feature("Map3D")
    @AllureId("8274")
    @DisplayName("Проверка работы поиска в адресной строке")
    @Description("Проверить, что раотает поиск в адресной строке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToMapsCD();

        step("Проверка, что адрес находится", () -> {
            $("input[placeholder='Найти адрес...']").setValue("Есенинский бульвар");
            $(".resultspanel").shouldBe(visible, Duration.ofSeconds(30));
        });
    }

    @Test
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
    @AllureId("8275")
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Description("Проверить, что отображается инструмент - Первоначальная позиция")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToMapsCD();

        step("Проверка наличия инструмента первоначальная позиция", () -> {
            $((".fas.fa-home-alt")).shouldBe(visible);
        });
    }

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