/*
package ru.mos.smart.tests.rinrif;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Epic("ИАИС РИН")
@Feature("RINRIF")
public class RinRifApplicationTest extends TestBase {

    @Test
    @DisplayName("Проверка перехода в карточку заявления")
    @Description("Проверить, что открывается карточка заявления")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void applicationCard() {
        java.lang.String randomTestId = "Заявление о выдаче разрешения на строительство № 09-З-748/22-(0)-0 от 26.12.2022  Плановая дата: 30.12.2022 ";
        sidebarPage.goToTasks();
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        $("#commonino").should(visible);
    }
}
*/
