package ru.mos.smart.pages;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ButtonKey {
    public static void button() {
        String locator;
        if ()
            locator = ".btn-sm:nth-child(2)";
        else locator = "$(\"#address-ctr\").setValue(\" поселок\").pressEnter();";
        }


    public static boolean isVisible(String locator) {
        try {
            $(By.xpath(locator)).waitUntil(visible, 5000);
            return true;
        } catch (ElementNotFound | Exception ex) {
            return false;
        }
    }
}