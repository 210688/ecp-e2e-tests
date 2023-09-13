package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;
import static ru.mos.smart.data.enums.Registers.AEROFOTO;

public class DronePage {
    private final ElementsCollection tableHeaders = $$("table th");
    private final ElementsCollection tableFieldData = $$(".table-striped");
    private final ElementsCollection searchResultTable = $$("table.search-result-table tr");
    private final SelenideElement link = searchResultTable.get(2).$$("td").get(1).$("a");

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Проверить наполненность карточки")
    public void goToCardDrone() {
        switchToWindow();
        String linkName = link.getAttribute("href");
        link.click();
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку", linkName);
        AllureAttachments.attachScreenshot("Карточка реестра" + AEROFOTO);
    }

    @Step("В реестре {registerName} присутствует список карточек, присутствуют колонки {list}")
    public void checkFilter(Registers registerName, List<String> list) {
        switchToWindow();
        String table = String.join(", ", list);
        tableHeaders.shouldHave(textsInAnyOrder(list));
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName.value());
        tableFieldData.shouldHave(sizeGreaterThan(0));
    }
}
