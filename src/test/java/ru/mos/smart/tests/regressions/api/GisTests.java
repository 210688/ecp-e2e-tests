package ru.mos.smart.tests.regressions.api;

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
public class GisTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Gis")
    @DisplayName("/app/gis/search/swagger-ui.html [GET]")
    @Description("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/gis/search/swagger-ui.html#/"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/gis/search/swagger-ui.html#/")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void gisSearchTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/gis/search/swagger-ui.html")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

}