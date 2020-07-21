package ru.mos.smart.tests.oasippt;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.helpers.DriverHelper.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("Модуль \"OASI\"")
@Story("Проверка наличия в витрине \"поля для поиска\"")
@Tag("OASI")
@Tag("ECP")

class SearchBox extends TestBase {
    @Test
    @Description("Проверка наличия в витрине поля для поиска")
    void SearchBox() {
        step("Авторизация", () -> {
            openUrlWithAuthorization("", LOGIN_s_PRAVAMI, PASSWORD_s_PRAVAMI);
        });

        step("Открытие в навигаторе Настройки - Конструктор витрин", () -> {
            $(byText("Настройки")).click();
            $(byText("Конструктор витрин")).click();
        });
        $(byName("candidateSearchValue")).setValue("Запросы проверки версии Проекта планировки").pressEnter();
        $(byTitle("Редактировать витрину")).click();
        $(".nav-item:nth-child(3) span:nth-child(2)").click();
        $(".form-control.ng-valid.ng-touched.ng-dirty").shouldBe(visible);
    }
}