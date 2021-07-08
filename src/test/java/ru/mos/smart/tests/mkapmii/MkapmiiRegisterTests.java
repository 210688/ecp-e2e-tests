package ru.mos.smart.tests.mkapmii;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.pages.ReestrPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class MkapmiiRegisterTests extends TestBase {
    @Test
    @AllureId("5189")
    @DisplayName("Проверка UI реестр оказания услуг по размещению инженерных изысканий")
    @Tags({@Tag("stage"), @Tag("regress")})
    @Epic("Автотесты")
    @Feature("Реестр и карточка заявления")
    void checkingTheAttributesOfTheRegistry() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        NavigatorPage.goToRegister();
        ReestrPage.open("Реестр оказания услуги по размещению инженерных изысканий");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () -> {
            $(".fa.fa-bars").shouldBe(visible);
            $(".fa.fa-filter").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $(".search-result-table tr").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Номер заявления",
                    "Дата подачи",
                    "Планируемая дата оказания",
                    "Фактическая дата оказания",
                    "Статус",
                    "Решение",
                    "Ответственный",
                    "Заявитель",
                    "Адрес",
                    "Номер ПГУ",
                    "Вид"
            ));
        });
    }

    @Test
    @AllureId("5191")
    @DisplayName("Проверка UI карточки заявления")
    @Tags({@Tag("stage"), @Tag("regress")})
    @Epic("Автотесты")
    @Feature("Реестр и карточка заявления")
    void uiCardTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        NavigatorPage.goToRegister();
        ReestrPage.open("Реестр оказания услуги по размещению инженерных изысканий");
        ReestrPage.gotoFirstCardNoSwitchWindow();
        step("Проверить, что форма озаглавлена Карточка заявления", () ->
                $("h1").shouldHave(text("Карточка заявления")));
        step("Открытая вкладка озаглавлена Сведения о заявлении", () ->
                $(".nav-link.active").shouldHave(text("Сведения о заявлении")));
        step("Проверить наличие нередактируемых полей", () -> {
            $("app-mkapmii-header").$(byText("Дата создания:")).sibling(0).should(matchText("\\d{2}\\.\\d{2}\\.\\d{4}"));
            $("app-mkapmii-header").$(byText("Срок исполнения:")).sibling(0).should(matchText("\\d{2}\\.\\d{2}\\.\\d{4}"));
            $("app-mkapmii-header").$(byText("Исполнитель:")).sibling(0).shouldNotBe(empty);
            $("app-mkapmii-header").$(byText("Вид инженерных изысканий:")).sibling(0).shouldNotBe(empty);
            $("app-mkapmii-header").$(byText("Адрес объекта:")).sibling(0).shouldNotBe(empty);
            $("app-mkapmii-header b").should(matchText("\\W+\\d+\\/\\d+-\\d+"));
            $(".item span").should(matchText("\\d+-\\d+-\\d+-\\d+\\/\\d+"));
        });
        step("Проверить, что область Сведения о заявителе свернута по умолчанию", () ->
                $$(".collapsible-title")
                        .findBy(text("Сведения о заявителе"))
                        .sibling(0).shouldNotBe(visible));
        step("Область Сведения о лице, обеспечившим выполнение инженерных изысканий развернута по умолчанию", () ->
                $$(".collapsible-title")
                        .findBy(text("Сведения о лице, обеспечившим выполнение инженерных изысканий"))
                        .sibling(0).shouldBe(visible));
        step("Область  Сведения о проведенных инженерных изысканиях развернута по умолчанию", () ->
                $$(".collapsible-title")
                        .findBy(text("Сведения о проведенных инженерных изысканиях"))
                        .sibling(0).shouldBe(visible));
        step("Область Предоставленные документы свернута по умолчанию", () ->
                $$(".collapsible-title")
                        .findBy(text("Предоставленные документы"))
                        .sibling(0).shouldNotBe(visible));
        step("Область Схемы сетей для отображения на Сводном плане или на плане подземных сооружений свернута по умолчанию", () ->
                $$(".collapsible-title")
                        .findBy(text("Схемы сетей для отображения на Сводном плане или на плане подземных сооружений"))
                        .sibling(0).shouldNotBe(visible));
        step("Область Иные документы свернута по умолчанию", () ->
                $$(".collapsible-title")
                        .findBy(text("Иные документы"))
                        .sibling(0).shouldNotBe(visible));
        step("Область Способ выдачи результата свернута по умолчанию", () ->
                $$(".collapsible-title")
                        .findBy(text("Способ выдачи результата"))
                        .sibling(0).shouldNotBe(visible));
        step("Содержатся кнопки: В реестр, Выдать на руки", () -> {
            $(".buttons-container").$(byText("В реестр")).shouldBe(visible);
            $(".buttons-container").$(byText("Выдать на руки")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("5190")
    @DisplayName("Проверка основных контролов карточки заявления")
    @Tags({@Tag("stage"), @Tag("regress")})
    @Epic("Автотесты")
    @Feature("Реестр и карточка заявления")
    void mainControlsTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        NavigatorPage.goToRegister();
        ReestrPage.open("Реестр оказания услуги по размещению инженерных изысканий");
        ReestrPage.gotoFirstCardNoSwitchWindow();

        ElementsCollection dataBlocks = $$(".tab-content .collapsible-title");

        step("Проверка наличия блоков данных", () ->
                dataBlocks.shouldHave(sizeGreaterThan(0)));
        step("Проверить скрытие/раскрытие всех блоков данных", () -> {
            for (SelenideElement dataBlock : dataBlocks) {
                if (dataBlock.has(text("Сведения о лице, обеспечившим выполнение инженерных изысканий")) ||
                        dataBlock.has(text("Сведения о проведенных инженерных изысканиях"))) {
                    dataBlock.sibling(0).shouldBe(visible, Duration.ofSeconds(10));
                    dataBlock.click();
                    dataBlock.sibling(0).shouldNotBe(visible, Duration.ofSeconds(10));
                    dataBlock.click();
                    dataBlock.sibling(0).shouldBe(visible, Duration.ofSeconds(10));

                } else {
                    dataBlock.sibling(0).shouldNotBe(visible, Duration.ofSeconds(10));
                    dataBlock.click();
                    dataBlock.sibling(0).shouldBe(visible, Duration.ofSeconds(10));
                    dataBlock.click();
                    dataBlock.sibling(0).shouldNotBe(visible, Duration.ofSeconds(10));
                }
            }
        });
        step("Нажать на кнопку Назад", () ->
                $(".buttons-container").$(byText("Назад")).click());
        step("Проверить, что форма успешно закрывается", () ->
                $("h2").shouldHave(text("Реестр оказания услуги по размещению инженерных изысканий")));
        ReestrPage.gotoFirstCardNoSwitchWindow();
        step("Нажать на кнопку В реестр", () ->
                $(".buttons-container").$(byText("В реестр")).click());
        step("Проверить, что открывается реестр Реестр оказания услуг по размещению инженерных изысканий", () ->
                $("h2").shouldHave(text("Реестр оказания услуги по размещению инженерных изысканий")));
    }

    @Test
    @AllureId("6520")
    @DisplayName("Проверка UI вкладки Выдача на руки")
    @Tags({@Tag("stage"), @Tag("regress")})
    @Epic("Автотесты")
    @Feature("Выдача заявления на руки")
    void handingOverTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        NavigatorPage.goToRegister();
        ReestrPage.open("Реестр оказания услуги по размещению инженерных изысканий");

        step("Используя фильтр, найти и открыть карточку в статусе Услуга оказана. Решение положительное", () -> {
            $(".search-result-table thead").$$("tr").last().$$("th").get(4).click();
            $("#dropdown-columns-basic").$(byText("Услуга оказана. Решение положительное")).click();
            $(".label-primary").shouldHave(text("Услуга оказана. Решение положительное")).click();
        });
        step("Проверить, что открыта форма Карточка заявления", () ->
                $("h1").shouldHave(text("Карточка заявления")));
        step("Открыть вкладку Выдача на руки", () ->
                $("#hand-outs-history-link").click());
        step("Проверить, что вкладка озаглавлена Выдача на руки", () ->
                $(".nav-link.active").shouldHave(text("Выдача на руки")));
        step("Проверить, что содержится блок со столбцами", () ->
                $("app-tab-hand-outs").shouldHave(
                        text("Исполнитель"),
                        text("Дата выдачи"),
                        text("Расписка о получении результата")
                ));
        step("Проверить, что есть кнопки", () -> {
            $(".buttons-container").$(byText("В реестр")).shouldBe(visible);
            $(".buttons-container").$(byText("Выдать на руки")).shouldBe(visible);
        });
    }
}
