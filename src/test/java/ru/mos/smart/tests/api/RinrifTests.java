package ru.mos.smart.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
public class RinrifTests extends ApiBearerTestBase {

    @Test
    @Layer("api")
    @Feature("Rinrif")
    @Link(url = "https://smart-predprod.mos.ru/app/rinrif/nadzor/swagger-ui.html#")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/rinrif/nadzor/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void rinrifNadzorTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/rinrif/nadzor/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @Layer("api")
    @Feature("Rinrif")
    @Link(url = "https://smart-predprod.mos.ru/app/rinrif/matcap/swagger-ui.html#")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/rinrif/matcap/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void rinrifMatcapTests() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("app/rinrif/matcap/documentTypes/all")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
