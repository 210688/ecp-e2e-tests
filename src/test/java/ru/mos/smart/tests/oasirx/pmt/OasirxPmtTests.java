package ru.mos.smart.tests.oasirx.pmt;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("PMT (ПМТ)")
@Tag("oasirx")
@Tag("pmt")
class OasirxPmtTests extends TestBase {

    @Test
    @DisplayName("Создание карточки ПМТ")
    void CreatingPMTcard() {
        LoginPage.openUrlWithAuthorization("", LOGIN_PMT, PASSWORD_PMT);

        step("Открытие в навигаторе ПМТ", () -> {
            $(byLinkText("ПМТ")).click();
        });

        step("Нажать Добваить ПМТ", () -> $(byLinkText("Добавить ПМТ")).click());

        step("Заполнить форму", () -> {

            //введение названия работы
            $("#description-ctr").setValue("Тест");

            //выбор цели проекта ("Стартовая площадка")
            $(".selectable-arrow").click();
            $(".value-row:nth-child(4)").click();

            //выбор округа ("ВАО")
            $("#prefect-ctr").click();
            $(byText("ВАО")).click();

            //выбор района ("Богородское")
            $("#district-ctr").click();
            $(byText("Богородское")).click();

            //введение адресного ориентира
            $("#address-ctr").setValue("Адресный ориентир");

            //заявитель (Департамент городского имущества города Москвы)
            $("#customer-ctr").click();
            $(byText("Департамент городского имущества города Москвы")).click();

            //ввести дату
            $(".ng-valid-required").setValue("27072020").click();

            //ввести номер обращения ЭДО
            $("#inNumber-ctr").setValue("0123");

            //чек-бокс "Нет файлов"
            $(".ui-chkbox-box").click();
        });

        step("Сохранить", () -> {
            $("#assign").click();
        });

        step("<b>Проверка</b>, что карточка создана", () -> {
            $("#assign").click();
        });

    }
}
