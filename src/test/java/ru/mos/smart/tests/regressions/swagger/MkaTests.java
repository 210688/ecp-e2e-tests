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
@Feature("Mka")
public class MkaTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Mka")
    @DisplayName("Получение описания всех типов документов [GET]")
    @Description("mkapmii/documentTypes [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mkapmii/order/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mkapmii/order/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("regressionsProd")})
    void mkapmiiOrderTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mkapmii/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Mka")
    @Description("/app/mkasdprv/order/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mkasdprv/order/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mkapsdprv/order/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("regressionsProd")})
    void mkasdprvOrderTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mkasdprv/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Mka")
    @Description("/app/mkaugdint/order/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mkaugdint/order/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mkaugdint/order/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("regressionsProd")})
    void mkaugdintOrderTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mkaugdint/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @Feature("Mka")
    @Description("/app/mkaopugd/order/documentTypes/all [GET]")
    @DisplayName("Получение описания всех типов документов")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/mkaopugd/order/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/mkaopugd/order/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api"), @Tag("regressionsProd")})
    void mkaopugdOrderTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/mkaopugd/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
