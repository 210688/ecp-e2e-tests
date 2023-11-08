package ru.mos.smart.tests.ugd.upsd;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;
import static ru.mos.smart.data.enums.Registers.UGD_UPSD_APPROVAL_DECISION;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("UGD")
@Feature("UPSD")
@Tags({@Tag("ugd"), @Tag("regres")})
class RegistersUpsdTests extends TestBase {

    @Test
    @AllureId("16980")
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Проверка доступности реестра \"УПСД. Подведомственные организации, утверждающие проектную документацию\"")
    @Description("Проверить, что реестр открывается")
    void checkOpenRegisterUpsd() {
        List<String> tableColumnList = Arrays.asList("Номер документа", "Дата документа", "Тип документа", "Файл документа",
                "Объект", "Организация, утвердившая ПД", "Дата предоставления информации");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_UPSD_APPROVAL_DECISION);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_UPSD_APPROVAL_DECISION, tableColumnList);
    }

    @Test
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Проверка доступности карточек в реестре УПСД. Подведомственные организации, утверждающие проектную документацию")
    @Description("Проверить, что карточка открывается в реестре УПСД. Подведомственные организации, утверждающие проектную документацию, " +
            "наполненность данными ")
    void checkOpenCardInRegisterUpsd() {
        List<String> blockColumnList = Arrays.asList("Сведения об объекте капитального строительства",
                "Сведения об утверждающем документе", "Организация, утвердившая проектную документацию");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_UPSD_APPROVAL_DECISION);
        ugdPage.goToRegistryCard(UGD_UPSD_APPROVAL_DECISION);
        ugdPage.checkBlocksInCard(UGD_UPSD_APPROVAL_DECISION, blockColumnList);
    }
}