package ru.mos.smart.tests.oasi.ppt;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("PPT (ППТ)")
class OasiPptTests extends TestBase {

    @Test
    @Disabled("тест не работает - надо разобраться с правами, не работает регистрация")
    @DisplayName("Проверка наличия в витрине поля для поиска")
    void searchFieldShouldExist() {
        LoginPage.openUrlWithAuthorization("", smart().logins(), smart().password());


        step("Открытие в навигаторе Настройки > Конструктор витрин", () -> {
            $(byText("Настройки")).click();
            $(byText("Конструктор витрин")).click();
        });

        step("Найти витрину Запросы проверки версии Проекта планировки", () -> {
            $(byName("candidateSearchValue")).setValue("Запросы проверки версии Проекта планировки").pressEnter();
        });

        step("Перейти к редактированию витрины", () -> {
            $(byTitle("Редактировать витрину")).click();
        });
    }
}