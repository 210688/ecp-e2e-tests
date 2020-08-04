package ru.mos.smart.tests.feedback;

import com.codeborne.selenide.Selectors;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.helpers.DriverHelper.openUrlWithAuthorization;
import static ru.mos.smart.helpers.EnvironmentHelper.webUrll;

@Epic("Платформа ЕЦП")
@Feature("Модуль \"feedback\"")
@Story("Проверка отправки уведомления в тех подержку")
@Tag("feedback")
@Tag("ecp")
class SupportRequest extends TestBase {

    @Test
    @Description("Используется тестовый пользователь 89 c нужными правами")
    @DisplayName("Проверка отправки уведомления в тех подержку")
    void SupportRequestForward() {
        step ("Авторизация", ()-> {
            openUrlWithAuthorization("", LOGIN_FEEDBACK, PASSWORD_FEEDBACK); //авторизация в системе
        });
        step("Открытие ссылки Инициировать обращение в техническую поддержку", ()-> open(webUrll));

        step("Заполнение поля Тип обращения", ()-> {
            $(".ng-arrow-wrapper:nth-child(3)").click();
            //$(":focus").setValue("Технические вопросы").click();
        });
        step("Заполнение поля Тема обращения", ()-> {
            $(".ng-input",1).click();
            $(":focus").setValue("Проверка автоматизации теста");
        });
        step("Заполнение поля Ссылка на страницу с ошибкой", ()-> {
            $(By.name("pageUrl")).setValue("https://smart-predprod.mos.ru");
            $(".btn.btn-primary").click();
        });
    }
}

