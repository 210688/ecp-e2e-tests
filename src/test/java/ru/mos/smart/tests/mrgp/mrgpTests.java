package ru.mos.smart.tests.mrgp;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("MRGP")
@Tag("mrgp")
@Tag("all_tests")
@Tag("prod_tests")
public class mrgpTests extends TestBase {
	@Test
	@DisplayName("Проверка открытия реестра")
	void openReestr() {
		LoginPage.openUrlWithAuthorization("", login_test, password_test);
		MainPage.InformaciyaAndReestr();

		step("Поиск в реестре", () -> $(byName("candidateSearchValue"))
				.setValue("Перечень программ").pressEnter());

		step("Открытие реестра Перечень программ", () -> {
			$x("//span[contains(text(),'Перечень программ')]").click();
			$x("//span[contains(text(),'Государственная программа города Москвы «Экономиче')]").click();
			$x("//a[contains(text(),'Мероприятия')]").click();
			$(byText("Мероприятия")).shouldBe(visible);
		});
	}
}