package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.NonNull;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ru.mos.smart.config.ConfigHelper.getWebSecureUrl;

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

    public void checkMainPage() {

    }

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Проверить открытие страницы Создать пользователя")
    public void createUser() {
        $x("//button[contains(text(),'Создать пользователя')]").should(visible).click();
    }

    @Step("Проверить доступность Главной страницы")
    public void checkFormMainPage() {
        $(".formly-form").should(visible, Duration.ofSeconds(15));
    }

    @Step("Проверить сообщение Неправильное имя пользователя или пароль.")
    public void checkMessageWrongPassword() {
        $(".kc-feedback-text")
                .shouldHave(text("Неправильное имя пользователя или пароль."));
    }

    @Step("Проверить открытие страницы восстановления пароля по Логину или Email")
    public void checkOpenRestorePassword() {
        open(getWebSecureUrl());
        $(".login-page__login").click();
        $(".restore_open").click();
    }

    @Step("Проверить сообщение об успешном восстановлении пароля")
    public void checkMessageRestorePassword() {
        $("#inputLogin").val("user_tests");
        $(".btn-primary block").click();
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
