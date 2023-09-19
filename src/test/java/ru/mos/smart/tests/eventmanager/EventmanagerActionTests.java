package ru.mos.smart.tests.eventmanager;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.pages.EventmanagerPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.EVENTMANAGER;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("UGD")
@Feature("CDP")
@Story("Eventmanager")
@Component("Информация")
@Owner("Soldatov")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class EventmanagerActionTests extends TestBase {
    EventmanagerPage eventmanagerPage = new EventmanagerPage();

    @Test
    @Description("Проверить корректность открытия и доступность карточек реестра Подписки на уведомления о событиях")
    @DisplayName("Проверка наличия карточек и заголовков в реестре Подписки на уведомления о событиях")
    void checkTheCardsInRegistryEventmanager() {
        List<String> tableColumnList = Arrays.asList("Дата создания", "Публикатор", "Подписчик", "Тип события");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(EVENTMANAGER);
        generalPage.validateTableHeadersInRegistry(EVENTMANAGER, tableColumnList, 20);
    }

    @Test
    @Description("Проверить корректность открытия и доступность карточек реестра Подписки на уведомления о событиях")
    @DisplayName("Проверка заголовков и заполнение данных в карточке Подписка на уведомления о событиях")
    void checkTheOpenCardsInRegistryEventmanager() {
        List<String> cardHeadersList = Arrays.asList("Сведения о подписке", "Сведения об авторе подписки");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(EVENTMANAGER);
        generalPage.goToRegistryCard(EVENTMANAGER);
        eventmanagerPage.checkingCardTabs();
        eventmanagerPage.checkingCardHeaders(EVENTMANAGER, cardHeadersList);
    }
}
