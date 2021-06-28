package ru.mos.smart.tests.mkasdprv;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.TasksPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("MKASDPRV (МКА Вывески)")
@Feature("Проверить данные заявления")
public class MkasdprvApplicantDetailsCheck extends TestBase {

    @Test
    @AllureId("4805")
    @DisplayName("01. Проверка основных контролов на странице")
    @Tags({@Tag("predprod"), @Tag("mkasdprv")})
    @Epic("MKASDPRV (МКА Вывески)")
    @Feature("Автотесты")
    void mainControlsTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.takeUnusedTask("Проверить данные заявления");

        ElementsCollection dataBlocks = $$(".main-container .title");

        step("Проверка наличия блоков данных", () ->
                dataBlocks.shouldHave(sizeGreaterThan(0)));
        step("Проверить скрытие/раскрытие всех блоков данных", () -> {
            for (SelenideElement dataBlock : dataBlocks) {
                dataBlock.scrollIntoView(true);
                dataBlock.parent().$(".content").shouldBe(visible, Duration.ofSeconds(10));
                dataBlock.click();
                dataBlock.parent().$(".content").shouldNotBe(visible, Duration.ofSeconds(10));
                dataBlock.click();
                dataBlock.parent().$(".content").shouldBe(visible, Duration.ofSeconds(10));
            }
        });
        step("Проверить скачивание файлов во всех блоках", () -> {
            ElementsCollection files = $$("cdp-ex-file");
            for (SelenideElement file : files) {
                file.$(byText("Скачать"))
                        .shouldHave(attributeMatching("href", "(.*)/filestore/v1/files/(.*)?systemCode=mkasdprv"));
            }
        });
        step("В поле «Причина отказа» проверить выпадающий список с причинами отказа", () -> {
            $("[for=Refuse]").parent().$("input").click();
            $("[placeholder=Причина]").click();
            $("ng-dropdown-panel").$$(".ng-option").shouldHave(sizeGreaterThan(0));
        });
        step("Проверить добавление нового блока причин отказа, с помощью кнопки «+»", () -> {
            $$(byText("Причина отказа")).shouldHave(size(1));
            $(".fas.fa-plus").click();
            $$(byText("Причина отказа")).shouldHave(size(2));
            $(".fas.fa-minus").click();
            $$(byText("Причина отказа")).shouldHave(size(1));
        });
        step("Проверить кнопку «Сформировать файл решения»", () -> {
            $(".ex-dropzone-outer").shouldNotBe(visible);
            $("[placeholder=Причина]").click();
            $("ng-dropdown-panel").$(".ng-option").click();
            $("textarea.form-control").setValue("ТЕСТ");
            $("button.for-reason-btn").click();
            $$(".ex-small-file-box").last().shouldHave(text("Отказ в приеме документов.docx"));
            $$(".ex-small-file-box").last().$(byText("Подписать")).shouldBe(visible);
            $$(".ex-small-file-box").last().$(byText("Скачать"))
                    .shouldHave(attributeMatching("href", "(.*)/filestore/v1/files/(.*)?systemCode=mkasdprv"));
        });
        step("Проверить удаление файла решения", () -> {
            $$(".ex-small-file-box").last().$(".fa.fa-trash-o").click();
            $(".modal-content").$(".btn-primary").click();
        });
        step("Проверить, что после удаления файла отображается область с возможностью загрузки нового файла, добавить новый файл", () ->
                $("cdp-ex-file-manager.to-check-File").shouldBe(visible));
        step("Нажать на кнопку «Завершить задачу»", () -> {
            $$("button").findBy(text("Завершить задачу")).click();
            $$(".toast-message").findBy(text("Файл заключения: необходимо сформировать файл!")).shouldBe(visible);
        });
        step("Нажать на кнопку «Закрыть»", () -> {
            $$("button").findBy(text("Закрыть")).click();
            $(".modal-content").shouldHave(text("На форме имеются несохраненные изменения.\n" +
                    "Все равно закрыть форму?"));
        });
        step("В модальном окне проверить кнопки «Отмена» и «Да»", () -> {
            $(".modal-content").$(".btn-primary").shouldBe(visible);
            $(".modal-content").$(".btn-warning").click();
        });
        step("Нажать на кнопку «Сохранить без завершения задачи»", () ->
                $$("button").findBy(text("Сохранить без завершения задачи")).click());
    }

    @Test
    @AllureId("4806")
    @DisplayName("02. Проверка перехода в карточку заявления")
    @Tags({@Tag("prod"), @Tag("mkasdprv")})
    @Epic("MKASDPRV (МКА Вывески)")
    @Feature("Автотесты")
    void applicationCardTest() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.takeUnusedTask("Проверить данные заявления");

        step("В шапке задачи нажать на номер заявления", () -> {
            $(byName("docNumber")).click();
            $("h1").shouldHave(text("Карточка заявления"));
        });
    }
}
