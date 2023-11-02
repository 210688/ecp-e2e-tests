package ru.mos.smart.tests.regressions.app;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("Проверка работы swagger по подсистемам")
@Tags({@Tag("cdp"), @Tag("regres"), @Tag("swagger")})
public class CatalogsTests extends ApiBearerTestBase {

    @Test
    @AllureId("17044")
    @DisplayName("Запрос реестров информации")
    void catalogsSourceCodesTest() {
        ValidatableResponse response = apiRequestBearer()
                .get("catalogs/catalog/EHD/54385")
                .then()
                .statusCode(200)
                .body("catalog.code", is(54385));
    }

    @Test
    @AllureId("17043")
    @Owner("SoldatovKS")
    @Layer("api")
    @DisplayName("Получить список имен ядер")
    void catalogsSearchSolrCoresCountTest() {
        ValidatableResponse response = apiRequestBearer()
                .get("catalogs-search/v1/solr/cores/names")
                .then()
                .statusCode(200);
        assertThat("cdp", is(equalTo("cdp")));
    }
}
