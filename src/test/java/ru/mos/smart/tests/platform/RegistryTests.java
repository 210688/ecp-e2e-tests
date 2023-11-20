package ru.mos.smart.tests.platform;

import io.qameta.allure.*;
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
    @AllureId("18150")
    @Owner("Soldatov")
    @DisplayName("Наличие списка реестров на странице Реестр")
    @Description("Проверка доступности реестров")
    void CheckRegistryForTaskList() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.checkListInRegistry();
    }

    @Test
    @AllureId("17970")
    @Owner("Soldatov")
    @DisplayName("Проверка открытия реестров")
    @Description("Проверка открытия реестра и наличие карточек")
    void CheckCardInRegistry() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(ORGANIZATION);
    }
}
