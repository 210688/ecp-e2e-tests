package ru.mos.smart.tests.mkapmii;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.mkapmii.Mkapmii;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.MkapmiiPage;
import ru.mos.smart.pages.TasksPage;
import ru.mos.smart.tests.TestBase;
import ru.mos.smart.utils.RandomUtils;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class MkapmiiApplicationTest extends TestBase {
    @Test
    @AllureId("5181")
    @DisplayName("01. Проверка основных контролов, закрытие задачи без сохранения")
    @Tags({@Tag("stage"), @Tag("regress")})
    @Epic("Автотесты")
    @Owner("innovault")
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    void mainControlsTest() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        Mkapmii mkapmii = new Mkapmii();
        MkapmiiPage mkapmiiPage = new MkapmiiPage();

        mkapmii.create(randomTestId);
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.openTaskByTestId(randomTestId);
        TasksPage.takeUnusedTask();

        ElementsCollection dataBlocks = $$(".tab-content .collapsible-title");

        step("Проверка наличия блоков данных", () ->
                dataBlocks.shouldHave(sizeGreaterThan(0)));
        step("Проверить скрытие/раскрытие всех блоков данных", () -> {
            for (SelenideElement dataBlock : dataBlocks) {
                if (dataBlock.has(text("Иные документы"))) {
                    dataBlock.scrollIntoView(true);
                    dataBlock.parent().$(".ng-trigger-expandInfoPanel").scrollIntoView(true).shouldNotBe(visible, Duration.ofSeconds(10));
                    dataBlock.scrollIntoView(true).click();
                    dataBlock.parent().$(".ng-trigger-expandInfoPanel").shouldBe(visible, Duration.ofSeconds(10));
                    dataBlock.scrollIntoView(true).click();
                    dataBlock.parent().$(".ng-trigger-expandInfoPanel").scrollIntoView(true).shouldNotBe(visible, Duration.ofSeconds(10));
                } else {
                    dataBlock.scrollIntoView(true);
                    dataBlock.parent().$(".ng-trigger-expandInfoPanel").scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(10));
                    dataBlock.scrollIntoView(true).click();
                    dataBlock.parent().$(".ng-trigger-expandInfoPanel").shouldNotBe(visible, Duration.ofSeconds(10));
                    dataBlock.scrollIntoView(true).click();
                    dataBlock.parent().$(".ng-trigger-expandInfoPanel").scrollIntoView(true).shouldBe(visible, Duration.ofSeconds(10));
                }
            }
        });

        step("Проверить скачивание файлов во всех блоках", () -> {
            ElementsCollection files = $$("cdp-ex-file");
            for (SelenideElement file : files) {
                file.$(byText("Скачать"))
                        .shouldHave(attributeMatching("href", "(.*)/filestore/v1/files/(.*)?systemCode=mkapmii"));
            }
        });
        step("Проверить скачивание электронной подписи во всех блоках (если есть)");
        step("Проверить работу радиобаттонов", () -> {
            mkapmiiPage.selectRefuseDocsRadioButton();
            mkapmiiPage.selectTakeToWorkRadioButton();
        });
        step("Выставить радиобаттон Отказать в приёме документов, проверить выпадающий список причин отказа", () -> {
            mkapmiiPage.selectRefuseDocsRadioButton();
            $("[placeholder=Причина]").click();
            $$(".ng-dropdown-panel-items").shouldHave(sizeGreaterThan(0));
        });
        step("Проверить кнопку добавления/удаления причины отказа", () -> {
            mkapmiiPage.addRefuseReason();
            $$(byText("Причина отказа")).shouldHave(size(2));
            mkapmiiPage.deleteRefuseReason();
            $$(byText("Причина отказа")).shouldHave(size(1));
        });
        step("Добавить любую причину отказа", () ->
                mkapmiiPage.selectReason());

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
                TasksPage.openTaskByTestId(randomTestId));
        step("Проверить, что внесенные данные НЕ сохранились", () ->
                $$(".ex-small-file-box").last().shouldNotHave(text("Отказ в приеме документов")));
    }

    @Test
    @AllureId("5182")
    @DisplayName("02. Сохранить без завершения")
    @Epic("Автотесты")
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    void saveAndNotFinishTest() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        Mkapmii mkapmii = new Mkapmii();
        MkapmiiPage mkapmiiPage = new MkapmiiPage();

        mkapmii.create(randomTestId);
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.openTaskByTestId(randomTestId);
        TasksPage.takeUnusedTask();

        mkapmiiPage.selectRefuseDocsRadioButton();
        mkapmiiPage.selectReason();
        mkapmiiPage.createDecisionFile();

        step("Нажать на кнопку Сохранить без завершения задачи", () ->
                $$("button").findBy(text("Сохранить без завершения задачи")).shouldNotHave(attribute("[disabled]")).click());
        step("Отрыть задачу, которая была закрыта на шаге 5", () ->
                TasksPage.openTaskByTestId(randomTestId));
        step("Проверить, что внесенные данные сохранены и отображаются", () ->
                $$(".ex-small-file-box").last().shouldHave(text("Отказ в приеме документов")));
    }

    @Test
    @AllureId("5188")
    @DisplayName("03. Проверка перехода в карточку заявления")
    @Epic("Автотесты")
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    void applicationCardTest() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        Mkapmii mkapmii = new Mkapmii();

        mkapmii.create(randomTestId);
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.openTaskByTestId(randomTestId);
        TasksPage.takeUnusedTask();

        step("В шапке задачи нажать на номер заявления", () ->
                $("[uisref='app.card']").click());
        step("Проверить что происходит переход в карточку заявления", () ->
                $("h1").shouldHave(text("Карточка заявления")));
    }

    @Test
    @AllureId("5180")
    @DisplayName("07. Успешный прием документов")
    @Epic("Автотесты")
    @Feature("Задача Проверить данные заявления. Проверка контролов. Успешный прием документов")
    void positiveFinishTask() {
        String randomTestId = "MKAPMII_ID: " + RandomUtils.getRandomString(10);
        Mkapmii mkapmii = new Mkapmii();
        MkapmiiPage mkapmiiPage = new MkapmiiPage();

        mkapmii.create(randomTestId);
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        TasksPage.openTaskByTestId(randomTestId);
        TasksPage.takeUnusedTask();

        mkapmiiPage.selectTakeToWorkRadioButton();

        step("Нажать Завершить задачу", () ->{
            $$("button").findBy(text("Завершить задачу")).shouldNotHave(attribute("[disabled]")).click();
            $$(".toast-message").findBy(text("Заявка принята в работу!")).shouldBe(visible);
            $("#my-task-showcase").shouldBe(visible, Duration.ofSeconds(30));
        });
    }
}
