package ru.mos.smart.tests.ugd.ssr;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class UgdSsrTests extends TestBase {

    @Test
    @AllureId("3080")
    @DisplayName("Проверка доступности реестра АРМ сотрудника Центра информирования по переселению жителей")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void reestrArm() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.reestrPage();
        step("Найти и открыть реестр АРМ сотрудника Центра информирования по переселению жителей", () ->
                $(byText("АРМ сотрудника Центра информирования по переселению жителей")).click());
        step("Реестр содержит по умолчанию такие колонки, как:", () ->
                $("table").$$("th").shouldHave(textsInAnyOrder(
                        "Фамилия, имя, отчество",
                        "Адрес (откуда)",
                        "Адрес (куда)",
                        "Адрес центра информирования",
                        "Статус переселения",
                        "Статус проживания",
                        "SsoId",
                        "Есть двойники СНИЛС",
                        "Обогащалась из ДГИ")));
    }

    @Test
    @AllureId("3081")
    @DisplayName("Проверка открытия карточки жителя через реестр ССР. Реестр жителей")
    @Tags({@Tag("predprod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void checkOpenReestrSsr() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.reestrPage();
        step("Найти и открыть реестр ССР. Реестр жителей", () ->
                $(byName("candidateSearchValue")).setValue("ССР. Реестр жителей").pressEnter());
        $(byText("ССР. Реестр жителей")).click();

        step("Открыть просмотровую форму карточки жителя", () ->
                $("input[placeholder='Поиск по ФИО и СНИЛС жителя']").setValue("Анненков Михаил Дмитриевич").pressEnter());
        $(byText("Анненков Михаил Дмитриевич")).click();

        step("Отображается просмотровая форма карточки жителя со следующими вкладками: ", () -> {
            step("Общая информация, в которую входят вкладки:", () -> {
                step("в таблице есть записи", () ->
                        $("app-person-card-general-base").$$("div _ngcontent-c18").should(sizeGreaterThan(0)));
                step("Расширенные сведения");
            });
            step("Сведения о переселении, в которую входят вкладки:", () -> {
                step("Основные сведения");
                step("Письма с предложениями, согласия и отказы");
                step("Договоры");
                step("Техническая информация с вкладками:", () -> {
                    step("Информирование жителей");
                    step("Межведомственные взаимодействия");
                });
                step("Акты по дефектам");
            });
            step("Возможности");
            step("Журнал изменений");
        });
    }
}
