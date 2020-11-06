package ru.mos.smart.tests.feedback;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.ActionsPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.helpers.EnvironmentHelper.webUrl;
import static ru.mos.smart.pages.ActionsPage.feedback;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;


@Layer("web")
@Epic("FEEDBACK (Форма обратной связи)")
@Tag("feedback")
@Tag("all_tests")
class SupportRequest extends TestBase {

	@Test
	@Description("Данная проверка отправляет письмо в тех поддержку, " +
			"запускать на определеных средах.")
	@DisplayName("Возможность инициировать обращение в техническую поддержку.")
	void SupportRequestForward() {
		openUrlWithAuthorization("", login_test, password_test);
		ActionsPage.searchAction(feedback);

		step("Заполнение поля Тип обращения", () -> {
			$x("//input[@role='combobox']").click();
			$x("//span[contains(text(),'Технические вопросы')]").click();
		});

		step("Заполнение поля Тема обращения", () -> {
			$(".ng-select-taggable input").click();
			$(".ng-select-taggable input").val("Не заходит на главную страницу").pressEnter();
		});

		step("Заполнение поля Ссылка на страницу с ошибкой", () -> {
			$(byName("pageUrl")).setValue(webUrl);
			$x("//div/button[contains(text(),'Отправить')]").click();
		});
	}
}
