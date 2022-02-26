package ru.mos.smart.tests.regressions.app;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static org.hamcrest.Matchers.equalTo;

@Epic("Проверка микросервисов")
public class EhdTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Description("Запрос на получение информации о справочниках ЕХД")
    @DisplayName("/ehd/dictsInfo [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/ehd/dictsInfo"),
            @Link(name = "prod", url = "https://smart.mos.ru/catalogs/ehd/dictsInfo")})
    void ehdDictsInfoTest() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/ehd/dictsInfo")
                .then()
                .body("get(0).id", equalTo(60))
                .body("get(0).name", equalTo("Справочник округов"))
                .body("get(0).total", equalTo(12));

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
