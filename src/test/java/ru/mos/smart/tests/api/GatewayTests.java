package ru.mos.smart.tests.api;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;

import static io.restassured.RestAssured.given;
import static ru.mos.smart.LogFilter.LogFilter.filters;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class GatewayTests {

    @Test()
    @Layer("api")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @DisplayName("Проверка сервиса gateway")
    void Gateway() {
        ValidatableResponse response = given()
                .filter(filters().withCustomTemplates())
                .auth()
                .preemptive()
                .basic(webConfig().loginSwagger(), webConfig().passwordSwagger())
                .get("https://smart-predprod.mos.ru/sg/app/ugd/ps/api/qr/getCcoByUgdId/5B686000CBA6116FC32576000038F8F5")
                .then()
                .log().body();

        response.statusCode(200);
    }
}
