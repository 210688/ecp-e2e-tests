package ru.mos.smart.pages;

import static com.codeborne.selenide.Selenide.*;

public class EooPagesButton {

    public static void switchTask(int Index) {
        $(".fa-lg", Index).click(); // треугольничек нажатие перейти к задачи
    }

    public static void buttonTakeTask(){ // Взять в работу назначенным исполнителем
        $x("//div/button[text()='Взять в работу']").click(); // взять в работу кнопка
    }

    public static void  saveButtonNextTask(){  //Сохранить и передать на подготовку
        $("#next").click();
    }
}
