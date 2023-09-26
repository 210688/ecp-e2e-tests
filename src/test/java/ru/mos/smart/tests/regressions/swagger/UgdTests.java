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
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("UGD")
public class UgdTests extends ApiBearerTestBase {

    @Test
    @AllureId("16914")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("SSR")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/ssr/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/ssr/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/ssr/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions") ,@Tag("regres")})
    void ugdSsrTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/ssr/documentTypes/all")
                .then()
                .body("name[3]", is("Дефекты квартиры"))
                .body("name[4]", is("Сведения о документах"));

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16919")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("DOCS")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/docs/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/docs/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/docs/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void ugdDocsTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/docs/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16910")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("LRP")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/lrp/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/lrp/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/lrp/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void ugdLrpTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/lrp/documentTypes/all")
                .then()
                .body("code[0]", is("BEST-RELEASED-PROJECT-REQUEST"))
                .body("code[1]", is("MAIL"));

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16915")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("GZK")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/gzk/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/gzk/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/gzk/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void ugdDGzkTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/gzk/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16911")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("NSI")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/nsi/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/nsi/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/nsi/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void ugdNsiTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/nsi/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16913")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("MTSK")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/mtsk/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/mtsk/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/mtsk/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void ugdDMtskTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/mtsk/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16916")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("OATI")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/oati/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/oati/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/oati/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void ugdOatiTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/oati/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16909")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("PS")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/ps/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/ps/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/ps/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void ugdPsTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/ps/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16920")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("UPSD")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/upsd/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/upsd/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/upsd/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void ugdUpsdTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/upsd/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16912")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("CP")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ugd/cp/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/ugd/cp/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ugd/cp/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void ugdCpTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ugd/cp/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
