package ru.mos.smart.tests.rinrif;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTERS;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeRinRif.*;

@Owner("Soldatov")
@Layer("web")
@Epic("ИФИС РИН")
@Feature("RINRIF")



public class RinRifCardTests extends TestBase {

    @Test
    @Story("nadzor")
    @AllureId("14049")
    @DisplayName("Проверка перехода в карточку из реестра Акты проверок")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardRegisterActsProverok() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(AKTS_PROVEROK);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("rv")
    @AllureId("14045")
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardRegisterEnteringObject() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("nadzor")
    @AllureId("14046")
    @DisplayName("Проверка перехода в карточку из реестра Все объекты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardAllObjects() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("nadzor")
    @AllureId("14046")
    @DisplayName("Проверка перехода в карточку из реестра Все объекты сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardAllObjectsSnos() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ALL_OBJECTS_SNOS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("nadzor")
    @AllureId("14051")
    @DisplayName("Проверка перехода в карточку из реестра Все организации")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardAllOrganizations() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_ORGANIZATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("nadzor")
    @AllureId("14053")
    @DisplayName("Проверка перехода в карточку из реестра Все решения о проверке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardReestrAllInspectionDecisions() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(All_INSPECTION_DECISIONS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("snos")
    @AllureId("14047")
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о завершении сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardReestrUvedomleniyaOzaversheniiSnosa() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(DEMOLITIONS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("snos")
    @AllureId("14048")
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о планируемом сносе")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardReestrUvedomleniyaOplaniruemomSnose() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("rs")
    @AllureId("14054")
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardRegisterConstructionLicense() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("rv")
    @AllureId("14052")
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardRegisterObjectOperation() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @Story("rs")
    @AllureId("14050")
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardBuildingPermitRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(BUILDING_PERMIT);
        rinrifPage.goToRegistryCardAndCheck();
    }
}
