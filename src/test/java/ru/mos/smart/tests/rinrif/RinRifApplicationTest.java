package ru.mos.smart.tests.rinrif;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

public class RinRifApplicationTest extends TestBase {

    @Test
    @DisplayName("Проверка перехода в карточку заявления")
    @Epic("Автотесты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("regres"), @Tag("rinrif")})
    void applicationCard() {
        String randomTestId = "Заявление о выдаче разрешения на строительство № 09-З-748/22-(0)-0 от 26.12.2022  Плановая дата: 30.12.2022 ";
        //mkapmiiPage.createTask(randomTestId);
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        sidebarPage.goToTasks();
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        //rinrifPage.gotoCard();
        $("#commonino").should(visible);
    }
}
