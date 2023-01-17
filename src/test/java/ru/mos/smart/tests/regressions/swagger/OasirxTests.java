package ru.mos.smart.tests.regressions.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("Проверка доступности Swagger приложений")
public class OasirxTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("app/oasirx/crd/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/crd/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mr/program/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxCrdTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasirx/crd/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("app/oasirx/elma/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов ")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/elma/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/elma/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxElmaTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasirx/elma/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("app/oasirx/eoo/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/eoo/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/eoo/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxEooTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasirx/eoo/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("app/oasirx/fii/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/fii/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/oasirx/fii/program/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxFiiTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasirx/fii/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Oasirx")
    @Description("app/oasirx/hearings/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/hearings/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/hearings/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxHearingsTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasirx/hearings/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasirx")
    @Owner("Soldatovks")
    @Description("app/oasirx/pkl/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/pkl/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/pkl/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxPklTests() {
        ValidatableResponse response = apiRequestBearer()
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
    @Description("app/oasirx/pmt/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/pmt/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/pmt/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxPmtTests() {
        ValidatableResponse response = apiRequestBearer()
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
    @Description("app/oasirx/sb/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/sb/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/sb/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxSbTests() {
        ValidatableResponse response = apiRequestBearer()
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
    @Description("app/oasirx/sprit/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/sprit/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/sprit/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxSpritTests() {
        ValidatableResponse response = apiRequestBearer()
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
    @Description("app/oasirx/szz/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/szz/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/szz/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxSzzTests() {
        ValidatableResponse response = apiRequestBearer()
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
    @Description("app/oasirx/violation/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/violation/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/violation/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxViolationTests() {
        ValidatableResponse response = apiRequestBearer()
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
    @Description("app/oasirx/vri/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/vri/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/vri/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxVriTests() {
        ValidatableResponse response = apiRequestBearer()
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
    @Description("app/oasirx/itmka/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/itmka/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/itmka/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxItmkaTests() {
        ValidatableResponse response = apiRequestBearer()
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
    @Description("app/oasirx/pzz/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasirx/pzz/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasirx/pzz/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void oasirxPzzTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasirx/pzz/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
