package ru.mos.smart.tests.regressions.app;

import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Owner;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.ApiBasicTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Проверка микросервисов")
public class GeoserverTests extends ApiBasicTestBase {

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @DisplayName("Проверка доступности Geoserver")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/geoserver/rest/about/system-status"),
            @Link(name = "prod", url = "https://smart.mos.ru/geoserver/rest/about/system-status")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("regressionsProd")})
    void GeoserverTests() {
        ValidatableResponse response = authorization.apiRequestBasicGeoserver()
                .get("geoserver/rest/about/system-status")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}


