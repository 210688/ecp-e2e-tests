package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.HeaderTableRinRif;
import ru.mos.smart.data.enums.Registers;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.mos.smart.helpers.AllureAttachments.attachScreenshot;

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
            checkingTableHeaders = registryCardsTable.$$("th");


    private void switchToWindow() {
        switchTo().window(1);
    }

    private void attachScreenshotCard(Registers registerName) {
        attachScreenshot("Скриншот карточки" + " " + registerName.value());
    }

    @Step("Проверить наличие карточек в реестре {registerName}")
    public void checkPresenceCardInRegistry(Registers registerName) {
        switchToWindow();
        resultsAllCardsInRegistry.shouldHave(sizeGreaterThan(1));
        attachScreenshot("Наличие карточек в реестре" + " " + registerName.value());
    }

    @Step("Проверить заполненность данными в карточке")
    public void checkInformationTheTab() {
        $(".description").should(visible);
    }

    private void headersInCard(List<String> expectedHeaders) {
        String headers = String.join(", ", expectedHeaders);
        headersInCard.shouldHave(texts(expectedHeaders));
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
        SelenideElement cardLinkElement = resultsAllCardsInRegistry.first().$$("td").get(0).$("a");
        String linkName = cardLinkElement.getAttribute("href");
        cardLinkElement.click();
        assert linkName != null;
        addAttachment("Ссылка на карточку " + registerName, linkName);
    }

    @Step("Перейти в карточку реестра {registerName}")
    public void goToRegistryCarr(Registers registerName) {
        switchTo().window(1);
        ElementsCollection rows = $$(".search-result-table > tbody > tr");
        SelenideElement randomRow = rows.get((int) (Math.random() * rows.size()));
        ElementsCollection cells = randomRow.$$("td");

        int randomCellIndex = (int) (Math.random() * cells.size());
        String cellText = cells.get(randomCellIndex).getText();
        if (!cellText.isEmpty()) {
            String hrefLink = cells.get(randomCellIndex).$("a").getAttribute("href");
            cells.get(randomCellIndex).$("a").click();
            assert hrefLink != null;
            addAttachment("Ссылка на карточку " + registerName, hrefLink);
        } else {
            throw new AssertionError("Текст в ячейке отсутствует.");
        }
    }

    @Step("Доступность заголовков {list} и наличие данных в карточке {registerName}")
    public void checkAvailabilityHeadersInCard(Registers registerName, List<String> list) {
        switchToWindow();
        headersInCard(list);
        attachScreenshotCard(registerName);
    }

    @Step("Реестр содержит хотя бы одну карточку, отображаются заголовки таблицы {list}")
    public void registryContainsCardsHeadersCheck(Registers registerName, List<String> list) {
        switchToWindow();
        verifyTableFieldDataSize();
        verifyTableHeadersMatchExpected(list);
        heading.shouldHave(text(valueOf(registerName))).should(visible);
        attachScreenshotCard(registerName);
    }

    private void verifyTableHeadersMatchExpected(List<String> expectedHeaders) {
        String table = String.join(", ", expectedHeaders);
        checkingTableHeaders.shouldHave(textsInAnyOrder(expectedHeaders));
    }

    private void verifyTableFieldDataSize() {
        resultsAllCardsInRegistry.shouldHave(sizeGreaterThan(1));
    }


    @Step("В карточке отображается вкладка с таблицей документов")
    public void checkDataTabsDocuments() {
        $x("//span[contains(text(),'Документы')]").should(visible).click();
        $$(".table-bordered").find(text("Печатное представление заявки на оказание ГУ")).should(visible);
        attachScreenshot("Вкладка документы");
    }

    public ElementsCollection getTableHeaders() {
        return checkingTableHeaders;
    }

    public void verifyColumnHeader(String expectedHeader, int index) {
        ElementsCollection headers = getTableHeaders();
        String actualHeader = headers.get(index).getText();
        step("Проверка, что заголовок '" + expectedHeader + "' соответствует ожидаемому. Фактическое значение: " + actualHeader, () -> {
            assertEquals(expectedHeader, actualHeader, "Значение не соответствует ожидаемому");
        });
    }

    public void verifyNumberHeader() {
        verifyColumnHeader("Номер акта", 0);
    }

    //Метод для получения заголовков таблицы
    private ElementsCollection getTableCardHeaders() {
        return headersInCard;
    }

    // Проверка соответствия заголовка колонки ожидаемому значению
    public void verifyColumnCardHeader(HeaderTableRinRif expectedCardHeader, int index) {
        ElementsCollection headers = getTableCardHeaders();
        String actualCardHeader = headers.get(index).getText();
        step("Проверить, что заголовок '" + expectedCardHeader.getValue() + "' соответствует ожидаемому. Фактическое значение: "
                + actualCardHeader, () -> {
            assertEquals(expectedCardHeader.getValue(), actualCardHeader, "Значение не соответствует ожидаемому");
        });
    }

    public void verifyCardHeader(HeaderTableRinRif[] headers) {
        step("Проверить заголовки в карточки", () -> {
            for (int i = 0; i < headers.length; i++) {
                verifyColumnCardHeader(headers[i], i);
            }
        });
    }
}

