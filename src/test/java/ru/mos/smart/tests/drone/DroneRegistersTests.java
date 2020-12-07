package ru.mos.smart.tests.drone;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("DRONE (Аэрофотосъемка)")
@Feature("Реестр данные аэрофотосъемки")
public class DroneRegistersTests extends TestBase {

    @Test
    @AllureId("2075")
    @DisplayName("Открытие реестра Данные аэрофотосъемки")
    @Tag("allModules")
    @Tag("prod")
    void openReestrDrone() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());
        MainPage.InformaciyaAndReestr();

        step("Найти и открыть реестр Данные аэрофотосъемки", () -> {
            $(byName("candidateSearchValue")).setValue("Данные аэрофотосъемки").pressEnter();
            $(byLinkText("Данные аэрофотосъемки")).click();
        });

        step("Проверка, что открылся реестр Данные аэрофотосъемки", () ->
                $(byText("4159")).shouldBe(visible));
    }
}