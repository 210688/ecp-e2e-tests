package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Описание общих элементов подсистемы OASIRX.
 */

public class OasirxPage {

    private final ElementsCollection
            tables = $$(".table-responsive tr"),
            tableHeaders = $$(".tab-container li"),
            cardHeaders = $$(".header.row div"),
            registryTableHeaders = $$(".theadapp > tr > th");


    private SelenideElement getLinkElement() {
        return tables.get(1).$$("td").get(0).$("a");
    }

    private SelenideElement getLinkElementEoo() {
        return tables.get(3).$$("td").get(1).$("a");
    }

    @Step("Реестр содержит хотя бы одну карточку, также присутствуют заголовки таблицы {list}")
    public void registryContainsCardsHeadersCheck(Registers registerName, List<String> list) {
        verifyTableHeadersMatchExpected(list);
        attachScreenshot(registerName);
        verifyTableFieldDataSize();
    }

    private void verifyTableHeadersMatchExpected(List<String> expectedHeaders) {
        String table = String.join(", ", expectedHeaders);
        registryTableHeaders.shouldHave(textsInAnyOrder(expectedHeaders));
    }

    private void attachScreenshot(Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName.value());
    }

    private void verifyTableFieldDataSize() {
        $$(".table-responsive").shouldHave(sizeGreaterThanOrEqual(1));
    }


    @Step("Проверить наличие заявок в реестре {registerName}")
    public void checkAvailabilityApplication(String registerName) {
        tables.shouldHave(sizeGreaterThanOrEqual(0));
        AllureAttachments.attachScreenshot("Список заявок");
    }

    @Step("Переход по ссылке в карточку документа СД")
    public void goToCard() {
        getLinkElement().click();
        Allure.parameter("Ссылка на карточку", getLinkElement().getAttribute("href"));
    }

    @Step("Переход по ссылке в карточку документа")
    public void goToCardEoo(List<String> list) {
        Allure.parameter("Ссылка на карточку", getLinkElementEoo().getAttribute("href"));
        getLinkElementEoo().click();
        String table = String.join(", ", list);
        cardHeaders.filter(visible).shouldHave(textsInAnyOrder(list));
        AllureAttachments.attachScreenshot("Карточка");
    }

    @Step("Проверить, что в реестре {registerName} есть данные и присутствуют колонки таблицы {list}")
    public void checkFilter(String registerName, List<String> list) {
        String table = String.join(", ", list);
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(list));
    }
}
