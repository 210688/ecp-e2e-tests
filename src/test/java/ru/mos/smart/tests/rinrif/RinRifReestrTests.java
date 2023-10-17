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
@Tags({@Tag("rinrif"), @Tag("regres")})
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
        reestrPage.goToRegister(INSPECTIONACT);
        rinrifPage.registryContainsCardsHeadersCheck(INSPECTIONACT, columnNames);
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
        reestrPage.goToRegister(OBJECTPASSPORT);
        rinrifPage.registryContainsCardsHeadersCheck(OBJECTPASSPORT, columnNames);
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
        reestrPage.goToRegister(OBJECTPASSPORT_SNOS);
        rinrifPage.registryContainsCardsHeadersCheck(OBJECTPASSPORT_SNOS, columnNames);
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
        reestrPage.goToRegister(ORGANIZATION);
        rinrifPage.registryContainsCardsHeadersCheck(ORGANIZATION, columnNames);
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
        reestrPage.goToRegister(INSPECTIONDECISION);
        rinrifPage.registryContainsCardsHeadersCheck(INSPECTIONDECISION, columnNames);
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
        reestrPage.goToRegister(VIOLATION);
        rinrifPage.registryContainsCardsHeadersCheck(VIOLATION, columnNames);

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
        reestrPage.goToRegister(POSTANOVLENIE);
        rinrifPage.registryContainsCardsHeadersCheck(POSTANOVLENIE, columnNames);
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
        reestrPage.goToRegister(PROTOCOL);
        rinrifPage.registryContainsCardsHeadersCheck(PROTOCOL, columnNames);
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
        rinrifPage.registryContainsCardsHeadersCheck(TZ_LABORATORIES, columnNames);
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
        reestrPage.goToRegister(SNOS_FINISH);
        rinrifPage.registryContainsCardsHeadersCheck(SNOS_FINISH, columnNames);
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
        reestrPage.goToRegister(SNOS_PLAN);
        rinrifPage.registryContainsCardsHeadersCheck(SNOS_PLAN, columnNames);
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
        reestrPage.goToRegister(RV_CHANGE);
        rinrifPage.registryContainsCardsHeadersCheck(RV_CHANGE, columnNames);
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
        reestrPage.goToRegister(RS_CHANGE);
        rinrifPage.registryContainsCardsHeadersCheck(RS_CHANGE, columnNames);
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
        reestrPage.goToRegister(RV_RV);
        rinrifPage.registryContainsCardsHeadersCheck(RV_RV, columnNames);
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
        reestrPage.goToRegister(RS_RS);
        rinrifPage.registryContainsCardsHeadersCheck(RS_RS, columnNames);
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
        rinrifPage.registryContainsCardsHeadersCheck(IZS_PLAN, columnNames);
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
        rinrifPage.registryContainsCardsHeadersCheck(IZS_ZAV, columnNames);
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
        rinrifPage.registryContainsCardsHeadersCheck(IZS_CHANGE, columnNames);
    }

    @Test
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре Решения о приостановке проверок")
    @Description("Проверить, что реестр Решения о приостановке проверок корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void goToRegistryCheckPauseInspections() {
        List<java.lang.String> columnNames = Arrays.asList("Статус", "Номер решения", "Дата решения", "Начало проверки", "Окончание проверки",
                "Ответственный", "Решение принял", "Подразделение", "ЕРКНМ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(CHECKPAUSE);
        rinrifPage.registryContainsCardsHeadersCheck(CHECKPAUSE, columnNames);
    }

    @Test
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре Заявления в прокуратуру")
    @Description("Проверить, что реестр Заявления в прокуратуру корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void goToRegistryClaimInProc() {
        List<java.lang.String> columnNames = Arrays.asList("Номер заявления", "Дата заявления", "Обращение", "Мотивированное представление",
                "Сопроводительное письмо", "Решение", "Номер решения", "Дата решения", "ЕРКНМ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PROCCLAIM);
        rinrifPage.registryContainsCardsHeadersCheck(PROCCLAIM, columnNames);
    }

    @Test
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре Документы по итогам КНМ")
    @Description("Проверить, что реестр Документы по итогам КНМ корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void goToRegistryDocumentsKnm() {
        List<java.lang.String> columnNames = Arrays.asList("Тип", "Номер документа", "Дата документа", "ЕРКНМ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(KNMRESULT);
        rinrifPage.registryContainsCardsHeadersCheck(KNMRESULT, columnNames);
    }

    @Test
    @Story("Pm")
    @DisplayName("Наличие карточек и заголовков в реестре Предостережения")
    @Description("Проверить, что реестр Предостережения корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void goToRegistryCaution() {
        List<java.lang.String> columnNames = Arrays.asList("Статус", "Рег. данные обращения", "Подготовил решение", "Решение о проведении ПМ",
                "Контролируемое лицо", "Объект", "Направил предостережение", "Предостережение",
                "Перечень требований, которые могут быть нарушены", "Дата поступления уведомления об исполнении", "Дата поступления возражений",
                "Дата ответа на возражения", "Результат рассмотрения возражения");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(CAUTION);
        rinrifPage.registryContainsCardsHeadersCheck(CAUTION, columnNames);
    }

    @Test
    @Story("Nadzor")
    @DisplayName("Наличие карточек и заголовков в реестре Извещения о начале СМР")
    @Description("Проверить, что реестр Извещения о начале СМР корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void goToRegistryIzvStartSmr() {
        List<java.lang.String> columnNames = Arrays.asList("Дело", "Извещение", "Плановая дата", "Объект",
                "Заявитель", "Данные ПГУ", "Ответственный специалист УН");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZVSTARTSMR);
        rinrifPage.registryContainsCardsHeadersCheck(IZVSTARTSMR, columnNames);
    }
}
