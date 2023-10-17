package ru.mos.smart.tests.rinrif;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.*;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Owner("Soldatov")
@Epic("ИАИС РИН")
@Feature("Rinrif")
@Tags({@Tag("rinrif"), @Tag("regres")})
public class RinRifCardTests extends TestBase {

    @Test
    @AllureId("17008")
    @Story("Nadzor")
    @DisplayName("Корректность открытия и доступность карточки реестра Акты проверок")
    @Description("Проверка корректности открытия карточки 'Акты проверок', " +
            "убедится в наличии заголовков и наличии заполненных данных в этой карточке.")
    void checkCardRegisterActsProverok() {
        List<String> blocksList = new ArrayList<>(Arrays.asList("Общая информация", "ЕРКНМ", "", "Общие сведения"));
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(INSPECTIONACT);
        rinrifPage.goToRegistryCard(INSPECTIONACT);
        rinrifPage.checkAvailabilityHeadersInCard(INSPECTIONACT, blocksList );
    }

    @Test
    @AllureId("17011")
    @Story("RV")
    @DisplayName("Корректность открытия и доступность карточки реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Description("Проверить, что открывается карточка из реестра - Внесение изменений в разрешения ввод объекта в эксплуатацию " +
            "убедится в наличии  заполненных данных в этой карточке.")
    void checkCardRegisterEnteringObject() {
        List<String> blocksList = new ArrayList<>(Arrays.asList("Общая информация", "Документы", "Результат", "Внешние системы",
                "Процессы", "Общие сведения", "Сведения о ЗУ и объектах", "ТЭП"));
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(RV_CHANGE);
        rinrifPage.goToRegistryCard(RV_CHANGE);
        rinrifPage.checkAvailabilityHeadersInCard(RV_CHANGE, blocksList);
    }

    @Test
    @AllureId("17010")
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра Все объекты")
    @Description("Проверить, что открывается карточка из реестра - Все объекты")
    void checkCardAllObjects() {
        List<String> blocksList = Arrays.asList("Общие сведения", "Организации", "Представленные документы");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(OBJECTPASSPORT);
        rinrifPage.goToRegistryCard(OBJECTPASSPORT);
        //rinrifPage.checkAvailabilityHeadersInCard(OBJECTPASSPORT, blocksList);
    }

