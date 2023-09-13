package ru.mos.smart.tests.oasirx.vri;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("VRI (ВРИ)")
public class VriCardFormTests extends TestBase {

    @Test
    @DisplayName("Форма карточки: История изменений")
    @Story("Работа с реестром и карточкой ВРИ")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void changeHistoryTest() {
        sidebarPage
                .goToVri();

        vriPage
                .openFirstCard()
                .cogWheelChoose("История изменений")
                .checkChangeLogShown();
    }

    @Test
    @DisplayName("Форма карточки: Процесс")
    @Story("Работа с реестром и карточкой ВРИ")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void processTest() {
        sidebarPage
                .goToVri();

        vriPage
                .openFirstCard()
                .cogWheelChoose("Процесс")
                .openProcessDiagram();
    }

    @Test
    @DisplayName("Форма карточки: Материалы")
    @Story("Работа с реестром и карточкой ВРИ")
    @Feature("VRI (ВРИ)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void materialsTest() {
        sidebarPage
                .goToVri();

        vriPage
                .openFirstCard()
                .clickButton("Материалы")
                .checkMaterialsShown();
    }
}
