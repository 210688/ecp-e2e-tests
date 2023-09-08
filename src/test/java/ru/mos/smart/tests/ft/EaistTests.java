package ru.mos.smart.tests.ft;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTERS;

@Layer("web")
@Epic("FT (Электронная приемка по ФТ)")
@Feature("Подсистема неактивна, необходимости в автотестах нет")
@Disabled
// Подсистема неактивна, необходимости в автотестах нет."
public class EaistTests extends TestBase {

    @Test
    @AllureId("5265")
    @DisplayName("Проверка реестров ЕАИСТ")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ft")})
    void reestrEaistCanBeOpened() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage
                .goToRegister("ЕАИСТ");

        step("В поисковой строке ввести ЕАИСТ", () -> {
            $(byName("candidateSearchValue")).setValue("ЕАИСТ").pressEnter();
        });

        step("Найдены реестры", () -> {
            $(byText("Реестр заказчиков ЕАИСТ")).shouldBe(visible);
            $(byText("Реестр контрактов ЕАИСТ")).shouldBe(visible);
            $(byText("Реестр поставщиков ЕАИСТ")).shouldBe(visible);
            $(byText("Реестр этапов контрактов ЕАИСТ")).shouldBe(visible);
        });
    }
}
