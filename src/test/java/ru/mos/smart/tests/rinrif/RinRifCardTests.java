package ru.mos.smart.tests.rinrif;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.RegisterObjectType.*;

@Owner("Soldatov")
@Layer("web")
@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("РинРиф")
@Story("Карточки")

public class RinRifCardTests extends TestBase {

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Акты проверок")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardRegisterActsProverok() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(AKTS_PROVEROK);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardRegisterEnteringObject() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(MODIFICATION_OBJECT_OPERATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Все объекты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardAllObjects() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(ALL_OBJECTS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Все объекты сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardAllObjectsSnos() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(ALL_OBJECTS_SNOS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Все организации")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardAllOrganizations() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(All_ORGANIZATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Все решения о проверке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardReestrAllInspectionDecisions() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(All_INSPECTION_DECISIONS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о завершении сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardReestrUvedomleniyaOzaversheniiSnosa() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(DEMOLITIONS);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о планируемом сносе")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardReestrUvedomleniyaOplaniruemomSnose() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(PLANNED_DEMOLITION_NOTICES);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardRegisterConstructionLicense() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("rinrif")})
    void checkCardRegisterObjectOperation() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardBuildingPermitRegister() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(BUILDING_PERMIT);
        rinrifPage.goToRegistryCardAndCheck();
    }
}
