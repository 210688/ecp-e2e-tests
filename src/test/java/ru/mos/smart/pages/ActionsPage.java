package ru.mos.smart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

/**
 * Страница Возможности
 */

public class ActionsPage {
    public static String
            actionName = "Создать ЭОО";

    // Поиск и выбор возможности по наименованию. Можно добавлять свои.
    @Step("Выбор возможности {action}")
    public static void searchAction(String actionName) {
        MainPage.actionsPage();

        step("Ввод наименования возможности в поиске", ()-> {
            $(By.name("common"))
                    .waitUntil(visible, 10000).shouldBe(visible).setValue(actionName);
        });

        step("Найти", ()-> {
            $(withText("Найти")).shouldBe(visible).click();
        });

        step("Выбор найденной возможности в списке", ()-> {
            $(withText(actionName))
                    .waitUntil(visible, 10000).shouldBe(visible).click();
        });
    }
}
