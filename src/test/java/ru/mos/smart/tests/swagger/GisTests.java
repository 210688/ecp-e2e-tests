package ru.mos.smart.tests.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.requests.Authorization;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;

@Owner("Soldatovks")
@Epic("OASI")
@Feature("GIS")
@Tags({@Tag("map2D") ,@Tag("regres"), @Tag("swagger")})
public class GisTests extends ApiBearerTestBase {

    @Test
    @AllureId("16965")
    @Story("2D")
    @Component("Swagger")
    @DisplayName("Описание всех типов документов")
    @Description("Проверить, что описаны все типы документов(gis/documentTypes [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/gis/search/swagger-ui.html#/"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/gis/search/swagger-ui.html#/")})
    void gisSearchTests() {
        ValidatableResponse response = Authorization.apiRequestBearer()
                .get("/app/gis/search/swagger-ui.html")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

}
