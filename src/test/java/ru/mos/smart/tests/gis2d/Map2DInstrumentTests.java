package ru.mos.smart.tests.gis2d;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("GIS 2D (Картографическое обеспечение, Реинформ)")
@Feature("Базовый функционал 2D - Инструменты измерения")
public class Map2DInstrumentTests extends TestBase {

    @Test
    @Description("Используется тестовый пользователь с правами группы GIS")
    @DisplayName("01. Проверка наличия инструментов измерений")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void checkngAvailabilityOfInstruments() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());

        step("Открыть Информация - Карта", () -> {
            $x("//span[contains(text(),'Информация')]").click();
            $(byLinkText("Карта")).click();
        });

        step("Проверка: Карта открылась в новой вкладке", () -> {
            switchTo().window(1);
            $(".mapboxgl-canvas").waitUntil(visible, 15000);
        });

        step("Проверить наличие инструментов измерений: линейка, квадрат, многоугольник", () -> {
            $((".fas.fa-ruler")).shouldBe(visible);
            $((".fas.fa-square-full")).shouldBe(visible);
            $((".fal.fa-draw-polygon")).shouldBe(visible);
        });
    }
}
