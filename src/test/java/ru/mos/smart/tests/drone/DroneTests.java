package ru.mos.smart.tests.drone;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.junit.OnPreprodOnly;
import ru.mos.smart.helpers.utils.RandomUtils;
import ru.mos.smart.tests.TestBase;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.enums.OpportunityForm.CREATE_CARD_AEROFOTO;
import static ru.mos.smart.data.enums.Registers.AEROFOTO;
import static ru.mos.smart.data.enums.Sidebar.*;
import static ru.mos.smart.utils.RandomUtils.generateRandomDate;

@Owner("Soldatov")
@Epic("OASI")
@Feature("Drone")
@Tags({@Tag("regres"), @Tag("drone"), })
public class DroneTests extends TestBase {
    private final ElementsCollection dateInput = $$("div.cdp-date-container > input");
    private final String randomDate = generateRandomDate();

    @Test
    @AllureId("17118")
    @OnPreprodOnly
    @Story("Drone")
    @Component("Госуслуги и функции")
    @DisplayName("Функциональность системы создания карточки аэросъемки")
    @Description("Проверить, что создается карточка аэросъемки")
    void createCardDrone() {

        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, OPPORTUNITIES );
        actionsPage.openToBusinessProcess(CREATE_CARD_AEROFOTO);
        switchTo().window(1);
        step("Наименование объекта", () ->
                $(byName("object")).click());
        $(byText("ст. «Стахановская»")).click();
        step("Желаемая дата съемки", () ->
                dateInput.get(0).val(randomDate));
        step("Тип съемки", () ->
                $(byName("shooting_afs")).click());
        $$(".ng-option-label").findBy(text("Пролет по заданному маршруту")).click();
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
                dateInput.get(1).val(randomDate));
        step("Номер контракта", () ->
                $(byName("constact_number")).click());
        $$(".ng-option-label").findBy(text("new/test")).click();
        step("Подрядчик", () ->
                $(byName("contractor")).click());
        $$(".ng-option-label").findBy(text("БСА Лужники")).click();
        step("Дата аэрофотосъемки", () ->
                dateInput.get(3).setValue("24.11.2022"));
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
    @AllureId("17228")
    @Story("DRONE")
    @Component("Информация")
    @DisplayName("Наличие карточек и заголовков в реестре аэрофотосъемки")
    @Description("Проверить, что корректно открывается реестр и доступность реестра аэрофотосъемки, " +
            "включая проверку порядка отображения заголовков")
    void checkingOfHeadersInRegistryDrone() {
        List<String> tableColumnList = Arrays.asList("Номер заявки", "Дата заявки", "Объект", "Адрес", "Инициатор заявки",
                "Дата съемки", "Номер контракта", "Дата контракта", "Подрядчик", "Категория", "Тип съемки", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION,  REGISTERS);
        reestrPage.goToRegister(AEROFOTO);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(AEROFOTO, tableColumnList);
    }
    @Test
    @AllureId("17229")
    @Story("DRONE")
    @Component("Информация")
    @DisplayName("Верификация присутствия заголовков таблицы и проверка наличия кнопок в карточке реестра аэрофотосъемки")
    @Description("Проверить, что корректно открывается реестр и доступность карточки реестра аэрофотосъемки")
    void checkingViewCardDrone() {
        List<String> cardHeadersList = Arrays.asList("Объект", "Информация о заявителе", "Информация о съемке", "Техническая информация");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(AEROFOTO);
        generalPage.goToRegistryCard(AEROFOTO);
        dronePage.checkButtonCard();
        dronePage.checkingCardHeaders(AEROFOTO, cardHeadersList);
    }
}