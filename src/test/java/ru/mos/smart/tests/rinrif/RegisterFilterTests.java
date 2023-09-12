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

import static com.codeborne.selenide.Selenide.*;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.Registers.*;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTERS;

@Owner("Soldatov")
@Layer("web")
@Epic("ИФИС РИН")
@Feature("RINRIF")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class RegisterFilterTests extends TestBase {

    @Test
    @Story("nadzor")
    @Description("Реестр Акты проверок")
    @DisplayName("Наполненность реестра Акты проверок")
    void goToRegisterAktsProverok() {
        List<String> columnNames = Arrays.asList("Номер акта", "Дата акта", "Место проведения проверки",
                "Результат проверки", "Специалист УН", "ЕРКНМ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(AKTS_PROVEROK);
        switchTo().window(1);
        $(".fa.fa-filter").click();
        $$("table th").get(1).$("title");;
    }

    @Test
    @Story("nadzor")
    @DisplayName("Наполненность реестра Все объекты")
    void goToRegisterVseObjects() {
        List<String> columnNames = Arrays.asList("Источник финансирования", "Номер дела", "Объект", "Застройщик ", "Почтовый адрес",
                "Дата начала строительства", "Дата окончания строительства", "Состояние", "Строительный надзор");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS);
        generalPage.checkTableFilter(ALL_OBJECTS, columnNames);
    }

    @Test
    @Story("nadzor")
    @DisplayName("Наполненность реестра Все объекты сноса")
    void goToRegisterAllObjectsSnos() {
        List<String> columnNames = Arrays.asList("Дело", "Объект", "Кадастровый номер ЗУ", "Кадастровый номер здания");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS_SNOS);
        generalPage.checkTableFilter(ALL_OBJECTS_SNOS, columnNames);
    }

    @Test
    @Story("nadzor")
    @DisplayName("Наполненность реестра Все организации")
    void goToRegisterAllOrganizations() {
        List<String> columnNames = Arrays.asList("Полное наименование организации / Руководитель", "ИНН", "ОГРН /СНИЛС / Паспорт",
                "Юр. адрес / Факт. адрес", "Почтовый адрес");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_ORGANIZATION);
        generalPage.checkTableFilter(ALL_OBJECTS_SNOS, columnNames);
    }

    @Test
    @Story("nadzor")
    @DisplayName("Проверка наличия данных и перехода в реестр Все решения о проверке")
    void goToRegisterAllInspectionDecisions() {
        List<String> columnNames = Arrays.asList("Номер", "Дата", "Объект", "Проверяемая организация", "Вид проверки", "Основание для проверки",
                "Период проведения", "Ответственный", "Статус", "ЕРКНМ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_INSPECTION_DECISIONS);
        generalPage.checkTableFilter(All_INSPECTION_DECISIONS, columnNames);
    }

    @Test
    @Story("nadzor")
    @DisplayName("Проверка наличия данных и перехода в реестр  Нарушения")
    void goToRegisterViolations() {
        List<String> columnNames = Arrays.asList("Номер нарушения", "Дата нарушения", "Наименование работ", "Специалист УН. ФИО");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(NARUSHENIYA);
        generalPage.checkTableFilter(NARUSHENIYA, columnNames);

    }

    @Test
    @Story("nadzor")
    @DisplayName("Проверка наличия данных и перехода в реестр Постановления")
    void goToRegisterPostanovleniya() {
        List<String> columnNames = Arrays.asList("Постановление", "Нарушитель", "Штраф", "Срок оплаты", "УН", "Подписал", "Оплачено (руб.)",
                "Долг по оплате (руб.)");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(POSTANOVLENIYA);
        generalPage.checkTableFilter(POSTANOVLENIYA, columnNames); //TODO: спросить про проверку данных в таблице
    }

    @Test
    @Story("nadzor")
    @DisplayName("Наполнение реестра Протоколы данными")
    void goToRegisterProtokols() {
        List<String> columnNames = Arrays.asList("Дата протокола", "Место совершения нарушения", "Статья КОАП РФ",
                "Проверяемая организация", "Специалист УН. ФИО");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PROTOKOLS);
        generalPage.checkTableFilter(PROTOKOLS, columnNames);
    }

    @Test
    @Story("nadzor")
    @DisplayName("Проверка наличия данных и перехода в реестр ТЗ лаборатории")
    void goToRegisterTzLabaratorii() {
        List<String> columnNames = Arrays.asList("Дата проверки ЦЭИИС", "Срок исполнения ТЗ", "Состав работ",
                "Состав работ утвержден ГБУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(TZ_LABORATORIES);
        generalPage.checkTableFilter(TZ_LABORATORIES, columnNames);

    }

    @Test
    @Story("snos")
    @DisplayName("Проверка наличия данных и перехода в реестр Уведомления о завершении сноса")
    void goToRegisterUvedomleniyaOzaversheniiSnosa() {
        List<String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата", "Заявитель",
                "Исполнитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(DEMOLITIONS);
        generalPage.checkTableFilter(DEMOLITIONS, columnNames);
    }

    @Test
    @Story("snos")
    @DisplayName("Проверка наличия данных и перехода в реестр Уведомления о планируемом сносе")
    void goToRegisterUvedomleniyaOplaniruemomSnose() {
        List<String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата",
                "Заявитель", "Исполнитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        generalPage.checkTableFilter(PLANNED_DEMOLITION_NOTICES, columnNames);
    }

    @Test
    @Story("rv")
    @DisplayName("Проверка наличия данных и перехода в реестр Внесение изменений в разрешения ввод объекта в эксплуатацию")
    void goToRegisterEnteringObjects() {
        List<String> columnNames = Arrays.asList("Дело", "Заявление", "Рег. дата", "Плановая дата",
                "Объект", "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        generalPage.checkTableFilter(MODIFICATION_OBJECT_OPERATION, columnNames);
    }

    @Test
    @Story("rs")
    @DisplayName("Проверка наличия данных и перехода в реестр Внесение изменений в разрешения на строительство")
    void goToRegisterChangeConstructionBuilding() {
        List<String> tableColumnList = Arrays.asList("Дело", "Вид изменений", "Заявление", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        generalPage.checkTableFilter(CHANGE_CONSTRUCTION_BUILDING, tableColumnList);
    }

    @Test
    @Story("rv")
    @DisplayName("Проверка наличия данных и перехода в реестр Разрешения на ввод объекта в эксплуатацию")
    void goToRegisterObjectOperation() {
        List<String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        generalPage.checkTableFilter(PERMISSIONS_OBJECT_OPERATION, tableColumnList);
    }

    @Test
    @Story("rs")
    @DisplayName("Проверка наличия данных и перехода в реестр Разрешения на строительство")
    void goToBuildingPermitRegister() {
        List<String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(BUILDING_PERMIT);
        generalPage.checkTableFilter(BUILDING_PERMIT, tableColumnList);
    }
}
