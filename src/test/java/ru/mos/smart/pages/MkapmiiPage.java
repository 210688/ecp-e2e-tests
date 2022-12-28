package ru.mos.smart.pages;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.helpers.utils.FileUtils;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.mos.smart.helpers.AuthorizationHelper.getAccessToken;

public class MkapmiiPage {
    @Step("В поле «Принять решение по заявлению» выбрать радиобаттон «Отказать в приеме документов»")
    public void selectRefuseDocsRadioButton() {
            sleep(300);
            $("input[ng-reflect-value=NEGATIVE_DOC_REFUSED]").shouldNotHave(attribute("[disabled]")).click();
            $(byText("Сформировать файл решения")).shouldBe(visible);
    }

    public void selectTakeToWorkRadioButton() {
        step("В поле «Принять решение по заявлению» выбрать радиобаттон «Принять в работу»", () -> {
            sleep(500);
            $("input[ng-reflect-value=POSITIVE]").shouldNotHave(attribute("[disabled]")).click();
            $(byText("Сформировать файл решения")).shouldNotBe(visible);
        });
    }

    public void addRefuseReason() {
        step("Нажать кнопку добавления причины отказа", () ->
                $(".fas.fa-plus").click());
    }

    public void deleteRefuseReason() {
        step("Нажать кнопку удаления причины отказа", () ->
                $(".fas.fa-minus").click());
    }

    public void selectReason() {
        step("В поле «Причина отказа» выбрать причину из выпадающего списка", () -> {
            $("[placeholder=Причина]").click();
            $("ng-dropdown-panel").$(".ng-option").click();
        });
    }

    public void createDecisionFile() {
        step("Нажать на кнопку «Сформировать файл решения»", () -> {
            $("button.btn-file-generation").click();
            $$(".toast-message").findBy(text("Заключение успешно сформировано!")).shouldBe(visible);
        });
    }

    public void createDecisionFile(String error) {
        step("Нажать на кнопку «Сформировать файл решения»", () ->
                $("button.btn-file-generation").click());
        step("Проверить, что всплывает алерт с ошибкой с указанием" +
                " на отсутствие причины отказа " + error, () -> {
            $$(".toast-message").findBy(text(error)).shouldBe(visible);
        });
    }

    public void addRefuseComment(String commentText) {
        step("В поле «Комментарий» ввести произвольное текстовое значение", () -> {
            $("textarea.form-control").setValue(commentText);
        });
    }

    @Step("Проверить выпадающий список причины отказа")
            public void otkaz() {
        $("[placeholder=Причина]").click();
        $$(".ng-dropdown-panel-items").shouldHave(sizeGreaterThan(0));
    }

    @Step("Создть заявление по API")
    public void createTask(String name) {
            String requestMessage = FileUtils.readStringFromFile("src/test/resources/files_for_tests/mkapmii/mkapmii_request.xml");
            //requestMessage = requestMessage.replace("{STREET}", name);
            //requestMessage = requestMessage.replace("{STREET}", name);

        /*    PguMockRequest request = new PguMockRequest();
            request.setId(0);
            request.setMessage(requestMessage);
            request.setMessageType("string");*/
            given()
                    .baseUri(ConfigHelper.getApplicationUrl())
                    .header("Authorization", "Bearer " + getAccessToken())
                    .log().uri()
                    .contentType(ContentType.JSON)
                    .body(requestMessage)
                    .when()
                    .post("app/mkapmii/order/pgu/pgu_mock_request")
                    .then()
                    .statusCode(200);
    }
}
