package ru.mos.smart.tests.mrgp;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTER;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("MRGP")
public class mrgpTests extends TestBase {
    @Test
    @DisplayName("Проверка открытия реестра")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("mrgp")})
    void openReestr() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        reestrPage
                .goToRegister("Перечень программ");

        step("Открытие реестра Перечень программ", () -> {
            $(byText("Перечень программ")).shouldBe(visible);
        });
    }
}