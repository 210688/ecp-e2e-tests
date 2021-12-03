package ru.mos.smart.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static org.hamcrest.Matchers.equalTo;

@Epic("Api тесты проверка доступности Swagger приложений и  микросервисов")
public class EhdTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Feature("EHD")
    @Description("Запрос на получение информации о всех справочниках")
    @DisplayName("/ehd/dictsInfo [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ehdDictsInfoTest() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/ehd/dictsInfo")
                .then()
                .body("get(0).id", equalTo(60))
                .body("get(0).name", equalTo("Справочник округов"))
                .body("get(0).total", equalTo(12))
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
