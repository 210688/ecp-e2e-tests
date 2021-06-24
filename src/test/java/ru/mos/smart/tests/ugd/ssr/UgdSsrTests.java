package ru.mos.smart.tests.ugd.ssr;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.*;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class UgdSsrTests extends TestBase {
    @Test
    @AllureId("1141")
    @DisplayName("Проверка доступности реестра ССР. Реестр отселяемых домов")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void ugdSsrRealEstateCatalogTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("ССР. Реестр отселяемых домов");

        step("Реестр содержит по умолчанию колонки:", () -> {
            $("table").$$("th").shouldHave(textsInAnyOrder(
                    "UNOM",
                    "Адрес",
                    "Номер дома",
                    "Административный округ",
                    "Год постройки",
                    "Скоро начнется переселение дома",
                    "Статус обогащения",
                    "Дата обогащения",
                    "Количество SsoId",
                    "Количество квартир"));
        });
    }

    @Test
    @AllureId("2557")
    @DisplayName("Проверка доступности реестра ССР. Реестр жителей")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void ugdSsrPersonCatalogTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("ССР. Реестр жителей");

        step("Реестр содержит по умолчанию колонки:", () -> {
            $("table").$$("th").shouldHave(textsInAnyOrder(
                    "Фамилия, имя, отчество",
                    "Дата рождения",
                    "Адрес отселяемого дома",
                    "Номер квартиры",
                    "Статус обогащения из ПФР",
                    "Дата обогащения из ПФР",
                    "Статус обогащения из ЕЛК",
                    "Дата обогащения из ЕЛК"));
        });
    }

    @Test
    @AllureId("3079")
    @DisplayName("Проверка доступности реестра ССР. Реестр центров информирования по переселению жителей")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void ugdSsrCipCatalog() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("ССР. Реестр центров информирования по переселению жителей");

        step("Реестр содержит по умолчанию колонки:", () -> {
            $("table").$$("th").shouldHave(textsInAnyOrder(
                    "Адрес центра переселения (округ, район)",
                    "Отселяемых домов",
                    "Заселяемых домов",
                    "Дата открытия центра",
                    "Дата закрытия центра",
                    "Статус"));
        });
    }

    @Test
    @AllureId("3080")
    @DisplayName("Проверка доступности реестра АРМ сотрудника Центра информирования по переселению жителей")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void reestrArm() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
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
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void checkOpenReestrSsr() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("ССР. Реестр жителей");
        ReestrPage.gotoFirstCard();

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
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void administrationWorkingDaysTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("Администрирование рабочих дней помощи в переезде");

        step("Отображается реестр Администрирование рабочих дней помощи в переезде", () -> {
            $("h2[_ngcontent-c4]").shouldHave(text("Администрирование рабочих дней помощи в переезде"));
            $(".catalog-showcase-wrapper").$$("tr[_ngcontent-c19]").shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @AllureId("3086")
    @DisplayName("Проверка доступности реестра Реестр заявлений на помощь в переезде")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void shippingApplicationTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("Реестр заявлений на помощь в переезде");

        step("Отображается реестр Реестр заявлений на помощь в переезде", () -> {
            $("h2[_ngcontent-c4]").shouldHave(text("Реестр заявлений на помощь в переезде"));
            $(".catalog-showcase-wrapper").$$("tr[_ngcontent-c19]").shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @AllureId("4128")
    @DisplayName("Проверка возможности подписания договора и акта приема-передачи")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void reestrSigningTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("ССР. Реестр жителей");
        ReestrPage.gotoFirstCard();
        PersonalCard.gotoTab("Возможности");
        PersonalCard.openCapability("Внести сведения о подписании договора");

        PersonalCard.clickOk();

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
            $$("button").findBy(text("Отмена")).click();
            $("app-standard-header").shouldBe(visible);
        });
    }

    @Test
    @AllureId("4129")
    @DisplayName("Проверка возможности выдачи ключей")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void keysIssuanceTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("ССР. Реестр жителей");
        ReestrPage.gotoFirstCard();
        PersonalCard.gotoTab("Возможности");
        PersonalCard.openCapability("Внести сведения о выдаче ключей от новой квартиры");
        PersonalCard.clickOk();

        step("Проверка  перехода в возможность 'Внести сведения о выдаче ключей от новой квартиры'", () -> {
            $("app-standard-form-field[label='Номер акта']").$(".our-mandatory").shouldBe(visible);
            $("app-standard-form-field[label='Дата']").$(".our-mandatory").shouldBe(visible);
            $("app-standard-form-field[label='Акт']").shouldBe(visible).$(".our-mandatory").shouldNotBe(visible);
        });
        step("Нажать на кнопку Отмена", () -> {
            $$("button").findBy(text("Отмена")).click();
            $("app-standard-header").shouldBe(visible);
        });
    }

    @Test
    @AllureId("4130")
    @DisplayName("Проверка возможности освобождения квартиры")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void apartmentsVacatingTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("ССР. Реестр жителей");
        ReestrPage.gotoFirstCard();
        PersonalCard.gotoTab("Возможности");
        PersonalCard.openCapability("Внести сведения об освобождении квартиры");

        step("Проверка  перехода в возможность 'Внести сведения об освобождении квартиры'", () -> {
            $("app-standard-form-field[ng-reflect-label='Номер акта']").$(".our-mandatory").shouldBe(visible);
            $("app-standard-form-field[ng-reflect-label='Дата']").$(".our-mandatory").shouldBe(visible);
        });
        step("Нажать на кнопку Отмена", () -> {
            $$("button").findBy(text("Отмена")).click();
            $("app-standard-header").shouldBe(visible);
        });
    }

    @Test
    @AllureId("4131")
    @DisplayName("Проверка открытия возможности Инициация процесса начала переселения")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void processInitiatingTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToActions();
        ActionsPage.searchAction("Инициация процесса начала переселения");

        step("В модальном окне нажать на кнопку Взять", () ->
                $(".modal-content").$(byText("Взять")).click());
        step("Проверка  перехода в возможность 'Инициация процесса начала переселения'", () -> {
            $x("//label[contains(text(),'Дата начала переселения')]").$(".our-mandatory").shouldBe(visible);
            $x("//label[contains(text(),'Письмо о начале переселения от')]").$(".our-mandatory").shouldBe(visible);
            $x("//label[contains(text(),'Номер')]").$(".our-mandatory").shouldBe(visible);
            $x("//h3[text()='Заселяемые дома']").shouldBe(visible);
            $x("//h3[text()='Принять решение']").shouldBe(visible);
            $x("//button[contains(text(),'Инициировать')]").shouldBe(visible);
            $x("//span[contains(text(),'Сохранить')]").shouldBe(visible);
            $x("//button[contains(text(),'Отмена')]").shouldBe(visible);
        });
        step("Нажать на кнопку Добавить дом/а", () -> {
            $x("//button[text()='Добавить дом/а']").click();
            $x("//button[contains(text(),'Выбрать заселяемый дом')]").shouldBe(visible);
            $x("//button[contains(text(),'Добавить отселяемые дома')]").shouldBe(visible);
            $x("//button[contains(text(),'Сохранить данные переселения')]").shouldBe(visible);
            $x("//button[contains(text(),'Отмена')]").shouldBe(visible);
        });
        step("Нажать на кнопку Отмена", () -> {
            $x("//button[contains(text(),'Отмена')]").click();
            $(".modal-content").$(byText("Отмена")).shouldBe(visible);
        });
        step("В модальном окне нажать на кнопку Закрыть", () ->
                $(".modal-content").$(byText("Закрыть")).click());

        step("Нажать на кнопку Отмена", () -> {
            $x("//button[contains(text(),'Отмена')]").click();
            $(byText("Все задачи")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("4132")
    @DisplayName(" Проверка открытия возможности Инициировать обогащения данных отселяемых домов из ДГИ")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void dgiPersonEnrichmentTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToActions();
        ActionsPage.searchAction("Инициировать обогащения данных отселяемых домов из ДГИ");

        step("Проверка  перехода в возможность 'Инициировать обогащения данных отселяемых домов из ДГИ'", () -> {
            $x("//h3[text()='Отселяемые дома']").shouldBe(visible);
            $x("//h3[text()='Принять решение']").shouldBe(visible);
            $x("//button[contains(text(),'Отмена')]").shouldBe(visible);
            $x("//button[contains(text(),'Инициировать')]").shouldHave(attribute("disabled"));
        });
        step("Нажать на кнопку Добавить дом/а", () -> {
            $x("//button[text()='Добавить дома/а']").click();
            $(".modal-header").shouldHave(text("Выберите отселяемые дома"));
            $("input[placeholder='УНОМ или адрес']").shouldBe(visible);
            $(".modal-content").$$("button").shouldHave(textsInAnyOrder(
                    "Найти",
                    "Очистить",
                    "Отмена",
                    "Выбрать",
                    "Предыдущая",
                    "Следующая"));
            $(".modal-content").$("th", 1).shouldHave(text("UNOM"));
            $(".modal-content").$("th", 2).shouldHave(text("Адрес"));

            ElementsCollection addressesTable = $(".modal-content").$$("tbody tr").snapshot();

            addressesTable.shouldHave(sizeGreaterThan(0));
            for (SelenideElement address : addressesTable) {
                address.$(byName("selectedItem")).shouldBe(visible);
            }
        });
        step("В модальном окне нажать на кнопку Отмена", () -> {
            $(".modal-content").$(byText("Отмена")).click();
            $(".modal-content").shouldNotBe(visible);
        });
        step("Нажать на кнопку Отмена", () -> $x("//button[text()='Отмена']").click());
    }

    @Test
    @AllureId("4266")
    @DisplayName("Проверка открытия дашборда 'Оперативный мониторинг за ходом переселения'")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void ssrChessboardTest() {
        String address = "город Москва, улица Госпитальный Вал, дом 3 " +
                "(УНОМ: 31354, Центральный административный округ, муниципальный округ Басманный)";
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.gotoChessboard();

        step("Проверка  перехода в Единую витрину данных", () -> {
            $(".tag.res-tag").shouldHave(attribute("class", "tag res-tag active"));
            $(".tag.oks-tag").shouldBe(visible).shouldHave(attribute("class", "tag oks-tag"));
        });
        step("В поисковой строке ввести 31354 и нажать на строку " + address, () -> {
            $("#search").setValue("31354");
            $(".search-dropdown").$(byText(address)).click();
        });
        step("Проверка, что отображаются данные по отселяемому дому", () -> {
            $(".house-card").shouldBe(visible);
            $$(".entrance-card").shouldHave(sizeGreaterThan(0));
            $$(".tag-text").shouldHave(sizeGreaterThan(0));
            $$(".floor-number").shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @AllureId("4627")
    @DisplayName("Проверка доступности реестра по заявлениям на комиссионный осмотр")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("ssr")})
    @Epic("UGD (УГД)")
    @Feature("SSR (Суперсервис реновации ССР)")
    void commissionInspectionRegisterTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("Реестр заявлений на устранение строительных дефектов");

        step("Найти и открыть реестр Реестр заявлений на устранение строительных дефектов", () -> {
            $("h2").shouldHave(text("Реестр заявлений на устранение строительных дефектов"));
            $("cdp-showcase-builder-search-results-table").$$("td").shouldHave(sizeGreaterThan(0));
        });
    }
}
