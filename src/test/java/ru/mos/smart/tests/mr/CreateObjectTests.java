package ru.mos.smart.tests.mr;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selenide.$;


@Epic("Платформа ЕЦП")
@Feature("Модуль \"Мой район\"")
@Story("Проверка работы функционала \"Создание объектов\"")
@Tag("MR")
@Tag("ECP")
class CreateObjectTests extends TestBase {
//
//    /*
//    1 Перейти на главную страницу
//    2 Перейти в раздел «Возможности»
//    3 Выбрать пункт Запустить процесс создания объекта и в открывшемся окне нажать ОК
//    4 Открытие формы Заполнить форму создания объекта
//    */
//    @Test
//    @Issue("KRLB-1")
//    @DisplayName("Проверка открытия формы \"создания объекта\" ")
//    void formCanBeOpened() {
//        openUrlWithAuthorization("/main/#/app/actions", "Открытие страницы \"Возможности\"");
//
//        actionsPage.selectOption("Запустить процесс создания объекта");
//
//        createObjectPage.verifyCreateObjectFormIsOpened();
//    }
//
//    /*
//    1 В форме "Создания объекта" в  поле «Тип элемента» выбрать значение Линейный, плоскостной
//    или Здание, строение, помещение
//    2 Не заполнять обязательные поля, помеченные *.
//    3 Нажать на кнопку «Завершить заполнение»
//    4 Появление уведомления «Не заполнены обязательные поля!»
//    */
//    @Test
//    @Disabled("Пока что отключено")
//    @DisplayName("Проверка всех основных полей  для формы \"создания объекта\"")
//    void checkFields() {
//        openUrlWithAuthorization("/main/#/app/actions", "Открытие страницы \"Возможности\"");
//
//        actionsPage.selectOption("Запустить процесс создания объекта");
//
//        $(byText("Линейный, плоскостной")).parent().$("ins").click();
//        $(byText("Завершить заполнение")).click();
//        $(byText("Не заполнены обязательные поля!")).shouldBe(visible);
//    }

}

