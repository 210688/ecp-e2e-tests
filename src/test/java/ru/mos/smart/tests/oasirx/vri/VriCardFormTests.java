package ru.mos.smart.tests.oasirx.vri;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

@Epic("OASI")
@Feature("Оасирх")
public class VriCardFormTests extends TestBase {

    @Test
    @AllureId("17049")
    @Story("VRI")
    @Component("Реестр")
    @DisplayName("Форма карточки: История изменений")
    @Description("Проверить, что форма карточки: История изменений - открывается")
    void changeHistoryTest() {
        sidebarPage
                .goToVri();

        vriPage
                .openFirstCard()
                .cogWheelChoose("История изменений")
                .checkChangeLogShown();
    }

    @Test
    @AllureId("17050")
    @Story("VRI")
    @Component("Реестр")
    @DisplayName("Форма карточки: Процесс")
    @Description("Проверить, что форма карточки: Процесс - открывается")
    void processTest() {
        sidebarPage
                .goToVri();

        vriPage
                .openFirstCard()
                .cogWheelChoose("Процесс")
                .openProcessDiagram();
    }

    @Test
    @AllureId("17051")
    @Story("VRI")
    @Component("Реестр")
    @DisplayName("Форма карточки: Материалы")
    @Description("Проверить, что Форма карточки: Материалы - открывается")
    void materialsTest() {
        sidebarPage
                .goToVri();

        vriPage
                .openFirstCard()
                .clickButton("Материалы")
                .checkMaterialsShown();
    }
}
