package ru.mos.smart.tests.drone;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

@Layer("web")
@Epic("DRONE (Аэрофотосъемка)")
@Feature("Реестр данные аэрофотосъемки")
public class DroneRegistersTests extends TestBase {

    @Test
    @DisplayName("Открытие реестра Данные аэрофотосъемки")
    @Tag("allModules")
    @Tag("prod")
    void openReestrDrone() {
        LoginPage.openUrlWithAuthorization("", smart().login(), smart().pass());
        MainPage.InformaciyaAndReestr();

        step("Найти и открыть реестр Данные аэрофотосъемки", () -> {
            $(byName("candidateSearchValue")).setValue("Данные аэрофотосъемки").pressEnter();
            $(byLinkText("Данные аэрофотосъемки")).click();
        });

        step("Проверить, что открывается  реестр Данные аэрофотосъемки", () ->
                $(byText("Найти")).shouldBe(visible));
    }
}