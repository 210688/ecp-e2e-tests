package ru.mos.smart.tests.eventmanager;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
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

    @Test
    @DisplayName("Проверка доступности реестра Подписки на уведомления о событиях")
    void checkingEventmanagerReestr() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(EVENTMANAGER);
        step("Проверить, что открывается  реестр Подписки на уведомления о событиях", () -> {
            $(byText("Подписки на уведомления о событиях")).shouldBe(visible);
        });
    }
}
