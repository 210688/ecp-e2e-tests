package ru.mos.smart.tests.oasirx.vri;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

@Epic("OASI")
@Feature("ОАСИРХ")
@Story("vri")
@Component("Реестр")
public class VriCardFormTests extends TestBase {

    @Test
    @AllureId("17049")
    @DisplayName("Форма карточки: История изменений")
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
    @DisplayName("Форма карточки: Процесс")
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
    @DisplayName("Форма карточки: Материалы")
    void materialsTest() {
        sidebarPage
                .goToVri();

        vriPage
                .openFirstCard()
                .clickButton("Материалы")
                .checkMaterialsShown();
    }
}
