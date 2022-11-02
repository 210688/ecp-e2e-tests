/*
package ru.mos.smart.tests.regressions.app;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.ApiBasicTestBase;

@Epic("Проверка микросервисов")
public class SgTests extends ApiBasicTestBase {

    @Test()
    @Layer("api")
    @Owner("Soldatovks")
    @Description("Проверка сервиса Sg")
    @DisplayName("Проверка сервиса gateway")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ServiceGateway() {
        ValidatableResponse response = apiSteps.apiRequestBasic()
                .get("sg/app/ugd/ps/api/qr/getCcoByUgdId/5B686000CBA6116FC32576000038F8F5")
                .then()
                .log().body();
        response.statusCode(200);

    }
}*/
