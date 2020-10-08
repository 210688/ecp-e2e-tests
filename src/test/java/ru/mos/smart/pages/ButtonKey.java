package ru.mos.smart.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ButtonKey {
    public static boolean isVisible(By locator) {
        try {
            $(locator).waitUntil(Condition.visible, 5000);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}