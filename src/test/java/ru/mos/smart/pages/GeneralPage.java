package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.data.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GeneralPage {

    private final ElementsCollection tableHeaders = $$("table th");
    private final ElementsCollection tableFieldData = $$(".search-result-table");
    private final SelenideElement settings =  $("#dropdown-columns-btn");

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("В реестре {registerName} присутствует список карточек и присутствуют заголовки таблицы {list}")
    public void checkTableFilter(Registers registerName, List<String> list) {
        switchToWindow();
        verifyTableHeaders(list);
        attachScreenshot(registerName);
        verifyTableFieldData();
    }

    private void verifyTableHeaders(List<String> list) {
        String table = String.join(", ", list);
        tableHeaders.shouldHave(textsInAnyOrder(list));
    }

    private void attachScreenshot(Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName.value());
    }

    private void verifyTableFieldData() {
        tableFieldData.shouldHave(sizeGreaterThan(0));
    }

    @Step("В реестре {registerName} отображаются кнопки сортировки и фильтр")
    public void columnsAndFilterButton(Registers registerName) {
        switchTo().window(1);
        settings.shouldBe(visible);
        $(".container-btn").$("button.btn-white").shouldBe(visible);
    }
}
