package ru.mos.smart.tests.regressions.api;

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
public class OasiTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("7445")
    @Feature("Oasi")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/pzz/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/pzz/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/pzz/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiPzzTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/pzz/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("7446")
    @Feature("Oasi")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/ag/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/ag/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/ag/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiAgTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/ag/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("7447")
    @Feature("Oasi")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/blago/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/blago/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/blago/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiBlagoTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/blago/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("7448")
    @Feature("Oasi")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/cafe/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/cafe/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/cafe/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiCafeTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/cafe/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("7449")
    @Feature("Oasi")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/citydevelopment/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/citydevelopment/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/citydevelopment/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiCitydevelopmentTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/citydevelopment/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("7450")
    @Feature("Oasi")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/pkr/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/pkr/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/pkr/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiPkrTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/pkr/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("7451")
    @Feature("Oasi")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/pmt/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/pmt/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/pmt/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiPmtTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/pmt/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7452")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/ppt/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/ppt/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/ppt/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiPptTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/ppt/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7453")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/facades/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/facades/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/facades/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiFacadesTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/facades/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7454")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/signboard/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/signboard/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/signboard/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiSignboardTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/signboard/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7455")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/gin/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/gin/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/gin/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiGinTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/gin/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7456")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/lighting/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/lighting/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/lighting/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiLightingTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/lighting/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7457")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/monuments/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/monuments/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/monuments/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiMonumentsTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/monuments/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7458")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/mrgp/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/mrgp/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/mrgp/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiMrgpTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/mrgp/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7459")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/nto/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/nto/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/nto/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiNtoTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/nto/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7460")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/oo/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/oo/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/oo/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiOoTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/oo/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7461")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/advertise/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/advertise/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/advertise/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiAdvertiseTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/oo/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7462")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/agr/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/agr/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/agr/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiAgrTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/agr/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Oasi")
    @Owner("Soldatovks")
    @AllureId("7463")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/ddh/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/ddh/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/ddh/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasiDdhTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasi/ddh/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
