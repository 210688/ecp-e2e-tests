package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HearingPage {

    private final SelenideElement headings = $(".ng-binding");
    private final ElementsCollection tableHeaders = $$(".tab-container li");


    @Step("Проверить открытие реестра {registerName}")
    public HearingPage checkHeading(String registerName) {
        headings.shouldHave(text("Публичные слушания"));
        return this;
    }

    @Step("Проверить, что в реестре {registerName} есть данные и присутствуют колонки таблицы {list}")
    public void checkFilter(String registerName, List<String> list) {
        String table = String.join(", ", list);
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(list));
        //tableFieldData.shouldHave(sizeGreaterThan(0));
    }
}
