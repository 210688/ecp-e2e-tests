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
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions") ,@Tag("rinrif")})
public class RinRifCardTests extends TestBase {

    @Test
    @AllureId("17008")
    @Story("Nadzor")
    @DisplayName("Корректность открытия и доступность карточки Акты проверок")
    @Description("Проверка корректности открытия карточки 'Акты проверок', " +
            "убедится в наличии заголовков и наличии заполненных данных в этой карточке.")
    void checkCardRegisterActsProverok() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(AKTS_PROVEROK);
        generalPage.goToRegistryCard(AKTS_PROVEROK);
        rinrifPage.checkingCardHeaders();
    }

    @Test
    @AllureId("17011")
    @Story("RV")
    @DisplayName("Переход в карточку из реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Description("Проверить, что открывается карточка из реестра - Внесение изменений в разрешения ввод объекта в эксплуатацию " +
            "убедится в наличии  заполненных данных в этой карточке.")
    void checkCardRegisterEnteringObject() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        generalPage.goToRegistryCard(MODIFICATION_OBJECT_OPERATION);
        rinrifPage.checkingCardHeadersRv();
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
        reestrPage.goToRegister(ALL_OBJECTS);
        generalPage.goToRegistryCard(ALL_OBJECTS);
        rinrifPage.checkAvailabilityOfUnits(ALL_OBJECTS, blocksList);
    }

    @Test
    @AllureId("17007")
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра Все организации")
    @Description("Проверить, что открывается карточка из реестра - Все организации")
    void checkCardAllOrganizations() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_ORGANIZATION);
        generalPage.goToRegistryCard(All_ORGANIZATION);
    }

    @Test
    @AllureId("17004")
    @Story("Nadzor")
    @DisplayName("Переход в карточку из реестра Все решения о проверке")
    @Description("Проверить, что открывается карточка из реестра - Все решения о проверке")
    void checkCardReestrAllInspectionDecisions() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_INSPECTION_DECISIONS);
        generalPage.goToRegistryCard(All_INSPECTION_DECISIONS);
    }

    @Test
    @AllureId("17002")
    @Story("Snos")
    @DisplayName("Переход в карточку из реестра Уведомления о завершении сноса")
    @Description("Проверить, что открывается карточка из реестра - Уведомления о завершении сноса")
    void checkCardReestrUvedomleniyaOzaversheniiSnosa() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(DEMOLITIONS);
        generalPage.goToRegistryCard(DEMOLITIONS);
    }

    @Test
    @AllureId("17009")
    @Story("Snos")
    @DisplayName("Переход в карточку из реестра Уведомления о планируемом сносе")
    @Description("Проверить, что открывается карточка из реестра - Уведомления о планируемом сносе")
    void checkCardReestrUvedomleniyaOplaniruemomSnose() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        generalPage.goToRegistryCard(PLANNED_DEMOLITION_NOTICES);
    }

    @Test
    @AllureId("17005")
    @Story("RS")
    @DisplayName("Переход в карточку из реестра Внесение изменений в разрешения на строительство")
    @Description("Проверить, что открывается карточка из реестра - Внесение изменений в разрешения на строительство")
    void checkCardRegisterConstructionLicense() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        generalPage.goToRegistryCard(CHANGE_CONSTRUCTION_BUILDING);
    }

    @Test
    @AllureId("17006")
    @Story("RV")
    @DisplayName("Переход в карточку из реестра Разрешения на ввод объекта в эксплуатацию")
    @Description("Проверить, что открывается карточка из реестра - Разрешения на ввод объекта в эксплуатацию")
    void checkCardRegisterObjectOperation() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        generalPage.goToRegistryCard(PERMISSIONS_OBJECT_OPERATION);
    }

    @Test
    @AllureId("17003")
    @Story("RS")
    @DisplayName("Переход в карточку из реестра Разрешения на строительство")
    @Description("Проверить, что открывается карточка из реестра - Разрешения на строительство")
    void checkCardBuildingPermitRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(BUILDING_PERMIT);
        generalPage.goToRegistryCard(BUILDING_PERMIT);
    }

    @Test
    @Story("IZS")
    @DisplayName("Переход в карточку из реестра ИЖС. Уведомление о завершении строительства")
    @Description("Проверить, что открывается карточка из реестра - ИЖС. Уведомление о завершении строительства " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryIzsZav() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "Документы", "Результат",
                "Внешние системы", "Процессы", "Служебная информация");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZS_ZAV);
        generalPage.goToRegistryCard(IZS_ZAV);
        rinrifPage.checkAvailabilityOfUnits(IZS_ZAV, cardHeaders);
    }

    @Test
    @Story("IZS")
    @DisplayName("Переход в карточку из реестра ИЖС. Уведомление о планируемом строительстве")
    @Description("Проверить, что открывается карточка из реестра - ИЖС. Уведомление о планируемом строительстве " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryIzsPlan() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "Документы", "Результат",
                "Внешние системы", "Процессы", "Служебная информация");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZS_PLAN);
        generalPage.goToRegistryCard(IZS_PLAN);
        rinrifPage.checkAvailabilityOfUnits(IZS_PLAN, cardHeaders);
    }

    @Test
    @Story("IZS")
    @DisplayName("Переход в карточку из реестра ИЖС. Уведомление об изменении в строительстве")
    @Description("Проверить, что открывается карточка из реестра - ИЖС. Уведомление об изменении в строительстве " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryIzsChange() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "Документы", "Результат",
                "Внешние системы", "Процессы", "Служебная информация");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(IZS_PLAN);
        generalPage.goToRegistryCard(IZS_PLAN);
        rinrifPage.checkAvailabilityOfUnits(IZS_PLAN, cardHeaders);
    }
}
