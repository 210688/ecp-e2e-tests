package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.helpers.AllureAttachments;
import ru.mos.smart.helpers.utils.RandomUtils;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TaskPage {

    ElementsCollection elements = $$("#my-task-showcase tr");
    public static final ElementsCollection nameElement = $$("td a");
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

    @Step("Проверка, что в задачах пользователя присутствует список задач")
    public void checkUserTask() {
        $(".list-group-item").should(visible,Duration.ofSeconds(10));
        assert elements.size() > 0 : "Коллекция не содержит элементов";
        AllureAttachments.attachScreenshot("Список задач пользователя");
    }


    @Step("Перейти к задаче")
    public static void clickTask(String task) {
        $(byText(task)).parent().parent().$(byTitle("Перейти к задаче"))
                .should(visible, Duration.ofSeconds(10)).click();
    }

    @Step("Поиск задачи и выбор её из списка")
    public void searchTask(String tasksName) {
        $x("//a[@href='/main/#/app/tasks']") // Задачи
                .should(visible, Duration.ofSeconds(10)).click();
        $x("//input[@placeholder='Найти задачу']")
                .should(visible, Duration.ofSeconds(10)).click();
        $x("//span[contains(@class,'task-title') and contains(.,'" + tasksName + "')]").click();
    }

    @Step("Взять задачу в работу ")
    public void takeUnusedTask() {
        if ($(".modal-content").getText().equals("Взять")) {
            $(".btn btn-warning").click();
            $$(".toast-message").findBy(text("Задача взята в работу!")).shouldBe(visible);
            $("div.description a").shouldHave((attributeMatching("href", "(.*)/app/rs/card(.*)/common"))).click();
        } else {
            $("div.description a").shouldHave((attributeMatching("href", "(.*)/app/rs/card(.*)/common"))).click();
        }
    }

    @Step("Принять задачу в работу ")
    public void takeUsedTask() {
        $(".modal-content").$(byText("Взять")).click();
        $(".toast-message").shouldBe(visible);
        $$(".toast-message").findBy(text("Задача взята в работу!")).shouldBe(visible);
    }


    @Step("Принять в работу задачу «{taskName}»")
    public void takeTask(String taskName) {
        $("#my-task-showcase").shouldBe(visible, Duration.ofSeconds(15));
        $("cdp-my-tasks-menu").$(byText(taskName)).click();
        $("#my-task-showcase").$(byText(taskName)).click();
        $("h1").shouldHave(text(taskName), Duration.ofSeconds(10));
    }

    @Step("Открыть задачу по имени документа «{testId}»")
    public void openTaskByTestId(String testId) {
        $("#my-task-showcase").shouldBe(visible, Duration.ofSeconds(30));
        $x("//*[@id='my-task-showcase']//*[contains(text(), '" + testId + "')]").click();
    }

    @Step("Открыть карточку в реестре")
    public void openCardIsReestr() {
        $(".search-result-table tbody").$$("tr").shouldHave(sizeGreaterThan(0));
        AtomicReference<String> card = new AtomicReference<>("");
        card.set($(".search-result-table.table").$$("tr").get(RandomUtils.getRandomInt(3, 11))
                .$$("td").get(1).$("a").getText());
        $(byText(card.get())).click();
        step("Проверить, что карточка окрывается", () ->
                $(".card-header").shouldHave(text("Решение о проверке"), text(card.get())).should(visible));
    }

    @Step("Открыть карточку в реестре")
    public void downloadCard() {
        ElementsCollection files = $$("cdp-ex-file");
        for (SelenideElement file : files) {
            file.$(byText("Скачать"))
                    .shouldHave(attributeMatching("href", "(.*)/filestore/v1/files/(.*)?systemCode=mkapmii"));
        }
    }
}
