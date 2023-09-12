package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.data.Registers;
import ru.mos.smart.helpers.AllureAttachments;
import ru.mos.smart.helpers.utils.RandomUtils;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Описание реестров RinRif.
 */

public class RinrifPage {

    private final ElementsCollection searchResultTable = $$("table.search-result-table tr");
    private final SelenideElement link = searchResultTable.get(3).$$("td").get(1).$("a");
    private final ElementsCollection tableHeaders = $("showcase-builder-filter").$$("div.title");

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Перейти в карточку реестра и проверить наполненность карточки")
    public void goToRegistryCardAndCheck() {
        String linkName = link.getAttribute("href");
        link.click();
        $(".card-header").shouldBe(visible);
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку", linkName);
        AllureAttachments.attachScreenshot("Карточка реестра");
    }

    @Step("Переход по ссылке {linkName} в карточку")
    public void goToCard() {

        String linkName = searchResultTable.get(RandomUtils.getRandomInt(3, 6)).$$("td").get(1).$("a").getAttribute("href");
        searchResultTable.shouldHave(sizeGreaterThan(0));
        searchResultTable.get(RandomUtils.getRandomInt(3, 6))
                .$$("td").get(1).$("a").click();
    }

    @Step("В реестре {registerName} фильтр содержит колонки {list}")
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
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName.value());
    }
}
