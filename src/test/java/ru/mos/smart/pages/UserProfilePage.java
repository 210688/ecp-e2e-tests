package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class UserProfilePage {
    public static SelenideElement
            setPasswordButton = $(byTitle("Сгенерировать пароль"));

    public static void pressSetPasswordButton () {
        setPasswordButton.click();
    }



}
