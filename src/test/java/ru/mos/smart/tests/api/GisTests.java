package ru.mos.smart.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Api тесты проверка доступности Swagger приложений и  микросервисов")
public class GisTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Link(url = "https://smart-predprod.mos.ru/app/gis/search/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/gis/search/swagger-ui.html [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void gisSearchTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/gis/search/swagger-ui.html")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

}
