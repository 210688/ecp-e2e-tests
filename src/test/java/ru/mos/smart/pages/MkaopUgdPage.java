package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class MkaopUgdPage {

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("В карточке Подписка на уведомления о событиях содержатся вкладки Сведения о подписке и Возможности")
    public void checkingCardTabs() {
        $x("//span[contains(text(),'Поручение')]").should(visible);
        $x("//span[contains(text(),'История')]").should(visible);
        $x("//span[contains(text(),'Техническая информация')]").should(visible);
    }
}
