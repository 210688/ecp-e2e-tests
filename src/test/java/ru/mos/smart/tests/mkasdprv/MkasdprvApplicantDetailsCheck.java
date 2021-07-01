package ru.mos.smart.tests.mkasdprv;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import e2e.kronverk.utils.RandomUtils;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.api.mkasdprv.Application;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.MkasdprvPage;
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
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        MkasdprvPage mkasdprvPage = new MkasdprvPage();
        Application application = new Application();

        application.create(randomTestId);
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.openTaskByTestId(randomTestId);
        TasksPage.takeUnusedTask();

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
            mkasdprvPage.selectReason();
            mkasdprvPage.addComment("ТЕСТ");
            mkasdprvPage.createDecisionFile();
            $$(".ex-small-file-box").last().shouldHave(text("Отказ в приеме документов.docx"));
            $$(".ex-small-file-box").last().$(byText("Подписать")).shouldBe(visible);
            $$(".ex-small-file-box").last().$(byText("Скачать"))
                    .shouldHave(attributeMatching("href", "(.*)/filestore/v1/files/(.*)?systemCode=mkasdprv"));
        });
        step("Проверить удаление файла решения", () -> {
            $$(".ex-small-file-box").last().$(".fa.fa-trash-o").click();
            $(".modal-content").$(".btn-primary").click();
        });
        step("Проверить, что после удаления файла отображается область с возможностью загрузки нового файла, добавить новый файл", () -> {
            $("cdp-ex-file-manager.to-check-File").shouldBe(visible);
            mkasdprvPage.uploadDecisionFile("files_for_tests/doc.docx");
            $("[title='doc.docx']").shouldBe(visible);
            $$("button").findBy(text("Подписать и завершить задачу")).shouldBe(visible);
            mkasdprvPage.deleteDecisionFile();
        });
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
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        Application application = new Application();

        application.create(randomTestId);
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.openTaskByTestId(randomTestId);
        TasksPage.takeUnusedTask();

        step("В шапке задачи нажать на номер заявления", () -> {
            $(byName("docNumber")).click();
            $("h1").shouldHave(text("Карточка заявления"));
        });
    }

    @Test
    @AllureId("4807")
    @DisplayName("03. Принять решение по заявлению - отказ. Причины отказа")
    @Tags({@Tag("predprod"), @Tag("mkasdprv")})
    @Epic("MKASDPRV (МКА Вывески)")
    @Feature("Автотесты")
    void negativeDecisionTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        MkasdprvPage mkasdprvPage = new MkasdprvPage();
        Application application = new Application();

        application.create(randomTestId);
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.openTaskByTestId(randomTestId);
        TasksPage.takeUnusedTask();
        mkasdprvPage.selectRefuseDocsRadioButton();

        step("В поле «Причина отказа» в выпадающем списке проверить наличие 3 причин отказа:", () -> {
            $("[placeholder=Причина]").click();
            $("ng-dropdown-panel").$(byText(
                    "Представление заявителем запроса и документов," +
                            " подписанных с использованием электронной подписи," +
                            " не принадлежащей лицу, подавшему запрос"))
                    .shouldBe(visible);
            $("ng-dropdown-panel").$(byText(
                    "Представление заявителем неполного комплекта документов," +
                            " предусмотренных пунктом 2.5.1.1 Регламента в качестве документов," +
                            " подлежащих обязательному представлению заявителем"))
                    .shouldBe(visible);
            $("ng-dropdown-panel").$(byText(
                    "Электронные копии (электронные образы) документов," +
                            " необходимых для предоставления государственной услуги," +
                            " не поддаются прочтению и (или) не соответствуют требованиям к форматам их предоставления"))
                    .shouldBe(visible);
        });
        step("Проверить добавление нового блока причин отказа, с помощью кнопки «+»", () -> {
            $$(byText("Причина отказа")).shouldHave(size(1));
            $(".fas.fa-plus").click();
            $$(byText("Причина отказа")).shouldHave(size(2));
            $(".fas.fa-minus").click();
            $$(byText("Причина отказа")).shouldHave(size(1));
        });
        mkasdprvPage.selectReason();
        mkasdprvPage.addComment("ТЕСТ");
        mkasdprvPage.createDecisionFile();
        step("Проверить, что сформированный файл можно скачать, подписать, удалить", () -> {
            $$(".ex-small-file-box").last().shouldHave(text("Отказ в приеме документов.docx"));
            $$(".ex-small-file-box").last().$(byText("Подписать")).shouldBe(visible);
            $$(".ex-small-file-box").last().$(byText("Скачать"))
                    .shouldHave(attributeMatching("href", "(.*)/filestore/v1/files/(.*)?systemCode=mkasdprv"));
            $$(".ex-small-file-box").last().$(".fa.fa-trash-o").shouldBe(visible);
        });
        step("После удаления файла проверить, что можно загрузить файл решения в расширении pdf, doc(x)", () -> {
            mkasdprvPage.deleteDecisionFile();
            $("cdp-ex-file-manager.to-check-File").shouldHave(text("Загрузить файл"));
            mkasdprvPage.uploadDecisionFile("files_for_tests/doc.docx");
            $("[title='doc.docx']").shouldBe(visible);
            mkasdprvPage.deleteDecisionFile();
            $("[title='doc.docx']").shouldNotBe(visible);

            $("cdp-ex-file-manager.to-check-File").shouldHave(text("Загрузить файл"));
            mkasdprvPage.uploadDecisionFile("files_for_tests/pdf.pdf");
            $("[title='pdf.pdf']").shouldBe(visible);
            mkasdprvPage.deleteDecisionFile();
            $("[title='pdf.pdf']").shouldNotBe(visible);

            $("cdp-ex-file-manager.to-check-File").shouldHave(text("Загрузить файл"));
            mkasdprvPage.uploadDecisionFile("files_for_tests/doc.doc");
            $("[title='doc.doc']").shouldBe(visible);
            mkasdprvPage.deleteDecisionFile();
            $("[title='doc.doc']").shouldNotBe(visible);
        });
    }

    @Test
    @AllureId("4808")
    @DisplayName("04. Принять решение. Сформировать файл решения. Загрузка файлов")
    @Tags({@Tag("predprod"), @Tag("mkasdprv")})
    @Epic("MKASDPRV (МКА Вывески)")
    @Feature("Автотесты")
    void negativeFilesTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        MkasdprvPage mkasdprvPage = new MkasdprvPage();
        Application application = new Application();

        application.create(randomTestId);
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.openTaskByTestId(randomTestId);
        TasksPage.takeUnusedTask();

        mkasdprvPage.selectRefuseDocsRadioButton();
        mkasdprvPage.selectReason();
        mkasdprvPage.addComment("ТЕСТ");
        mkasdprvPage.createDecisionFile();
        mkasdprvPage.deleteDecisionFile();

        step("Проверить, что после удаления файла отображается область с возможностью загрузки нового файла, добавить новый файл", () ->
                $("cdp-ex-file-manager.to-check-File").shouldHave(text("Загрузить файл")));
        step("Загрузить файл с расширением pdf, doc(x)", () -> {
            mkasdprvPage.uploadDecisionFile("files_for_tests/pdf.pdf");
            $("[title='pdf.pdf']").shouldBe(visible);
            mkasdprvPage.deleteDecisionFile();
            $("[title='pdf.pdf']").shouldNotBe(visible);

        });
        step("Загрузить файл с расширением не pdf, doc(x)", () -> {
            mkasdprvPage.uploadDecisionFile("files_for_tests/bad.file");
            $$(".toast-message").findBy(text("не загружен!")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("4809")
    @DisplayName("05. Успешный отказ в приёме документов")
    @Tags({@Tag("predprod"), @Tag("mkasdprv")})
    @Epic("MKASDPRV (МКА Вывески)")
    @Feature("Автотесты")
    void refuseDocsTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        MkasdprvPage mkasdprvPage = new MkasdprvPage();
        Application application = new Application();

        application.create(randomTestId);
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.openTaskByTestId(randomTestId);
        TasksPage.takeUnusedTask();
        mkasdprvPage.selectRefuseDocsRadioButton();
        mkasdprvPage.selectReason();
        mkasdprvPage.addComment("ТЕСТ");

        step("Нажать на кнопку «Завершить задачу»", () -> {
            $$("button").findBy(text("Завершить задачу")).click();
            $$(".toast-message").findBy(text("Файл заключения: необходимо сформировать файл!")).shouldBe(visible);
        });
        mkasdprvPage.createDecisionFile();
        step("Нажать на кнопку «Завершить задачу»");
    }
}
