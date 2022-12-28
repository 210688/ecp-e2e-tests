package ru.mos.smart.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import ru.mos.smart.api.Authorization;
import ru.mos.smart.api.mkasdprv.PguMockRequest;
import ru.mos.smart.helpers.utils.FileUtils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class MkasdprvPage {
    public void selectRefuseDocsRadioButton() {
        step("В поле «Принять решение по заявлению» выбрать радиобаттон «Отказать в приеме документов»", () -> {
            $("[for=Refuse]").parent().$("input").click();
            $(byText("Сформировать файл решения")).shouldBe(visible);
        });
    }

    public void selectTakeToWorkRadioButton() {
        step("В поле «Принять решение по заявлению» выбрать радиобаттон «Принять в работу»", () -> {
            $("[for=TakeToWork]").parent().$("input").click();
        });
    }

    public void addComment(String commentText) {
        step("В поле «Комментарий» ввести произвольное текстовое значение", () -> {
            $("textarea.form-control").setValue(commentText);
        });
    }

    public void createDecisionFile() {
        step("Нажать на кнопку «Сформировать файл решения»", () ->
                $("button.for-reason-btn").click());
    }

    @Step("Удаление файла решения")
    public void deleteDecisionFile() {
        $$(".ex-small-file-box").last().$(".fa.fa-trash-o").click();
        $(".modal-content").$(".btn-primary").click();
    }

    @Step("Загрузка файла решения {fileName}")
    public void uploadDecisionFile(String fileName) {
        Selenide.executeJavaScript("$(\"input[type='file']\").last().val('');");
        $$("input[type='file']").last().uploadFromClasspath(fileName);
    }

    public void selectReason() {
        step("В поле «Причина отказа» выбрать причину из выпадающего списка", () -> {
            $("#tab1").$("[placeholder=Причина]").click();
            $("ng-dropdown-panel").$(".ng-option").click();
        });
    }

    public void createTask(String name) {
        step("Создаем заявление по API", () -> {
            String requestMessage = FileUtils.readStringFromFile("src/test/resources/files_for_tests/mkasdprv/mkasdprv_request.txt");
            requestMessage = requestMessage.replace("{STREET}", name);

            PguMockRequest request = new PguMockRequest();
            request.setId(0);
            request.setMessage(requestMessage);
            request.setMessageType("string");

            Authorization authorization = new Authorization();

            given()
                    .cookies(authorization.getAuthCookie(webConfig().loginRegress(), webConfig().passwordRegress()))
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .post("/app/mkasdprv/order/pgu_status/pgu_mock_request")
                    .then()
                    .statusCode(200);
        });
    }
}
