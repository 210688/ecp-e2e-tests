package ru.mos.smart.tests.regressions.swagger;

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
public class OssigmipTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Feature("Ossigmip")
    @Owner("Soldatovks")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ossigmip/permit/documentTypes/all [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/ossigmip/permit/pzz/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ossigmip/permit/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void ossigmipPermitTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ossigmip/permit/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
