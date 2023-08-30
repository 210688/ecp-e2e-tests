package ru.mos.smart.tests.rinrif;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeRinRif.*;

@Owner("Soldatov")
@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("РинРиф")
@Story("Карточки")

public class RinRifCardTests extends TestBase {

    @Test
    @AllureId("14049")
    @DisplayName("Проверка перехода в карточку из реестра Акты проверок")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardRegisterActsProverok() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(AKTS_PROVEROK);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14045")
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardRegisterEnteringObject() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14046")
    @DisplayName("Проверка перехода в карточку из реестра Все объекты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardAllObjects() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(ALL_OBJECTS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14046")
    @DisplayName("Проверка перехода в карточку из реестра Все объекты сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardAllObjectsSnos() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(ALL_OBJECTS_SNOS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14051")
    @DisplayName("Проверка перехода в карточку из реестра Все организации")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardAllOrganizations() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(All_ORGANIZATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14053")
    @DisplayName("Проверка перехода в карточку из реестра Все решения о проверке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardReestrAllInspectionDecisions() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(All_INSPECTION_DECISIONS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14047")
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о завершении сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardReestrUvedomleniyaOzaversheniiSnosa() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(DEMOLITIONS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14048")
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о планируемом сносе")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardReestrUvedomleniyaOplaniruemomSnose() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14054")
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardRegisterConstructionLicense() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14052")
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardRegisterObjectOperation() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @AllureId("14050")
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrifCards")})
    void checkCardBuildingPermitRegister() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(BUILDING_PERMIT);
        rinrifPage.goToRegistryCardAndCheck();
    }
}
