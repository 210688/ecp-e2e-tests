package ru.mos.smart.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.openqa.selenium.Cookie;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;

public class Authorization {
    private static ExtractableResponse<Response> getAutocloseResponse() {
        return
                given()
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0")
                        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                        .header("Accept-Language", "en-US,en;q=0.5")
                        .header("Connection", "close")
                        .header("DNT", "1")
                        .header("Connection", "Upgrade-Insecure-Requests")
                        .when()
                        .get("/autoclose.html")
                        .then()
                        .extract();
    }

    private static String getRequestUrl(String pageSource) {
        return Jsoup.parse(pageSource).select("#kc-form-login").get(0).attr("action");
    }

    private static void setCookies(Map<String, String> cookiesMap) {
        open("/autoclose.html");
        cookiesMap.forEach((k, v) -> getWebDriver().manage().addCookie(new Cookie(k, v)));
    }

    public static void auth(String login, String password) {
        ExtractableResponse<Response> autocloseResponse = getAutocloseResponse();
        String requestUrl = getRequestUrl(autocloseResponse.asString());
        Map<String, String> autocloseCookies = autocloseResponse.cookies();
        Map<String, String> formParams = new HashMap<String, String>() {{
            put("username", login);
            put("password", password);
        }};

        Map<String, String> authorizationCookies =
                given()
                        .cookies(autocloseCookies)
                        .contentType(ContentType.URLENC)
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0")
                        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                        .header("Accept-Language", "en-US,en;q=0.5")
                        .header("Connection", "close")
                        .header("DNT", "1")
                        .header("Connection", "Upgrade-Insecure-Requests")
                        .formParams(formParams)
                        .when()
                        .post(requestUrl)
                        .then()
                        .extract().cookies();

        setCookies(authorizationCookies);
    }

    public static Map<String, String> getAuthCookie(String login, String password) {
        ExtractableResponse<Response> autocloseResponse = getAutocloseResponse();
        String requestUrl = getRequestUrl(autocloseResponse.asString());
        Map<String, String> autocloseCookies = autocloseResponse.cookies();
        Map<String, String> formParams = new HashMap<String, String>() {{
            put("username", login);
            put("password", password);
        }};

        ExtractableResponse<Response> response =
                given()
                        .cookies(autocloseCookies)
                        .contentType(ContentType.URLENC)
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0")
                        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                        .header("Accept-Language", "en-US,en;q=0.5")
                        .header("Connection", "close")
                        .header("DNT", "1")
                        .header("Connection", "Upgrade-Insecure-Requests")
                        .formParams(formParams)
                        .when()
                        .post(requestUrl)
                        .then()
                        .extract();

        return given()
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:76.0) Gecko/20100101 Firefox/76.0")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Language", "en-US,en;q=0.5")
                .header("Connection", "close")
                .header("DNT", "1")
                .header("Connection", "Upgrade-Insecure-Requests")
                .when()
                .redirects().follow(false)
                .get(response.header("Location"))
                .then()
                .extract().cookies();
    }

}
