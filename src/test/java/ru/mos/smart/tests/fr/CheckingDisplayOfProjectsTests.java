package ru.mos.smart.tests.fr;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("FR (Фонд реновации)")
@Feature("Подсистема неактивна, необходимости в автотестах нет")
@Disabled
// Подсистема неактивна, необходимости в автотестах нет."
public class CheckingDisplayOfProjectsTests extends TestBase {

    @Test
    @DisplayName("Проверка отображения проектов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkingDisplayOfProjects() {
        step("В боковом меню выбрать Проекты", () ->
                $(byLinkText("Проекты"))
                        .click());
        step("Открывается страница Проекты со списком всех проектов в виде таблицы", () -> {
            $(byText("Проекты")).shouldBe(visible);
            $(byText("Номер")).shouldBe(visible);
        });
    }
}
