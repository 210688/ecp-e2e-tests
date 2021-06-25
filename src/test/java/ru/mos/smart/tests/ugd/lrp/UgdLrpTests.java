package ru.mos.smart.tests.ugd.lrp;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("UGD (УГД)")
@Feature("LRP (Конкурс \"Лучший реализованный проект\")")
class UgdLrpTests extends TestBase {

    @Test
    @AllureId("1063")
    @DisplayName("Проверка открытия формы подачи \"Подать заявку на участие в конкурсе ЛРП\"")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("lrp")})
    void openTheApplicationFormLrp() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToActions();

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
    @AllureId("1062")
    @DisplayName("Проверка открытия формы подачи " +
            "Подать завку на участие в конкурсе ЛРП за стороннюю организацию")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("lrp")})
    void openTheApplicationFormLrpOutsideOrg() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToActions();

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

    @Test
    @DisplayName("Открытие реестра Заявки на участие в конкурсе ЛРП")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("lrp")})
    void openRegisterLrpZayavki() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();

        step("Найти и открыть реестр Заявки на участие в конкурсе ЛРП", () -> {
            $(byName("candidateSearchValue")).setValue("Заявки на участие в конкурсе ЛРП").pressEnter();
            $x("//span[contains(text(),'Заявки на участие в конкурсе ЛРП')]").click();
        });

        step("В реестре присутствуют колонки:", () -> {
            $x("//th[contains(text(),'Номер')]").shouldBe(exist);
            $x("//th[contains(text(),'Дата регистрации')]").shouldBe(exist);
            $x("//th[contains(text(),'Участник конкурса')]").shouldBe(exist);
            $x("//th[contains(text(),'Заявитель')]").shouldBe(exist);
            $x("//th[contains(text(),'Статус')]").shouldBe(exist);
            $x("//th[contains(text(),'Исполнитель')]").shouldBe(exist);
            $x("//th[contains(text(),'Исполнено')]").shouldBe(exist);
        });
    }

    @Test
    @DisplayName("Открытие реестра Мои заявки на участие в конкурсе ЛРП")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("lrp")})
    void openRegisterLrpMoiZayavki() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();

        step("Найти и открыть реестр Мои заявки на участие в конкурсе ЛРП", () -> {
            $(byName("candidateSearchValue")).setValue("Мои заявки на участие в конкурсе ЛРП").pressEnter();
            $x("//span[contains(text(),'Мои заявки на участие в конкурсе ЛРП')]").click();
        });

        step("Открыт реестр Мои заявки на участие в конкурсе ЛРП", () -> {
            $x("//h2[contains(text(),'Мои заявки на участие в конкурсе ЛРП')]").click();
            //TODO добавить проверку
        });
    }
}
