package ru.mos.smart.api;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.jsoup.Jsoup;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.sleep;
import static io.restassured.RestAssured.given;

public class Authorization {
    static Map<String, Map<String, String>> authCookiesCollection = new HashMap<>();
    static Map<String, String> loginStatus = new HashMap<>();

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

    private static Map<String, String> authorize(String login, String password) {
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
        Map<String, String> cookies = new HashMap<>(response.cookies());
        cookies.putAll(given()
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
                .extract().cookies());

        return cookies;
    }

    public static Map<String, String> getAuthCookie(String login, String password) {
        if (loginStatus.get(login) == null) {
            loginStatus.put(login, "Started");
            authCookiesCollection.put(login, authorize(login, password));
            loginStatus.put(login, "Done");
        }
        if (loginStatus.get(login).equals("Started")) {
            for (int i = 0; i < 30; i++) {
                if (loginStatus.get(login).equals("Started")) {
                    sleep(1000);
                } else {
                    break;
                }
            }
        }
        if (authCookiesCollection.get(login) == null) {
            return authCookiesCollection.put(login, authorize(login, password));
        } else {
            return authCookiesCollection.get(login);
        }
    }
}
