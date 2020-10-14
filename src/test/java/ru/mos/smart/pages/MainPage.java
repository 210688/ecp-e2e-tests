package ru.mos.smart.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

/**
 * Главная страница описание, что есть что.
 */

public class MainPage {
	@Step("Меню мои возможности")
	public static void actionsPage() {
		step("Возможности", () -> {
			$(By.xpath("//nav//a[@href='/main/#/app/actions']")).
					shouldBe(visible).click();
		});
}

	@Step("Выход и Вход")
	public static void logOut() {
		$(withText("Выйти")).waitUntil(visible, 10000).click();
		$(withText("Войти")).waitUntil(visible, 10000);
	}
	@Step("Реестр")
	public static void reestr() {
		$(By.xpath("//nav//a[@href='/main/#/app/catalog-registers']")).click();
	}
	@Step("Информация")
	public static void informaciya() {
		$(By.xpath("//nav//a//span[text()='Информация']")).click();
	}
}
