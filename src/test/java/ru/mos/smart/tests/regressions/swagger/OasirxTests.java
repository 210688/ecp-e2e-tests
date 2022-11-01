package ru.mos.smart.tests.regressions.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Проверка доступности Swagger приложений")
public class OasirxTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/crd/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/crd/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/program/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxCrdTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/crd/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/elma/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/elma/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/elma/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxElmaTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/elma/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/eoo/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/eoo/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/eoo/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxEooTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/eoo/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/fii/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/fii/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/oasirx/fii/program/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxFiiTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/fii/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/hearings/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/hearings/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/hearings/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxHearingsTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/hearings/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx")
    @Owner("Soldatovks")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/pkl/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/pkl/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/pkl/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxPklTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/pkl/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/pmt/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/pmt/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/pmt/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/pmt/swagger-ui.html")})
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
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/sb/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/sb/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/sb/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/sb/swagger-ui.html")})
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
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/sprit/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/sprit/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/sprit/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/sprit/swagger-ui.html")})
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
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/szz/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/szz/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/szz/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/szz/swagger-ui.html")})
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
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/violation/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/violation/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/violation/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/violation/swagger-ui.html")})
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
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/vri/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/vri/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/vri/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/vri/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxVriTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/vri/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/itmka/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/itmka/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/itmka/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/itmka/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxItmkaTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/itmka/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/itmka/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/pzz/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/pzz/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/pzz/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxPzzTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/pzz/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
