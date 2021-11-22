package ru.mos.smart.tests.api;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;

import static io.qameta.allure.Allure.parameter;
import static io.restassured.RestAssured.given;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class GeoserverTests {

    @Test()
    @Layer("api")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @DisplayName("Проверка сервиса geoserver")
    void Geoserver() {
        ValidatableResponse response = given()
                .auth()
                .preemptive()
                .basic(webConfig().loginSwagger(), webConfig().passwordSwagger())
                .get("https://smart-predprod.mos.ru/geoserver/rest/about/system-status")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
