package ru.mos.smart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TasksPages {
    public static String
            task1 = "sd";

    @Step("Выбор задачи")
    public static void searchTask(String tasksName) {
        $(By.xpath("//a[@href='/main/#/app/tasks']")) //Задачи
                .waitUntil(visible, 10000).click();

        step("Ввод наименования задачи в поиске", () -> {
            $(By.xpath("//input[@placeholder='Найти задачу']"))
                    .waitUntil(visible, 10000).shouldBe(visible).setValue(tasksName).pressEnter();
        });
    }
}
