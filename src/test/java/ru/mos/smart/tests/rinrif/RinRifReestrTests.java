package ru.mos.smart.tests.rinrif;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.RegisterObjectType.*;

@Owner("Soldatov")
@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("РинРиф")
public class RinRifReestrTests extends TestBase {

    @Test
    @AllureId("12316")
    @DisplayName("Проверка наличия данных и перехода в реестр Акты проверок")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterAktsProverok() {
        List<String> columnNames = Arrays.asList("Номер акта", "Дата акта", "Место проведения проверки",
                "Результат проверки", "Специалист УН", "ЕРКНМ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(AKTS_PROVEROK);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(AKTS_PROVEROK, columnNames);
    }

    @Test
    @AllureId("14038")
    //@RepeatedIfExceptionsTest(repeats = 3, exceptions = NoSuchElementException.class)
    @DisplayName("Проверка наличия данных и перехода в реестр Все объекты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterVseObjects() {
        List<String> columnNames = Arrays.asList("Источник финансирования", "Номер дела", "Объект", "Застройщик ", "Почтовый адрес",
                "Дата начала строительства", "Дата окончания строительства", "Состояние", "Строительный надзор");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(ALL_OBJECTS);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(ALL_OBJECTS, columnNames);
    }

    @Test
    @AllureId("14037")
    @DisplayName("Проверка наличия данных и перехода в реестр Все объекты сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterAllObjectsSnos() {
        List<String> columnNames = Arrays.asList("Дело", "Объект", "Кадастровый номер ЗУ", "Кадастровый номер здания");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(ALL_OBJECTS_SNOS);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(ALL_OBJECTS_SNOS, columnNames);
    }

    @Test
    @AllureId("14039")
    @DisplayName("Проверка наличия данных и перехода в реестр Все организации")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterAllOrganizations() {
        List<String> columnNames = Arrays.asList("Полное наименование организации / Руководитель", "ИНН", "ОГРН /СНИЛС / Паспорт",
                "Юр. адрес / Факт. адрес", "Почтовый адрес");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(All_ORGANIZATION);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(ALL_OBJECTS_SNOS, columnNames);
    }

    @Test
    @AllureId("12315")
    @DisplayName("Проверка наличия данных и перехода в реестр Все решения о проверке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterAllInspectionDecisions() {
        List<String> columnNames = Arrays.asList("Номер", "Дата", "Объект", "Проверяемая организация", "Вид проверки", "Основание для проверки",
                "Период проведения", "Ответственный", "Статус", "ЕРКНМ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(All_INSPECTION_DECISIONS);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(All_INSPECTION_DECISIONS, columnNames);
    }

    @Test
    @AllureId("12330")
    @DisplayName("Проверка наличия данных и перехода в реестр  Нарушения")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterViolations() {
        List<String> columnNames = Arrays.asList("Номер нарушения", "Дата нарушения", "Наименование работ", "Специалист УН. ФИО");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(NARUSHENIYA);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(NARUSHENIYA, columnNames);

    }

    @Test
    @AllureId("12332")
    @DisplayName("Проверка наличия данных и перехода в реестр Постановления")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterPostanovleniya() {
        List<String> columnNames = Arrays.asList("Постановление", "Нарушитель", "Штраф", "Срок оплаты", "УН", "Подписал", "Оплачено (руб.)",
                "Долг по оплате (руб.)");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(POSTANOVLENIYA);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(POSTANOVLENIYA, columnNames); //TODO: спросить про проверку данных в таблице
    }

    @Test
    @AllureId("14040")
    @DisplayName("Проверка наличия данных и перехода в реестр Протоколы")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterProtokols() {
        List<String> columnNames = Arrays.asList("Дата протокола", "Место совершения нарушения", "Статья КОАП РФ", "Проверяемая организация",
                "Специалист УН. ФИО");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(PROTOKOLS);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(PROTOKOLS, columnNames);
    }

    @Test
    @AllureId("14041")
    @DisplayName("Проверка наличия данных и перехода в реестр ТЗ лаборатории")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterTzLabaratorii() {
        List<String> columnNames = Arrays.asList("Дата проверки ЦЭИИС", "Срок исполнения ТЗ", "Состав работ", "Состав работ утвержден ГБУ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(TZ_LABORATORIES);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(TZ_LABORATORIES, columnNames);

    }

    @Test
    @AllureId("14042")
    @DisplayName("Проверка наличия данных и перехода в реестр Уведомления о завершении сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterUvedomleniyaOzaversheniiSnosa() {
        List<String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата", "Заявитель",
                "Исполнитель", "Данные ПГУ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(DEMOLITIONS);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(DEMOLITIONS, columnNames);
    }

    @Test
    @AllureId("14043")
    @DisplayName("Проверка наличия данных и перехода в реестр Уведомления о планируемом сносе")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterUvedomleniyaOplaniruemomSnose() {
        List<String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата",
                "Заявитель", "Исполнитель", "Данные ПГУ");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(PLANNED_DEMOLITION_NOTICES, columnNames);
    }

    @Test
    @AllureId("12328")
    @DisplayName("Проверка наличия данных и перехода в реестр Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterEnteringObjects() {
        List<String> columnNames = Arrays.asList("Дело", "Заявление", "Рег. дата", "Плановая дата",
                "Объект", "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(MODIFICATION_OBJECT_OPERATION, columnNames);
    }

    @Test
    @AllureId("12319")
    @DisplayName("Проверка наличия данных и перехода в реестр Внесение изменений в разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterChangeConstructionBuilding() {
        List<String> tableColumnList = Arrays.asList("Дело", "Вид изменений", "Заявление", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(CHANGE_CONSTRUCTION_BUILDING, tableColumnList);
    }

    @Test
    @AllureId("12320")
    @DisplayName("Проверка наличия данных и перехода в реестр Разрешения на ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void goToRegisterObjectOperation() {
        List<String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(PERMISSIONS_OBJECT_OPERATION, tableColumnList);
    }

    @Test
    @AllureId("12352")
    @DisplayName("Проверка наличия данных и перехода в реестр Разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif"), @Tag("regressions")})
    void goToBuildingPermitRegister() {
        List<String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(BUILDING_PERMIT);
        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        rinrifPage.checkFilter(BUILDING_PERMIT, tableColumnList);
    }
}