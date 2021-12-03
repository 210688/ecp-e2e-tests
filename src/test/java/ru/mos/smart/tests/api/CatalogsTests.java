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
import static org.hamcrest.Matchers.hasItems;

@Epic("Api тесты проверка доступности Swagger приложений и  микросервисов")
public class CatalogsTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Feature("catalogs")
    @Description("Запрос реестров информации")
    @DisplayName("/catalogs/source/codes [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void catalogsSourceCodesTest() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/catalogs/source/codes")
                .then()
                .body("$", hasItems("EHD", "ECHD"))
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("catalogs")
    @Description("Поиск по реестрам информации")
    @DisplayName("/catalogs-search/v1/solr/cores/count [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void catalogsSearchSolrCoresCountTest() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/catalogs-search/v1/solr/cores/count")
                .then()
                .body("apgrcore", equalTo(0))
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
