package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static ru.mos.smart.data.RegisterObjectTypeDrone.AEROFOTO;

public class DronePage {
    private final String aerofoto = AEROFOTO.getDroneDescription();
    private final ElementsCollection tableHeaders = $$("table th");
    private final ElementsCollection tableFieldData = $$(".table-striped");
    private final ElementsCollection searchResultTable = $$("table.search-result-table tr");
    private final SelenideElement link = searchResultTable.get(2).$$("td").get(1).$("a");
    private final SelenideElement aeroFoto = $(byText(aerofoto));



    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("В реестре Данные аэрофотосъемки присутствует список карточек")
    public void checkCardsReestrDrone() {
        aeroFoto.should(visible);
        AllureAttachments.attachScreenshot("Список карточек");
    }

    @Step("Проверить наполненность карточки")
    public void goToCardDrone() {
        switchToWindow();
        String linkName = link.getAttribute("href");
        link.click();
        //$(".card-header").shouldBe(visible);
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку", linkName);
        AllureAttachments.attachScreenshot("Карточка реестра данные аэрофотосъемки");
    }

    @Step("В реестре {registerName} присутствует список карточек, присутствуют колонки {list}")
    public void checkFilter(String registerName, List<String> list) {
        switchToWindow();
        String table = String.join(", ", list);
        tableHeaders.shouldHave(textsInAnyOrder(list));
        //tableHeaders.filter(visible).shouldHave(textsInAnyOrder(list));
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName);
        tableFieldData.shouldHave(sizeGreaterThan(0));
    }
}
