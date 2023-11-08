package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;
import static ru.mos.smart.helpers.AllureAttachments.attachScreenshotRegisters;

@Slf4j
public class UgdPage {

    private final ElementsCollection
            resultsAllCardsInRegistry = $$(".search-result-table > tbody > tr"),
            blocksInCard = $$(".wrapper-content h3");


    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Перейти в карточку реестра {registerName}")
    public void goToRegistryCard(Registers registerName) {
        switchToWindow();
        resultsAllCardsInRegistry.shouldHave(sizeGreaterThan(1)
                .because("Ожидалось, что таблица содержит хотя-бы одну карточку"));
        SelenideElement cardLinkElement = resultsAllCardsInRegistry.first().$("td:first-child a");
        String linkName = cardLinkElement.getAttribute("href");
        cardLinkElement.click();
        assert linkName != null;
        Allure.addAttachment("Ссылка на карточку" + registerName, linkName);
    }

    /**
     * Проверяет доступность блоков и наличие данных в указанной карточке.
     * @param registerName Название реестра.
     * @param expectedHeaders Список ожидаемых заголовков блоков.
     */
    @Step("Доступность блоков {list} и наличие данных в карточке {registerName}")
    public void checkBlocksInCard(Registers registerName, List<String> expectedHeaders) {
        switchToWindow();
        verifyHeadersInCard(expectedHeaders);
        attachScreenshotRegisters(registerName);
    }

    /**
     * Проверяет наличие ожидаемых заголовков блоков в карточке.
     * @param expectedHeaders Список ожидаемых заголовков блоков.
     */
    private void verifyHeadersInCard(List<String> expectedHeaders) {
        String headers = String.join(", ", expectedHeaders);
        //log.info("Проверка заголовков блоков в карточке: " + headers);
        blocksInCard.shouldHave(texts(expectedHeaders));
        //log.info("Заголовки блоков успешно проверены.");
    }
}