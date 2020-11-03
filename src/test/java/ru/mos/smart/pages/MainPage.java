package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

/**
 * Главная страница описание, что есть что.
 */

public class MainPage {

	@Step("Меню мои возможности")
	public static void actionsPage() {
		step("Возможности", () -> {
			$x("//nav//a[@href='/main/#/app/actions']")
					.shouldBe(visible).click();
		});
	}

	@Step("Выход и Вход")
	public static void logOut() {
		$(withText("Выйти")).waitUntil(visible, 10000).click();
		$(withText("Войти")).waitUntil(visible, 10000);
	}

	@Step("Реестр")
	public static void InformaciyaAndReest() { // Переход в реестры
		$x("//span[contains(text(), 'Информация')]").click();
		$x("//a[@href='/main/#/app/catalog-registers']").click();
	}
}