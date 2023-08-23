package ru.mos.smart.tests.rrlayer;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Layer("web")
@Epic("RRLAYER (Росреестр)")
@Feature("Поиск записи в реестре Росреестр. Земельные участки")
public class RosreestrRegistersTests extends TestBase {

    @Test
    @DisplayName("02.Поиск Росреестр. Земельные участки")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("rrlayer")})
    void openRosreestrZemUch() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        sidebarPage
                .goToRegister("Росреестр. Земельные участки");

        step("В списке реестров найти и открыть ", () -> {
            $(byName("candidateSearchValue")).setValue("Росреестр. Земельные участки").pressEnter();
            $(byLinkText("Росреестр. Земельные участки")).click();
        });

        step("Реестр открывается, присутствует список", () -> {
            $(byText("Росреестр. Земельные участки")).shouldBe(visible);
        });
    }
}
