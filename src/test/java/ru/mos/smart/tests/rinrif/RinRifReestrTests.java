package ru.mos.smart.tests.rinrif;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.*;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Owner("Soldatov")
@Epic("ИАИС РИН")
@Feature("Rinrif")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class RinRifReestrTests extends TestBase {

    @Test
    @AllureId("16987")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр Акты проверок")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterAktsProverok() {
        List<java.lang.String> columnNames = Arrays.asList("Номер акта", "Дата акта", "Место проведения проверки",
                "Результат проверки", "Специалист УН", "ЕРКНМ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(AKTS_PROVEROK);
        //generalPage.checkTableFilter(AKTS_PROVEROK, 20, columnNames);
    }

    @Test
    @AllureId("16997")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр Все объекты")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterVseObjects() {
        List<java.lang.String> columnNames = Arrays.asList("Источник финансирования", "Номер дела", "Объект", "Застройщик ", "Почтовый адрес",
                "Дата начала строительства", "Дата окончания строительства", "Состояние", "Строительный надзор");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS);
        //generalPage.checkTableFilter(ALL_OBJECTS, 20, columnNames);
    }

    @Test
    @AllureId("16996")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр Все объекты сноса")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterAllObjectsSnos() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Объект", "Кадастровый номер ЗУ", "Кадастровый номер здания");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS_SNOS);
        //generalPage.checkTableFilter(ALL_OBJECTS_SNOS, 20, columnNames);
    }

    @Test
    @AllureId("16992")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр Все организации")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterAllOrganizations() {
        List<java.lang.String> columnNames = Arrays.asList("Полное наименование организации / Руководитель", "ИНН", "ОГРН /СНИЛС / Паспорт",
                "Юр. адрес / Факт. адрес", "Почтовый адрес");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_ORGANIZATION);
        //generalPage.checkTableFilter(ALL_OBJECTS_SNOS, 20, columnNames);
    }

    @Test
    @AllureId("16985")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр Все решения о проверке")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterAllInspectionDecisions() {
        List<java.lang.String> columnNames = Arrays.asList("Номер", "Дата", "Объект", "Проверяемая организация", "Вид проверки", "Основание для проверки",
                "Период проведения", "Ответственный", "Статус", "ЕРКНМ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_INSPECTION_DECISIONS);
        //generalPage.checkTableFilter(All_INSPECTION_DECISIONS, 20, columnNames);
    }

    @Test
    @AllureId("16991")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр  Нарушения")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterViolations() {
        List<java.lang.String> columnNames = Arrays.asList("Номер нарушения", "Дата нарушения", "Наименование работ", "Специалист УН. ФИО");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(NARUSHENIYA);
       // generalPage.checkTableFilter(NARUSHENIYA, 20, columnNames);

    }

    @Test
    @AllureId("16995")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр Постановления")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterPostanovleniya() {
        List<java.lang.String> columnNames = Arrays.asList("Постановление", "Нарушитель", "Штраф", "Срок оплаты", "УН", "Подписал", "Оплачено (руб.)",
                "Долг по оплате (руб.)");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(POSTANOVLENIYA);
        reestrPage.searchField();
        //generalPage.checkTableFilter(POSTANOVLENIYA, 20, columnNames); //TODO: спросить про проверку данных в таблице
    }

    @Test
    @AllureId("16986")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр Протоколы")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterProtokols() {
        List<java.lang.String> columnNames = Arrays.asList("Дата протокола", "Место совершения нарушения", "Статья КОАП РФ", "Проверяемая организация",
                "Специалист УН. ФИО");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PROTOKOLS);
        reestrPage.searchField();
       // generalPage.checkTableFilter(PROTOKOLS, 20, columnNames);
    }

    @Test
    @AllureId("16984")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр ТЗ лаборатории")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterTzLabaratorii() {
        List<java.lang.String> columnNames = Arrays.asList("Дата проверки ЦЭИИС", "Срок исполнения ТЗ", "Состав работ", "Состав работ утвержден ГБУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(TZ_LABORATORIES);
        reestrPage.searchField();
        //generalPage.checkTableFilter(TZ_LABORATORIES, 20, columnNames);

    }

    @Test
    @AllureId("16994")
    @Story("Snos")
    @DisplayName("Наличия данных и перехода в реестр Уведомления о завершении сноса")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterUvedomleniyaOzaversheniiSnosa() {
        List<java.lang.String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата", "Заявитель",
                "Исполнитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(DEMOLITIONS);
        reestrPage.searchField();
        //generalPage.checkTableFilter(DEMOLITIONS, 20, columnNames);
    }

    @Test
    @AllureId("16990")
    @Story("Snos")
    @DisplayName("Наличия данных и перехода в реестр Уведомления о планируемом сносе")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterUvedomleniyaOplaniruemomSnose() {
        List<java.lang.String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата",
                "Заявитель", "Исполнитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        reestrPage.searchField();
        //generalPage.checkTableFilter(PLANNED_DEMOLITION_NOTICES, 20, columnNames);
    }

    @Test
    @AllureId("16998")
    @Story("RV")
    @DisplayName("Наличия данных и перехода в реестр Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterEnteringObjects() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Заявление", "Рег. дата", "Плановая дата",
                "Объект", "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        reestrPage.searchField();
        //generalPage.checkTableFilter(MODIFICATION_OBJECT_OPERATION, 20, columnNames);
    }

    @Test
    @AllureId("16988")
    @Story("RS")
    @DisplayName("Наличия данных и перехода в реестр Внесение изменений в разрешения на строительство")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterChangeConstructionBuilding() {
        List<java.lang.String> tableColumnList = Arrays.asList("Дело", "Вид изменений", "Заявление", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        reestrPage.searchField();
        //generalPage.checkTableFilter(CHANGE_CONSTRUCTION_BUILDING, 20, tableColumnList);
    }

    @Test
    @AllureId("16989")
    @Story("RV")
    @DisplayName("Наличия данных и перехода в реестр Разрешения на ввод объекта в эксплуатацию")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegisterObjectOperation() {
        List<java.lang.String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        reestrPage.searchField();
       // generalPage.checkTableFilter(PERMISSIONS_OBJECT_OPERATION, 20, tableColumnList);
    }

    @Test
    @AllureId("16993")
    @Story("RS")
    @DisplayName("Наличия данных и перехода в реестр Разрешения на строительство")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToBuildingPermitRegister() {
        List<java.lang.String> tableColumnList = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(BUILDING_PERMIT);
        reestrPage.searchField();
        //generalPage.checkTableFilter(BUILDING_PERMIT, 20, tableColumnList);
    }
}
