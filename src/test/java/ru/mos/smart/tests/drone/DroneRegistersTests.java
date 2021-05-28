package ru.mos.smart.tests.drone;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.pages.ReestrPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("DRONE (Аэрофотосъемка)")
@Feature("Реестр данные аэрофотосъемки")
public class DroneRegistersTests extends TestBase {

    @Test
    @AllureId("2075")
    @DisplayName("Открытие реестра Данные аэрофотосъемки")
    @Tags({@Tag("drone"), @Tag("predprod"), @Tag("prod")})
    void openReestrDrone() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginDrone(), webConfig().passwordDrone());
        NavigatorPage.reestrPage();
        ReestrPage.Drone();

        step("Проверить, что открывается  реестр Данные аэрофотосъемки", () -> {
            $(byText("Данные аэрофотосъемки")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("2076")
    @DisplayName("Переход в карточку из реестра")
    @Tags({@Tag("drone"), @Tag("predprod"), @Tag("prod")})
    void openCardDrone() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginDrone(), webConfig().passwordDrone());
        NavigatorPage.reestrPage();
        ReestrPage.Drone();

        step("Открыть карточку реестра", () -> {
            $((".form-control.input-lg")).setValue("2000000933_S").pressEnter();
            $x("//a/div[contains(text(),'2000000933_S')]").click();
        });

        step("Проверить,что карточка открылась", () -> {
            $x("//div/h1[contains(text(),'Технический номер заявки 2000000933_S')]")
                    .shouldBe(visible);
        });
    }

    @Test
    @AllureId("2079")
    @DisplayName("Создать карточку аэросъемки")
    @Tag("DRONE_TRACK")
    @Epic("DRONE (Аэрофотосъемка)")
    @Feature("Работа с карточкой аэросъёмки")
    void addCartDrone() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginDrone(), webConfig().passwordDrone());
        NavigatorPage.actionsPage();
        step("Выбрать Создать карточку аэросъемки", () ->
                $(byText(" Создать карточку аэросъемки ")).click());
        $(byName("object")).click();
        $(byText("Жилой дом_ул.Шереметьевская, вл.13, к.1")).click();

        step("Заполнить поля формы:", () -> {
            step("Наименование объекта - выбрать из выпадающего списка или добавить новый объект облета");
            step("Адресный ориентир - заполняется автоматически");
            step("Категория объекта - заполняется автоматически");
            step("Желаемая дата съемки - выбрать дату");
            step("Тип съемки - выбрать из выпадающего списка");
            step("Требования к съемке - указать требования");
            step("Приоритет - выбрать из выпадающего списка");
            step("Категория материалов - выбрать из выпадающего списка");
            step("Организация-инициатор заявки - выбрать из выпадающего списка");
            step("Инициатор заявки - заполняется автоматически");
            step("Номер заявки - ввести номер");
            step("Дата заявки - выбрать дату");
            step("Номер контракта - выбрать из выпадающего списка (0001)");
            step("Дата заключения контракта - заполняется автоматически после выбора номера контракта (16.04.2020)");
            step("Подрядчик - выбрать из выпадающего списка");
            step("Дата аэрофотосъемки - выбрать дату");
            step("Координаты аэрофотосъемки (точка) - заполнить по шаблону POINT(широта долгота)");
            step("Материалы аэрофотосъемки - загрузить материалы: файлы формата mp4, zip При загрузке данных других форматов будет выходить сообщение об ошибке.");
            step("Прикрепить лог файл полета дрона");
        });

        step("Нажать на кнопку Внести данные");
    }


    @Test
    @AllureId("2080")
    @DisplayName("Просмотреть карточку аэросъемки")
    @Tag("DRONE_TRACK")
    @Epic("DRONE (Аэрофотосъемка)")
    @Feature("Работа с карточкой аэросъёмки")
    void viewCartDrone() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginDrone(), webConfig().passwordDrone());
        NavigatorPage.reestrPage();
        ReestrPage.Drone();
        step("Открыть карточку аэрофотосъемки", () ->
                $(byText("2000000969_S")).click());
        step("Проверить, что карточка окрывается", () ->
                $(byText("Технический номер заявки 2000000969_S")).should(visible));
    }



}
