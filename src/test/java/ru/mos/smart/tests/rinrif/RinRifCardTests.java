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
        rinrifPage.goToRegistryCard(AKTS_PROVEROK);
        //rinrifPage.checkingCardHeaders();
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
        rinrifPage.goToRegistryCard(MODIFICATION_OBJECT_OPERATION);
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
        rinrifPage.goToRegistryCard(ALL_OBJECTS);
        rinrifPage.checkAvailabilityHeadersInCard(ALL_OBJECTS, blocksList);
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
        rinrifPage.goToRegistryCard(All_ORGANIZATION);
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
        rinrifPage.goToRegistryCard(All_INSPECTION_DECISIONS);
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
        rinrifPage.goToRegistryCard(DEMOLITIONS);
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
        rinrifPage.goToRegistryCard(PLANNED_DEMOLITION_NOTICES);
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
        rinrifPage.goToRegistryCard(CHANGE_CONSTRUCTION_BUILDING);
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
        rinrifPage.goToRegistryCard(PERMISSIONS_OBJECT_OPERATION);
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
        rinrifPage.goToRegistryCard(BUILDING_PERMIT);
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
        reestrPage.goToRegister(IZS_PLAN);
        rinrifPage.goToRegistryCard(IZS_PLAN);
        rinrifPage.checkAvailabilityHeadersInCard(IZS_PLAN, cardHeaders);
    }
}
