package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.size;
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
            numberCardsInTheRegistry = listCardsInTheRegistry.$$("tr");
    private final SelenideElement searchResultLink = searchResultsTableRows.get(2).$$("td").get(1).$("a");

    Random random = new Random();
    int randomNumber = random.nextInt(5) + 1;

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("В реестре {registerName} имеется список из {numberCardsPerPage} карточек с заголовками таблицы {list}")
    public void validateTableHeadersInRegistry(Registers registerName, List<String> list, int numberCardsPerPage) {
        switchToWindow();
        verifyTableHeadersMatchExpected(list);
        attachScreenshot(registerName);
        verifyTableFieldDataSize(numberCardsPerPage);
    }

    private void verifyTableHeadersMatchExpected(List<String> expectedHeaders) {
        String table = String.join(", ", expectedHeaders);
        checkingTableHeaders.shouldHave(textsInAnyOrder(expectedHeaders));
    }

    private void attachScreenshot(Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName.value());
    }

    private void verifyTableFieldDataSize(int expectedSize) {
        numberCardsInTheRegistry.shouldHave(size(expectedSize));
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
        String linkName = searchResultLink.getAttribute("href");
        searchResultLink.click();
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку", linkName);
        //AllureAttachments.attachScreenshot("Карточка реестра" + RegisterName.value());
    }
}
