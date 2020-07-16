package ru.mos.smart.tests.oasi.oasioo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Epic("ЕЦП тесты")
@Tag("WEB")
class OasiOOTests extends TestBase {
    @Test
    @Description("Cоздание объекта")
    void uiCreateUnicalObject() {
        open("https://smart-predprod.mos.ru/main/#/app/actions");

        $(byText("Войти по логину и паролю")).click();
        $("#username").setValue(LOGIN_MR_TEST);
        $("#password").setValue(PASSWORD_MR_TEST);
        $("#kc-login").click();

        $(By.name("common")).setValue("Создать уникальный объект").pressEnter();
        $(byText("Создать уникальный объект")).click();
        $(byText("Общие сведения")).should(exist);
    }

    @Test
    @Description("Проверка доступности реестра")
    void uiReesTest() {
        open("https://smart-predprod.mos.ru/main/#/app/catalog-registers");

        $(byText("Войти по логину и паролю")).click();
        $("#username").setValue(LOGIN_s_PRAVAMI);
        $("#password").setValue(PASSWORD_s_PRAVAMI);
        $("#kc-login").click();

        $(By.name("candidateSearchValue")).setValue("Решения совещаний по прогграмме \"Мой район\"").pressEnter();
        $("table.search-result-table").$$("tr._ngcontent-c1").shouldHave(size(1));
        $(byText("Решения совещаний по программе \"Мой район\"")).click();
        
    }

    @Test
    @Description("Проверка отсутствия записей в реестре")
    void uiReesNegativeTest() {
        open("https://smart-predprod.mos.ru/main/#/app/catalog-registers");

        $(byText("Войти по логину и паролю")).click();
        $("#username").setValue(LOGIN_s_PRAVAMI);
        $("#password").setValue(PASSWORD_s_PRAVAMI);
        $("#kc-login").click();

        $(By.name("candidateSearchValue")).setValue("Данные реестра отсутствуют").pressEnter();
        $(byText("Ничего не найдено")).should(exist);
    }


    @Test
    @Description("Карта должна открываться (есть права)")
    void uispravochnikipositiveTest() {
        open("https://smart-predprod.mos.ru/main/#/app/dicts/card/BusinessProcessRegistry");

        $(byText("Войти по логину и паролю")).click();
        $("#username").setValue(LOGIN_s_PRAVAMI);
        $("#password").setValue(PASSWORD_s_PRAVAMI);
        $("#kc-login").click();

        $(byText("Реестр бизнес-процессов")).should(exist);
        $("[placeholder=\"Код\"]").setValue("oasioo_PublishingData");
        $(byText("Размещение материалов")).should(exist);
        //$(By.className("ng-scope")).setValue("oasioo_AppointDeveloper").pressEnter();

    }

    @Test
    @DisplayName("negative")
    @Description("Карта не должна открываться (нет прав)") //todo добавить другую учетку
    void uiMapNegativeTest() {
        open("https://smart-predprod.mos.ru/map/#/map;onMode3D=true");

        $(byText("Войти по логину и паролю")).click();
        $("#username").setValue(LOGIN_BES_PRAV);
        $("#password").setValue(PASSWORD_BES_PRAV);
        $("#kc-login").click();

        $(byText("Мои задачи")).should(exist);
        assertTrue(url().contains("main/#/app/tasks"));
    }
}
    /* 1. открываю https://smart-predprod.mos.ru/map/#/map;onMode3D=true
    2. авторизируюсь

    Ожидаю редирект на https://smart-predprod.mos.ru/map/#/map;onMode3D=true
    но редиректит на https://smart-predprod.mos.ru/main/?from=/map/^/map;onMode3D=true#/app/main

    open("https://smart-predprod.mos.ru/map/#/map;onMode3D=true");
       sleep(10000);
       $(byText("Ничео не найдено")).shouldNot(visible);
        assertTrue(url().contains("main/#/app/tasks"));
        candidateSearchValue
        $(byText("Градразвитие (ЭЛМА)")).click();
       $x("//h2[text() ='Градразвитие (ЭЛМА)']").shouldBe(visible);
        $(".pagination").$(byText("2")).click();
     */