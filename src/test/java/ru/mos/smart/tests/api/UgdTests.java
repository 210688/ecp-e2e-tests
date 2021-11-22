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
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


@Epic("Api тесты проверки микросервисов")
public class UgdTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Link(url = "https://smart-predprod.mos.ru/app/ugd/ssr/swagger-ui.htm")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/ssr/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void authUserTest() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/ssr/documentTypes/all")
                .then()
                .log().body();


        parameter("Code", response.extract().statusCode());

        response.statusCode(200)

                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/ugdSsrTests.json"));
    }
}
