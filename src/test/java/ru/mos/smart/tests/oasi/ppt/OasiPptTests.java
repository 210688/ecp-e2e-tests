package ru.mos.smart.tests.oasi.ppt;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;


@Epic("Платформа ЕЦП")
@Feature("OASI (ОАСИ)")
//@Suite("PPT")
@Story("Проверка наличия в витрине \"поля для поиска\"")
@Tag("oasi") @Tag("oasippt")
class OasiPptTests extends TestBase {

    @Test //тест не работает - надо разобраться с правами
    @DisplayName("Проверка наличия в витрине поля для поиска")
    void searchFieldShouldExist() {
        openUrlWithAuthorization("", LOGIN_s_PRAVAMI, PASSWORD_s_PRAVAMI); // заблокирован

        step("Открытие в навигаторе Настройки > Конструктор витрин", () -> {
            $(byText("Настройки")).click();
            $(byText("Конструктор витрин")).click();
        });

        step("Найти витрину «Запросы проверки версии Проекта планировки»", () -> {
            $(byName("candidateSearchValue")).setValue("Запросы проверки версии Проекта планировки").pressEnter();
        });

        step("Перейти к редактированию витрины", () -> {
            $(byTitle("Редактировать витрину")).click();
        });

        //step("Перейти на вкладку Поля", () -> {

        //step("Проверить наличие поля \"Номер версии данных\"", () -> {

    }
}