/*package ru.mos.smart.tests.api;

import io.qameta.allure.Epic;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.ApiBasicTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Api тесты проверки микросервисов")
public class GeoserverTests extends ApiBasicTestBase {

    @Test()
    @Layer("api")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @DisplayName("Проверка сервиса geoserver")
    void Geoserver() {
        ValidatableResponse response = apiSteps.apiRequestBasicGeoserver()
                .get("/geoserver/rest/about/system-status")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }*/

