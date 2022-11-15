package ru.mos.smart.tests.rinrif;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.annotations.ManualMember;
import ru.mos.smart.helpers.utils.RandomUtils;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

public class RinRifReestrTests extends TestBase {

    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Акты проверок")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrAktsProverok() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Акты проверок");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $(".search-result-table tr").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Номер акта",
                    "Дата акта",
                    "Место проведения проверки",
                    "Результат проверки",
                    "Специалист УН",
                    "ЕРКНМ"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Все объекты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrVseObjects() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Все объекты");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Источник финансирования",
                    "Номер дела",
                    "Объект",
                    "Застройщик ",
                    "Почтовый адрес",
                    "Дата начала строительства",
                    "Дата окончания строительства",
                    "Состояние",
                    "Строительный надзор"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Все объекты")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void predosterezheniya() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Все объекты");
        open("/rinrif/nadzor/#/app/nadzor/objectPassport/000c934a-be81-4bc3-9cfc-f850d37d1d19/common");
        $("#button-basic").click();
        $("#dropdown-basic").click();
        switchTo().window(1);
        $(byText("Взять")).click();
        //$(".modal-content").should(visible, Duration.ofSeconds(10)).
        //$x("//button[contains(text(),'Взять')]").should(visible, Duration.ofSeconds(10)).click();
    }


    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Все объекты сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrVseObjectsSnos() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Все объекты сноса");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Дело",
                    "Объект",
                    "Кадастровый номер ЗУ",
                    "Кадастровый номер здания"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Все организации")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrVseOrganization() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Все организации");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Полное наименование организации / Руководитель",
                    "ИНН ",
                    "ОГРН /СНИЛС / Паспорт",
                    "Юр. адрес / Факт. адрес",
                    "Почтовый адрес"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @AllureId("8078")
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Все решения о проверке")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrVseResheniyaOproverke() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Все решения о проверке");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Номер ",
                    "Дата  ",
                    "Объект",
                    "Проверяемая организация",
                    "Вид проверки",
                    "Основание для проверки",
                    "Период проведения",
                    "Ответственный",
                    "Статус",
                    "ЕРКНМ"
            ));
            //$(".search-result-table.table").$$("tr").get(RandomUtils.getRandomInt(3,11)).$$("td").get(1).$("a").click();
            //$(".search-result-table.table").shouldBe(visible);
        });

        step("Доступен список объектов", () -> {
            $(".search-result-table tbody").$$("tr").shouldHave(sizeGreaterThan(0));
            AtomicReference<String> card = new AtomicReference<>("");

            step("Получаем номер существующей карточки", () -> {
                card.set($(".search-result-table.table").$$("tr").get(RandomUtils.getRandomInt(3, 11))
                        .$$("td").get(1).$("a").getText());
            });
            step("Открыть карточку Все решения о проверке", () ->
                    $(byText(card.get())).click());
            step("Проверить, что карточка окрывается", () ->
                    $(byText("Решение о проверке" + card.get())).should(visible));
        });
     /*       open("https://smart-predprod.mos.ru/rinrif/nadzor/#/app/nadzor/inspectionDecision/3be68750-6ba9-4c27-b62a-a0a6f079aaca/common");
            $(".tab-container").$("ul").$$("li").filter(visible).shouldHave(textsInAnyOrder(
                    "Общая информация",
                    "Документы по итогам КНМ",
                    "ЕРКНМ",
                    "Профилактические мероприятия",
                    ","*/
    }

    //TODO $(".table_hover").$$("tr").get(4).$$("td").get(1).$("mdm-runtime.ng-star-inserted")
//+ card.get())
    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Нарушения")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrNarusheniya() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Нарушения");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Номер нарушения",
                    "Дата нарушения",
                    "Наименование работ",
                    "Специалист УН. ФИО"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Постановления")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrPostanovleniya() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Постановления");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Основание для возбуждения дела",
                    "Организация-нарушитель",
                    "Специалист УН. ФИО",
                    "Статья КОАП РФ"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Протоколы")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrProtokoli() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Протоколы");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Дата протокола",
                    "Место совершения нарушения",
                    "Статья КОАП РФ",
                    "Проверяемая организация",
                    "Специалист УН. ФИО"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра ТЗ лаборатории")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrTzLabaratorii() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("ТЗ лаборатории");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Дата проверки ЦЭИИС",
                    "Срок исполнения ТЗ",
                    "Состав работ",
                    "Состав работ утвержден ГБУ"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @AllureId("8084")
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Уведомления о завершении сноса")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrUvedomleniyaOzaversheniiSnosa() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Уведомления о завершении сноса");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Статус",
                    "Номер уведомления",
                    "Дата уведомления",
                    "Плановая дата",
                    "Заявитель",
                    "Исполнитель",
                    "Данные ПГУ"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @Owner("soldatovks")
    @ManualMember("reinform")
    @Layer("web")
    @Epic("Автотесты")
    @DisplayName("Проверка  реестра Уведомления о планируемом сносе")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkReestrUvedomleniyaOplaniruemomSnose() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister();

        reestrPage
                .open("Уведомления о планируемом сносе");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $("table").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Статус",
                    "Номер уведомления",
                    "Дата уведомления",
                    "Плановая дата",
                    "Заявитель",
                    "Исполнитель",
                    "Данные ПГУ"
            ));
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }
}
