package ru.mos.smart.tests.rinrif;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.Registers.*;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTERS;

@Owner("Soldatov")
@Layer("web")
@Epic("ИАИС РИН")
@Feature("RINRIF")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class RinRifCardTests extends TestBase {

    @Test
    @Story("nadzor")
    @DisplayName("Проверка перехода в карточку из реестра Акты проверок")
    @Description("Проверить, что открывается из реестра - Акты проверок")
    void checkCardRegisterActsProverok() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(AKTS_PROVEROK);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("rv")
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Description("Проверить, что открывается карточка из реестра - Внесение изменений в разрешения ввод объекта в эксплуатацию")
    void checkCardRegisterEnteringObject() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("nadzor")
    @DisplayName("Проверка перехода в карточку из реестра Все объекты")
    @Description("Проверить, что открывается карточка из реестра - Все объекты")
    void checkCardAllObjects() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("nadzor")
    @DisplayName("Проверка перехода в карточку из реестра Все объекты сноса")
    @Description("Проверить, что открывается карочка из реестра - Все объекты сноса")
    void checkCardAllObjectsSnos() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS_SNOS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("nadzor")
    @DisplayName("Проверка перехода в карточку из реестра Все организации")
    @Description("Проверить, что открывается карточка из реестра - Все организации")
    void checkCardAllOrganizations() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_ORGANIZATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("nadzor")
    @DisplayName("Проверка перехода в карточку из реестра Все решения о проверке")
    @Description("Проверить, что открывается карточка из реестра - Все решения о проверке")
    void checkCardReestrAllInspectionDecisions() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_INSPECTION_DECISIONS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("snos")
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о завершении сноса")
    @Description("Проверить, что открывается карточка из реестра - Уведомления о завершении сноса")
    void checkCardReestrUvedomleniyaOzaversheniiSnosa() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(DEMOLITIONS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("snos")
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о планируемом сносе")
    @Description("Проверить, что открывается карточка из реестра - Уведомления о планируемом сносе")
    void checkCardReestrUvedomleniyaOplaniruemomSnose() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("rs")
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения на строительство")
    @Description("Проверить, что открывается карточка из реестра - Внесение изменений в разрешения на строительство")
    void checkCardRegisterConstructionLicense() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("rv")
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на ввод объекта в эксплуатацию")
    @Description("Проверить, что открывается карточка из реестра - Разрешения на ввод объекта в эксплуатацию")
    void checkCardRegisterObjectOperation() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("rs")
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на строительство")
    @Description("Проверить, что открывается карточка из реестра - Разрешения на строительство")
    void checkCardBuildingPermitRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(BUILDING_PERMIT);
        rinrifPage.goToRegistryCardAndCheck();
    }
}
