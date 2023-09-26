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

    @Epic("OASI")
    @Feature("Oasirx")
public class OasirxTests extends ApiBearerTestBase {

    @Test
    @AllureId("16929")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("CRD")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/crd/documentTypes/all [GET])")
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
    @AllureId("16931")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("Elma")
    @DisplayName("Описания всех типов документов ")
    @Description("Проверить, что описаны все типы документов(app/oasirx/elma/documentTypes/all [GET])")
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
    @AllureId("16937")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("Eoo")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/eoo/documentTypes/all [GET])")
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
    @AllureId("16935")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("Fii")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/fii/documentTypes/all [GET])")
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
    @AllureId("16936")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("Hearings")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/hearings/documentTypes/all [GET])")
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
    @AllureId("16925")
    @Layer("api")
    @Story("PKL")
    @Owner("Soldatovks")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/pkl/documentTypes/all [GET])")
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
    @AllureId("16934")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("PMT")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/pmt/swagger-ui.html#/")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/pmt/documentTypes/all [GET])")

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
    @AllureId("16939")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("SB")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/sb/swagger-ui.html#/")
    @DisplayName("Получение описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/sb/documentTypes/all [GET])")
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
    @AllureId("16924")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("Sprit")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/sprit/swagger-ui.html#/")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/sprit/documentTypes/all [GET])")
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
    @AllureId("16938")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("SZZ")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/szz/swagger-ui.html#/")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/szz/documentTypes/all [GET])")
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
    @AllureId("16923")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("Violation")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/violation/swagger-ui.html#/")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/violation/documentTypes/all [GET])")
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
    @AllureId("16922")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("VRI")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/vri/swagger-ui.html#/")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/vri/documentTypes/all [GET])")
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
    @AllureId("16927")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("Itmka")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/itmka/swagger-ui.html#/")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/itmka/documentTypes/all [GET])")
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
    @AllureId("16933")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("Itmka")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/itmka/swagger-ui.html#/")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasirx/pzz/documentTypes/all [GET])")
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
