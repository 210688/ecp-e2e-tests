package ru.mos.smart.tests.ugd.oati;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;
import static ru.mos.smart.data.enums.Registers.UGD_OATI;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("UGD")
@Feature("Ugd")
@Tags({@Tag("ugd"), @Tag("regres")})
class RegistersUvedomleniaTests extends TestBase {

    @Test
    @AllureId("16981")
    @Story("Oati")
    @Component("Реестры")
    @DisplayName("Открытие реестра")
    @Description("Проверить, что реестр открывается")
    void openRegisterUvedomlenia() {
        ElementsCollection tables = $$(".search-result-table > tbody > tr");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_OATI);
        switchTo().window(1);
        tables.shouldHave(sizeGreaterThanOrEqual(1));
    }
}


