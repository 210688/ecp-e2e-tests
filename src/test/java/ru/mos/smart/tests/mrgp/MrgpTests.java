package ru.mos.smart.tests.mrgp;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.enums.Registers.MRGP;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("OASI")
@Feature("MRGP")
@Tags({@Tag("mrgp"), @Tag("regres")})
public class MrgpTests extends TestBase {

    @Test
    @AllureId("17082")
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Проверка открытия реестра")
    @Description("Проверить, что открывается реестр - Перечень программ")
    void openReestr() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(MRGP);

        step("Открытие реестра Перечень программ", () -> {
            $(byText("Перечень программ")).shouldBe(visible);
        });
    }
}