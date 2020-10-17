package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class TasksPages {
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
		$(byText(task)).parent().parent().$(byTitle("Перейти к задаче") ).click();
	}


	@Step("Выбор задачи")
	public static void searchTask(String tasksName) {
		$(By.xpath("//a[@href='/main/#/app/tasks']")) //Задачи
				.waitUntil(visible, 5000).click();

		step("Ввод наименования задачи в поиске", () -> {
			$(By.xpath("//input[@placeholder='Найти задачу']"))
					.waitUntil(visible, 5000).shouldBe(visible).setValue(tasksName).pressEnter();
		});

		step("Выбор задачи в списке {taskName}", ()-> {
			$(By.xpath("//span[contains(@class,'task-title') and contains(.,'" + tasksName + "')]")).click();
		});
	}
}
