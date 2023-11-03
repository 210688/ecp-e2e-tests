package ru.mos.smart.tests.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("Проверка работы swagger по подсистемам")
@Tags({@Tag("ossigmip"), @Tag("regres"), @Tag("swagger")})
public class OssigmipTests extends ApiBearerTestBase {

    @Test
    @AllureId("16926")
    @Feature("OSSIGMIP")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(/app/ossigmip/permit/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/ossigmip/permit/pzz/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/ossigmip/permit/swagger-ui.html")})
    void ossigmipPermitTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("/app/ossigmip/permit/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());
        response.statusCode(200);
    }
}
