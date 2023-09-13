package ru.mos.smart.tests.mkasdprv;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.junit.OnPreprodOnly;
import ru.mos.smart.helpers.utils.RandomUtils;
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
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.TASK;

@Layer("web")
@Epic("OASI")
@Feature("MKASDPRV")
public class MkasdprvApplicantDetailsCheckTest extends TestBase {

    @Test
    @OnPreprodOnly
    @DisplayName("01. Проверка основных контролов на странице")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void mainControlsTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        mkasdprvPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        ElementsCollection dataBlocks = $$(".main-container .title");

        step("Проверка наличия блоков данных", () ->
                dataBlocks.shouldHave(sizeGreaterThan(0)));
        step("Проверить скрытие/раскрытие всех блоков данных", () -> {
            for (SelenideElement dataBlock : dataBlocks) {
                dataBlock.scrollIntoView(true);
                dataBlock.parent().$(".content").scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(10));
                dataBlock.scrollIntoView(true).click();
                dataBlock.parent().$(".content").shouldNotBe(visible, Duration.ofSeconds(10));
                dataBlock.scrollIntoView(true).click();
                dataBlock.parent().$(".content").scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(10));
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
    @OnPreprodOnly
    @DisplayName("02. Проверка перехода в карточку заявления")
    @Epic("MKASDPRV (МКА Вывески)")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void applicationCardTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        mkasdprvPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();

        step("В шапке задачи нажать на номер заявления", () -> {
            $(byName("docNumber")).click();
            $("h1").shouldHave(text("Карточка заявления"));
        });
    }

    @Test
    @OnPreprodOnly
    @DisplayName("03. Принять решение по заявлению - отказ. Причины отказа")
    @Epic("MKASDPRV (МКА Вывески)")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void negativeDecisionTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        mkasdprvPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
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
    @OnPreprodOnly
    @DisplayName("04. Принять решение. Сформировать файл решения. Загрузка файлов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void negativeFilesTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        mkasdprvPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
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
    @OnPreprodOnly
    @DisplayName("05. Успешный отказ в приёме документов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void refuseDocsTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        mkasdprvPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
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

    @Test
    @OnPreprodOnly
    @DisplayName("Завершение задачи (принять в работу)")
    @Story("02. Завершение задачи Проверить данные заявления (принять в работу)")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void finishTaskTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        mkasdprvPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        mkasdprvPage.selectTakeToWorkRadioButton();

        step("Нажать Завершить задачу", () -> {
            $$(".toast-message").shouldHave(size(0), Duration.ofSeconds(15));
            $("button.btn-primary").scrollIntoView(true).click();
        });

        step("Проверка, что заявка отправлена на ознакомление", () ->
                $$(".toast-message").findBy(text("Заявка отправлена на ознакомление!"))
                        .shouldBe(visible, Duration.ofSeconds(20)));
    }
}
