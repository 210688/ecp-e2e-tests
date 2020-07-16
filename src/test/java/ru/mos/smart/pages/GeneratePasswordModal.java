package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

// GeneratePasswordModal

public class GeneratePasswordModal {
    /* класс для поп-ап модального окна изменения пароля пользователю (общий для платформы)
     * место появления - редактирование пароля пользователя (в частности в Моём районе).
     * */

    public static SelenideElement savePasswordButton = $("[ng-click=\"ctrl.save()\"]");

    public static void pressSavePasswordButton() {
        savePasswordButton.click();
    }


}
