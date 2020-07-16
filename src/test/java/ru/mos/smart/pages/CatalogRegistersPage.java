package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class CatalogRegistersPage {

    @Step("Ввод \"{text}\" в строку поиска")
    public void searchReestr(String text) {
        $(byName("candidateSearchValue")).setValue(text).pressEnter();
    }

    @Step("Проверка, что реестр \"{text}\" найден")
    public void verifyReestrIsFound(String text) {
        $("table.search-result-table").shouldHave(text(text));
    }
}
