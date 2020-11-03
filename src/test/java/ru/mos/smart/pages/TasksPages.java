package ru.mos.smart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TasksPages {
    public static String
            task1 = "Определить разработчика материалов",
            task2 = "Внести информацию о проведении",
            task3 = "Подготовить материалы для ЭОО",
            task4 = "Проверить материалы для ЭОО",
            task5 = "Подготовить решение по материалам (руководитель)",
            task6 = "Согласовать материалы для ЭОО (начальник управления)",
            task7 = "Согласовать материалы (зам. пред.)",
            task8 = "Согласовать материалы (зам. пред. ЭОО)";


    @Step("Выбор задачи")
    public static void searchTask(String tasksName) {
        $(By.xpath("//a[@href='/main/#/app/tasks']")) //Задачи
                .waitUntil(visible, 5000).click();

        step("Ввод наименования задачи в поиске", () -> {
            $(By.xpath("//input[@placeholder='Найти задачу']"))
                    .waitUntil(visible, 5000).shouldBe(visible).setValue(tasksName).pressEnter();
        });

        step("Выбор задачи в списке {taskName}", () -> {
            $(By.xpath("//span[contains(@class,'task-title') and contains(.,'" + tasksName + "')]")).click();
        });
    }
}
