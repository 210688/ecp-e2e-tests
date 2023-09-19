package ru.mos.smart.tests.ft;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.enums.Registers.EAIST;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("FT (Электронная приемка по ФТ)")
@Feature("Подсистема неактивна, необходимости в автотестах нет")
public class EaistTests extends TestBase {

    @Test
    @Description("Доступность реестра ЕАИСТ")
    @DisplayName("В реестре присутствуют карточки")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void reestrEaistCanBeOpened() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(EAIST);
    }
}
