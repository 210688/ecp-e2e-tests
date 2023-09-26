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

@Epic("ИАИС")
@Feature("Rinrif")
public class RinrifTests extends ApiBearerTestBase {

    @Test
    @AllureId("16921")
    @Layer("api")
    @Story("Nadzor")
    @Owner("Soldatovks")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/rinrif/nadzor/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/nadzor/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/nadzor/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions") ,@Tag("regres")})
    void rinrifNadzorTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/rinrif/nadzor/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16918")
    @Layer("api")
    @Story("Matcap")
    @Owner("Soldatovks")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/rinrif/matcap/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/matcap/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/matcap/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void rinrifMatcapTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/rinrif/matcap/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }

    @Test
    @AllureId("16917")
    @Layer("api")
    @Story("Snos")
    @Owner("Soldatovks")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/rinrif/snos/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/snos/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/snos/swagger-ui.html")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void rinrifSnosTests() {
        ValidatableResponse response = apiRequestBearer()
                .get("app/rinrif/snos/documentTypes/all")
                .then();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}
