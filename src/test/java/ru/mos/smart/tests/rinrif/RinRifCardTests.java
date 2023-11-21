package ru.mos.smart.tests.rinrif;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.data.enums.HeaderTableRinRif;
import ru.mos.smart.tests.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.HeaderTableRinRif.*;
import static ru.mos.smart.data.enums.Registers.*;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("ИАИС РИН")
@Feature("RINRIF")
@Tags({@Tag("rinrif"), @Tag("regres")})
public class RinRifCardTests extends TestBase {

    @Test
    @AllureId("17008")
    @Owner("Soldatov")
    @Story("NADZOR")
    @DisplayName("Корректность открытия и доступность карточки реестра Акты проверок")
    @Description("Проверка корректности открытия карточки 'Акты проверок', " +
            "убедится в наличии заголовков и наличии заполненных данных в этой карточке.")
    void checkCardRegisterActsProverok() {
        List<String> blocksList = new ArrayList<>(Arrays.asList("Общая информация", "ЕРКНМ", "", "", "Общие сведения"));
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(INSPECTIONACT);
        rinrifPage.goToRegistryCard(INSPECTIONACT);
        rinrifPage.checkAvailabilityHeadersInCard(INSPECTIONACT, blocksList);
    }

    @Test
    @AllureId("17011")
    @Owner("Soldatov")
    @Story("RV")
    @DisplayName("Корректность открытия и доступность карточки реестра Внесение изменений в разрешения ввод объекта в эксплуатацию")
    @Description("Проверить, что открывается карточка из реестра - Внесение изменений в разрешения ввод объекта в эксплуатацию " +
            "убедится в наличии  заполненных данных в этой карточке.")
    void checkCardRegisterEnteringObject() {
        List<String> blocksList = new ArrayList<>(Arrays.asList("Общая информация", "Документы", "Результат", "Внешние системы",
                "Процессы", "Общие сведения", "Сведения о ЗУ и объектах", "ТЭП"));
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(RV_CHANGE);
        rinrifPage.goToRegistryCard(RV_CHANGE);
        rinrifPage.checkAvailabilityHeadersInCard(RV_CHANGE, blocksList);
    }

    @Test
    @AllureId("17010")
    @Owner("Soldatov")
    @Story("NADZOR")
    @DisplayName("Переход в карточку из реестра Все объекты")
    @Description("Проверить, что открывается карточка из реестра - Все объекты")
    void checkCardAllObjects() {
        List<String> blocksList = Arrays.asList("Паспорт", "Документы МГСН", "Профилактические мероприятия", "", "");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(OBJECTPASSPORT);
        rinrifPage.goToRegistryCard(OBJECTPASSPORT);
        rinrifPage.checkAvailabilityHeadersInCard(OBJECTPASSPORT, blocksList);
    }

    @Test
    @AllureId("17007")
    @Owner("Soldatov")
    @Story("NADZOR")
    @DisplayName("Переход в карточку из реестра Все организации")
    @Description("Проверить, что открывается карточка из реестра - Все организации")
    void checkCardAllOrganizations() {
        List<String> blocksList = Arrays.asList("Общие сведения", "Организации", "Представленные документы");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(ORGANIZATION);
        rinrifPage.goToRegistryCarr(ORGANIZATION);

    }

