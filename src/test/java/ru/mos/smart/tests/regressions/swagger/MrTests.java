package ru.mos.smart.tests.regressions.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("OASI")
@Feature("Mr")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class MrTests extends ApiBearerTestBase {

    @Test
    @AllureId("16957")
    @Story("camera")
    @Description("mr/documentTypes [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/camera/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/camera/swagger-ui.html")})
    void mrCameraTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mr/camera/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @AllureId("16956")
    @Story("link")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/link/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/link/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/link/swagger-ui.html")})
    void mrLinkTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mr/link/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @AllureId("16960")
    @Story("meeting")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/meeting/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/meeting/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/meeting/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void mrMeetingTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mr/meeting/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @AllureId("16959")
    @Story("program")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mr/program/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/program/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/program/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void mrProgramTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mr/program/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
