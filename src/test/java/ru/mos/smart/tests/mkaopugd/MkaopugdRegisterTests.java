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
@Feature("MKAOPUGD")
@Tags({@Tag("mkaopugd"), @Tag("regres")})
public class MkaopugdRegisterTests extends TestBase {
    MkaopUgdPage mkaopUgdPage = new MkaopUgdPage();

    @Test
    @AllureId("17225")
    @Story("MKAOPUGD_ORDER")
    @Component("Информация")
    @DisplayName("Наличия карточек и заголовков в реестре")
    @Description("Проверить, что корректно открывается реестр и доступность карточек реестра поручений УГД")
    void goToRegistryInstructionsUgd() {
        List<String> tableColumnList = Arrays.asList("№ заседания", "№ протокола", "Дата заседания", "Срок", "Тип",
                "Наименование", "Кадастровый номер", "Адрес", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKAOPUGD_ORDER);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(MKAOPUGD_ORDER, tableColumnList);

    }

    @Test
    @AllureId("17224")
    @Story("MKAOPUGD_ORDER")
    @Component("Информация")
    @DisplayName("Отображение заголовков и заполнение данных в карточке поручений УГД")
    @Description("Проверить, что корректно открываются карточки в реестре поручений УГД")
    void checkCardRegisterInstructionsUgd() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKAOPUGD_ORDER);
        generalPage.goToRegistryCard(MKAOPUGD_ORDER);
        mkaopUgdPage.checkingCardTabs();
    }
}
