package ru.mos.smart.tests.regressions.app;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.ApiBasicTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Проверка работы swagger по подсистемам")
@Tags({@Tag("cdp"), @Tag("regres"), @Tag("swagger")})
public class GeoserverTests extends ApiBasicTestBase {

    @Test
    @AllureId("17045")
    @DisplayName("Проверка доступности Geoserver")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/geoserver/rest/about/system-status"),
            @Link(name = "prod", url = "https://smart.mos.ru/geoserver/rest/about/system-status")})
    void geoserverTests() {
        ValidatableResponse response = authorization.apiRequestBasicGeoserver()
                .get("geoserver/rest/about/system-status")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}


