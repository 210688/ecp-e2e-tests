package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavBar {
    public static SelenideElement
            usernsiLogoutButton = $(By.linkText("Выйти"));

    public static void pressLogout() {
        usernsiLogoutButton.click();
    }
}
