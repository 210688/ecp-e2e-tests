package ru.mos.smart.tests.mr;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.junit.OnPreprodOnly;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.enums.Registers.MR_PROGRAM_OBJ;
import static ru.mos.smart.data.enums.Registers.MR_PROGRAM_ORDER;
import static ru.mos.smart.data.enums.Sidebar.*;

@Epic("OASI")
@Feature("RAYON")
@Tags({@Tag("rayon"), @Tag("regres")})
public class MrTests extends TestBase {

    private final Faker faker = new Faker();

    @Test
    @AllureId("17085")
    @Story("PROGRAM")
    @DisplayName("Открытие реестра Поручения Мэра по программе \"Мой район\"")
    @Description("Проверить, что открывается реестр - Поручения Мэра по программе Мой район")
    void checkAttributesOfMrProgramInstructionRegistry() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage
                .goToRegister(MR_PROGRAM_ORDER);
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
            $(".search-form").$("button.btn-search").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $("#dropdown-columns-btn").shouldBe(visible);
            $(".container-btn").$(".fa.fa-filter").shouldBe(visible);
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });


    }

    @Test
    @AllureId("17087")
    @Story("PROGRAM")
    @DisplayName("В реестре Объекты по программе \"Мой район\" присутствуют заголовки карточек")
    @Description("Проверить, что в реестре присутствуют заголовки карточек")
    void checkAttributesOfMrProgramObjRegistry() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MR_PROGRAM_OBJ);
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form input").shouldBe(visible);
            $(".search-form").$("button.btn-search").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$(".fa.fa-bars").shouldBe(visible);
            $(".container-btn").$(".fa.fa-filter").shouldBe(visible);
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @AllureId("17083")
    @Story("PROGRAM")
    @DisplayName("Открытие карточки реестра Объекты по программе \"Мой район\"")
    @Description("Проверить, что открываются карточки в реестре")
    void checkAttributesOfMrProgramObjCard() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MR_PROGRAM_OBJ);

        step("Открыть любую карточку реестра", () -> {
            $(".input-lg").setValue("город Москва, Сиреневый бульвар, дом 30, строение 1").pressEnter();
            $("table").$("tbody").$(byText("город Москва, Сиреневый бульвар, дом 30, строение 1")).click();
        });

        switchTo().window(1);
        SelenideElement navTabs = $(".nav.nav-tabs");
        step("В карточке присутствуют вкладки:", () -> {
            navTabs.$(byText("Общая информация")).shouldBe(visible, Duration.ofSeconds(10)).click();
            navTabs.$(byText("Работы на объекте")).shouldBe(visible);
            navTabs.$(byText("Поручения Мэра")).shouldBe(visible);
            navTabs.$(byText("Решения штабов")).shouldBe(visible);
            navTabs.$(byText("История изменений по объекту")).shouldBe(visible);
            navTabs.$(byText("История изменений работ на объекте")).shouldBe(visible);
            navTabs.$(byText("Процесс")).shouldBe(visible);
            navTabs.$(byText("JSON объекта")).shouldBe(visible);
            navTabs.$(byText("JSON работ")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("17086")
    @Story("PROGRAM")
    @DisplayName("Переход с мини-карты в карточке объекта в Карту")
    @Description("Проверить, что происходит переход с мини-карты в карточке объекта в Карту")
    void checkSwitchToMapOnMrProgramObjCard() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage
                .goToRegister(MR_PROGRAM_OBJ);

        step("Открыть любую карточку реестра", () -> {
            $(".input-lg")
                    .setValue("Индивидуальное жилое строение по адресу: город Москва, Лыткаринская улица, дом 11А")
                    .pressEnter();
            $(byLinkText("Индивидуальное жилое строение по адресу: город Москва, Лыткаринская улица, дом 11А")).click();
        });

        switchTo().window(1);
        step("На мини-карте нажать Открыть карту", () ->
                $(".map-btn").shouldBe(visible, Duration.ofSeconds(15)).click());

        switchTo().window(2);
        step("В новой вкладке открывается Карта", () ->
                $(".mapboxgl-canvas").shouldBe(visible, Duration.ofSeconds(15)));
    }

    @Test
    @AllureId("17084")
    @Story("PROGRAM")
    @OnPreprodOnly
    @DisplayName("Запуск процесса создания объекта")
    @Description("Проверить, что запускается процесс создания объекта")
    void checkStartingObjectCreationProcess() {

        String createdObjectName = "Объект бытового обслуживания №" + faker.number().numberBetween(1, 100);

        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, OPPORTUNITIES);
        actionsPage.goToActions("Запустить процесс создания объекта");

        step("В открывшемся окне (Вы действительно хотите запустить процесс по созданию объекта?) выбрать ОК", () ->
                $(".form-group").$(".btn-primary").should(visible, Duration.ofSeconds(10)).click());

        ElementsCollection formLabel = $(".form-horizontal").$$("label");
        step("Заполнить все необходимые поля", () -> {
            formLabel.find(text("Округ")).sibling(0).should(visible, Duration.ofSeconds(10)).click();
            $(".ng-dropdown-panel-items").$$(".ng-option-label")
                    .find(text("ЗАО")).click();
            formLabel.find(text("Район")).sibling(0).click();
            $(".ng-dropdown-panel-items").$$(".ng-option-label")
                    .find(text("Дорогомилово")).click();
            formLabel.find(text("Тип объекта")).sibling(0).$(byText("Линейный, плоскостной")).click();
            formLabel.find(text("Адресный ориентир")).sibling(0).$("textarea").val("Адресный ориентир");
            formLabel.find(text("Отрасль")).sibling(0).click();
            $(".ng-dropdown-panel-items").$$(".ng-option-label")
                    .find(text("Торговля")).click();
            formLabel.find(text("Вид объекта")).sibling(0).click();
            $(".ng-dropdown-panel-items").$$(".ng-option-label")
                    .find(text("Объекты бытового обслуживания")).click();
            formLabel.find(text("Наименование объекта")).sibling(0).$("textarea").val(createdObjectName);
            formLabel.find(text("Ответственный орган исполнительной власти")).sibling(0).click();
            $(".ng-dropdown-panel-items").$$(".ng-option-label")
                    .find(text("Департамент торговли и услуг города Москвы")).click();
        });
        step("Нажать Завершить заполнение", () ->
                $(".row.form-group").$("button.btn-primary").scrollTo().click());

        $(".mail-box-header").$(byText("Все задачи")).should(visible, Duration.ofSeconds(20));
        reestrPage
                .goToRegister(MR_PROGRAM_OBJ);

        step("Проверить объект в реестре", () -> {
            $(".input-lg").setValue(createdObjectName).pressEnter();
            $("table").should(visible, Duration.ofSeconds(20))
                    .$(byText(createdObjectName)).shouldBe(visible);

        });
    }
}
