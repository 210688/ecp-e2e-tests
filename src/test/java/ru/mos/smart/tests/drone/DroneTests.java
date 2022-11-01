package ru.mos.smart.tests.drone;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;
import ru.mos.smart.utils.RandomUtils;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class DroneTests extends TestBase {
    private final String createCard = "/drone/#/app/drone/videoUpload";

    @Test
    @AllureId("7683")
    @DisplayName("Создать карточку аэросъемки")
    @Epic("DRONE (Аэрофотосъемка)")
    @Feature("Автотесты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("drone"), @Tag("createCartDrone")})
    void createCartDrone() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        ElementsCollection calendars = $$("div.input-group.date.ng-scope > input");
        ElementsCollection materials = $$(".ng-option-label");
        ElementsCollection shooting = $$(".ng-option-label");

        navigatorPage
                .goToActions();
        step("Выбрать Создать карточку аэросъемки", () ->
                open(createCard));
        step("Наименование объекта", () ->
                $(byName("object")).click());
        $(byText("ст. «Стахановская»")).click();
        step("Желаемая дата съемки", () ->
                calendars.get(0).setValue("21.12.2022"));
        step("Тип съемки", () ->
                $(byName("shooting_afs")).click());
        $$(".ng-option-label").findBy(text("Фото")).click();
        step("Требования к съемке", () ->
                $(byName("requirements")).setValue("Тестовый обЬект"));
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
    @AllureId("7680")
    @DisplayName("В реестре данные аэрофотосъемки присутствуют данные")
    @Epic("DRONE (Аэрофотосъемка)")
    @Feature("Автотесты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("drone")})
    void openReestrDrone() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Данные аэрофотосъемки");
        step("Проверить, что в реестре Данные аэрофотосъемки есть карточки", () -> {
            $(byText("Данные аэрофотосъемки")).shouldBe(visible);
            $(".search-result-table tbody").$$("tr").shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @AllureId("7680")
    @DisplayName("Просмотреть карточку аэросъемки")
    @Epic("DRONE (Аэрофотосъемка)")
    @Feature("Автотесты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("drone")})
    void viewCartDrone() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Данные аэрофотосъемки");

        AtomicReference<String> card = new AtomicReference<>("");

        step("Получаем номер существующей карточки", () -> {
            $(".search-result-table tbody").$$("tr").shouldHave(sizeGreaterThan(0));
            card.set($(".search-result-table").$("a").getText());
        });
        step("Открыть карточку аэрофотосъемки", () ->
                $(byText(card.get())).click());
        step("Проверить, что карточка окрывается", () ->
                $(byText("Технический номер заявки " + card.get())).should(visible));
    }
}