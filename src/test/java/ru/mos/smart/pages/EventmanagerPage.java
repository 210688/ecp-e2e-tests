package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EventmanagerPage {

    private final ElementsCollection cardHeaders = $$(".wrapper-content > div");

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("В карточке Подписка на уведомления о событиях содержатся вкладки Сведения о подписке и Возможности")
    public void checkingCardTabs() {
        $x("//a[contains(text(),'Сведения о подписке')]").should(visible);
        $x("//a[contains(text(),'Возможности')]").should(visible);
    }

    @Step("В карточке {registerName} присутствуют заголовки {list}")
    public void checkingCardHeaders(Registers registerName, List<String> list) {
        verifyTableHeaders(list);
        attachScreenshot(registerName);
        verifyTableFieldData();
    }

    private void verifyTableHeaders(List<String> list) {
        String table = String.join(", ", list);
        cardHeaders.shouldHave(textsInAnyOrder(list));
    }

    private void attachScreenshot(Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот карточки" + " " + registerName.value());
    }

    private void verifyTableFieldData() {
        cardHeaders.shouldHave(size(2));
    }
}
