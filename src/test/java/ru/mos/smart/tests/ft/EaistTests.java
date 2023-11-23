package ru.mos.smart.tests.ft;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.enums.Registers.EAIST;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("OASI")
@Feature("FT")
public class EaistTests extends TestBase {

    @Test
    @AllureId("17112")
    @DisplayName("В реестре присутствуют карточки")
    @Description("Проверить, что присутствуют карточки в реестре")
    void reestrEaistCanBeOpened() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(EAIST);
    }
}
// Подсистема не активна