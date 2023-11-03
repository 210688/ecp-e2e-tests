package ru.mos.smart.tests.regressions.app;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("Проверка работы swagger по подсистемам")
@Feature("API по платформе")
@Tags({@Tag("cdp"), @Tag("regres"), @Tag("swagger")})
public class SolrTests extends ApiBearerTestBase {

    @Test
    @AllureId("17046")
    @DisplayName("Получение списка ошибок конфигурации")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/search/v1/solr/admin/errors"),
            @Link(name = "prod", url = "https://smart.mos.ru/search/v1/solr/admin/errors")})
    void ehdDictsInfoTest() {
        ValidatableResponse response = apiRequestBearer()
                .get("search/v1/solr/admin/errors")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
