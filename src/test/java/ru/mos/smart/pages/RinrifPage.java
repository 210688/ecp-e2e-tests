package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.valueOf;

/**
 * Описание реестров RinRif.
 */

public class RinrifPage {

    private final SelenideElement
            info = $("#infoZu"),
            commonInfo = $("#commoninfo-link"),
            infoZu = $("#infoZu-link"),
            tep = $("#tep-link"),
            searchForm = $("input.form-control"),
            getInfo = $("#commoninfo-link"),
            registryCardsTable = $("table.search-result-table tr"),
            heading = $("span[class='ng-star-inserted']");

    private final ElementsCollection
            headersInCard = $$(".tab-container li"),
            resultsAllCardsInRegistry = $$(".search-result-table > tbody > tr"),
            cardSearchResultTable = $$(".search-result-table"),
            tableHeaders = $("showcase-builder-filter").$$("div.title"),
            checkingTableHeaders = registryCardsTable.$$("th");

    private void switchToWindow() {
        switchTo().window(1);
    }

    private void headersInCard(List<String> expectedHeaders) {
        String headers = String.join(", ", expectedHeaders);
        headersInCard.shouldHave(texts(expectedHeaders));
    }

    private void attachScreenshot(Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот карточки" + " " + registerName.value());
    }

    @Step("Доступность поиска карточки в реестре")
    public void searchToCardInRegistry() {
        switchToWindow();
        resultsAllCardsInRegistry.shouldHave(sizeGreaterThan(0));
        SelenideElement cardLinkElement = resultsAllCardsInRegistry.find(text("ЕНО"));
        String originalText = cardLinkElement.getText();
        int startIndex = originalText.indexOf("ЕНО") + 4;
        String enoNumber = originalText.substring(startIndex);
        searchForm.val(enoNumber).pressEnter();
        cardSearchResultTable.find(visible).shouldHave(text(enoNumber));
    }

    @Step("Перейти в карточку реестра {registerName}")
    public void goToRegistryCard(Registers registerName) {
        switchToWindow();
        resultsAllCardsInRegistry.shouldHave(sizeGreaterThan(1)
                .because("Ожидалось, что таблица содержит хотя-бы одну карточку"));
        //resultsAllCardsInRegistry.shouldHave(sizeGreaterThan(1)).as("");
        SelenideElement cardLinkElement = resultsAllCardsInRegistry.first().$$("td").get(2).$("a");
        String linkName = cardLinkElement.getAttribute("href");
        cardLinkElement.click();
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку" + registerName, linkName);
    }

    @Step("Доступность заголовков {list} и наличие данных в карточке {registerName}")
    public void checkAvailabilityHeadersInCard(Registers registerName, List<String> list) {
        switchToWindow();
        headersInCard(list);
        attachScreenshot(registerName);
    }

    @Step("Реестр содержит хотя бы одну карточку, отображаются заголовки таблицы {list}")
    public void registryContainsCardsHeadersCheck(Registers registerName, List<String> list) {
        switchToWindow();
        verifyTableFieldDataSize();
        verifyTableHeadersMatchExpected(list);
        heading.shouldHave(text(valueOf(registerName))).should(visible);
        attachScreenshot(registerName);
    }

    private void verifyTableHeadersMatchExpected(List<String> expectedHeaders) {
        String table = String.join(", ", expectedHeaders);
        checkingTableHeaders.shouldHave(textsInAnyOrder(expectedHeaders));
    }

    private void verifyTableFieldDataSize() {
        resultsAllCardsInRegistry.shouldHave(sizeGreaterThanOrEqual(1));
    }
}
