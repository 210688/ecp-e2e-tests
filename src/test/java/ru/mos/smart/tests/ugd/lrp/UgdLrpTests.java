package ru.mos.smart.tests.ugd.lrp;


import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("UGD (УГД)")
@Feature("LRP (Конкурс \"Лучший реализованный проект\")")
@Tag("allModules")
@Tag("predprod")
@Tag("prod")
class UgdLrpTests extends TestBase {

    @Test
    @DisplayName("Проверка открытия формы подачи \"Подать заявку на участие в конкурсе ЛРП\"")
    void openTheApplicationFormLrp() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());

        step("Перейти во вкладку Гослуслуги - Возможности", () -> {
            $(byLinkText("Госуслуги и функции")).click();
            $(byLinkText("Возможности")).click();
        });

        step("Найти и выбрать операцию Подать заявку на участие в конкурсе ЛРП", () -> {
            $(".form-control").setValue("Подать заявку на участие в конкурсе ЛРП").pressEnter();
            $x("//span[contains(text(),'Подать заявку на участие в конкурсе ЛРП')]").click();
        });

        step("Проверка наличия вкладок", () -> {
            $(byText("Выбор участника конкурса")).shouldBe(visible);
            $(byText("Сведения об участнике конкурса")).shouldBe(visible);
            $(byText("Сведения об организации")).shouldBe(visible);
            $(byText("Критерии номинации")).shouldBe(visible);
            $(byText("Загрузка файлов")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Проверка открытия формы подачи" +
            "\"Подать завку на участие в конкурсе ЛРП за стороннюю организацию\"")
    void openTheApplicationFormLrpOutsideOrg() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());

        step("Перейти во вкладку Гослуслуги - Возможности", () -> {
            $(byLinkText("Госуслуги и функции")).click();
            $(byLinkText("Возможности")).click();
        });

        step("Найти и выбрать операцию Подать заявку на участие в конкурсе ЛРП за стороннюю организацию", () -> {
            $(".form-control").setValue("Подать заявку на участие в конкурсе ЛРП за стороннюю организацию")
                    .pressEnter();
            $x("//span[contains(text(),'Подать заявку на участие в конкурсе ЛРП за стороннюю организацию')]")
                    .click();
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
