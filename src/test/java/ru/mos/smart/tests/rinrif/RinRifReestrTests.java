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
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif"), @Tag("regres")})
public class RinRifReestrTests extends TestBase {

    @Test
    @AllureId("16987")
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре Акты проверок")
    @Description("Проверка Корректности открытия реестра и отображения заголовков таблицы")
    void goToRegistryAktsProverok() {
        List<java.lang.String> columnNames = Arrays.asList("Номер акта", "Дата акта", "Место проведения проверки",
                "Результат проверки", "Специалист УН", "ЕРКНМ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(AKTS_PROVEROK);
        generalPage.registryContainsCardsHeadersCheck(AKTS_PROVEROK, columnNames);
    }

    @Test
    @AllureId("16997")
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре Все объекты")
    @Description("Проверка Корректности открытия реестра и отображения заголовков таблицы")
    void goToRegistryVseObjects() {
        List<java.lang.String> columnNames = Arrays.asList("Источник финансирования", "Номер дела", "Объект", "Застройщик ", "Почтовый адрес",
                "Дата начала строительства", "Дата окончания строительства", "Состояние", "Строительный надзор");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS);
        generalPage.registryContainsCardsHeadersCheck(ALL_OBJECTS, columnNames);
    }

    @Test
    @AllureId("16996")
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре Все объекты сноса")
    @Description("Проверка Корректности открытия реестра и отображения заголовков таблицы")
    void goToRegistryAllObjectsSnos() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Объект", "Кадастровый номер ЗУ", "Кадастровый номер здания");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS_SNOS);
        generalPage.registryContainsCardsHeadersCheck(ALL_OBJECTS_SNOS, columnNames);
    }

    @Test
    @AllureId("16992")
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре Все организации")
    @Description("Проверка Корректности открытия реестра и отображения заголовков таблицы")
    void goToRegistryAllOrganizations() {
        List<java.lang.String> columnNames = Arrays.asList("Полное наименование организации / Руководитель", "ИНН", "ОГРН /СНИЛС / Паспорт",
                "Юр. адрес / Факт. адрес", "Почтовый адрес");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_ORGANIZATION);
        generalPage.registryContainsCardsHeadersCheck(All_ORGANIZATION, columnNames);
    }

    @Test
    @AllureId("16985")
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре Все решения о проверке")
    @Description("Проверка Корректности открытия реестра и отображения заголовков таблицы")
    void goToRegistryAllInspectionDecisions() {
        List<java.lang.String> columnNames = Arrays.asList("Номер", "Дата", "Объект", "Проверяемая организация", "Вид проверки", "Основание для проверки",
                "Период проведения", "Ответственный", "Статус", "ЕРКНМ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_INSPECTION_DECISIONS);
        generalPage.registryContainsCardsHeadersCheck(All_INSPECTION_DECISIONS, columnNames);
    }

    @Test
    @AllureId("16991")
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре нарушения")
    @Description("Проверка Корректности открытия реестра и отображения заголовков таблицы")
    void goToRegistryViolations() {
        List<java.lang.String> columnNames = Arrays.asList("Номер нарушения", "Дата нарушения", "Наименование работ", "Специалист УН. ФИО");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(NARUSHENIYA);
        generalPage.registryContainsCardsHeadersCheck(NARUSHENIYA, columnNames);

    }

    @Test
    @AllureId("16995")
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре постановления")
    @Description("Проверка Корректности открытия реестра и отображения заголовков таблицы")
    void goToRegistryPostanovleniya() {
        List<java.lang.String> columnNames = Arrays.asList("Постановление", "Нарушитель", "Штраф", "Срок оплаты", "УН", "Подписал", "Оплачено (руб.)",
                "Долг по оплате (руб.)");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(POSTANOVLENIYA);
        generalPage.registryContainsCardsHeadersCheck(POSTANOVLENIYA, columnNames);
    }

    @Test
    @AllureId("16986")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр Протоколы")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegistryProtokols() {
        List<java.lang.String> columnNames = Arrays.asList("Дата протокола", "Место совершения нарушения", "Статья КОАП РФ", "Проверяемая организация",
                "Специалист УН. ФИО");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PROTOKOLS);
        generalPage.registryContainsCardsHeadersCheck(PROTOKOLS, columnNames);
    }

    @Test
    @AllureId("16984")
    @Story("Nadzor")
    @DisplayName("Наличия данных и перехода в реестр ТЗ лаборатории")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegistryTzLabaratorii() {
        List<java.lang.String> columnNames = Arrays.asList("Дата проверки ЦЭИИС", "Срок исполнения ТЗ", "Состав работ", "Состав работ утвержден ГБУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(TZ_LABORATORIES);
        generalPage.registryContainsCardsHeadersCheck(TZ_LABORATORIES, columnNames);

    }

    @Test
    @AllureId("16994")
    @Story("Snos")
    @DisplayName("Наличия данных и перехода в реестр Уведомления о завершении сноса")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegistryUvedomleniyaOzaversheniiSnosa() {
        List<java.lang.String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата", "Заявитель",
                "Исполнитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(DEMOLITIONS);
        generalPage.registryContainsCardsHeadersCheck(DEMOLITIONS, columnNames);
    }

    @Test
    @AllureId("16990")
    @Story("Snos")
    @DisplayName("Наличие данных и переход в реестр Уведомления о планируемом сносе")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegistryUvedomleniyaOplaniruemomSnose() {
        List<java.lang.String> columnNames = Arrays.asList("Статус", "Номер уведомления", "Дата уведомления", "Плановая дата",
                "Заявитель", "Исполнитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        generalPage.registryContainsCardsHeadersCheck(PLANNED_DEMOLITION_NOTICES, columnNames);
    }

    @Test
    @AllureId("16998")
    @Story("RV")
    @DisplayName("Наличия данных и перехода в реестр Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegistryEnteringObjects() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Заявление", "Рег. дата", "Плановая дата",
                "Объект", "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        generalPage.registryContainsCardsHeadersCheck(MODIFICATION_OBJECT_OPERATION, columnNames);
    }

    @Test
    @AllureId("16988")
    @Story("RS")
    @DisplayName("Наличия данных и перехода в реестр Внесение изменений в разрешения на строительство")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegistryChangeConstructionBuilding() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Вид изменений", "Заявление", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        generalPage.registryContainsCardsHeadersCheck(CHANGE_CONSTRUCTION_BUILDING, columnNames);
    }

    @Test
    @AllureId("16989")
    @Story("RV")
    @DisplayName("Наличия данных и перехода в реестр Разрешения на ввод объекта в эксплуатацию")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegistryObjectOperation() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        generalPage.registryContainsCardsHeadersCheck(PERMISSIONS_OBJECT_OPERATION, columnNames);
    }

    @Test
    @AllureId("16993")
    @Story("RS")
    @DisplayName("Наличия данных и перехода в реестр Разрешения на строительство")
    @Description("Проверить, что присутствуют данные в реестре и он открывается")
    void goToRegistryBuildingPermit() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Заявление ", "Рег. дата", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответный документ", "Исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(BUILDING_PERMIT);
        generalPage.registryContainsCardsHeadersCheck(BUILDING_PERMIT, columnNames);
    }

    @Test
    @AllureId("17617")
    @Story("IZS")
    @DisplayName("Наличие карточек и заголовков в реестре ИЖС. Уведомление о планируемом строительстве")
    @Description("Проверить, что реестр ИЖС. Уведомление о планируемом строительстве корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void goToRegistryIzsPlan() {
        List<java.lang.String> columnNames = Arrays.asList("Номер дела", "Заявление", "Дата заявления", "Надзорное дело", "Плановая дата",
                "Заявитель", "Исполнитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZS_PLAN);
        generalPage.registryContainsCardsHeadersCheck(IZS_PLAN, columnNames);
    }

    @Test
    @AllureId("17618")
    @Story("IZS")
    @DisplayName("Наличие карточек и заголовков в реестре ИЖС. Уведомление о завершении строительства")
    @Description("Проверить, что реестр ИЖС. Уведомление о завершении строительства корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void goToRegistryIzsZav() {
        List<java.lang.String> columnNames = Arrays.asList("Номер дела", "Заявление", "Дата заявления", "Надзорное дело", "Плановая дата",
                "Заявитель", "Исполнитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZS_ZAV);
        generalPage.registryContainsCardsHeadersCheck(IZS_ZAV, columnNames);
    }

    @Test
    @AllureId("17619")
    @Story("IZS")
    @DisplayName("Наличие карточек и заголовков в реестре ИЖС. Уведомление об изменении в строительстве")
    @Description("Проверить, что реестр ИЖС. Уведомление об изменении в строительстве корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void goToRegistryIzsChange() {
        List<java.lang.String> columnNames = Arrays.asList("Номер дела", "Заявление", "Дата заявления", "Надзорное дело", "Плановая дата",
                "Заявитель", "Исполнитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZS_CHANGE);
        generalPage.registryContainsCardsHeadersCheck(IZS_CHANGE, columnNames);
    }
}
