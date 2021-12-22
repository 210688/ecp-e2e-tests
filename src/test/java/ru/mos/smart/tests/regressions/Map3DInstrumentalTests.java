package ru.mos.smart.tests.regressions;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.annotations.AutoMember;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;


@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Базовый функционал Цифровой двойник")
public class Map3DInstrumentalTests extends TestBase {

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6532")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Открытие приложения Цифровой двойник")
    void openTheTsifrovoyDvoynik() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20));
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6533")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @DisplayName("Проверка отображения панели слоев")
    void checkingTheDisplayOfLayersPanel() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToMaps3D();

        step("В левой боковой панели открыть Дерево слоев", () ->
                $("span[title='Дерево слоёв']")).click();
        step("Проверка, что в дереве слоев присустсвуют слои", () ->
                Wait().withTimeout(Duration.ofSeconds(10)).until(driver ->
                        $$(".layerspanel.scroller").size() > 0));
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @AllureId("7525")
    @Description()
    @DisplayName("Проверка работы поиска в адресной строке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToMaps3D();

        step("Проверка, что адрес находится", () -> {
            $("input[placeholder='Найти адрес...']").setValue("Есенинский бульвар");
            $(".resultspanel").shouldBe(visible, Duration.ofSeconds(10));
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6536")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @Description()
    @DisplayName("Проверка наличия строки адресного поиска")
    void checkingAvailabilityOfAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());

        navigatorPage
                .goToMaps3D();

        step("Проверить наличие строки адресного поиска", () -> {
            $(".search").shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6537")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @Description()
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());

        navigatorPage
                .goToMaps3D();

        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $((".far.fa-plus")).shouldBe(visible);
            $((".far.fa-minus")).shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6535")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @Description()
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());

        navigatorPage
                .goToMaps3D();

        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $((".fas.fa-home-alt")).shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6534")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    @Description()
    @DisplayName("Проверка наличия инструментов  линейка, треугольник, выбор подложки")
    void checkingAvailabilityOfInstruments() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginRegress(), webConfig().passwordRegress());

        navigatorPage
                .goToMaps3D();

        step("Проверить наличие инструментов: линейка, треугольник, выбор подложки", () -> {
            $((".fas.fa-ruler")).shouldBe(visible);
            $((".fas.fa-ruler-triangle")).shouldBe(visible);
            $((".fas.fa-map")).shouldBe(visible);
        });
    }
}