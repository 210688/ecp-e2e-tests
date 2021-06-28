package ru.mos.smart.pages;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TasksPage {
    public static String
            task1 = "Определение разработчика материалов",
            task2 = "Подготовка материалов для ЭОО",
            task3 = "Внесение информации о проведении",
            task4 = "Проверка материалов для ЭОО",
            task5 = "Подготовка решения руководителем УГР ВАО",
            task6 = "Подготовка решения руководителем УОС",
            task7 = "Согласование материалов для ЭОО начальником УППТ",
            task8 = "Согласование материалов для ЭОО зам. председателя УППТ",
            task9 = "Согласование материалов зам. председателя ЭОО";


    public static void clickTask(String task) {
        $(byText(task)).parent().parent().$(byTitle("Перейти к задаче"))
                .should(visible, Duration.ofSeconds(10)).click();
    }


    @Step("Выбор задачи")
    public static void searchTask(String tasksName) {
        $x("//a[@href='/main/#/app/tasks']") // Задачи
                .should(visible, Duration.ofSeconds(10)).click();

        step("Ввод наименования задачи в поиске", () ->
                $x("//input[@placeholder='Найти задачу']")
                        .should(visible, Duration.ofSeconds(10)).click());

        step("Выбор задачи в списке {taskName}", () ->
                $x("//span[contains(@class,'task-title') and contains(.,'" + tasksName + "')]").click());
    }

    @Step("Принять в работу задачу «{taskName}»")
    public static void takeUnusedTask(String taskName) {
        $("#my-task-showcase").shouldBe(visible,Duration.ofSeconds(15));
        $("cdp-my-tasks-menu").$(byText(taskName)).click();
        $("#my-task-showcase").$("[title='Исполнитель не назначен']").click();
        $("h1").shouldHave(text(taskName), Duration.ofSeconds(10));
        sleep(5000);
        if($(".modal-content").isDisplayed()) {
            $(".modal-content").$(byText("Взять")).click();
        }
    }
    @Step("Принять в работу задачу «{taskName}»")
    public static void takeTask(String taskName) {
        $("#my-task-showcase").shouldBe(visible,Duration.ofSeconds(15));
        $("cdp-my-tasks-menu").$(byText(taskName)).click();
        $("#my-task-showcase").$(byText(taskName)).click();
        $("h1").shouldHave(text(taskName), Duration.ofSeconds(10));
    }

    @Step("Открыть задачу по имени документа «{documentName}»")
    public static void openTaskByDocumentName(String documentName) {
        $("#my-task-showcase").shouldBe(visible,Duration.ofSeconds(15));
        $x("//*[@id='my-task-showcase']//*[contains(text(), '" + documentName + "')]").click();
        $(byName("docNumber")).shouldHave(text(documentName), Duration.ofSeconds(10));
    }
}
