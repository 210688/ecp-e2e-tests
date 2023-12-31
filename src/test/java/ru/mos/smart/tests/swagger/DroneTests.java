package ru.mos.smart.tests.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.requests.Authorization;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;

@Layer("api")
@Epic("OASI")
@Feature("DRONE")
@Tags({@Tag("drone") ,@Tag("regres"), @Tag("swagger")})
public class DroneTests extends ApiBearerTestBase {


    @Test
    @AllureId("16963")
    @Story("Drone")
    @Component("Swagger")
    @DisplayName("Описание всех типов документов")
    @Description("Проверить, что описаны все типы документов(drone/documentTypes [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/drone/drone/swagger-ui.html#/"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/drone/drone/swagger-ui.html#/")})
    void droneTest() {
        ValidatableResponse response = Authorization.apiRequestBearer()
                .get("/app/drone/drone/documentTypes/all")
                .then();
        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}