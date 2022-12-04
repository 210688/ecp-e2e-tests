package ru.mos.smart.tests.regressions.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Проверка доступности Swagger приложений")
public class DroneTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Description("drone/documentTypes [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Feature("Drone")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/drone/drone/swagger-ui.html#/"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/drone/drone/swagger-ui.html#/")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void DroneTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/drone/drone/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
