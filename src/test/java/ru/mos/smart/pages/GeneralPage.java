package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GeneralPage {

    private final SelenideElement
            settingsButton = $("#dropdown-columns-btn"),
            registryCardsTable = $("table.search-result-table tr"),
            listCardsInTheRegistry = $(".search-result-table > tbody");

    private final ElementsCollection
            checkingTableHeaders = registryCardsTable.$$("th"),
            searchResultsTableRows = $$("table.search-result-table  tr"),
            //numberCardsInTheRegistry = listCardsInTheRegistry.$$("tr");
            numberCardsInTheRegistry = $$(".search-result-table > tbody tr");

    private SelenideElement searchResultLink() {
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        return searchResultsTableRows.get(randomNumber).$$("td").get(1).$("a");
    }


    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Реестр содержит хотя бы одну карточку, и нем отображаются заголовки таблицы {list}")
    public void RegistryContainsCardsHeadersCheck(Registers registerName, List<String> list) {
        switchToWindow();
        verifyTableHeadersMatchExpected(list);
        attachScreenshot(registerName);
        verifyTableFieldDataSize();
    }

    private void verifyTableHeadersMatchExpected(List<String> expectedHeaders) {
        String table = String.join(", ", expectedHeaders);
        checkingTableHeaders.shouldHave(textsInAnyOrder(expectedHeaders));
    }

    private void attachScreenshot(Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName.value());
    }

    private void verifyTableFieldDataSize() {
        numberCardsInTheRegistry.shouldHave(sizeGreaterThanOrEqual(1));
    }

    @Step("В реестре {registerName} отображаются кнопки сортировки и фильтр")
    public void columnsAndFilterButton(Registers registerName) {
        switchTo().window(1);
        settingsButton.shouldBe(visible);
        $(".container-btn").$("button.btn-white").shouldBe(visible);
    }


    @Step("Переход в карточку реестра ")
    public void goToRegistryCard(Registers RegisterName) {
        switchToWindow();
        SelenideElement searchResultLink = searchResultLink();
        String linkName = searchResultLink.getAttribute("href");
        searchResultLink.click();
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку", linkName);
    }
}
