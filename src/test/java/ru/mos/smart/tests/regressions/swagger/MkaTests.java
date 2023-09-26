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
public class MkaTests extends ApiBearerTestBase {

    @Test
    @AllureId("16962")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Mkapmii")
    @DisplayName("Описания всех типов документов [GET]")
    @Description("Проверить, что описаны все типы документов [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions") ,@Tag("regres")})
    void mkapmiiOrderTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mkapmii/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @AllureId("16964")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Mkasdprv")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/mkaopugd/order/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mkasdprv/order/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mkapsdprv/order/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void mkasdprvOrderTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mkasdprv/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @AllureId("16961")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Mkaugdint")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/mkaugdint/order/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mkaugdint/order/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mkaugdint/order/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void mkaugdintOrderTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mkaugdint/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @AllureId("16958")
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Mkaopugd")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/mkaopugd/order/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mkaopugd/order/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mkaopugd/order/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void mkaopugdOrderTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mkaopugd/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
