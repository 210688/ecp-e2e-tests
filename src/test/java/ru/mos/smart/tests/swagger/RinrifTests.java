package ru.mos.smart.tests.swagger;

import io.qameta.allure.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("Проверка работы swagger по подсистемам")
@Feature("ИАИС РИН")
@Tags({@Tag("rinrif"), @Tag("regres"), @Tag("swagger")})
public class RinrifTests extends ApiBearerTestBase {

    @Test
    @AllureId("16921")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("NADZOR")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/rinrif/nadzor/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/nadzor/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/nadzor/swagger-ui.html")})
    void rinrifNadzorTests() {
        Response response = apiRequestBearer()
                .get("app/rinrif/nadzor/documentTypes/all")
                .then()
                .extract().response();

        responseCode.checkResponseCode(response.statusCode(), 200);
    }

    @Test
    @AllureId("16918")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("MATCAP")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/rinrif/matcap/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/matcap/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/matcap/swagger-ui.html")})
    void rinrifMatcapTests() {
        Response response = apiRequestBearer()
                .get("app/rinrif/matcap/documentTypes/all")
                .then()
                .extract().response();
        responseCode.checkResponseCode(response.statusCode(), 200);
    }

    @Test
    @AllureId("16917")
    @Layer("api")
    @Owner("Soldatovks")
    @Story("SNOS")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/rinrif/snos/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/snos/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/snos/swagger-ui.html")})
    void rinrifSnosTests() {
        Response response = apiRequestBearer()
                .get("app/rinrif/snos/documentTypes/all")
                .then()
                .extract().response();

        responseCode.checkResponseCode(response.statusCode(), 200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("18001")
    @Story("RV")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/rinrif/rv/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/rv/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/rv/swagger-ui.html")})
    void getDocumentsRinrifRvTests() {
        Response response = apiRequestBearer()
                .get("app/rinrif/rv/documentTypes/all")
                .then()
                .extract().response();

        responseCode.checkResponseCode(response.statusCode(), 200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("18004")
    @Story("RS")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/rinrif/rs/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/rs/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/rs/swagger-ui.html")})
    void getDocumentsRinrifRsTests() {
        Response response = apiRequestBearer()
                .get("app/rinrif/rs/documentTypes/all")
                .then()
                .extract().response();

        responseCode.checkResponseCode(response.statusCode(), 200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("18003")
    @Story("IZS")
    @DisplayName("Описания всех типов документов")
    @Description("Проверить, что описаны все типы документов(app/rinrif/izs/documentTypes/all [GET])")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/izs/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/izs/swagger-ui.html")})
    void getDocumentsRinrifIzsTests() {
        Response response = apiRequestBearer()
                .get("app/rinrif/izs/documentTypes/all")
                .then()
                .extract().response();

        responseCode.checkResponseCode(response.statusCode(), 200);
    }

    @Test
    @Layer("api")
    @Owner("Soldatovks")
    @AllureId("18002")
    @Story("PM")
    @DisplayName("Описания всех типов документов Предостережения")
    @Description("Проверить, что описаны все типы документов Предостережения")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/app/rinrif/pm/swagger-ui.html"),
            @Link(name = "prod", url = "https://smart.mos.ru/app/rinrif/pm/swagger-ui.html")})
    void getDocumentsRinrifIPmTests() {
        Response response = apiRequestBearer()
                .get("app/rinrif/pm/documentTypes/all")
                .then()
                .extract().response();

        responseCode.checkResponseCode(response.statusCode(), 200);
    }
}
