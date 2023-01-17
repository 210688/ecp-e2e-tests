package ru.mos.smart.tests.rinrif;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.RegisterObjectType.*;

@Layer("web")
@Epic("Автотесты")
public class RinRifReestrTests extends TestBase {

    @Test
    @Owner("Soldatov")
    @DisplayName("Проверить переход в реестр Акты проверок")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterAktsProverok() {
        List<String> tableColumnList = Arrays.asList("Номер акта", "Дата акта", "Место проведения проверки", "Результат проверки", "Специалист УН", "ЕРКНМ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(AKTS_PROVEROK);
        reestrPage.searchField(AKTS_PROVEROK);
        reestrPage.columnsAndFilterButton(AKTS_PROVEROK);
        rinrifPage.checkFilter(AKTS_PROVEROK, tableColumnList);
        //rinrifPage.tableActFilter();
        reestrPage.presentDataInTable();
    }

/*    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkRes() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        //ElementsCollection st = (ElementsCollection) $$(".jsoneditor-values tr").get(13);
        open("/rinrif/rv/#/app/rv/card/6f88fd83-fa15-4f39-b920-fbc427061393/json");
        $$(".jsoneditor-values tr").get(13).setValue("Проверяю");
        $x("//button[contains(text(),'Сохранить измененный документ')]").click();*/


        //System.out.println("statusCode:" + statusCode);

    @Test
    @Owner("Soldatov")
    @DisplayName("Проверить переход в реестр Все объекты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkReestrVseObjects() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все объекты");
        reestrPage.searchField("Все объекты");
        reestrPage.columnsAndFilterButton("Все объекты");
        rinrifPage.tableFilterAllObjects();
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("Soldatov")
    @DisplayName("Проверить переход в карточку из реестра Все объекты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardAllObjects() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все объекты");
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Паспорт");
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Все объекты сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkReestrAllObjectsSnos() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все объекты сноса");
        reestrPage.searchField("Все объекты сноса");
        reestrPage.columnsAndFilterButton("Все объекты сноса");
        rinrifPage.filterTableAllObjectsSnos();
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в карточку из реестра Все объекты сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardAllObjectsSnos() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все объекты");
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Паспорт");
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Все организации")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkReestrAllOrganizations() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все организации");
        reestrPage.searchField("Все организации");
        reestrPage.columnsAndFilterButton("Все организации");
        rinrifPage.filterTableAllOrganizations();
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в карточку из реестра Все организации")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardAllOrganizations() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все организации");
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Общая информация");
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Все решения о проверке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterAllInspectionDecisions() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все решения о проверке");
        reestrPage.searchField("Все решения о проверке");
        reestrPage.columnsAndFilterButton("Все решения о проверке");
        rinrifPage.checkFilterCardAllInspectionDecisions();
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в карточку из реестра Все решения о проверке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardReestrAllInspectionDecisions() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все решения о проверке");
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Общие сведения");
        //infoZu
    }

    //TODO $(".table_hover").$$("tr").get(4).$$("td").get(1).$("mdm-runtime.ng-star-inserted")
