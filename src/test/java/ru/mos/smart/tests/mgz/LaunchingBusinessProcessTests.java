package ru.mos.smart.tests.mgz;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("MGZ (МГЗ)")
@Story("Запуск бизнес-процессов")
@Tag("mgz")
class LaunchingBusinessProcessTests extends TestBase {

    @Test
    @DisplayName("Запуск бизнес-процесса \"Создание структуры работ по объекту\" на текущего пользователя")
    void launchingBusinessProcessCreatingWorkStructureForAnObject() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);

        step("В Навигаторе открыть Госуслуги и функции -> Возможности", () -> {
            $(byLinkText("Госуслуги и функции")).click();
            $(byLinkText("Возможности")).click();
        });

        step("В списке возможностей выбрать \"Запустить процесс\"", () -> {
            $((".form-control")).setValue("Запустить процесс").pressEnter();
            open("/mgz/#/app/start/process/");
        });

        step("В строке \"Процесс\" выбрать \"Создание структуры работ по объекту\"", () -> {
            $("ng-select").setValue("Создание структуры работ по объекту").pressEnter();
        });

        step("В выпадающем списке \"Проект\" выбрать предназначенный для тестирования проект", () -> {
            $(".ng-input:nth-child(2)").setValue("Тест 9").pressEnter();
        });

        step("Поставить чек-бокс \"На текущего пользователя\"", () -> {
            $(".iradio_square-orange").click();
        });

        //ng-input ng-placeholder iradio_square-orange iCheck-helper"
        //Нажать "Запустить процесс"".
        //Проверка:Появление сообщения "Процесс "Создание структуры работ по объекту" успешно запущен",
        //на текущего пользователя назначена задача.
    }
}