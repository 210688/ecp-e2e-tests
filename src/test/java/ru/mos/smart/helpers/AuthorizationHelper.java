package ru.mos.smart.helpers;

import io.restassured.http.ContentType;
import ru.mos.smart.config.ConfigHelper;

import static io.restassured.RestAssured.given;
import static ru.mos.smart.LogFilter.LogFilter.filters;

public class AuthorizationHelper {

    public static String accessToken;
    //public static ApiSteps apiSteps;

    //    @Step("Авторизация")
    public static String getAccessToken() {

        if (accessToken == null) accessToken = authorization();

        return accessToken;
    }

    public static String authorization() {
        String data = "grant_type=password" +
                "&username=" + ConfigHelper.getUsername() +
                "&password=" + ConfigHelper.getPassword() +
                "&client_id=app-cdp" +
                "&client_secret=" + ConfigHelper.getClientSecret();

//        Allure.addAttachment("Request body", "text/plain", data);
        return given()
                .filter(filters().withCustomTemplates())
                .contentType(ContentType.URLENC)
                .body(data)
                .when()
                .post(ConfigHelper.getAuthorizationURL() + "/iam/auth/realms/smart/protocol/openid-connect/token")
                .then()
                .statusCode(200)
                .extract().path("access_token");
    }
}
