package ru.mos.smart.tests.regressions.app;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Проверка микросервисов")
public class SolrTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Description("Получение списка ошибок конфигурации")
    @DisplayName("/search/v1/solr/admin/errors  [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/search/v1/solr/admin/errors"),
            @Link(name = "prod", url = "https://smart.mos.ru/search/v1/solr/admin/errors")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ehdDictsInfoTest() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/search/v1/solr/admin/errors ")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
