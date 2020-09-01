package ru.mos.smart.tests.ugd.oati;

import com.codeborne.selenide.Condition;
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
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;


@Epic("Платформа ЕЦП")
@Feature("UGD (УГД)")
@Story("Создание проекта уведомдения")
@Tag("ugd") @Tag("oati")
class CreateNotificationProjectTests extends TestBase {

    @Test
    @DisplayName("Проверка доступности формы подачи \"Сформировать уведомление о проведении работ, предусмотренных АИП г. Москвы\"")
    void checkingNotificationSubmissionForm() {
        openUrlWithAuthorization("", LOGIN_UGD, PASSWORD_UGD);

        step("Открытие в навигаторе Госуслуги и функции > Возможности", () -> {
            $(byLinkText("Госуслуги и функции")).click();
            $(byLinkText("Возможности")).click();
        });

        step("Выбрать операцию \"Направить новое уведомление ОАТИ о проведении работ\"", () -> {
            $(".form-control").setValue("Направить новое уведомление ОАТИ о проведении работ").pressEnter();
            $(byLinkText("Направить новое уведомление ОАТИ о проведении работ")).click();
        });

        step("Выбрать \"Уведомление ОАТИ о проведении работ, предусмотренных АИП\"", () -> {
            $(".cdp-radio.green checked").click();
            $(byLinkText("Выбрать")).click();
        });

        //В поле «Выберите объект капитального строительства» ввести значение
        //«Москва, НАО, Внуковское, Ленина ул.»
        //из выпадающего списка выбрать ОКС «Москва, НАО, Внуковское, Ленина ул. (пос. ДСК "Мичуринец") уч. 63/65».

        //Нажать на кнопку «Отмена».
        //В появившемся модальном окне нажать на кнопку «Сохранить и выйти» (не нажимать кнопку «Подать»).

        //Проверка: Закрывается ЭФ формирования уведомления,
        //создается карточка уведомления в статусе «Проект уведомления» и задача «Отправить уведомление ОАТИ о проведении работ»
    }
}
