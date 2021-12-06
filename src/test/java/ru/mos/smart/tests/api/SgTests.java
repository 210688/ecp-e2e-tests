package ru.mos.smart.tests.api;

import io.qameta.allure.Epic;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.ApiBasicTestBase;

@Epic("Api тесты проверки микросервисов")
public class SgTests extends ApiBasicTestBase {

    @Test()
    @Layer("api")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @DisplayName("Проверка сервиса SG")
    void ServiceGateway() {
        ValidatableResponse response = apiSteps.apiRequestBasic()
                .get("sg/app/ugd/ps/api/qr/getCcoByUgdId/5B686000CBA6116FC32576000038F8F5")
                .then()
                .log().body();

        response.statusCode(200);

    }
}