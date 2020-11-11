package ru.mos.smart.tests.oasirx.pmt;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("PMT (ПМТ)")
class SearchingPmtCardTests extends TestBase {

	@Test
	@DisplayName("Поиск ПМТ по названию")
	@Tag("allModules")
	@Tag("prod")
	void searchingPmtCardByName() {
		LoginPage.openUrlWithAuthorization("", login_pmt, pasword_pmt);

		step("Открытие в навигаторе ПМТ", () -> $x("//span[text()='ПМТ']").click());


		step("Перейти во вкладку Все ПМТ", () -> $("#tab2-link").click());

		step("Проверка, что появилась строчка Межевание территорий", () -> $
				(byText("Межевание территорий")).shouldBe(visible));
	}
}
