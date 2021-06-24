package ru.mos.smart.pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

/**
 * Страница Возможности
 */

public class ActionsPage {
    public static String
            actionName = "Создать ЭОО",
            feedback = "Инициировать обращение в техническую поддержку";

    // Поиск и выбор возможности по наименованию. Можно добавлять свои.
    @Step("Выбор возможности {action}")
    public static void searchAction(String actionName) {
        NavigatorPage.goToActions();

        step("Ввод наименования возможности в поиске", () -> {
            $(byName("common"))
                    .should(visible, Duration.ofSeconds(10)).setValue(actionName);
        });

        step("Найти", () -> {
            $(withText("Найти")).click();
        });

        step("Выбор найденной возможности в списке", () -> {
            $(withText(actionName))
                    .should(visible, Duration.ofSeconds(10)).click();
        });
    }
}
