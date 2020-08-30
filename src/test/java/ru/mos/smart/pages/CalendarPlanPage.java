package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarPlanPage {
    public static String okazanieUslug = "Оказание услуг и работы по сбору исходных данных " +
            "в необходимом и достаточном объеме для проектирования. " +
            "Проведение инженерных изысканий.",
            poluchenieTechnicheskihUslovii = "Получение технических условий для проектирования" +
            " объекта, составление задания на проектирование, " +
            "оказание услуг и работ технического заказчика на период " +
            "проектирования объекта (проектная документация)." +
            " Оказание услуг по направлению проектной документации" +
            " на гос. экспертизу.";


    public static void setTableCellValue(String titleText, int cellIndex, String value) {
        $(byText(titleText))
                .parent().$("input[type=number]", cellIndex)
                .setValue(value);
    }
}
