package ru.mos.smart.tests.fr;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("FR (Фонд реновации)")
@Feature("Запуск проекта")
public class LaunchProjectTests extends TestBase {

    @Test
    @AllureId("877")
    @DisplayName("Создание объекта АИП")
    @Tag("allModules")
    @Tag("prodRunPrc")
    void launchProjectAip() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsers(), ConfigHelper.getPas());

        step("В панели Навигатор нажать кнопку Объекты АИП", () ->
                $x("//span[contains(text(),'Объекты АИП')]").click());

        step("В рабочей области витрины нажать на кнопку Создать Объект АИП", () ->
                $x("//a[contains(text(),' Создать объект АИП')]").click());

        step("Заполнить поля", () -> $(".form-control").setValue("Автотест"));

        step("Нажать на кнопку Сохранить", () -> $x("//button[contains(text(),'Сохранить')]")
                .click());
        $(byText("Найти")).shouldBe(visible);
    }
}