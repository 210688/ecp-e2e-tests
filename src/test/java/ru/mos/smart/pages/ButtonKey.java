package ru.mos.smart.pages;

import static com.codeborne.selenide.Selenide.*;

/**
 * Страница под вопросом
 */

public class ButtonKey {

    public static void setButtonInRabota() {
        sleep(5000);
        if ($x("//div/button[text()='Взять в работу']").isDisplayed()) {
            ($x("//div/button[text()='Взять в работу']")).click();
        } else {
            $("#address-ctr").setValue("Степной поселок");
        }
    }

    public static void setButtonInRabot() {
        sleep(5000);
        if ($x("//div/button[text()='Взять в работу']").isDisplayed()) {
            ($x("//div/button[text()='Взять в работу']")).click();
        } else {
            $("#address-ctr").setValue("Степной поселок");
        }
    }
}