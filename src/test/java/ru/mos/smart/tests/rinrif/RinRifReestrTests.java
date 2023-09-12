package ru.mos.smart.tests.rinrif;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.Registers.*;

@Owner("Soldatov")
@Layer("web")
@Epic("ИАИС РИН")
@Feature("RINRIF")

public class RinRifReestrTests extends TestBase {

    @Test
    @Story("nadzor")
    @AllureId("12316")
    @DisplayName("Проверка наличия данных и перехода в реестр Акты проверок")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterAktsProverok() {
        List<java.lang.String> columnNames = Arrays.asList("Номер акта", "Дата акта", "Место проведения проверки",
                "Результат проверки", "Специалист УН", "ЕРКНМ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(AKTS_PROVEROK);
        reestrPage.searchField();
        generalPage.checkTableFilter(AKTS_PROVEROK, columnNames);
    }

    @Test
    @Story("nadzor")
    @AllureId("14038")
    //@RepeatedIfExceptionsTest(repeats = 3, exceptions = NoSuchElementException.class)
    @DisplayName("Проверка наличия данных и перехода в реестр Все объекты")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterVseObjects() {
        List<java.lang.String> columnNames = Arrays.asList("Источник финансирования", "Номер дела", "Объект", "Застройщик ", "Почтовый адрес",
                "Дата начала строительства", "Дата окончания строительства", "Состояние", "Строительный надзор");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(ALL_OBJECTS);
        reestrPage.searchField();
        generalPage.checkTableFilter(ALL_OBJECTS, columnNames);
    }

    @Test
    @Story("nadzor")
    @AllureId("14037")
    @DisplayName("Проверка наличия данных и перехода в реестр Все объекты сноса")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterAllObjectsSnos() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Объект", "Кадастровый номер ЗУ", "Кадастровый номер здания");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(ALL_OBJECTS_SNOS);
        reestrPage.searchField();
        generalPage.checkTableFilter(ALL_OBJECTS_SNOS, columnNames);
    }

    @Test
    @Story("nadzor")
    @AllureId("14039")
    @DisplayName("Проверка наличия данных и перехода в реестр Все организации")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterAllOrganizations() {
        List<java.lang.String> columnNames = Arrays.asList("Полное наименование организации / Руководитель", "ИНН", "ОГРН /СНИЛС / Паспорт",
                "Юр. адрес / Факт. адрес", "Почтовый адрес");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(All_ORGANIZATION);
        reestrPage.searchField();
        generalPage.checkTableFilter(ALL_OBJECTS_SNOS, columnNames);
    }

