package ru.mos.smart.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarPlanPage {
    public static String
            okazanieUslug = "Оказание услуг и работы по сбору исходных данных " +
            "в необходимом и достаточном объеме для проектирования. " +
            "Проведение инженерных изысканий.",
            poluchenieTechnicheskihUslovii = "Получение технических условий для проектирования" +
                    " объекта, составление задания на проектирование, " +
                    "оказание услуг и работ технического заказчика на период " +
                    "проектирования объекта (проектная документация)." +
                    " Оказание услуг по направлению проектной документации" +
                    " на гос. экспертизу.",
            korrektirovkaPoZamechaniyam = "Корректировка по замечаниям гос. экспертизы." +
                    " Получение положительного заключения государственной" +
                    " экспертизы, передача его для выпуска Решения об" +
                    " утверждении проектной документации, включая сводный сметный расчет.",
            OkazanieUslug = "Оказание услуг и работы технического заказчика" +
                    " на период проектирования объекта в объеме, необходимом" +
                    " и достаточном для обеспечения строительства (рабочая документация).",
            PeredachaGosZakazciku = "Передача гос. заказчику утвержденной проектной" +
                    " документации и других документов, по Акту приема-передачи.";

    public static void setTableCellValue(String titleText, int cellIndex, String value) {
        $(byText(titleText))
                .parent().$("input[type=number]", cellIndex)
                .setValue(value);
    }
}
