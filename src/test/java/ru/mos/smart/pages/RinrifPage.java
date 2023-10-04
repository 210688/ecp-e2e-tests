package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;
import ru.mos.smart.helpers.utils.RandomUtils;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
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
            tep = $("#tep-link");

    private final ElementsCollection
            searchResultTable = $$("table.search-result-table tr"),
            blocksInCard = $$(".tab-container li");

    private final SelenideElement link = searchResultTable.get(3).$$("td").get(1).$("a");
    private final ElementsCollection tableHeaders = $("showcase-builder-filter").$$("div.title");

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Доступность блоков {list} в карточке")
    public void checkAvailabilityOfUnits(Registers registerName, List<String> list) {
        switchToWindow();
        blocksInCard(list);
        attachScreenshot(registerName);
    }

    private void blocksInCard(List<String> expectedHeaders) {
        String block = String.join(", ", expectedHeaders);
        blocksInCard.shouldHave(textsInAnyOrder(expectedHeaders));
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

    @Step("Перейти в карточку реестра и проверить заполнение данных")
    public void goToRegistryCardAndCheck() {
        String linkName = link.getAttribute("href");
        link.click();
        $(".card-header").shouldBe(visible);
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку", linkName);
        //AllureAttachments.attachScreenshot("Карточка реестра");
    }

    @Step("Переход по ссылке {linkName} в карточку")
    public void goToCard() {

        String linkName = searchResultTable.get(RandomUtils.getRandomInt(3, 6)).$$("td").get(1).$("a").getAttribute("href");
        searchResultTable.shouldHave(sizeGreaterThan(0));
        searchResultTable.get(RandomUtils.getRandomInt(3, 6))
                .$$("td").get(1).$("a").click();
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
