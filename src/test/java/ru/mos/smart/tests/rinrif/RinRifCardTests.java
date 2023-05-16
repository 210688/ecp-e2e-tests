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

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
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
    @DisplayName("Проверка переход в карточку из реестра Акты проверок")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardRegisterActsProverok() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Акты проверок");
        rinrifPage.goToRegistryCardAndCheck();
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardRegisterEnteringObject() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Внесение изменений в разрешения ввод объекта в эксплуатацию");
        rinrifPage.goToRegistryCardAndCheck();
        //rinrifPage.checkRegistryCard(); //"Внесение изменений в разрешение на ввод объекта в эксплуатацию"
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Все объекты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardAllObjects() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все объекты");
        rinrifPage.goToRegistryCardAndCheck();
        rinrifPage.checkTableHeaders("Паспорт");
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Все объекты сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardAllObjectsSnos() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все объекты");
        rinrifPage.goToRegistryCardAndCheck();
        rinrifPage.checkTableHeaders("Паспорт");
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Все организации")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardAllOrganizations() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все организации");
        rinrifPage.goToRegistryCardAndCheck();
        rinrifPage.checkTableHeaders("Общая информация");
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Все решения о проверке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardReestrAllInspectionDecisions() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Все решения о проверке");
        rinrifPage.goToRegistryCardAndCheck();
        rinrifPage.checkTableHeaders("Общие сведения");
        //infoZu
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о завершении сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardReestrUvedomleniyaOzaversheniiSnosa() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Уведомления о завершении сноса");
        rinrifPage.goToRegistryCardAndCheck();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Уведомление о планируемом сносе"));
        //infoZu
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Уведомления о планируемом сносе")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardReestrUvedomleniyaOplaniruemomSnose() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister("Уведомления о планируемом сносе");
        rinrifPage.goToRegistryCardAndCheck();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Прием уведомления о планируемом сносе объекта капитального строительства"));
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Внесение изменений в разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardRegisterConstructionLicense() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(CHANGE_CONSTRUCTION_BUILDING);
        rinrifPage.goToRegistryCardAndCheck();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Внесение изменений в разрешение на строительство"));
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на ввод объекта в эксплуатацию")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardRegisterObjectOperation() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(PERMISSIONS_OBJECT_OPERATION);
        rinrifPage.goToRegistryCardAndCheck();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Выдача разрешения на ввод объекта в эксплуатацию"));
    }

    @Test
    @DisplayName("Проверка перехода в карточку из реестра Разрешения на строительство")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("rinrif")})
    void checkCardBuildingPermitRegister() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToRegister(BUILDING_PERMIT);
        rinrifPage.goToRegistryCardAndCheck();
        rinrifPage.checkTableHeaders("Общая информация");
        $("#commoninfo").shouldHave(text("Выдача разрешения на строительство для объектов капитального строительства"));
    }
}
