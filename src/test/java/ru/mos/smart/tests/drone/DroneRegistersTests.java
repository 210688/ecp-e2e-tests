package ru.mos.smart.tests.drone;

import io.qameta.allure.AllureId;
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
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

@Layer("web")
@Epic("DRONE (Аэрофотосъемка)")
@Feature("Реестр данные аэрофотосъемки")
public class DroneRegistersTests extends TestBase {

    @Test
    @AllureId("2075")
    @DisplayName("Открытие реестра Данные аэрофотосъемки")
    @Tag("allModules")
    @Tag("prod")
    @Tag("predprod")
    @Tag("regress")
    void openReestrDrone() {
        LoginPage.openUrlWithAuthorization("", smart().login(), smart().passwords());
        MainPage.InformaciyaAndReestr();

        step("Найти и открыть реестр Данные аэрофотосъемки", () -> {
            $(byName("candidateSearchValue")).setValue("Данные аэрофотосъемки").pressEnter();
            $(byLinkText("Данные аэрофотосъемки")).click();
        });

        step("Проверить, что открывается  реестр Данные аэрофотосъемки", () -> {
            $(byText("Данные аэрофотосъемки")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("2076")
    @DisplayName("Переход в карточку из реестра")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("regress")
    void openCardDrone() {
        LoginPage.openUrlWithAuthorization("", smart().login(), smart().passwords());
        MainPage.InformaciyaAndReestr();

        step("Найти и открыть реестр Данные аэрофотосъемки", () -> {
            $(byName("candidateSearchValue")).setValue("Данные аэрофотосъемки").pressEnter();
            $(byLinkText("Данные аэрофотосъемки")).click();
        });

        step("Открыть карточку реестра", () -> {
            $((".form-control.input-lg")).setValue("2000000933_S").pressEnter();
            $x("//a/div[contains(text(),'2000000933_S')]").click();
        });

        step("Проверить, что карточка открылась", () -> {
            $x("//div/h1[contains(text(),'Технический номер заявки 2000000933_S')]")
                    .shouldBe(visible);
        });
    }
}
