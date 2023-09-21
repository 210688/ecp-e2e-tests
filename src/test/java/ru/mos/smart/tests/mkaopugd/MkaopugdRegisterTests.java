package ru.mos.smart.tests.mkaopugd;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.pages.MkaopUgdPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.MKAOPUGD_ORDER;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("UGD")
@Feature("mkaopugd")

@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class MkaopugdRegisterTests extends TestBase {
    MkaopUgdPage mkaopUgdPage = new MkaopUgdPage();

    @Test
    @AllureId("17225")
    @Story("mkaopugd-order")
    @Component("Информация")
    @Description("Проверить корректность открытия и доступность карточек реестра поручений УГД")
    @DisplayName("Проверка наличия карточек и заголовков в реестре")
    void goToRegistryInstructionsUgd() {
        List<String> tableColumnList = Arrays.asList("№ заседания", "№ протокола", "Дата заседания", "Срок", "Тип",
                "Наименование", "Кадастровый номер", "Адрес", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKAOPUGD_ORDER);
        generalPage.validateTableHeadersInRegistry(MKAOPUGD_ORDER, tableColumnList, 10);

    }

    @Test
    @AllureId("17224")
    @Story("mkaopugd-order")
    @Component("Информация")
    @Description("Проверить корректность открытия карточки в реестре поручений УГД")
    @DisplayName("Верификация присутствия заголовков таблицы  и заполнение данных в карточке поручений")
    void checkCardRegisterInstructionsUgd() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKAOPUGD_ORDER);
        generalPage.goToRegistryCard(MKAOPUGD_ORDER);
        mkaopUgdPage.checkingCardTabs();
    }
}
