package ru.mos.smart.tests.oasirx.pmt;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.helpers.DriverHelper.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("Модуль \"OASIRX\"")
@Story("Создание \"карточки ПМТ\"")
@Tag("OASIRX")
@Tag("PMT")
@Tag("ECP")
class CreatingPMTcard extends TestBase {
    @Test
    @Description("Создание карточки ПМТ")
    void CreatingPMTcard() {
        step("Авторизация", () -> {
            openUrlWithAuthorization("", LOGIN_PMT, PASSWORD_PMT);
        });

        step("Открытие в навигаторе ПМТ", () -> {
            $(byLinkText("ПМТ")).click();
        });

        step("Нажать Добваить ПМТ", () -> {
             $(byLinkText("Добавить ПМТ")).click();
        });

        step("Заполнить поля", () -> {

            //введение названия работы
            $(byId("description-ctr")).setValue("Тест");

            //выбор цели проекта ("Стартовая площадка")
            $(".selectable-arrow").click();
            $(".value-row:nth-child(4)").click();

            //выбор округа ("ВАО")
            $(byId("prefect-ctr")).click();
            $(byText("ВАО")).click();

            //выбор района ("Богородское")
            $(byId("district-ctr")).click();
            $(byText("Богородское")).click();

            //введение адресного ориентира
            $(byId("address-ctr")).setValue("Адресный ориентир");

            //заявитель (Департамент городского имущества города Москвы)
            $(byId("customer-ctr")).click();
            $(byText("Департамент городского имущества города Москвы")).click();

            //ввести дату
            $(".ng-valid-required").setValue("27072020").click();

            //ввести номер обращения ЭДО
            $(byId("inNumber-ctr")).setValue("0123");

            //чек-бокс "Нет файлов"
            $(".ui-chkbox-box").click();
        });

        step("Сохранить", () -> {
            $(byId("save")).click();
        });

    }
}
