package ru.mos.smart.tests.fr;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("FR (Фонд реновации)")
@Feature("")
@Tag("fr")
@Tag("all_tests")
@Tag("prod_tests")
public class CheckingDisplayOfProjectsTests extends TestBase {

    @Test
    @DisplayName("Проверка отображения проектов")
    void checkingDisplayOfProjects() {
        LoginPage.openUrlWithAuthorization("", LOGIN_FR, PASSWORD_FR);

        step("В боковом меню выбрать Проекты", () -> $(byLinkText("Проекты"))
                .click());

        step("Открывается страница Проекты со списком всех проектов в виде таблицы", () -> {
            $(byText("Проекты")).shouldBe(visible);
            $(byText("Номер")).shouldBe(visible);
        });
    }
}