    @Test
    @Story("nadzor")
    @AllureId("12315")
    @DisplayName("Проверка наличия данных и перехода в реестр Все решения о проверке")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterAllInspectionDecisions() {
        List<java.lang.String> columnNames = Arrays.asList("Номер", "Дата", "Объект", "Проверяемая организация", "Вид проверки", "Основание для проверки",
                "Период проведения", "Ответственный", "Статус", "ЕРКНМ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(All_INSPECTION_DECISIONS);
        reestrPage.searchField();
        generalPage.checkTableFilter(All_INSPECTION_DECISIONS, columnNames);
    }

    @Test
    @Story("nadzor")
    @AllureId("12330")
    @DisplayName("Проверка наличия данных и перехода в реестр  Нарушения")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterViolations() {
        List<java.lang.String> columnNames = Arrays.asList("Номер нарушения", "Дата нарушения", "Наименование работ", "Специалист УН. ФИО");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(NARUSHENIYA);
        reestrPage.searchField();
        generalPage.checkTableFilter(NARUSHENIYA, columnNames);

    }

    @Test
    @Story("nadzor")
    @AllureId("12332")
    @DisplayName("Проверка наличия данных и перехода в реестр Постановления")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterPostanovleniya() {
        List<java.lang.String> columnNames = Arrays.asList("Постановление", "Нарушитель", "Штраф", "Срок оплаты", "УН", "Подписал", "Оплачено (руб.)",
                "Долг по оплате (руб.)");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(POSTANOVLENIYA);
        reestrPage.searchField();
        generalPage.checkTableFilter(POSTANOVLENIYA, columnNames); //TODO: спросить про проверку данных в таблице
    }

    @Test
    @Story("nadzor")
    @AllureId("14040")
    @DisplayName("Проверка наличия данных и перехода в реестр Протоколы")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterProtokols() {
        List<java.lang.String> columnNames = Arrays.asList("Дата протокола", "Место совершения нарушения", "Статья КОАП РФ", "Проверяемая организация",
                "Специалист УН. ФИО");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(PROTOKOLS);
        reestrPage.searchField();
        generalPage.checkTableFilter(PROTOKOLS, columnNames);
    }

    @Test
    @Story("nadzor")
    @AllureId("14041")
    @DisplayName("Проверка наличия данных и перехода в реестр ТЗ лаборатории")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterTzLabaratorii() {
        List<java.lang.String> columnNames = Arrays.asList("Дата проверки ЦЭИИС", "Срок исполнения ТЗ", "Состав работ", "Состав работ утвержден ГБУ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(TZ_LABORATORIES);
        reestrPage.searchField();
        generalPage.checkTableFilter(TZ_LABORATORIES, columnNames);

    }

    @Test
    @Story("snos")
    @AllureId("14042")
    @DisplayName("Проверка наличия данных и перехода в реестр Уведомления о завершении сноса")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterUvedomleniyaOzaversheniiSnosa() {
        List<java.lang.String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата", "Заявитель",
                "Исполнитель", "Данные ПГУ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(DEMOLITIONS);
        reestrPage.searchField();
        generalPage.checkTableFilter(DEMOLITIONS, columnNames);
    }

    @Test
    @Story("snos")
    @AllureId("14043")
    @DisplayName("Проверка наличия данных и перехода в реестр Уведомления о планируемом сносе")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterUvedomleniyaOplaniruemomSnose() {
        List<java.lang.String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата",
                "Заявитель", "Исполнитель", "Данные ПГУ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        reestrPage.searchField();
        generalPage.checkTableFilter(PLANNED_DEMOLITION_NOTICES, columnNames);
    }

    @Test
    @Story("rv")
    @AllureId("12328")
    @DisplayName("Проверка наличия данных и перехода в реестр Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterEnteringObjects() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Заявление", "Рег. дата", "Плановая дата",
                "Объект", "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        reestrPage.searchField();
        generalPage.checkTableFilter(MODIFICATION_OBJECT_OPERATION, columnNames);
    }

    @Test
    @Story("rs")
    @AllureId("12319")
    @DisplayName("Проверка наличия данных и перехода в реестр Внесение изменений в разрешения на строительство")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterChangeConstructionBuilding() {
        List<java.lang.String> tableColumnList = Arrays.asList("Дело", "Вид изменений", "Заявление", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        reestrPage.searchField();
        generalPage.checkTableFilter(CHANGE_CONSTRUCTION_BUILDING, tableColumnList);
    }

    @Test
    @Story("rv")
    @AllureId("12320")
    @DisplayName("Проверка наличия данных и перехода в реестр Разрешения на ввод объекта в эксплуатацию")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("api"), @Tag("rinrifReestr")})
    void goToRegisterObjectOperation() {
        List<java.lang.String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        reestrPage.searchField();
        generalPage.checkTableFilter(PERMISSIONS_OBJECT_OPERATION, tableColumnList);
    }

    @Test
    @Story("rs")
    @AllureId("12352")
    @DisplayName("Проверка наличия данных и перехода в реестр Разрешения на строительство")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifReestr")})
    void goToBuildingPermitRegister() {
        List<java.lang.String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(BUILDING_PERMIT);
        reestrPage.searchField();
        generalPage.checkTableFilter(BUILDING_PERMIT, tableColumnList);
    }
}
