package ru.mos.smart.tests.oasi.blago;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.OASI_BLAGO_PRO;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("OASI")
@Feature("OASI")
@Story("Blago")
public class BlagoRegistersTests extends TestBase {

    @Test
    @AllureId("17079")
    @DisplayName("Проверка наличия реестров")
    @Description("Проверить, что реестр Проекты благоустройства - открывается ")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingBlagoRegisters() {
        List<String> columnNames = Arrays.asList("Номер ОАСИ", "Дата", "Адрес", "Плановая дата",
                "Объект", "Статус", "Ответственный исполнитель");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(OASI_BLAGO_PRO);
        //generalPage.checkTableFilter(OASI_BLAGO_PRO, 20, columnNames);

    }
}
