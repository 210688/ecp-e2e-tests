package ru.mos.smart.tests.regressions.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Проверка доступности Swagger приложений")
public class MrTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Mr")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/camera/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/camera/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/camera/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
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
    @Owner("Soldatovks")
    @Feature("Mr")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/link/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/link/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/link/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
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
    @Owner("Soldatovks")
    @Feature("Mr")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/meeting/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/meeting/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/meeting/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
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
    @Owner("Soldatovks")
    @Feature("Mr")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/program/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/program/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/program/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void mrProgramTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/mr/program/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
