package ru.mos.smart.tests.oasirx.crd;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CrdspravochikTests {

    @Test
    @AllureId("3262")
    @DisplayName("Справочники платформы")
    @Story("Справочники")
    @Feature("CRD (Согласование документов)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("crd")})
    void Crdspravochiki() {
        step("Открыть по очереди перечисленные справочники, в поле код ввести crd:", () -> {
            step("Подсистемы");
            step("Типы документов");
            step("Правила разграничения прав доступа к результатам общего поиска");
            step("Реестр бизнес-процессов");
            step("Настройки для витрины Мои задачи");
            step("Навигатор");
        });
    }
}
