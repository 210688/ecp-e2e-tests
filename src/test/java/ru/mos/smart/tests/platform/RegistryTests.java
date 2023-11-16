package ru.mos.smart.tests.platform;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.enums.Registers.ORGANIZATION;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("Регрессионные тесты платформы (функционал)")
@Feature("Работа с реестрами")
@Tag("regressing")
public class RegistryTests extends TestBase {

    @Test
    @DisplayName("Наличие списка реестров на странице Реестр")
    @Description("Проверка доступности реестров")
    void CheckRegistryForTaskList() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.checkListInRegistry();
    }

    @Test
    @AllureId("17970")
    @DisplayName("Проверка открытия реестров")
    @Description("Проверка открытия реестра и наличие карточек")
    void CheckCardInRegistry() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(ORGANIZATION);
    }
}
