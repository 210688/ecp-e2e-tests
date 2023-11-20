package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static java.time.Duration.ofSeconds;

public class ReestrPage {
    private final SelenideElement filter = $(".btn.btn-type-basic");
    private final ElementsCollection registryName = $$("trv-input"),
            listRegistry = $$(".ag-center-cols-container > div");

    @Step("Перейти в реестр {registerName}")
    public void goToRegistry(Registers registerName) {
        filter.should(visible, ofSeconds(10)).click();
        registryName.get(1).$("input").val(registerName.value());
        $(byText(registerName.value())).should(visible, ofSeconds(15)).click();
    }

    @Step("Проверить наличие элементов в списке реестров")
    public void checkListInRegistry() {
        listRegistry.shouldHave(sizeGreaterThan(1));
        AllureAttachments.attachScreenshot("Скриншот реестра");
    }

    @Step("В реестре содержится поле для поиска")
    public void searchField() {
        $(".search-form").$("input").shouldBe(visible, ofSeconds(10));
    }


    @Step("Проверка наличия колонок")
    public void checkColumns(List<String> columns) {
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