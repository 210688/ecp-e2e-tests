package ru.mos.smart.tests.mgz;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Epic("MGZ (Мосгорзаказ)")
@Tag("mgz") @Tag("all_test")
class openProjectsCard extends TestBase {

    @Test
    @DisplayName("Открытие карточки проекта МГЗ")
    void openProjectsCard() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);

        step("В боковом меню открыть вкладку \"Проекты\"", () -> {
            open("/mgz/#/app/projects/list");
        });

        step("В строке поиска ввести название проекта", () -> {
            $(byName("value")).setValue("Тестовый").pressEnter();
        });

        step("Открыть карточку нужного проекта", () -> {
            $(byText("Тестовый проект")).click();
        });

        step("Проверка, что карточка открылась", () -> {
            $(byText("Тестовый проект")).shouldBe(visible);
        });
    }
}
