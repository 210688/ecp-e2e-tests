package ru.mos.smart.tests.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("Проверка работы swagger по подсистемам")
@Feature("RAYON")
@Tags({@Tag("rayon"), @Tag("regres"), @Tag("swagger")})
public class MrTests extends ApiBearerTestBase {

    @Test
    @AllureId("16957")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("CAMERA")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(mr/documentTypes [GET])")
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
    @Layer("api")
    @Owner("Soldatovks")
    @Story("LINK")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/mr/link/documentTypes/all [GET])")
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
    @Layer("api")
    @Owner("Soldatovks")
    @Story("MEETING")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/mr/meeting/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/meeting/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/meeting/swagger-ui.html")})
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
    @Layer("api")
    @Owner("Soldatovks")
    @Story("PROGRAM")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/mr/program/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mr/program/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/program/swagger-ui.html")})
    void mrProgramTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mr/program/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
