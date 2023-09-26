package ru.mos.smart.tests.regressions.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.requests.Authorization;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;


public class GisTests extends ApiBearerTestBase {

    @Test
    @AllureId("16965")
    @Layer("api")
    @Owner("Soldatovks")
    @Epic("OASI")
    @Feature("GIS")
    @DisplayName("Описание всех типов документов")
    @Description("Проверить, что описаны все типы документов(gis/documentTypes [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/gis/search/swagger-ui.html#/"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/gis/search/swagger-ui.html#/")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions") ,@Tag("regres")})
    void gisSearchTests() {
        ValidatableResponse response = Authorization.apiRequestBearer()
                .get("/app/gis/search/swagger-ui.html")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

}
