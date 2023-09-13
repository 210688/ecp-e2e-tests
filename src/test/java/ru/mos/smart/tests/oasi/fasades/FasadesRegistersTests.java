package ru.mos.smart.tests.oasi.fasades;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.data.enums.Registers.OASI_FACADES_PFD;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;


@Epic("OASI (ОАСИ)")
@Feature("FASADES (ОАСИ Фасады)")
public class FasadesRegistersTests extends TestBase {

    @Test
    @DisplayName("Проверка перехода к реестру Проекты изменений фасадов зданий (жилые)")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void openRegisterFasadesZhil() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(OASI_FACADES_PFD);
        $(byText("Проекты изменений фасадов зданий (жилые)")).shouldBe(visible);

    }
}