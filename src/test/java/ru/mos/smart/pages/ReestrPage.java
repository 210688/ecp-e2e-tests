package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ReestrPage {

    @Step("Открыть реестр {registerName}")
    public ReestrPage open(String registerName) {
        $(byName("candidateSearchValue")).setValue(registerName).pressEnter();
        $(byText(registerName)).click();

        return this;

    }

    public ReestrPage search(String registerName) {
        $(byName("candidateSearchValue")).setValue(registerName).pressEnter();

        return this;
    }

    @Step("Открыть карточку жителя, нажав на поле с ФИО жителя")
    public ReestrPage gotoFirstCard() {
        $("showcase-builder-runtime a").click();
        switchTo().window(1);

        return this;
    }

    @Step("Открыть первую карточку реестра")
    public ReestrPage gotoFirstCardNoSwitchWindow() {
        $("showcase-builder-runtime a").click();

        return this;
    }


    @Step("Открытие раздела СД")
    public ReestrPage goToSdCard() {
        $(byText("СД")).click();
        $(byText("СД")).shouldBe(visible);

        return this;
    }
}
