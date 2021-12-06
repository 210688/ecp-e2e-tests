package ru.mos.smart.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
public class OasiTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Link(url = "https://smart-predprod.mos.ru/app/oasi/pzz/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/pzz/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiPzzTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/pzz/documentTypes/all")
                .then()
                .log().status();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Link(url = "https://smart-predprod.mos.ru/app/oasi/pkr/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/pkr/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiPkrTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/pkr/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Link(url = "https://smart-predprod.mos.ru/app/oasi/pmt/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/pmt/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiPmtTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/pmt/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Link(url = "https://smart-predprod.mos.ru/app/oasi/ppt/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/ppt/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiPptTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/ppt/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
