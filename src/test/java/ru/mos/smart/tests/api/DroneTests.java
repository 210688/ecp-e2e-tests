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
public class DroneTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/vri/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/vri/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxVriTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/oasirx/vri/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
