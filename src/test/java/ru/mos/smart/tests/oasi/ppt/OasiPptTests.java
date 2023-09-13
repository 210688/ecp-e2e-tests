package ru.mos.smart.tests.oasi.ppt;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("PPT (ППТ)")
class OasiPptTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия в витрине поля для поиска")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
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