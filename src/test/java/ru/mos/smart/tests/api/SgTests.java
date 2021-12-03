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
import ru.mos.smart.tests.ApiBasicTestBase;

import static io.qameta.allure.Allure.parameter;

@Epic("Api тесты проверки микросервисов")
public class SgTests extends ApiBasicTestBase {

    @Test()
    @Layer("api")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    @DisplayName("Проверка сервиса SG")
    void ServiceGateway() {
        ValidatableResponse response = apiSteps.apiRequestBasic()
                .get("sg/app/ugd/ps/api/qr/getCcoByUgdId/5B686000CBA6116FC32576000038F8F5")
                .then()
                .log().body();

        response.statusCode(200);

    }

    @Test
    @Layer("api")
    @Link(url = "https://smart-predprod.mos.ru/app/oasirx/Pzz/swagger-ui.html#/")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/oasirx/pzz/documentTypes/all [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void oasirxPzzTests() {
        ValidatableResponse response = apiSteps.apiRequestBasic()
                .get("app/oasirx/Pzz/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
