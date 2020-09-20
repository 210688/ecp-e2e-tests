package ru.mos.smart.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class EooPagesButton {


    public static void SwitchTask() {
        $(".fa-lg").click(); // треугольничек нажатие перейти к задачи
    }
    public static void TakeTask(){ // Взять в работу назначенным исполнителем
        $(".btn-sm:nth-child(2)").click(); // взять в работу кнопка
    }
}
