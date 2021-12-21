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
public class RinrifTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Feature("Rinrif")
    @Owner("Soldatovks")
    @AllureId("7508")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/rinrif/nadzor/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/nadzor/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/nadzor/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void rinrifNadzorTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/rinrif/nadzor/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Rinrif")
    @Owner("Soldatovks")
    @AllureId("7509")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/rinrif/matcap/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/matcap/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/matcap/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void rinrifMatcapTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/rinrif/matcap/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Rinrif")
    @Owner("Soldatovks")
    @AllureId("7510")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/rinrif/snos/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/snos/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/snos/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void rinrifSnosTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/rinrif/snos/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
