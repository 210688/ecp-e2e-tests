package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.addAttachment;
import static ru.mos.smart.helpers.AllureAttachments.attachScreenshot;

public class DictPage {

    SelenideElement search =  $(By.name("filterinput"));

    private final ElementsCollection
            dicts = $$(".table-responsive tr"),
            dict = $$(".table-responsive"),
            listSystemDict = $$(".table-hover > tbody > tr");

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Наличие системных справочников")
    public void checkListSystemDict() {
        dicts.shouldHave(sizeGreaterThan(1));
        attachScreenshot("Список системных справочников");
    }

    @Step("Наличие данных в справочнике Возможности")
    public void checkListActions() {
        dicts.shouldHave(sizeGreaterThan(1));
        attachScreenshot("Справочник Возможности");
    }

    @Step("Поиск справочника")
    public void searchDicts() {
        search.val("AdminGroupsList");
        dict.find(visible).shouldHave(text("Административные группы прав доступа"));
    }

    @Step("Переход в системный справочник Возможности")
    public void goToSystemDict() {
        listSystemDict.shouldHave(sizeGreaterThan(1)
                .because("Ожидалось, что справочник содержит хотя-бы один системный справочник"));
        SelenideElement cardLinkElement = listSystemDict.first().$$("td").get(1).$("a");
        String linkName = cardLinkElement.getAttribute("href");
        cardLinkElement.click();
        assert linkName != null;
        addAttachment("Ссылка на системный справочник возможности ", linkName);
    }
}
