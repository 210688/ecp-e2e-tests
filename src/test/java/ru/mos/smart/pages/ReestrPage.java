package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class ReestrPage {

    @Step("Открыть реестр {registerName}")
    public ReestrPage open(String registerName) {
        step("В поиске ввести название реестра и открыть его");
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

    @Step("Проверка наличия колонок")
    public ReestrPage checkColumns(List<String> columns) {
        SelenideElement catalog = $(".catalog-showcase-wrapper");
        SelenideElement showColumns = catalog.$(".showcase-builder-settings #dropdown-columns-basic").$(byText("Выбор колонок таблицы"))
                .closest("tr").$(".cdp-checkbox");
        step("Включить настройку колонок и раскрыть список колонок", () -> {
            catalog.$(".fa.fa-cogs").click();
            showColumns.shouldBe(visible);
            if (!showColumns.has(cssClass("checked"))) {
                showColumns.click();
            }
            catalog.$(".fa.fa-cogs").click();
            catalog.$(".fa.fa-bars").click();
        });
        columns.forEach(column ->
                step("Проверка наличия колонки " + column, () -> {
                    catalog.$(".reinform-cdp-columns-switcher #dropdown-columns-basic").$(byText(column))
                            .closest("tr").$(".cdp-checkbox").shouldHave(cssClass("checked"));
                    catalog.$(".search-result-table thead").$(byText(column)).shouldBe(visible);
                }));

        return this;
    }

    public ReestrPage checkColumns(List<String> columns, List<String> hiddenColumns) {
        SelenideElement catalog = $(".catalog-showcase-wrapper");
        checkColumns(columns);

        hiddenColumns.forEach(column ->
                step("Проверка скрытой колонки " + column, () -> {
                    catalog.$(".reinform-cdp-columns-switcher #dropdown-columns-basic").$(byText(column))
                            .closest("tr").$(".cdp-checkbox").shouldNotHave(cssClass("checked"));
                    catalog.$(".search-result-table thead").$(byText(column)).shouldNotBe(visible);
                }));

        return this;
    }
}
