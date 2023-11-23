package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeLessThanOrEqual;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class MydistrictPage {

    SelenideElement tableContainingColumnNamesNumber = $(byText("№")),
            tableContainingColumnNamesLink = $(byText("Ссылка")),
            tableContainingColumnNamesDistrict = $(byText("Округ")),
            tableContainingColumnNamesRayon = $(byText("Район")),
            tableContainingColumnNamesIndustry = $(byText("Отрасль")),
            tableContainingColumnNamesObjectType = $(byText("Вид объекта")),
            tableContainingColumnNamesObjectName = $(byText("Наименование объекта")),
            tableContainingColumnNamesAddressLandmark = $(byText("Адресный ориентир")),
            tableContainingColumnNamesResponsibleExecutiveBody = $(byText("Ответсвенный орган исполнительной власти")),
            tableContainingColumnNamesSpecialObject = $(byText("Особый объект")),
            tableContainingColumnNamesPlanMasterObject = $(byText("Объект мастера плана")),
            tableContainingColumnNamesObjectCreationDate = $(byText("Дата создания объекта")),
            tableContainingColumnNamesLinkAddress = $(byText("Адресс ссылки")),
            nameObjectsUnderMyDistrictProgram = $(".bs-text-ex__h3.ng-star-inserted"),
            exportToExcelButton = $(".d-flex.flex-row.justify-content-end"),
            testingMultisearchWithPlaceholderTextFromAttributes = $(".formly-input-text__control.default"),
            checkThatTheFindButtonIsActive = $(".modalButMain.ng-star-inserted")
                    .$(byText("Найти")),
            checkThatTheResetButtonIsActive = $(byText("Сбросить")),
            makeSureTheAdvancedSearchButtonIsActive = $(byText("Расширенный поиск")),
            checkThatTheColumnVisibilityButtonIsActive = $(byText("Видимость столбцов")),
            checkThatTheMaximumNumberOfRecordsPerPageIs25 = $("div.ag-center-cols-container"),
            checkThatThePaginationFieldIsVisible = $(".bottom-toolbar.ng-star-inserted"),
            checkThatTheTotalNumberOfRecordsCounterIsTotalRecords = $(".rows-count.ng-star-inserted"),
            checkingHorizontalAndVerticalScrolling = executeJavaScript("window.scrollTo(0, document.body.scrollHeight)"),
            checkingHorizontalAndVerticalScrollingSupportSpan = $(".support span").scrollTo(),
            checkingHorizontalAndVerticalScrollingLinkAddress = $(byText("Адрес ссылки")).scrollTo();


    @Step("Таблица, содержащая информацию об объектах (витрина объектов), состоящая из следующих столбцов: №, Ссылка," +
            " Округ, Район, Отрасль, Вид объекта, Наименование объекта, Адресный оренитир," +
            " Ответсвенный орган исполнительной власти, Особый объект, Объект мастера плана, Дата создания объекта," +
            " Адресс ссылки")

    public void tableContainingColumnNames() {

        tableContainingColumnNamesNumber.shouldBe(visible);
        tableContainingColumnNamesLink.shouldBe(visible);
        tableContainingColumnNamesDistrict.shouldBe(visible);
        tableContainingColumnNamesRayon.shouldBe(visible);
        tableContainingColumnNamesIndustry.shouldBe(visible);
        tableContainingColumnNamesObjectType.shouldBe(visible);
        tableContainingColumnNamesObjectName.shouldBe(visible);
        tableContainingColumnNamesAddressLandmark.shouldBe(visible);
        tableContainingColumnNamesResponsibleExecutiveBody.shouldBe(visible);
        tableContainingColumnNamesSpecialObject.shouldBe(visible);
        tableContainingColumnNamesPlanMasterObject.shouldBe(visible);
        tableContainingColumnNamesObjectCreationDate.shouldBe(visible);
        tableContainingColumnNamesLinkAddress.shouldBe(visible);
    }

    @Step("Проверка наименования:Объекты по программе Мой район")
    public void nameObjectsUnderMyDistrictProgram() {
        nameObjectsUnderMyDistrictProgram.shouldBe(visible);
    }

    @Step("Проверка, что активная кнопка Экспорт в Excel")
    public void exportToExcelButton() {
        exportToExcelButton.shouldBe(visible);
    }

    @Step("Проверка мультипоиска с текстом-заполнителем из атибутов, по которым возможен поиск Адрес или наименование" +
            " объекта")
    public void testingMultisearchWithPlaceholderTextFromAttributes() {
        testingMultisearchWithPlaceholderTextFromAttributes.shouldBe(visible);
    }

    @Step("Проверить, что активная кнопка Найти")
    public void checkThatTheFindButtonIsActive() {
        checkThatTheFindButtonIsActive.shouldBe(visible);
    }

    @Step("Проверить, что активная кнопка сбросить")
    public void checkThatTheResetButtonIsActive() {
        checkThatTheResetButtonIsActive.shouldBe(visible);
    }

    @Step("Проверить, что активна кнопка Расширенный поиск")
    public void makeSureTheAdvancedSearchButtonIsActive() {
        makeSureTheAdvancedSearchButtonIsActive.shouldBe(visible);
    }

    @Step("Проверить, что активна кнопка Видимость столбцов")
    public void checkThatTheColumnVisibilityButtonIsActive() {
        checkThatTheColumnVisibilityButtonIsActive.shouldBe(visible);
    }

    @Step("Проверить, что максимальное количество записей на странице - 25")
    public void checkThatTheMaximumNumberOfRecordsPerPageIs25() {
        checkThatTheMaximumNumberOfRecordsPerPageIs25.shouldHave();
    }

    @Step("Проверить, что поле пагинация отображается")
    public void checkThatThePaginationFieldIsVisible() {
        checkThatThePaginationFieldIsVisible.shouldBe(visible);
    }

    @Step("Проверить, что счетчик общего количества имеет запись Всего записей")
    public void checkThatTheTotalNumberOfRecordsCounterIsTotalRecords() {
        checkThatTheTotalNumberOfRecordsCounterIsTotalRecords.shouldBe(visible);

    }

    @Step("Проверка горизонтального и вертикального скролла")
    public void checkingHorizontalAndVerticalScrolling() {
        checkingHorizontalAndVerticalScrolling.shouldBe(visible);
        checkingHorizontalAndVerticalScrollingSupportSpan.shouldBe(visible);
        checkingHorizontalAndVerticalScrollingLinkAddress.shouldBe(visible);
    }

    @Step("Проверка расширенного поиска с отображением кнопок: Тип объекта (выбор значения из списка), " +
            " Проблемный объект (Чек-бокс), Место притяжения (Чек-бокс)," +
            " К публикации на открытых информационных ресурсах (Чек-бокс), К публикации на mos.ru (Чек-бокс), " +
            "Объект культурного наследия (Чек-бокс), Инфекционная больница covid-19 (Чек-бокс), " +
            "Номер каталога ЕХД (Ручной ввод), Кнопка Очистить фильтры, Кнопка Скрыть панель расширенного поиска")
    public void testingAdvancedSearchWithButtonDisplay() {
        //  $(byText("Расширенный поиск")).click();
        $(byText("Тип объекта")).$(byText("Выберете значение"));
        $(byText(" Проблемный объект  "))
                .$x("//input[contains(@class, 'ng-touched medium')]");
        $(byText("Место притяжения"));
        $(byText("К публикации на открытых информационных ресурсах"));
        $(byText("К публикации на mos.ru"));
        $(byText("Объект культурного наследия"));
        $(byText("Инфекционная больница covid-19"));
        $(byText("Номер каталога ЕХД"))
                .$("#formly_66_trv-input_e28a3422-94b5-4b7a-a36d-66231e47fec8_0");
        $(byText("Очистить фильтры"));
        $(byText("Скрыть панель расширенного поиска"));
    }

    @Step("Проверить видимость элементов в кнопке видимость столбцов")
    public void checkTheVisibilityOfElementsInTheColumnVisibilityButton() {
        // $(byText("Видимость столбцов")).click();
        $(".custom-dialog__title");
        $(".custom-dialog__close.trvi-close");
        $("#item9933-0").$(byText("№"));
        $("item9933-1").$(byText("Ссылка"));
        $("#item9933-2").$(byText("Округ"));
        $("#item9933-3").$(byText("Район"));
        $("#item9933-6").$(byText("Отрасль"));
        $("#item9933-7").$(byText("Вид объекта"));
        $("#item9933-8").$(byText("Наименование объекта"));
        $("#item9933-9").$(byText("Адресный ориентир"));
        $("#item9933-10").$(byText("Отвественный орган исполнительной власти"));
        $("#item9933-11").$(byText("Особый объект"));
        $("#item9933-13").$(byText("Объект мастер-плана"));
        $("#item9933-15").$(byText("Дата создания объекта"));
        $("#item9933-16").$(byText("Адрес ссылки"));
        $(byText("Выбрать все"));
        $(byText("Готово"));
        $(byText("Отмена"));


    }

}
