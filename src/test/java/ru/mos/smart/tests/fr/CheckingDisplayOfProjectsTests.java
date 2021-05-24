package ru.mos.smart.tests.fr;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("FR (Фонд реновации)")
@Feature("Запуск проекта")
public class CheckingDisplayOfProjectsTests extends TestBase {

    @Test
    @DisplayName("Проверка отображения проектов")
    @Tags({@Tag("fr"),@Tag("predprod"),@Tag("prod")})
    void checkingDisplayOfProjects() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("В боковом меню выбрать Проекты", () ->
                $(byLinkText("Проекты"))
                        .click());

        step("Открывается страница Проекты со списком всех проектов в виде таблицы", () -> {
            $(byText("Проекты")).shouldBe(visible);
            $(byText("Номер")).shouldBe(visible);
        });
    }
}
