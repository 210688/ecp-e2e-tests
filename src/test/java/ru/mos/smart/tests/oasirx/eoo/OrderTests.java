package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.EooComponents;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.pages.TasksPages;
import ru.mos.smart.tests.TestBase;

import java.io.File;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.TasksPages.*;


@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("EOO (Электронные общественные обсуждения)")
@Story("PPT test")
@Tag("order")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTests extends TestBase {
	@Test
	@Order(1)
	@DisplayName("01. Добавление ЭОО")
	void addEoo() {
	}

	@Test
	@Order(2)
	@DisplayName("02. Определение разработчика материалов")
	void opredRazrabMaterial() {
	}

	@Test
	@Order(3)
	@DisplayName("03. Подготовка материалов для ЭОО")
	void materialInEoo() {
	}

	@Test
	@Order(4)
	@DisplayName("04. Внесение информации о проведении")
	void infoOProvedenii() {
	}

	@Test
	@Order(5)
	@DisplayName("05. Проверка материалов для ЭОО")
	void proverkaMaterialaEoo() {
	}

	@Test
	@Order(6)
	@DisplayName("06. Подготовка решения руководителем УГР ВАО")
	void podgotovkaResheniyaUgrVa0() {
	}

	@Test
	@Order(7)
	@DisplayName("07. Подготовка решения руководителем УОС")
	void podgotovkaReshenyaUos() {
	}

	@Test
	@Order(8)
	@DisplayName("08. Согласование материалов для ЭОО (начальник управления)")
	void soglasovMaterialEooNach() {
	}

	@Test
	@Order(9)
	@DisplayName("09. Согласование материалов для ЭОО зам. председателя УППТ")
	void soglasovMaterialZamPred() {
	}

	@Test
	@Order(10)
	@DisplayName("10. Согласование материалов зам. председателя ЭОО")
	void soglasovMaterialZamPredEoo() {
	}
}