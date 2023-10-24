package ru.mos.smart.tests.regressions.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("OASI")
@Feature("OASI")
@Tags({@Tag("oasi"), @Tag("regres") })
public class OasiTests extends ApiBearerTestBase {

    @Test
    @AllureId("16945")
    @Story("PZZ")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasi/pzz/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/pzz/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/pzz/swagger-ui.html")})
    void oasiPzzTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/pzz/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @AllureId("16930")
    @Story("AG")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/oasi/ag/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/ag/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/ag/swagger-ui.html")})
    void oasiAgTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/ag/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @AllureId("16948")
    @Story("Blago")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/blago/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/blago/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/blago/swagger-ui.html")})
    void oasiBlagoTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/blago/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16928")
    @Story("Cafe")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/cafe/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/cafe/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/cafe/swagger-ui.html")})
    void oasiCafeTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/cafe/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16941")
    @Story("Citydevelopment")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/citydevelopment/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/citydevelopment/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/citydevelopment/swagger-ui.html")})
    void oasiCitydevelopmentTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/citydevelopment/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16949")
    @Story("PKR")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/pkr/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/pkr/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/pkr/swagger-ui.html")})
    void oasiPkrTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/pkr/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16953")
    @Story("Facades")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/facades/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/facades/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/facades/swagger-ui.html")})
    void oasiFacadesTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/facades/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16955")
    @Story("GIN")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/gin/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/gin/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/gin/swagger-ui.html")})
    void oasiGinTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/gin/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16942")
    @Story("Lighting")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/lighting/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/lighting/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/lighting/swagger-ui.html")})
    void oasiLightingTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/lighting/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16951")
    @Story("Monuments")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/monuments/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/monuments/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/monuments/swagger-ui.html")})
    void oasiMonumentsTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/monuments/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16940")
    @Story("MRGP")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/mrgp/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/mrgp/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/mrgp/swagger-ui.html")})
    void oasiMrgpTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/mrgp/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16952")
    @Story("NTO")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/nto/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/nto/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/nto/swagger-ui.html")})
    void oasiNtoTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/nto/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16932")
    @Story("OO")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/oo/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/oo/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/oo/swagger-ui.html")})
    void oasiOoTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/oo/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16943")
    @Story("Advertis")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/advertise/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/advertise/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/advertise/swagger-ui.html")})
    void oasiAdvertiseTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/oo/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16947")
    @Story("AGR")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/agr/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/agr/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/agr/swagger-ui.html")})
    void oasiAgrTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/agr/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16944")
    @Story("DDH")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasi/ddh/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/oasi/ddh/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/oasi/ddh/swagger-ui.html")})
    void oasiDdhTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/oasi/ddh/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
