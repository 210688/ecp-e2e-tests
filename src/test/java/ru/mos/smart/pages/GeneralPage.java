package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.NonNull;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
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
            resultsAllCardsInRegistry = $$(".search-result-table > tbody > tr");

    private SelenideElement searchResultLink() {
        Random random = new Random();
        int randomNumber = random.nextInt(5) + 1;
        return resultsAllCardsInRegistry.get(randomNumber).$$("td").get(1).$("a");
    }

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Реестр содержит хотя бы одну карточку, и в нем отображаются заголовки таблицы {list}")
    public void  verifyRegistryContainsCardsAndTableHeaders(Registers registerName, List<String> list) {
        switchToWindow();
        checkTableFieldDataSize();
        checkTableHeadersMatchExpected(list);
        attachScreenshot(registerName);
    }

    private void checkTableFieldDataSize() {
        resultsAllCardsInRegistry.shouldHave(sizeGreaterThan(1));
    }

    private void checkTableHeadersMatchExpected(List<String> expectedHeaders) {
        String table = String.join(", ", expectedHeaders);
        checkingTableHeaders.shouldHave(textsInAnyOrder(expectedHeaders));
    }

    private void attachScreenshot(@NonNull Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName.value());
    }


    @Step("Перейти в карточку реестра {registerName}")
    public void goToRegistryCard(Registers registerName) {
        switchToWindow();
        resultsAllCardsInRegistry.shouldHave(sizeGreaterThan(1)
                .because("Ожидалось, что таблица содержит хотя-бы одну карточку"));
        SelenideElement cardLinkElement = resultsAllCardsInRegistry.first().$$("td").get(2).$("a");
        String linkName = cardLinkElement.getAttribute("href");
        cardLinkElement.click();
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку" + registerName, linkName);
    }
}
