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
import static org.hamcrest.Matchers.is;

@Epic("Проверка доступности Swagger приложений")
public class UgdTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/ssr/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/ssr/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/ssr/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdSsrTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/ssr/documentTypes/all")
                .then()
                .body("name[3]", is("Дефекты квартиры"))
                .body("name[4]", is("Сведения о документах"));

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/docs/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/docs/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/docs/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdDocsTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/docs/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/lrp/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/lrp/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/lrp/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdLrpTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/lrp/documentTypes/all")
                .then()
                .body("code[0]", is("BEST-RELEASED-PROJECT-REQUEST"))
                .body("code[1]", is("MAIL"));

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/gzk/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/gzk/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/gzk/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdDGzkTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/gzk/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/nsi/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/nsi/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/nsi/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdNsiTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/nsi/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/mtsk/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/mtsk/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/mtsk/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdDMtskTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/mtsk/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/oati/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/oati/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/oati/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdOatiTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/oati/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/ps/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/ps/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/ps/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdPsTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/ps/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/upsd/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/upsd/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/upsd/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdUpsdTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/upsd/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UGD")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ugd/cp/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/cp/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/cp/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ugdCpTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ugd/cp/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
