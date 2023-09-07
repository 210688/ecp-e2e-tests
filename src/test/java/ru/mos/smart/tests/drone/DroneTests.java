package ru.mos.smart.tests.drone;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.utils.RandomUtils;
import ru.mos.smart.tests.TestBase;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.RegisterObjectTypeDrone.AEROFOTO;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTER;

@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Drone (Аэрофотосъемка)")
@Owner("Soldatov")
@Layer("web")
public class DroneTests extends TestBase {
    private final String createCard = "/drone/#/app/drone/videoUpload";
    private final ElementsCollection calendars = $$("div.input-group.date.ng-scope > input");
    private final String aerofoto = AEROFOTO.getDroneDescription();

    @Test
    @DisplayName("Создать карточку аэросъемки")
    @Tags({@Tag("drone"), @Tag("predprod"), @Tag("createCardDrone")})
    void createCardDrone() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        actionsPage.openToBusinessProcess("Создать карточку аэросъемки");
        step("Наименование объекта", () ->
                $(byName("object")).click());
        $(byText("ст. «Стахановская»")).click();
        step("Желаемая дата съемки", () ->
                calendars.get(0).setValue("21.12.2023"));
        step("Тип съемки", () ->
                $(byName("shooting_afs")).click());
        $$(".ng-option-label").findBy(text("Фото")).click();
        step("Требования к съемке", () ->
                $(byName("requirements")).setValue("Тестовый объект"));
        step("Приоритет", () ->
                $(byName("shooting_type")).click());
        $$(".ng-option-label").findBy(text("Средний")).click();
        step("Категория материалов", () ->
                $(byName("materialsCategory")).click());
        $$(".ng-option-label").findBy(text("Для общего доступа")).click();
        step("Организация-инициатор заявки", () ->
                $(byName("initiator_org")).click());
        $$(".ng-option-label").findBy(text("ОАО ГКЗ")).click();
        step("Номер заявки", () ->
                $(byName("droneRequest.number")).val(RandomUtils.getRandomInt(5)));
        step("Дата заявки", () ->
                calendars.get(1).setValue("24.11.2022"));
        step("Номер контракта", () ->
                $(byName("constact_number")).click());
        $$(".ng-option-label").findBy(text("new/test")).click();
        step("Подрядчик", () ->
                $(byName("contractor")).click());
        $$(".ng-option-label").findBy(text("БСА Лужники")).click();
        step("Дата аэрофотосъемки", () ->
                calendars.get(3).setValue("24.11.2022"));
        $(byName("point")).val("POINT(42 22)");
        $(byName("description")).val("Тестовая заявка для тестирования");
        step("Загрузить материалы аэрофотосъемки", () ->
                $(byName("file")).uploadFile(new File("src/test/resources/drone/video.mp4")));
        step("Загрузить лог файла полета дрона", () ->
                $(byName("logFile")).uploadFile(new File("src/test/resources/drone/log.txt")));
        step("Нажать на кнопку Внести данные", () ->
                $("button[type='submit']").click());
        $("#sidebar_system-name").shouldBe(visible);
    }

    @Test
    @AllureId("12348")
    @Description("Наличие карточек в реестре данные аэрофотосъемки")
    @DisplayName("В реестре данные аэрофотосъемки присутствуют карточки")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkCardsInReestrDrone() {
        List<String> tableColumnList = Arrays.asList("Номер заявки", "Дата заявки", "Объект", "Адрес", "Инициатор заявки",
                "Дата съемки", "Номер контракта", "Дата контракта", "Подрядчик", "Категория", "Тип съемки", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        reestrPage.goToRegister(aerofoto);
        dronePage.checkFilter(aerofoto, tableColumnList );
    }

    @Test
    @AllureId("12350")
    @Description("Просмотреть карточку аэросъемки")
    @DisplayName("В карточке присутствуют данные")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void viewCartDrone() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        reestrPage.goToRegister(aerofoto);
        dronePage.goToCardDrone();
    }
}