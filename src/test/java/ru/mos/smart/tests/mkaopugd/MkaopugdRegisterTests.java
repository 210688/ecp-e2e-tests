package ru.mos.smart.tests.mkaopugd;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.enums.Registers.MKAOPUGD_ORDER;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Layer("web")
@Epic("UGD")
@Feature("ugd mkaopugd")
@Story("mkaopugd-order")
@Component("Информация")
public class MkaopugdRegisterTests extends TestBase {

    @Test
    @DisplayName("Реестр поручений УГД")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void registerOfInstructionsUgd() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKAOPUGD_ORDER);
    }

    @Test
    @DisplayName("Карточка Реестра поручений УГД")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void cardOfRegisterUgd() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKAOPUGD_ORDER);
    }
}
