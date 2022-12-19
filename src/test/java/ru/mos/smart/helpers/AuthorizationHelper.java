package ru.mos.smart.helpers;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static ru.mos.smart.config.ConfigHelper.*;
import static ru.mos.smart.helpers.filter.LogFilter.filters;

public class AuthorizationHelper {

    public static String accessToken;

    //Авторизация
    public static String getAccessToken() {

        if (accessToken == null) accessToken = authorization();

        return accessToken;
    }

    public static String authorization() {
        System.out.println(getLoginServices());
        System.out.println(getPasswordServices());
        String data = "grant_type=password" +
                "&username=" + getLoginServices() +
                "&password=" + getPasswordServices() +
                "&client_id=app-cdp" +
                "&client_secret=" + getClientSecret();

        return given()
                .filter(filters().withCustomTemplates())
                .contentType(ContentType.URLENC)
                .body(data)
                .when()
                .post(getAuthorizationURL() + "/iam/auth/realms/smart/protocol/openid-connect/token")
                .then()
                .statusCode(200)
                .extract().path("access_token");
    }
}
