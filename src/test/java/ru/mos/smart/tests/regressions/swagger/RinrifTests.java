package ru.mos.smart.tests.regressions.swagger;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Owner("Soldatovks")
@Epic("OASI")
@Feature("RINRIF")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class RinrifTests extends ApiBearerTestBase {

    @Test
    @AllureId("16921")
    @Story("nadzor")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/rinrif/nadzor/documentTypes/all [GET]")
    void rinrifNadzorTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/rinrif/nadzor/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16918")
    @Story("matcap")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/rinrif/matcap/documentTypes/all [GET]")
    void rinrifMatcapTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/rinrif/matcap/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16917")
    @Story("snos")
    @Description("Получение описания всех типов документов")
    @DisplayName("app/rinrif/snos/documentTypes/all [GET]")
    void rinrifSnosTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/rinrif/snos/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
