package ru.mos.smart.tests.regressions.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.AutoMember;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;


@Epic("Регрессионные тесты для проверки базового функционала после обновления релизов")
@Feature("Базовый функционал Цифровой двойник")
public class Map3DInstrumentalTests extends TestBase {

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @DisplayName("Открытие приложения Цифровой двойник")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void openTheTsifrovoyDvoynik() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        step("Перейти Информация - Цифровой двойник", () -> {
            navigatorPage
                    .goToMapsCD();
        });

        step("Запустилось приложение Цифровой Двойник", () -> {
            $("#city").should(visible, Duration.ofSeconds(30));
        });
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @DisplayName("Проверка отображения панели слоев")
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

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @DisplayName("Проверка работы поиска в адресной строке")
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
    @DisplayName("Cтрока адресного поиска отображается на карте")
    @Owner("soldatovks")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfScalingTools() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        step("Проверить наличие строки адресного поиска");
        navigatorPage
                .goToMapsCD();
        step("Проверить наличие кнопок масштабирования на карте");
        $((".far.fa-plus")).shouldBe(visible);
        $((".far.fa-minus")).shouldBe(visible);

    }

    @Test
    @AutoMember("soldatovks")
    @Owner("web")
    @Description()
    @DisplayName("Проверка наличия инструмента Первоначальная позиция")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfInitialPositionTool() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToMapsCD();

        step("Проверить наличия инструмента Первоначальная позиция", () -> {
            $((".fas.fa-home-alt")).shouldBe(visible);
        });
    }

    @Test
    @Owner("soldatovks")
    @Layer("web")
    @Description()
    @DisplayName("Проверка наличия инструментов  линейка, треугольник, выбор подложки")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingAvailabilityOfInstruments() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToMapsCD();

        step("Проверить наличие инструментов: линейка, треугольник, выбор подложки", () -> {
            $((".fas.fa-ruler")).shouldBe(visible);
            $((".fas.fa-ruler-triangle")).shouldBe(visible);
            $((".fas.fa-map")).shouldBe(visible);
        });
    }
}