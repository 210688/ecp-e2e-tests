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
public class OasirxTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/crd/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/crd/swagger-ui.html#/")
    void oasirxCrdTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/crd/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/elma/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/elma/swagger-ui.html#/")
    void oasirxElmaTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/elma/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/eoo/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/eoo/swagger-ui.html#/")
    void oasirxEooTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/eoo/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/fii/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/fii/swagger-ui.html#/")
    void oasirxFiiTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/fii/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/hearings/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/hearings/swagger-ui.html#/")
    void oasirxHearingsTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/hearings/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/pkl/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/pkl/swagger-ui.html#/")
    void oasirxPklTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/Pkl/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/pmt/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/pmt/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxPmtTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/pmt/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Link(url = "https://smart-predprod.mos.ru/app/oasi/pzz/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/pzz/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxPzzTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/pzz/documentTypes/all")
                .then()
                .log().status();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/sb/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/sb/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxSbTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/sb/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/sprit/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/sprit/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxSpritTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/sprit/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/szz/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/szz/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxSzzTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/szz/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/violation/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/violation/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxViolationTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/violation/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx swagger")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/vri/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/vri/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxVriTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/vri/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
