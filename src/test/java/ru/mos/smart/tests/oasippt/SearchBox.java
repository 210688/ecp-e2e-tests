package ru.mos.smart.tests.oasippt;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.helpers.DriverHelper.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("Модуль \"OASI\"")
@Story("Проверка наличия в витрине \"поля для поиска\"")
@Tag("OASI")
@Tag("ECP")

class SearchBox extends TestBase {
    @Test
    @Description("Проверка наличия в витрине поля для поиска")
    void SearchBox() {
        open("https://smart-predprod.mos.ru/main/#/app/actions");

            $(byText("Войти по логину и паролю")).click();
            $("#username").setValue(LOGIN_s_PRAVAMI);
            $("#password").setValue(PASSWORD_s_PRAVAMI);
            $("#kc-login").click();

        step("Открытие в навигаторе Настройки - Конструктор витрин", ()-> {
                    $(byLinkText("Настройки")).click();
                    $(byLinkText("Конструктор витрин")).click();
                });

        step("Открытие в навигаторе Настройки - Конструктор витрин", ()-> {
            $(By.name("candidateSearchValue")).setValue("Запросы проверки версии Проекта планировки").pressEnter();
            open("https://smart-predprod.mos.ru/extras/#/app/showcase-builder/edit/bd3098c7-6ae7-414d-92d1-012bda1129b5");
                });
    }
}
