package ru.mos.smart.tests.ugd.lrp;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.annotations.ManualMember;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTERS;

@Layer("web")
@Epic("UGD (УГД)")
@Feature("LRP (Конкурс \"Лучший реализованный проект\")")
@ManualMember("croc")
@Owner("soldatovks")
class UgdLrpTests extends TestBase {

    @Test
    @Story("Госуслуги и функции")
    @Component("Возможности")
    @AllureId("6500")
    @DisplayName("Проверка открытия формы подачи \"Подать заявку на участие в конкурсе ЛРП\"")
    void openTheApplicationFormLrp() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        actionsPage
                .goToActions("Подать заявку на участие в конкурсе ЛРП");
            $(".form-control").setValue("Подать заявку на участие в конкурсе ЛРП").pressEnter();
            $x("//span[contains(text(),'Подать заявку на участие в конкурсе ЛРП')]").click();
        step("Проверка наличия вкладок", () -> {
            $(byText("Выбор участника конкурса")).shouldBe(visible);
            $(byText("Сведения об участнике конкурса")).shouldBe(visible);
            $(byText("Сведения об организации")).shouldBe(visible);
            $(byText("Критерии номинации")).shouldBe(visible);
            $(byText("Загрузка файлов")).shouldBe(visible);
        });
    }

    @Test
    @Story("Госуслуги и функции")
    @Component("Возможности")
    @AllureId("6390")
    @DisplayName("Проверка открытия формы подачи " +
            "Подать завку на участие в конкурсе ЛРП за стороннюю организацию")
    void openTheApplicationFormLrpOutsideOrg() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        actionsPage
                .goToActions("Подать заявку на участие в конкурсе ЛРП");

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
    @Story("Информация")
    @Component("Реестры")
    @AllureId("6366")
    @DisplayName("Открытие реестра Заявки на участие в конкурсе ЛРП")
    void openRegisterLrpZayavki() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        actionsPage
                .goToActions("Подать заявку на участие в конкурсе ЛРП");

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
    @Story("Информация")
    @Component("Реестры")
    @AllureId("6446")
    @DisplayName("Открытие реестра Мои заявки на участие в конкурсе ЛРП")
    void openRegisterLrpMoiZayavki() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister("Мои заявки на участие в конкурсе ЛРП");
            $(byName("candidateSearchValue")).setValue("Мои заявки на участие в конкурсе ЛРП").pressEnter();
            $x("//span[contains(text(),'Мои заявки на участие в конкурсе ЛРП')]").click();
        step("Открыт реестр Мои заявки на участие в конкурсе ЛРП", () -> {
            $x("//h2[contains(text(),'Мои заявки на участие в конкурсе ЛРП')]").click();
            //TODO добавить проверку
        });
    }
}