//+ card.get())
    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Нарушения")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterViolations() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Нарушения");
        reestrPage.searchField("Нарушения");
        reestrPage.columnsAndFilterButton("Нарушения");
        rinrifPage.checkFilterCardViolations();
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Постановления")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterPostanovleniya() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Постановления");
        reestrPage.searchField("Постановления");
        reestrPage.columnsAndFilterButton("Постановления");
        rinrifPage.checkFilterCardResolutions();
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Протоколы")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkReestrProtokoli() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Протоколы");
        reestrPage.searchField("Протоколы");
        reestrPage.columnsAndFilterButton("Протоколы");
        $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                "Дата протокола",
                "Место совершения нарушения",
                "Статья КОАП РФ",
                "Проверяемая организация",
                "Специалист УН. ФИО"
        ));
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр ТЗ лаборатории")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkReestrTzLabaratorii() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("ТЗ лаборатории");
        reestrPage.searchField("ТЗ лаборатории");
        reestrPage.columnsAndFilterButton("ТЗ лаборатории");
        $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                "Дата проверки ЦЭИИС",
                "Срок исполнения ТЗ",
                "Состав работ",
                "Состав работ утвержден ГБУ"
        ));
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Уведомления о завершении сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkReestrUvedomleniyaOzaversheniiSnosa() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Уведомления о завершении сноса");
        reestrPage.searchField("Уведомления о завершении сноса");
        reestrPage.columnsAndFilterButton("Уведомления о завершении сноса");
        rinrifPage.checkFilterCardUvedomleniyaOzaversheniiSnosa();
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в карточку из реестра Уведомления о завершении сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardReestrUvedomleniyaOzaversheniiSnosa() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Уведомления о завершении сноса");
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Уведомление о планируемом сносе"));
        //infoZu
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Уведомления о планируемом сносе")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkReestrUvedomleniyaOplaniruemomSnose() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Уведомления о планируемом сносе");
        reestrPage.searchField("Уведомления о планируемом сносе");
        reestrPage.columnsAndFilterButton("Уведомления о планируемом сносе");
        rinrifPage.checkFilterCardUvedomleniyaOzaversheniiSnosa();
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в карточку из реестра Уведомления о планируемом сносе")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardReestrUvedomleniyaOplaniruemomSnose() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Уведомления о планируемом сносе");
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Прием уведомления о планируемом сносе объекта капитального строительства"));
        //infoZu
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterEnteringObjects() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Внесение изменений в разрешения ввод объекта в эксплуатацию");
        reestrPage.searchField("Внесение изменений в разрешения ввод объекта в эксплуатацию");
        reestrPage.columnsAndFilterButton("Внесение изменений в разрешения ввод объекта в эксплуатацию");
        rinrifPage.checkFilterCardUVneseniyaa();
        reestrPage.presentDataInTable();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в карточку из реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardRegisterEnteringObject() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Внесение изменений в разрешения ввод объекта в эксплуатацию");
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Общая информация");
        rinrifPage.card();
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Внесение изменений в разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterChangeConstructionBuilding() {
        List<String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        reestrPage.searchField(CHANGE_CONSTRUCTION_BUILDING);
        reestrPage.columnsAndFilterButton(CHANGE_CONSTRUCTION_BUILDING);
        rinrifPage.checkFilter(CHANGE_CONSTRUCTION_BUILDING, tableColumnList);
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в карточку из реестра Внесение изменений в разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardRegisterConstructionLicense() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Внесение изменений в разрешение на строительство"));
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Разрешения на ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterObjectOperation() {
        List<String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(OBJECT_OPERATION);
        reestrPage.searchField(OBJECT_OPERATION);
        reestrPage.columnsAndFilterButton(OBJECT_OPERATION);
        rinrifPage.checkFilter(OBJECT_OPERATION, tableColumnList);
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в карточку из реестра Разрешения на ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardRegisterObjectOperation() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(OBJECT_OPERATION);
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Выдача разрешения на ввод объекта в эксплуатацию"));
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в реестр Разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif"), @Tag("regressions")})
    void goToBuildingPermitRegister() {
        List<String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(BUILDING_PERMIT_REGISTER);
        reestrPage.searchField(BUILDING_PERMIT_REGISTER);
        reestrPage.columnsAndFilterButton(BUILDING_PERMIT_REGISTER);
        rinrifPage.checkFilter(BUILDING_PERMIT_REGISTER, tableColumnList);
    }

    @Test
    @Owner("soldatovks")
    @DisplayName("Проверить переход в карточку из реестра Разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardBuildingPermitRegister() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(BUILDING_PERMIT_REGISTER);
        rinrifPage.goToCard();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Выдача разрешения на строительство для объектов капитального строительства"));
    }
}