package ru.mos.smart.tests.oasi.blago;

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
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("BLAGO (ОАСИ Благоустройство)")
public class BlagoRegistersTests extends TestBase {

    @Test
    @AllureId("2613")
    @DisplayName("Проверка наличия реестров")
    @Tag("allModules")
    @Tag("prod")
    void checkingBlagoRegisters() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());
        MainPage.InformaciyaAndReestr();

        step("Выполнить поиск по Проекты благоустройства", () -> {
            $(byName("candidateSearchValue")).setValue("Проекты благоустройства").pressEnter();
        });

        step("Найдены реестры", () -> {
            $(byText("Проекты благоустройства (подготовка инженерно-топографического плана)")).shouldBe(visible);
            $(byText("Проекты благоустройства (подготовка ситуационного плана)")).shouldBe(visible);
            $(byText("Проекты благоустройства (рассмотрение концепции)")).shouldBe(visible);
            $(byText("Проекты благоустройства (согласование изменения границ)")).shouldBe(visible);
            $(byText("Проекты благоустройства (согласование проектов)")).shouldBe(visible);
        });
    }
}
