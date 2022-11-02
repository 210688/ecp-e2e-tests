package ru.mos.smart.tests.fr;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Layer("web")
@Epic("FR (Фонд реновации)")
@Feature("Подсистема неактивна, необходимости в автотестах нет")
@Disabled
// Подсистема неактивна, необходимости в автотестах нет."
public class CheckingDisplayOfProjectsTests extends TestBase {

    @Test
    @DisplayName("Проверка отображения проектов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("fr")})
    void checkingDisplayOfProjects() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());

        step("В боковом меню выбрать Проекты", () ->
                $(byLinkText("Проекты"))
                        .click());

        step("Открывается страница Проекты со списком всех проектов в виде таблицы", () -> {
            $(byText("Проекты")).shouldBe(visible);
            $(byText("Номер")).shouldBe(visible);
        });
    }
}
