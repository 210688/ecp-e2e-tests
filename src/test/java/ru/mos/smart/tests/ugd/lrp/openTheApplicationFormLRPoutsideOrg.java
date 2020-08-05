package ru.mos.smart.tests.ugd.lrp;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
@Feature("Модуль \"UGD\"")
@Story("Проверка открытия формы подачи Подать заявку на участие в конкурсе ЛРП за стороннюю организацию")
@Tag("UGD")
@Tag("LRP")
@Tag("ECP")

class openTheApplicationFormLRPoutsideOrg extends TestBase {
    @Test
    @Description("Проверка открытия формы подачи Подать заявку на участие в конкурсе ЛРП за стороннюю организацию")
    void openTheApplicationFormLRPPoutsideOrg() {
        openUrlWithAuthorization("", LOGIN_UGD, PASSWORD_UGD);

        step("Открытие в навигаторе Мои возможности", () -> {
            //В левом боковом меню выбрать «Госуслуги и функции» > «Возможности»
            $(byLinkText("Госуслуги и функции")).click();
            $(byLinkText("Возможности")).click();
        });

        step("Выбрать операцию Подать заявку на участие в конкурсе ЛРП за стороннюю организацию", () -> {
            //в поисковой строке ввести "Подать заявку на участие в конкурсе ЛРП за стороннюю организацию"
            $(byClassName("form-control")).setValue("Подать заявку на участие в конкурсе ЛРП за стороннюю организацию").pressEnter();

            //выбрать операцию "Подать заявку на участие в конкурсе ЛРП за стороннюю организацию"
            $(byLinkText("Подать заявку на участие в конкурсе ЛРП за стороннюю организацию")).click();
        });

        step("Проверка наличия вкладок", () -> {
            $(byText("Выбор участника конкурса")).shouldBe(visible);
            $(byText("Сведения об участнике конкурса")).shouldBe(visible);
            $(byText("Сведения об организации")).shouldBe(visible);
            $(byText("Критерии номинации")).shouldBe(visible);
            $(byText("Загрузка файлов")).shouldBe(visible);
        });
    }
}
