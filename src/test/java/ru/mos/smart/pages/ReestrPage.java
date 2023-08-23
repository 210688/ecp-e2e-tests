package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.time.Duration.ofSeconds;

public class ReestrPage {

    private final ElementsCollection elements =  $$("[title]");

    private final ElementsCollection tableHeaders = $$("table th");
    private final ElementsCollection registryFilledWithData  = $$(".search-result-table");
    private final ElementsCollection tableFieldData = $$(".table-striped");
    private final ElementsCollection tableFieldDataOasirx = $$(".viewtable");

    @Step("Проверка, что в реестре  присутствует список реестров доступных пользователю")
    public void checkReestrTask() {
        assert elements.size() > 0 : "Коллекция не содержит элементов";
        AllureAttachments.attachScreenshot("Список реестров пользователя");
    }


    @Step("Проверить, что в реестре {registerName} есть данные и присутствуют колонки таблицы {list}")
    public void checkFilter(String registerName, List<String> list) {
        String table = String.join(", ", list);
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(list));
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName);
        tableFieldData.shouldHave(sizeGreaterThan(0));
    }

    @Step("Проверить, что в реестре {registerName} есть данные и присутствуют колонки таблицы {list}")
    public void checkFieldData(String registerName, List<String> list) {
        String table = String.join(", ", list);
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(list));
        AllureAttachments.attachScreenshot("Скриншот реестра" + " " + registerName);
        tableFieldDataOasirx.shouldHave(sizeGreaterThan(0));
    }

    @Step("Проверить, что реестр наполнен данными и присутствуют заголовки {list}")
    public void checkRegistryHeader(List<String> list) {
        String table = String.join(", ", list);
        tableHeaders.filter(visible).shouldHave(textsInAnyOrder(list));
        registryFilledWithData.shouldHave(sizeGreaterThan(0));
    }

    @Step("Проверить, что в реестре содержится поле для поиска")
            public void searchField() {
        $(".search-form").$("input").shouldBe(visible, ofSeconds(10));
    }

    @Step("Проверить, что в реестре отображаются кнопки сортировки и фильтр")
            public void columnsAndFilterButton() {
        $("#dropdown-columns-btn").shouldBe(visible);
        $(".container-btn").$("button.btn-white").shouldBe(visible);
    }

    @Step("Проверить, что таблица заполнена данными")
            public void presentDataInTable() {
        $$(".table-striped").shouldHave(sizeGreaterThan(0));
    }

    @Step("Перейти в  карточку жителя, нажав на поле с ФИО жителя")
    public ReestrPage gotoFirstCard() {
        $("showcase-builder-runtime a").click();
        switchTo().window(1);
        return this;
    }

    @Step("Перейти в первую карточку реестра")
    public void gotoFirstCardNoSwitchWindow() {
        $("showcase-builder-runtime a").click();

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
