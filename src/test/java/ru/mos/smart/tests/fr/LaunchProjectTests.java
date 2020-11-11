package ru.mos.smart.tests.fr;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("FR (Фонд реновации)")
@Feature("Запуск проекта")
@Tag("fr")
//@Tag("all_tests")
public class LaunchProjectTests extends TestBase {

    @Test
    @DisplayName("Создать объект АИП")
    @Tag("allModules")
    @Tag("prodRunPrc")
    void launchProjectAip() {
        LoginPage.openUrlWithAuthorization("", LOGIN_FR, PASSWORD_FR);

        step("В панели Навигатор нажать кнопку Объекты АИП", () ->
                open("/fr/#/app/aip/list"));

        step("В рабочей области витрины нажать на кнопку Создать Объект АИП", () ->
                $(byLinkText("Создать объект АИП")).click());

        step("Заполнить поля", () -> $(".form-control").setValue("Автотест"));

        step("Нажать на кнопку Сохранить", () -> $("#submit").click());
    }
}