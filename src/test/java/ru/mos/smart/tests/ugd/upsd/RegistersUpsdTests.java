package ru.mos.smart.tests.ugd.upsd;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;
import static ru.mos.smart.data.enums.Registers.UGD_UPSD;
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
    void registerUpsdViewing() {
        ElementsCollection tables = $$(".search-result-table > tbody > tr");
        //List<String> tableColumnList = Arrays.asList(); //TODO добавить проверку
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_UPSD);
        tables.shouldHave(sizeGreaterThan(1));
    }
}