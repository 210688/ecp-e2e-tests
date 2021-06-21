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
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
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

        step("Найти и открыть реестр ССР. Реестр жителей", () -> {
            $(byName("candidateSearchValue")).setValue("ССР. Реестр жителей").pressEnter();
            $(byText("ССР. Реестр жителей")).click();
        });

        step("Открыть просмотровую форму карточки жителя", () -> {
            $("showcase-builder-runtime a").click();
            switchTo().window(1);
        });

        step("Отображается просмотровая форма карточки жителя со следующими вкладками: ", () -> {
            step("Общая информация, в которую входят вкладки:", () -> {
                step("Базовые сведения", () ->
                        $("app-person-card-general-base").$$("div[_ngcontent-c18]").shouldHave(sizeGreaterThan(0)));
                step("Расширенные сведения", () -> {
                    $(byText("Расширенные сведения")).click();
                    $("app-person-card-general-external").$$("div[_ngcontent-c19]").shouldHave(sizeGreaterThan(0));
                });

            });
            step("Сведения о переселении, в которую входят вкладки:", () -> {
                step("Основные сведения", () -> {
                    $(byText("Сведения о переселении")).click();
                    $("app-person-card-resettlement-general").$$("div[_ngcontent-c22]").shouldHave(sizeGreaterThan(0));
                });
                step("Письма с предложениями, согласия и отказы", () -> {
                    $(byText("Письма с предложениями, согласия и отказы")).click();
                    $("app-resettlement-letters").$$("div[_ngcontent-c29]").shouldHave(sizeGreaterThan(0));
                });
                step("Договоры", () -> {
                    $(byText("Договоры")).click();
                    $("app-person-card-resettlement-contracts").$$("div[_ngcontent-c24]").shouldHave(sizeGreaterThan(0));
                });
                step("Техническая информация с вкладками:", () -> {
                    step("Информирование жителей", () -> {
                        $$(".nav-link").findBy(text("Техническая информация")).click();
                        $("app-person-card-resettlement-tech-info").$$("div[_ngcontent-c25]").shouldHave(sizeGreaterThan(0));
                    });
                    step("Межведомственные взаимодействия", () -> {
                        $(byText("Межведомственные взаимодействия")).click();
                        $("app-person-card-resettlement-tech-info").$$("div[_ngcontent-c25]").shouldHave(sizeGreaterThan(0));
                    });
                });
                step("Акты по дефектам", () -> {
                    $(byText("Устранение дефектов")).click();
                    $(byText("Акты по дефектам")).click();
                    $("app-person-card-defect-acts").$("div.defect-acts").shouldBe(visible);
                });
            });
            step("Возможности", () -> {
                $$(".nav-link").findBy(text("Возможности")).click();
                $("app-person-card-actions").$$("div[_ngcontent-c6]").shouldHave(sizeGreaterThan(0));
            });
            step("Журнал изменений", () -> {
                $(byText("Журнал изменений")).click();
                $("app-standard-changelog").$$("div[_ngcontent-c27]").shouldHave(sizeGreaterThan(0));
            });
        });
    }

    @Test
    @AllureId("3085")
    @DisplayName("Проверка доступности реестра Администрирование рабочих дней помощи в переезде")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("allModules"), @Tag("regress")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void administrationWorkingDaysTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.reestrPage();

        step("Найти и открыть реестр Администрирование рабочих дней помощи в переезде", () -> {
            $(byName("candidateSearchValue")).setValue("Администрирование рабочих дней помощи в переезде").pressEnter();
            $(byText("Администрирование рабочих дней помощи в переезде")).click();
        });
        step("Отображается реестр Администрирование рабочих дней помощи в переезде", () -> {
            $("h2[_ngcontent-c4]").shouldHave(text("Администрирование рабочих дней помощи в переезде"));
            $(".catalog-showcase-wrapper").$$("tr[_ngcontent-c19]").shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @AllureId("3086")
    @DisplayName("Проверка доступности реестра Реестр заявлений на помощь в переезде")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("allModules"), @Tag("regress")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void shippingApplicationTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.reestrPage();

        step("Найти и открыть реестр Реестр заявлений на помощь в переезде", () -> {
            $(byName("candidateSearchValue")).setValue("Реестр заявлений на помощь в переезде").pressEnter();
            $(byText("Реестр заявлений на помощь в переезде")).click();
        });

        step("Отображается реестр Реестр заявлений на помощь в переезде", () -> {
            $("h2[_ngcontent-c4]").shouldHave(text("Реестр заявлений на помощь в переезде"));
            $(".catalog-showcase-wrapper").$$("tr[_ngcontent-c19]").shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @AllureId("4128")
    @DisplayName("Проверка возможности подписания договора и акта приема-передачи")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("allModules"), @Tag("regress")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void reestrSigningTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.reestrPage();

        step("Открыть реестр ССР. Реестр жителей", () -> {
            $(byName("candidateSearchValue")).setValue("ССР. Реестр жителей").pressEnter();
            $(byText("ССР. Реестр жителей")).click();
        });
        step("Открыть карточку жителя, нажав на поле с ФИО жителя", () -> {
            $("showcase-builder-runtime a").click();
            switchTo().window(1);
        });
        step("Перейти на вкладку Возможности", () -> {
            $("app-standard-header").shouldBe(visible);
            $$(".nav-link").findBy(text("Возможности")).click();
        });
        step("Открыть возможность Внести сведения о подписании договора", () -> {
            $$("td[_ngcontent-c6]").findBy(text("Внести сведения о подписании договора")).click();
        });
        step("В модальном окне с предупреждением нажать на кнопку Ок", () -> {
            $(".modal-content button").click();
        });
        step("Проверка  перехода в возможность 'Внести сведения о подписании договора'", () ->
                $$(".wrapper-content h3[_ngcontent-c13]").shouldHave(textsInAnyOrder(
                        "Общие сведения",
                        "Сведения о принятых заявлениях на согласие/отказ",
                        "Шаг 1. Распечатайте и подпишите договор",
                        "Шаг 2. Распечатайте и подпишите акт приема-передачи жилого помещения",
                        "Шаг 3. Загрузите подписанные документы - договор и акт приема-передачи жилого помещения",
                        "Сведения о собственниках / нанимателях",
                        "Принять решение")));
        step("Активировать чекбокс Акт будет подписан позже", () -> {
            $(byName("actWillBeSignedLater")).$("div.green").click();
            $(byText("Подписанный акт")).$(".our-mandatory").shouldNotBe(visible);
        });
        step("Нажать на кнопку Отмена", () -> {
            $$("button[_ngcontent-c13]").findBy(text("Отмена")).click();
            $("app-standard-header").shouldBe(visible);
        });
    }
}
