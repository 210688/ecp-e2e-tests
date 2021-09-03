package ru.mos.smart.tests.regressions;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
    @DisplayName("Открытие приложения Цифровой двойник")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod"), @Tag("prod"), @Tag("prod")})
    void openTheTsifrovoyDvoynik() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(30)).click();
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6533")
    @DisplayName("Проверка отображения панели слоев")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingTheDisplayOfLayersPanel() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(30)).click();
        });

        step("В левой боковой панели открыть Дерево слоев 2D", () -> $((".fas.fa-layer-group"))
                .click());

        step("Разворачивается панель Дерево слоев 2D", () -> {
            $((".main-left-panel")).shouldBe(visible);
            $x("//div/span[contains(text(),'Дерево слоёв 2D')]").shouldBe(visible);
        });

        step("Закрыть панель Дерево слоев 2D", () -> $((".fas.fa-layer-group"))
                .click());

        step("В левой боковой панели открыть Дерево слоев 3D", () -> $((".fas.fa-cube"))
                .click());

        step("Разворачивается панель Дерево слоев 3D", () -> {
            $((".main-left-panel")).shouldBe(visible);
            $x("//div/span[contains(text(),'Дерево слоёв 3D')]").shouldBe(visible);
        });

        step("Закрыть панель Дерево слоев 3D", () -> $((".fas.fa-cube"))
                .click());

        step("Проверить, что боковая панель закрыта", () -> $((".main-left-panel"))
                .shouldNotBe(visible));
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6536")
    @Description()
    @DisplayName("Проверка наличия строки адресного поиска")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfAddressSearch() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20)).click();
        });

        step("Проверить наличие строки адресного поиска", () -> {
            //$x("//div/input[contains(@class,'form-control')]").shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6537")
    @Description()
    @DisplayName("Проверка наличия инструментов масштабирования: кнопок + и -")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20)).click();
        });

        step("Проверить наличие инструментов масштабирования: кнопок + и -", () -> {
            $((".far.fa-plus")).shouldBe(visible);
            $((".far.fa-minus")).shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6535")
    @Description()
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20)).click();
        });

        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $((".fas.fa-home-alt")).shouldBe(visible);
        });
    }

    @Test
    @AutoMember("soldatovks")
    @Layer("web")
    @AllureId("6534")
    @Description()
    @DisplayName("Проверка наличия инструментов  линейка, треугольник, выбор подложки")
    @Tags({@Tag("regressions"), @Tag("predprod"), @Tag("prod")})
    void checkingAvailabilityOfInstruments() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().login_regress(), webConfig().password_regress());

        step("Перейти Информация - Цифровой двойник", () -> {
            $(byLinkText("Информация")).should(visible).click();
            $(By.cssSelector("a[href='/map3d/#/map3d']")).click();
        });

        step("В новом окне запустилось приложение Цифровой Двойник", () -> {
            switchTo().window(1);
            $("#city").should(visible, Duration.ofSeconds(20)).click();
        });

        step("Проверить наличие инструментов: линейка, треугольник, выбор подложки", () -> {
            $((".fas.fa-ruler")).shouldBe(visible);
            $((".fas.fa-ruler-triangle")).shouldBe(visible);
            $((".fas.fa-map")).shouldBe(visible);
        });
    }
}