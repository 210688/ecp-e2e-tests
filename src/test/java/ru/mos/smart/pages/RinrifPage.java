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
import static ru.mos.smart.data.enums.Registers.AKTS_PROVEROK;

/**
 * Описание реестров RinRif.
 */

public class RinrifPage {

    private final SelenideElement
            info = $("#infoZu"),
            commonInfo = $("#commoninfo-link"),
            infoZu = $("#infoZu-link"),
            tep = $("#tep-link"),
            searchForm = $("input.form-control");

    private final ElementsCollection
            headersInCard = $$(".tab-container li"),
            resultsAllCardsInRegistry = $$(".search-result-table > tbody > tr"),
            cardSearchResultTable = $$(".search-result-table"),
            tableHeaders = $("showcase-builder-filter").$$("div.title");

    private void switchToWindow() {
        switchTo().window(1);
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

    @Step("Перейти в карточку реестра и проверить заполнение данных")
    public void goToRegistryCard(Registers registerName) {
        resultsAllCardsInRegistry.shouldHave(sizeGreaterThan(0));
        switchTo().window(1);
        SelenideElement cardLinkElement = resultsAllCardsInRegistry.get(1).$$("td").get(7).$("a");
        String linkName = cardLinkElement.getAttribute("href");
        cardLinkElement.click();
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку", linkName);
    }

    @Step("Доступность заголовков {list} в карточке")
    public void checkAvailabilityHeadersInCard(Registers registerName, List<String> list) {
        switchToWindow();
        headersInCard(list);
        attachScreenshot(registerName);
    }

    private void headersInCard(List<String> expectedHeaders) {
        String headers = String.join(", ", expectedHeaders);
        headersInCard.shouldHave(texts(expectedHeaders));
    }

    @Step("В карточке Акт проверки заполнены данные на вкладке Общие сведения")
    public void checkingCardHeaders() {
        info.should(visible);
        attachScreenshot(AKTS_PROVEROK);
    }

    @Step("Доступность вкладок 'Основные сведения', 'Сведения о ЗУ', 'ТЭП' в карточке 'Заявление о выдаче разрешения на ввод в эксплуатацию'")
    public void checkingCardHeadersRv() {
        commonInfo.should(visible);
        infoZu.should(visible);
        tep.should(visible);
    }


    @Step("В карточке присутствуют заголовки {list}")
    public void checkTableFilter(Registers registerName, List<String> list) {
        switchToWindow();
        verifyTableHeaders(list);
        attachScreenshot(registerName);
    }

    private void verifyTableHeaders(List<String> list) {
        String table = String.join(", ", list);
        tableHeaders.shouldHave(textsInAnyOrder(list));
    }

    private void attachScreenshot(Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот карточки" + " " + registerName.value());
    }
}
