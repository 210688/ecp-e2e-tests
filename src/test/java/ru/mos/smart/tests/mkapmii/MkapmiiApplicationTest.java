package ru.mos.smart.tests.mkapmii;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.ManualMember;
import ru.mos.smart.helpers.junit.OnPreprodOnly;
import ru.mos.smart.helpers.utils.RandomUtils;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.enums.Sidebar.SERVICES_AND_FUNCTION;
import static ru.mos.smart.data.enums.Sidebar.TASK;


@Epic("OASI")
@Feature("MKAPMII")
@Story("MKAPMII")
@ManualMember("innovault")
public class MkapmiiApplicationTest extends TestBase {

    @Test
    @OnPreprodOnly
    @DisplayName("01. Проверка основных контролов, закрытие задачи без сохранения")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void mainControlsTest() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        mkapmiiPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        ElementsCollection dataBlocks = $$(".tab-content .collapsible-title");

        step("Проверка наличия блоков данных", () ->
                dataBlocks.shouldHave(sizeGreaterThan(0)));
        step("Проверить скрытие/раскрытие всех блоков данных", () -> {
            for (SelenideElement dataBlock : dataBlocks) {
                if (dataBlock.has(text("Иные документы"))) {
                    dataBlock.scrollIntoView(true);
                    dataBlock
                            .parent().$(".ng-trigger-expandInfoPanel").scrollIntoView(true).shouldNotBe(visible, Duration.ofSeconds(10));
                    dataBlock.scrollIntoView(true).click();
                    dataBlock
                            .parent().$(".ng-trigger-expandInfoPanel").shouldBe(visible, Duration.ofSeconds(10));
                    dataBlock
                            .scrollIntoView(true).click();
                    dataBlock
                            .parent().$(".ng-trigger-expandInfoPanel").scrollIntoView(true).shouldNotBe(visible, Duration.ofSeconds(10));
                } else {
                    dataBlock.scrollIntoView(true);
                    dataBlock
                            .parent().$(".ng-trigger-expandInfoPanel").scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(10));
                    dataBlock.scrollIntoView(true).click();
                    dataBlock
                            .parent().$(".ng-trigger-expandInfoPanel").shouldNotBe(visible, Duration.ofSeconds(10));
                    dataBlock.scrollIntoView(true).click();
                    dataBlock
                            .parent().$(".ng-trigger-expandInfoPanel").scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(10));
                }
            }
        });
        taskPage.downloadCard();
        mkapmiiPage.selectRefuseDocsRadioButton();
        mkapmiiPage.selectTakeToWorkRadioButton();
        mkapmiiPage.selectRefuseDocsRadioButton();
        mkapmiiPage.otkaz();
        step("Проверить кнопку добавления/удаления причины отказа", () -> {
            mkapmiiPage.addRefuseReason();
            $$(byText("Причина отказа")).shouldHave(size(2));
            mkapmiiPage.deleteRefuseReason();
            $$(byText("Причина отказа")).shouldHave(size(1));
        });
        step("Добавить любую причину отказа", mkapmiiPage::selectReason);

        step("Проверить, что в блоке отказа в приёме документов можно скачать/удалить файл решения", () -> {
            mkapmiiPage.createDecisionFile();
            $$(".ex-small-file-box").last().shouldHave(text("Отказ в приеме документов"));
            $$(".ex-small-file-box").last().$(byText("Подписать")).shouldBe(visible);
            $$(".ex-small-file-box").last().$(byText("Скачать"))
                    .shouldHave(attributeMatching("href", "(.*)/filestore/v1/files/(.*)?systemCode=mkapmii"));
            $$(".ex-small-file-box").last().$(".fa.fa-trash-o").click();
            $(".modal-content").$(".btn-primary").click();
            $$(".ex-small-file-box").last().shouldNotHave(text("Отказ в приеме документов"));
            mkapmiiPage.createDecisionFile();
            $$(".ex-small-file-box").last().shouldHave(text("Отказ в приеме документов"));
        });
        step("Нажать на кнопку Закрыть", () -> {
            $(".buttons-container").$(byText("Закрыть")).click();
            $(".modal-content").$$("button").findBy(text("Да")).click();
        });
        step("В списке задач открыть ту же задачу, которая была закрыта на шаге 1", () ->
                taskPage.openTaskByTestId(randomTestId));
        step("Проверить, что внесенные данные НЕ сохранились", () ->
                $$(".ex-small-file-box").last().shouldNotHave(text("Отказ в приеме документов")));
    }

    @Test
    @OnPreprodOnly
    @DisplayName("02. Сохранить без завершения")
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void saveAndNotFinishTest() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        mkapmiiPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        mkapmiiPage.selectRefuseDocsRadioButton();
        mkapmiiPage.selectReason();
        mkapmiiPage.createDecisionFile();
        step("Нажать на кнопку Сохранить без завершения задачи", () ->
                $$("button").findBy(text("Сохранить без завершения задачи")).shouldNotHave(attribute("[disabled]")).click());
        step("Отрыть задачу, которая была закрыта на шаге 5", () ->
                taskPage.openTaskByTestId(randomTestId));
        step("Проверить, что внесенные данные сохранены и отображаются", () ->
                $$(".ex-small-file-box").last().shouldHave(text("Отказ в приеме документов")));
    }

    @Test
    @OnPreprodOnly
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    @DisplayName("03. Проверка перехода в карточку заявления")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void applicationCardTest() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        mkapmiiPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        step("В шапке задачи нажать на номер заявления", () ->
                $("[uisref='app.card']").click());
        step("Проверить что происходит переход в карточку заявления", () ->
                $("h1").shouldHave(text("Карточка заявления")));
    }

    @Test
    @OnPreprodOnly
    @DisplayName("07. Успешный прием документов")
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void positiveFinishTask() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        mkapmiiPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        mkapmiiPage.selectTakeToWorkRadioButton();
        step("Нажать Завершить задачу", () -> {
            $$("button").findBy(text("Завершить задачу")).shouldNotHave(attribute("[disabled]")).click();
            $$(".toast-message").findBy(text("Заявка принята в работу!")).shouldBe(visible);
            $("#my-task-showcase").shouldBe(visible, Duration.ofSeconds(30));
        });
    }

    @Test
    @OnPreprodOnly
    @DisplayName("04. Неуспешный отказ в приёме документов (отсутствует причина отказа и файл заключения)")
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void unsuccessfulRefuseTest() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        mkapmiiPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        mkapmiiPage.selectRefuseDocsRadioButton();
        mkapmiiPage.addRefuseComment("Тестовый комментарий");
        mkapmiiPage.createDecisionFile("Причина отказа: значение не выбрано!");
    }

    @Test
    @OnPreprodOnly
    @DisplayName("05. Неуспешный отказ в приёме документов (отсутствует файл заключения)")
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void unsuccessfulRefuseNoFileTest() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        mkapmiiPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        mkapmiiPage.selectRefuseDocsRadioButton();
        mkapmiiPage.selectReason();
        mkapmiiPage.addRefuseComment("Тестовый комментарий");
        step("Нажать Завершить задачу", () ->
                $$("button").findBy(text("Завершить задачу")).shouldNotHave(attribute("[disabled]")).click());

        step("Проверить, что всплывает алерт с ошибкой с " +
                "указанием на отсутствие файла решения (Файл заключения: необходимо сформировать файл!)", () ->
                $$(".toast-message").findBy(text("Файл заключения: необходимо сформировать файл!")).shouldBe(visible));

        step("Поле Причина отказа оставить пустым," +
                " в поле комментарий ввести произвольное значение," +
                " сформировать файл, нажать на кнопку Завершить задачу", () -> {
            mkapmiiPage.deleteRefuseReason();
            mkapmiiPage.addRefuseComment("Тестовый комментарий");
            mkapmiiPage.createDecisionFile("Причина отказа: значение не выбрано!");
            $$("button").findBy(text("Завершить задачу")).shouldNotHave(attribute("[disabled]")).click();
            $$(".toast-message").findBy(text("Файл заключения: необходимо сформировать файл!")).shouldBe(visible);
        });
        step("Оставить все поля пустыми, нажать на кнопку Завершить задачу", () -> {
            mkapmiiPage.deleteRefuseReason();
            $$("button").findBy(text("Завершить задачу")).shouldNotHave(attribute("[disabled]")).click();
            $$(".toast-message").findBy(text("Причина отказа: значение не выбрано!")).shouldBe(visible);
            $$(".toast-message").findBy(text("Файл заключения: необходимо сформировать файл!")).shouldBe(visible);
        });
    }

    @Test
    @OnPreprodOnly
    @DisplayName("06. Неуспешный отказ в приёме документов (все поля не заполнены)")
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void unsuccessfulRefuseEmptyFieldsTest() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        mkapmiiPage.createTask(randomTestId);
        sidebarPage.clickSidebarMenu(SERVICES_AND_FUNCTION);
        sidebarPage.clickSubMenuList(SERVICES_AND_FUNCTION, TASK);
        taskPage.openTaskByTestId(randomTestId);
        taskPage.takeUnusedTask();
        mkapmiiPage.selectRefuseDocsRadioButton();
        step("Нажать на кнопку Завершить задачу", () ->
                $$("button").findBy(text("Завершить задачу")).shouldNotHave(attribute("[disabled]")).click());
        step("Проверить, что всплывает алерт с ошибкой с указанием" +
                " на отсутствие причины отказа и отсутствие файла решения" +
                " (Причина отказа: значение не выбрано! Файл заключения: необходимо сформировать файл!)", () -> {
            $$(".toast-message").findBy(text("Причина отказа: значение не выбрано!")).shouldBe(visible);
            $$(".toast-message").findBy(text("Файл заключения: необходимо сформировать файл!")).shouldBe(visible);
        });
    }
}
