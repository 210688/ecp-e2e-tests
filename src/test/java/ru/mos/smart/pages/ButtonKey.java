package ru.mos.smart.pages;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

//public class ButtonKey {
//    public static boolean isVisib(By locator) {
 //       try {
 //           $(locator).waitUntil(Condition.visible, 5000);
 //           return true;
 //       } catch (Exception ex) {
//            return false;
//        }
//   }


public class ButtonKey {
    public static boolean isVisible(String locator) {
        try {
            $(By.xpath("//div/button[text()='Взять в работу']")).waitUntil(visible, 5000).click();
            return true;
        } catch (ElementNotFound | Exception ex) {
            return false;
        }
    }
}


