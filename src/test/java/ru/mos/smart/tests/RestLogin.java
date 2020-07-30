package ru.mos.smart.tests;
import com.google.gson.JsonObject;
import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;


public class RestLogin {
    @Test
    public void AuthenticationBasics() {
        RestAssured.baseURI = "https://smart-predprod.mos.ru/oauth/expired";
        RequestSpecification request = RestAssured.given();

        Response response = request.get();
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Status message " + response.body().asString());
    }
}
//https://smart-predprod.mos.ru/auth/user