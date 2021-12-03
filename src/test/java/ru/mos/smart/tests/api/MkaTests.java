package ru.mos.smart.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
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
public class MkaTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Link(url = "https://smart-predprod.mos.ru/app/mkapmii/order/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mkapmii/order/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void mkapmiiOrderTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/mkapmii/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Link(url = "https://smart-predprod.mos.ru/app/mkasdprv/order/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mkasdprv/order/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void mkasdprvOrderTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/mkasdprv/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Link(url = "https://smart-predprod.mos.ru/app/mkaugdint/order/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mkaugdint/order/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void mkaugdintOrderTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/mkaugdint/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Link(url = "https://smart-predprod.mos.ru/app/mkaopugd/order/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/mkaopugd/order/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void mkaopugdOrderTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/mkaopugd/order/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
