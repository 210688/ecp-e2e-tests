package ru.mos.smart.tests.mydistrict;


import io.qameta.allure.AllureId;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static ru.mos.smart.data.enums.Registers.IZS_ZAV;
import static ru.mos.smart.data.enums.Registers.MR_PROGRAM_OBJ;
import static ru.mos.smart.data.enums.Sidebar.*;

public class MydistrictRegistryObject extends TestBase {


    @Test
    @AllureId("10734")
    @Tag("regres")
    void checkAttributesOfMydistrictRegistryObject() {
        // List<String> tableColumnList = Arrays.asList("№, Ссылка, Округ, Район, Отрасль, Вид объекта," +
        //   " Наименование объекта, Адресный оренитир, Ответсвенный орган исполнительной власти, Особый объект," +
        //     "Объект мастера плана, Дата создания объекта, Адресс ссылки");


        sidebarPage.clickSidebarMenu(MY_RAYON);
        sidebarPage.clickSubMenuList(MY_RAYON, REGISTERS_OBJECTS);
        //  mydistrictPage.checkAvailabilityHeadersInCard(tableColumnList);
        mydistrictPage.nameObjectsUnderMyDistrictProgram();
        mydistrictPage.exportToExcelButton();


        step("Проверка наименования:Объекты по программе Мой район", () -> {
            $(".bs-text-ex__h3.ng-star-inserted").shouldBe();
        });
        step("Проверка, что активная кнопка Экспорт в Excel", () -> {
            $(".d-flex.flex-row.justify-content-end").shouldBe();
        });
        step("Проверка мультипоиска с текстом-заполнителем из атибутов," +
                " по которым возможен поиск Адрес или наименование объекта", () -> {
            $(".formly-input-text__control.default").shouldBe();
        });
        step("Проверить, что активная кнопка Найти", () -> {
            $(".modalButMain.ng-star-inserted")
                    .$(byText("Найти")).shouldBe();
        });
        step("Проверить, что активная кнопка сбросить", () -> {
            $(byText("Сбросить")).shouldBe();
        });
        step("Проверить, что активна кнопка Расширенный поиск", () -> {
            $(byText("Расширенный поиск")).shouldBe();
        });
        step("Проверить, что активна кнопка Видимость столбцов", () -> {
            $(byText("Видимость столбцов")).shouldBe();
        });

        step("Проверить, что максимальное количество записей на странице - 25", () -> {
            $$("div.ag-center-cols-container")
                    .shouldHave(sizeLessThanOrEqual(25));
        });

        step("Проверить, что таблица содержит наименование колонок", () -> {
            $$(".ag-header-viewport")
                    .shouldHave(texts("№", "Ссылка", "Округ", "Район", "Отрасль",
                            "Вид объекта", "Наименование объекта", "Адресный оренитир",
                            "Ответсвенный орган исполнительной власти", "Особый объект", "Объект мастера плана",
                            "Дата создания объекта", "Адресс ссылки"));

        });
    }

}




