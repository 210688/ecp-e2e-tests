package ru.mos.smart.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Api тесты проверка доступности Swagger приложений и  микросервисов")
public class OssigmipTests extends ApiBearerTestBase {

    @Test
    @Feature("Ossigmip")
    @Link(url = "https://smart-predprod.mos.ru/app/ossigmip/permit/documentTypes/all")
    @Description("Получение описания всех типов документов")
    @DisplayName("/app/ossigmip/permit/documentTypes/all [GET]")
    void ossigmipPermitTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/app/ossigmip/permit/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
