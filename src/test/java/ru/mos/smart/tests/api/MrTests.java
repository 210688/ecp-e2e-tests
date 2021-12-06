package ru.mos.smart.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Api тесты проверка доступности Swagger приложений и  микросервисов")
public class MrTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Feature("Mr")
    @Link(url = "https://smart-predprod.mos.ru/app/mr/camera/swagger-ui.html")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/camera/documentTypes/all [GET]")
    void mrCameraTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/mr/camera/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Mr")
    @Link(url = "https://smart-predprod.mos.ru/app/mr/link/swagger-ui.html")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/link/documentTypes/all [GET]")
    void mrLinkTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/mr/link/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Mr")
    @Link(url = "https://smart-predprod.mos.ru/app/mr/meeting/swagger-ui.html")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/meeting/documentTypes/all [GET]")
    void mrMeetingTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/mr/meeting/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Mr")
    @Link(url = "https://smart-predprod.mos.ru/app/mr/program/swagger-ui.html")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/program/documentTypes/all [GET]")
    void mrProgramTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/mr/program/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