    @Test
    @AllureId("17007")
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра Все организации")
    @Description("Проверить, что открывается карточка из реестра - Все организации")
    void checkCardAllOrganizations() {
        List<String> blocksList = Arrays.asList("Общие сведения", "Организации", "Представленные документы");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ORGANIZATION);
        //rinrifPage.goToRegistryCard(ORGANIZATION);
        //rinrifPage.checkAvailabilityHeadersInCard(ORGANIZATION, blocksList);
    }

    @Test
    @AllureId("17004")
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра Все решения о проверке")
    @Description("Проверить, что открывается карточка из реестра - Все решения о проверке")
    void checkCardReestrAllInspectionDecisions() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(INSPECTIONDECISION);
        rinrifPage.goToRegistryCard(INSPECTIONDECISION);
    }

    @Test
    @AllureId("17002")
    @Story("Snos")
    @DisplayName("Переход в карточку из реестра Уведомления о завершении сноса")
    @Description("Проверить, что открывается карточка из реестра - Уведомления о завершении сноса")
    void checkCardReestrUvedomleniyaOzaversheniiSnosa() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(SNOS_FINISH);
        rinrifPage.goToRegistryCard(SNOS_FINISH);
    }

    @Test
    @AllureId("17009")
    @Story("Snos")
    @DisplayName("Переход в карточку из реестра Уведомления о планируемом сносе")
    @Description("Проверить, что открывается карточка из реестра - Уведомления о планируемом сносе")
    void checkCardReestrUvedomleniyaOplaniruemomSnose() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(SNOS_PLAN);
        rinrifPage.goToRegistryCard(SNOS_PLAN);
    }

    @Test
    @AllureId("17005")
    @Story("RS")
    @DisplayName("Переход в карточку из реестра Внесение изменений в разрешения на строительство")
    @Description("Проверить, что открывается карточка из реестра - Внесение изменений в разрешения на строительство")
    void checkCardRegisterConstructionLicense() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(RS_CHANGE);
        rinrifPage.goToRegistryCard(RS_CHANGE);
    }

    @Test
    @AllureId("17006")
    @Story("RV")
    @DisplayName("Переход в карточку из реестра Разрешения на ввод объекта в эксплуатацию")
    @Description("Проверить, что открывается карточка из реестра - Разрешения на ввод объекта в эксплуатацию")
    void checkCardRegisterObjectOperation() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(RV_RV);
        rinrifPage.goToRegistryCard(RV_RV);
    }

    @Test
    @AllureId("17003")
    @Story("RS")
    @DisplayName("Переход в карточку из реестра Разрешения на строительство")
    @Description("Проверить, что открывается карточка из реестра - Разрешения на строительство")
    void checkCardBuildingPermitRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(RS_RS);
        rinrifPage.goToRegistryCard(RS_RS);
    }

    @Test
    @Story("IZS")
    @AllureId("17621")
    @DisplayName("Переход в карточку из реестра ИЖС. Уведомление о завершении строительства")
    @Description("Проверить, что открывается карточка из реестра - ИЖС. Уведомление о завершении строительства " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryIzsZav() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "Документы", "Результат",
                "Внешние системы", "Процессы", "Служебная информация", "Общие сведения", "Сведения о ЗУ и объекте");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZS_ZAV);
        rinrifPage.goToRegistryCard(IZS_ZAV);
        rinrifPage.checkAvailabilityHeadersInCard(IZS_ZAV, cardHeaders);
    }

    @Test
    @Story("IZS")
    @AllureId("17620")
    @DisplayName("Переход в карточку из реестра ИЖС. Уведомление о планируемом строительстве")
    @Description("Проверить, что открывается карточка из реестра - ИЖС. Уведомление о планируемом строительстве " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryIzsPlan() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "Документы", "Результат",
                "Внешние системы", "Процессы", "Служебная информация", "Общие сведения", "Сведения о ЗУ и объекте");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZS_PLAN);
        rinrifPage.goToRegistryCard(IZS_PLAN);
        rinrifPage.checkAvailabilityHeadersInCard(IZS_PLAN, cardHeaders);
    }

    @Test
    @Story("IZS")
    @DisplayName("Переход в карточку из реестра ИЖС. Уведомление об изменении в строительстве")
    @Description("Проверить, что открывается карточка из реестра - ИЖС. Уведомление об изменении в строительстве " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryIzsChange() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "Документы", "Результат",
                "Внешние системы", "Процессы", "Служебная информация", "Общие сведения", "Сведения о ЗУ и объекте");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZS_CHANGE);
        rinrifPage.goToRegistryCard(IZS_CHANGE);
        rinrifPage.checkAvailabilityHeadersInCard(IZS_CHANGE, cardHeaders);
    }

    @Test
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра Все объекты сноса")
    @Description("Проверить, что открывается карточка из реестра - Все объекты сноса " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryObjectPassportSnos() {
        List<String> cardHeaders = Arrays.asList("Паспорт", "Документы МГСН", "Профилактические мероприятия", "", "");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(OBJECTPASSPORT_SNOS);
        rinrifPage.goToRegistryCard(OBJECTPASSPORT_SNOS);
        rinrifPage.checkAvailabilityHeadersInCard(OBJECTPASSPORT_SNOS, cardHeaders);
    }

    @Test
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра нарушения")
    @Description("Проверить, что открывается карточка из реестра - нарушения " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryViolations() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "", "");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(VIOLATION);
        rinrifPage.goToRegistryCard(VIOLATION);
        rinrifPage.checkAvailabilityHeadersInCard(VIOLATION, cardHeaders);
    }

    @Test
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра постановления")
    @Description("Проверить, что открывается карточка из реестра - постановления " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryPostanovlenie() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(POSTANOVLENIE);
        rinrifPage.goToRegistryCard(POSTANOVLENIE);
    }

    @Test
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра протоколы")
    @Description("Проверить, что открывается карточка из реестра - протоколы " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryProtocols() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "", "");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PROTOCOL);
        rinrifPage.goToRegistryCard(PROTOCOL);
        rinrifPage.checkAvailabilityHeadersInCard(PROTOCOL, cardHeaders);
    }

    @Test
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра ТЗ лаборатории")
    @Description("Проверить, что открывается карточка из реестра - ТЗ лаборатории " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryTzLabaratorii() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "", "");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(TZ_LABORATORIES);
        rinrifPage.goToRegistryCard(TZ_LABORATORIES);
        rinrifPage.checkAvailabilityHeadersInCard(TZ_LABORATORIES, cardHeaders);
    }
}
