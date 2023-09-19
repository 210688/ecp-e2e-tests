package ru.mos.smart.tests.mkaopugd;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
@Feature("ugd mkaopugd")
@Story("mkaopugd-order")
@Component("Информация")
public class MkaopugdRegisterTests extends TestBase {
    MkaopUgdPage mkaopUgdPage = new MkaopUgdPage();

    @Test
    @Description("Проверить корректность открытия и доступность карточек реестра поручений УГД")
    @DisplayName("Проверка наличия карточек и заголовков в реестре")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToRegistryInstructionsUgd() {
        List<String> tableColumnList = Arrays.asList("№ заседания", "№ протокола", "Дата заседания", "Срок", "Тип",
                "Наименование", "Кадастровый номер", "Адрес", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKAOPUGD_ORDER);
        generalPage.validateTableHeadersInRegistry(MKAOPUGD_ORDER, tableColumnList, 10);

    }

    @Test
    @Description("Проверить корректность открытия карточки в реестре поручений УГД")
    @DisplayName("Проверка заголовков и заполнение данных в карточке поручений УГД")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkCardRegisterInstructionsUgd() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKAOPUGD_ORDER);
        generalPage.goToRegistryCard(MKAOPUGD_ORDER);
        mkaopUgdPage.checkingCardTabs();
    }
}
