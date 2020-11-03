package ru.mos.smart.tests.fr;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("FR (Фонд реновации)")
@Feature("Запуск проекта")
@Tag("fr")
public class LaunchProjectTests extends TestBase {

    @Test
    @DisplayName("Создать объект АИП")
    void launchProjectAip() {
        openUrlWithAuthorization("", LOGIN_FR, PASSWORD_FR);

        step("В панели \"Навигатор\" нажать кнопку \"Объекты АИП\"", () -> {
            sleep(10000);
            open("/fr/#/app/aip/list");
        });

        step("В рабочей области витрины нажать на кнопку \"Создать Объект АИП\"", () -> {
            sleep(10000);
            $(byLinkText("Создать объект АИП")).click();
        });

        step("Заполнить поля", () -> {
            sleep(10000);
            $(".form-control").setValue("Тест 03.11");
        });

        step("Нажать на кнопку \"Сохранить\"", () -> {
            sleep(5000);
            $("#submit").click();
        });
    }
}