    @Test
    @AllureId("17004")
    @Owner("Soldatov")
    @Story("NADZOR")
    @DisplayName("Переход в карточку из реестра Все решения о проверке")
    @Description("Проверить, что открывается карточка из реестра - Все решения о проверке")
    void checkCardReestrAllInspectionDecisions() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(INSPECTIONDECISION);
    }

    @Test
    @AllureId("17002")
    @Owner("Soldatov")
    @Story("SNOS")
    @DisplayName("Переход в карточку из реестра Уведомления о завершении сноса")
    @Description("Проверить, что открывается карточка из реестра - Уведомления о завершении сноса")
    void checkCardReestrUvedomleniyaOzaversheniiSnosa() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(SNOS_FINISH);
        rinrifPage.goToRegistryCard(SNOS_FINISH);
    }

    @Test
    @AllureId("17009")
    @Owner("Soldatov")
    @Story("SNOS")
    @DisplayName("Переход в карточку из реестра Уведомления о планируемом сносе")
    @Description("Проверить, что открывается карточка из реестра - Уведомления о планируемом сносе")
    void checkCardReestrUvedomleniyaOplaniruemomSnose() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(SNOS_PLAN);
        rinrifPage.goToRegistryCard(SNOS_PLAN);
    }

    @Test
    @AllureId("17005")
    @Owner("Soldatov")
    @Story("RS")
    @DisplayName("Переход в карточку из реестра Внесение изменений в разрешения на строительство")
    @Description("Проверить, что открывается карточка из реестра - Внесение изменений в разрешения на строительство")
    void checkCardRegisterConstructionLicense() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(RS_CHANGE);
        rinrifPage.goToRegistryCard(RS_CHANGE);
    }

    @Test
    @AllureId("17006")
    @Owner("Soldatov")
    @Story("RV")
    @DisplayName("Переход в карточку из реестра Разрешения на ввод объекта в эксплуатацию")
    @Description("Проверить, что открывается карточка из реестра - Разрешения на ввод объекта в эксплуатацию")
    void checkCardRegisterObjectOperation() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(RV_RV);
        rinrifPage.goToRegistryCard(RV_RV);
    }

    @Test
    @AllureId("17003")
    @Owner("Soldatov")
    @Story("RS")
    @DisplayName("Переход в карточку из реестра Разрешения на строительство")
    @Description("Проверить, что открывается карточка из реестра - Разрешения на строительство")
    void checkCardBuildingPermitRegister() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(RS_RS);
        rinrifPage.goToRegistryCard(RS_RS);
    }

    @Test
    @AllureId("18076")
    @Owner("Soldatov")
    @Story("RS")
    @DisplayName("Проверка карточки на открытие вкладок в реестре Разрешения на строительство")
    @Description("Проверить, что вкладки открываются и отображаются элементы")
    void verifyTabsOpenAndPresenceOfElements() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(RS_RS);
        rinrifPage.goToRegistryCard(RS_RS);
        rinrifPage.checkDataTabsDocuments();
    }

    @Test
    @AllureId("17621")
    @Owner("Soldatov")
    @Story("IZS")
    @DisplayName("Переход в карточку из реестра ИЖС. Уведомление о завершении строительства")
    @Description("Проверить, что открывается карточка из реестра - ИЖС. Уведомление о завершении строительства " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryIzsZav() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "Документы", "Результат", "Внешние системы",
                "Процессы", "Общие сведения", "Сведения о ЗУ и объекте");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(IZS_ZAV);
        rinrifPage.goToRegistryCard(IZS_ZAV);
        rinrifPage.checkAvailabilityHeadersInCard(IZS_ZAV, cardHeaders);
    }

    @Test
    @AllureId("17620")
    @Owner("Soldatov")
    @Story("IZS")
    @DisplayName("Перейти в карточку из реестра ИЖС. Уведомление о планируемом строительстве")
    @Description("Проверить, что открывается карточка из реестра - ИЖС. Уведомление о планируемом строительстве " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardInRegistryIzsPlan() {
        HeaderTableRinRif[] expectedHeaders = {
                GENERAL_INFORMATION_HEADER, DOCUMENTS_HEADER, RESULT_HEADER, EXTERNAL_SYSTEMS_HEADER,
                PROCESS_HEADER, GENERAL_DATA, INFORMATION_ZU_AND_OBJECTS
        };
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(IZS_PLAN);
        rinrifPage.checkPresenceCardInRegistry(IZS_PLAN);
        rinrifPage.goToRegistryCard(IZS_PLAN);
        rinrifPage.checkInformationTheTab();
        rinrifPage.verifyCardHeader(expectedHeaders);
    }

    @Test
    @AllureId("17619")
    @Owner("Soldatov")
    @Story("IZS")
    @DisplayName("Перейти в карточку из реестра ИЖС. Уведомление об изменении в строительстве")
    @Description("Проверить, что открывается карточка из реестра - ИЖС. Уведомление об изменении в строительстве " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardInRegistryIzsChange() {
        HeaderTableRinRif[] expectedHeaders = {
                GENERAL_INFORMATION_HEADER, DOCUMENTS_HEADER, RESULT_HEADER, EXTERNAL_SYSTEMS_HEADER,
                PROCESS_HEADER, GENERAL_DATA, INFORMATION_ZU_AND_OBJECTS
        };

        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(IZS_CHANGE);
        rinrifPage.checkPresenceCardInRegistry(IZS_CHANGE);
        rinrifPage.goToRegistryCard(IZS_CHANGE);
        rinrifPage.checkInformationTheTab();
        rinrifPage.verifyCardHeader(expectedHeaders);
    }

    @Test
    @AllureId("17847")
    @Owner("Soldatov")
    @Story("NADZOR")
    @DisplayName("Перейти в карточку из реестра Все объекты сноса")
    @Description("Проверить, что открывается карточка из реестра - Все объекты сноса " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryObjectPassportSnos() {
        List<String> cardHeaders = Arrays.asList("Паспорт", "Документы МГСН", "", "", "");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(OBJECTPASSPORT_SNOS);
        rinrifPage.goToRegistryCard(OBJECTPASSPORT_SNOS);
        rinrifPage.checkAvailabilityHeadersInCard(OBJECTPASSPORT_SNOS, cardHeaders);
    }

    @Test
    @AllureId("17850")
    @Owner("Soldatov")
    @Story("NADZOR")
    @DisplayName("Переход в карточку из реестра нарушения")
    @Description("Проверить, что открывается карточка из реестра - нарушения " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryViolations() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "", "");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(VIOLATION);
        rinrifPage.goToRegistryCard(VIOLATION);
        rinrifPage.checkAvailabilityHeadersInCard(VIOLATION, cardHeaders);
    }

    @Test
    @AllureId("17849")
    @Owner("Soldatov")
    @Story("NADZOR")
    @DisplayName("Переход в карточку из реестра постановления")
    @Description("Проверить, что открывается карточка из реестра - постановления " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryPostanovlenie() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(POSTANOVLENIE);
        rinrifPage.goToRegistryCard(POSTANOVLENIE);
    }

    @Test
    @AllureId("17851")
    @Owner("Soldatov")
    @Story("NADZOR")
    @DisplayName("Переход в карточку из реестра протоколы")
    @Description("Проверить, что открывается карточка из реестра - протоколы " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryProtocols() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "", "");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(PROTOCOL);
        rinrifPage.goToRegistryCard(PROTOCOL);
        rinrifPage.checkAvailabilityHeadersInCard(PROTOCOL, cardHeaders);
    }

    @Test
    @AllureId("17848")
    @Owner("Soldatov")
    @Story("NADZOR")
    @DisplayName("Переход в карточку из реестра ТЗ лаборатории")
    @Description("Проверить, что открывается карточка из реестра - ТЗ лаборатории " +
            "убедится в наличии заголовков и данных в карточке.")
    void checkCardRegistryTzLabaratorii() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "", "");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(TZ_LABORATORIES);
        rinrifPage.goToRegistryCard(TZ_LABORATORIES);
        rinrifPage.checkAvailabilityHeadersInCard(TZ_LABORATORIES, cardHeaders);
    }
}
