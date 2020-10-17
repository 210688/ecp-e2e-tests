package ru.mos.smart.tests.oasirx.eoo;

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

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.TasksPages.*;


@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("EOO (Электронные общественные обсуждения)")
@Story("PPT_")
@Tag("oasirx") @Tag("eoo")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EooTestPptTests extends TestBase {
	@Test
	@Order(1)
	@DisplayName("1. Добавление ЭОО")
	void addEoo() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		step("Добавить ЭОО", () -> {
			$(byLinkText("Добавить ЭОО")).click();
			$("#description-ctr").setValue("Тестовый релиз"); // Ввод надписи в Описание проекта
			$("#prefect-ctr input").setValue("ВАО").pressEnter(); // Ввод округа
			$("#district-ctr input").setValue("Вешняки").pressEnter(); // Район
			$("#source_type-ctr input").setValue("ППТ").pressEnter(); // Тип исходного проекта
			$("#assign").click();
		});
	}

	@Test
	@Order(2)
	@DisplayName("2. Определить разработчика материалов")
	void opredRazrabMaterial() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		EooComponents.inTaskEoo();
		TasksPages.clickTask(task1);
		EooComponents.buttonTakeTask();
		step("Определить разработчика материалов", () -> {
			$("#responsibleExecutor_code-ctr input").setValue("УППТ").pressEnter(); // Ответственное управление
			$("#address-ctr").setValue("Московский бульвар"); // Адресный ориентир
			$("#responsibleExecutor_login-ctr input").setValue("Электронные Общественные Обсуждения").pressEnter(); //Исполнитель
			$("#projectType-ctr input").setValue("Конкурсный").pressEnter(); // Тип проекта
			$("#developer_code-ctr input").setValue("Генплан ГАУ «Научно-исследовательский " +
					"и проектный институт Генерального плана города Москвы»").pressEnter(); // Разработчик материалов
			EooComponents.saveButtonNextTask();
		});
	}

	@Test
	@Order(3)
	@DisplayName("3. Подготовка материалов для ЭОО")
	void materialInEoo() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		EooComponents.inTaskEoo();
		TasksPages.clickTask(task2);
		EooComponents.buttonTakeTask();
		step("Подготовка материалов для ЭОО", () -> {
			sleep(5000);
			$("input[type=file]", 0).uploadFile(new File("src/test/resources/images/423438.jpg"));
			sleep(5000);
			$("input[type=file]", 3).uploadFile(new File("src/test/resources/images/13446.doc")); //Текст для размещения на АГ
			sleep(5000);
			$("input[type=file]", 4).uploadFile(new File("src/test/resources/images/456459.jpg")); //Границы проведения ЭОО
			sleep(5000);
			$("input[type=file]", 5).uploadFile(new File("src/test/resources/images/56457.pdf")); //Утверждаемая часть
			sleep(5000);
			EooComponents.saveButtonNextTask();
		});
	}

	@Test
	@Order(4)
	@DisplayName("4. Внесение информации о проведении")
	void infoOProvedenii() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		EooComponents.inTaskEoo();
		TasksPages.clickTask(task3);
		EooComponents.buttonTakeTask();
		step("Внесение информации о проведении", () -> {
			$(".ng-input input").setValue("Не более одного месяца").pressEnter();
			$("#notification_date-ctr input").setValue("15.10.2020");
			$("#calculateDate").click();
			EooComponents.saveButtonNextTask();
		});
	}

	@Test
	@Order(5)
	@DisplayName("5. Проверка материалов для ЭОО")
	void proverkaMaterialaEoo() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		EooComponents.inTaskEoo();
		TasksPages.clickTask(task4);
		//EooComponents.buttonTakeTask();
		step("Проверка материалов для ЭОО", () -> {
			$("#docAgreeContent_confirmRounds_sectorChiefCheckConfirm-ctr-wrapper .ui-chkbox-icon").click();
			$("#docAgreeContent_confirmRounds_zamChiefCheckConfirm-ctr-wrapper .ui-chkbox-icon").click();
			EooComponents.saveButtonNextTask();
		});
	}

	@Test
	@Order(6)
	@DisplayName("6. Подготовка решения руководителем УГР ВАО")
	void podgotovkaResheniyaUgrVa0() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		EooComponents.inTaskEoo();
		EooComponents.giveOutPrava(task5);
		TasksPages.clickTask(task5);
		step("Подготовка решения руководителем УГР ВАО", () -> {
			$("#detailView-ctr .right").click();
			$("#executeBy-ctr .ui-radiobutton-label").click();
			$("#approved-ctr .right").click();
			$("#save").click();
			EooComponents.saveButtonNextTask();
		});
	}

	@Test
	@Order(7)
	@DisplayName("7. Подготовка решения руководителем УОС")
	void podgotovkaReshenyaUos() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		EooComponents.inTaskEoo();
		EooComponents.giveOutPrava(task6);
		TasksPages.clickTask(task6);
		step("Подготовка решения руководителем УОС", () -> {
			$("#detailView-ctr .right").click();
			$("#executeBy-ctr .ui-radiobutton-label").click();
			$("#approved-ctr .right").click();
			$("#save").click();
			EooComponents.saveButtonNextTask();
		});
	}

	@Test
	@Order(8)
	@DisplayName("8. Согласовать материалы для ЭОО (начальник управления)")
	void soglasovMaterialEooNach() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		EooComponents.inTaskEoo();
		EooComponents.giveOutPrava(task7);
		TasksPages.clickTask(task7);
		step("Подготовка решения руководителем УОС", () -> {
			$("#detailView-ctr .right").click();
			EooComponents.saveButtonNextSoglas();
		});
	}

	@Test
	@Order(9)
	@DisplayName("9. Согласование материалов для ЭОО зам. председателя УППТ")
	void soglasovMaterialZamPred() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		EooComponents.inTaskEoo();
		EooComponents.giveOutPrava(task8);
		TasksPages.clickTask(task8);
		step("Согласование материалов для ЭОО зам. председателя УППТ", () -> {
			$("#detailView-ctr .right").click();
			EooComponents.saveButtonNextSoglas();
		});
	}

	@Test
	@Order(10)
	@DisplayName("10. Согласование материалов зам. председателя ЭОО")
	void soglasovMaterialZamPredEoo() {
		LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
		MainPage.dobavitEoo();
		EooComponents.inTaskEoo();
		EooComponents.giveOutPrava(task9);
		TasksPages.clickTask(task9);
		step("Согласование материалов зам. председателя ЭОО", () -> {
			EooComponents.saveButtonNextSoglas();
		});
	}
}