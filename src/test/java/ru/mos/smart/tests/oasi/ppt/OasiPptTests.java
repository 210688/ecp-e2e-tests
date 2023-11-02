package ru.mos.smart.tests.oasi.ppt;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Epic("OASI")
@Feature("PPT")
@Tags({@Tag("oasi"), @Tag("regres")})
class OasiPptTests extends TestBase {

    @Test
    @AllureId("17076")
    @Story("PPT")
    @DisplayName("Наличия в витрине поля для поиска")
    @Description("Проверить, что в витрине есть поле для поиска")
    void searchFieldShouldExist() {

        step("Открытие в навигаторе Настройки > Конструктор витрин", () -> {
            $(byText("Настройки")).click();
            $(byText("Конструктор витрин")).click();
        });
        step("Найти витрину Запросы проверки версии Проекта планировки", () -> {
            $(byName("candidateSearchValue")).setValue("Запросы проверки версии Проекта планировки").pressEnter();
        });
        step("Перейти к редактированию витрины", () ->
                $(byTitle("Редактировать витрину")).click());
    }
}