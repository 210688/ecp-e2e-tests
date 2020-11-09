package ru.mos.smart.tests;
import com.google.gson.JsonObject;
import io.qameta.allure.Description;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;


public class RestLogin { // todo
    @Test
    public void AuthenticationBasics() {
        RestAssured.baseURI = "https://smart-predprod.mos.ru/oauth/expired";
        RequestSpecification request = RestAssured.given();

        Response response = request.get();
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Status message " + response.body().asString());
    }

//    step("5.Проверка успешности запуска теста", () -> {
//        step("5.1 Нажать кнопку 'Вернуться к списку тестов'", () ->
//                $x("//button[text()='Вернуться к списку тестов']").click());
//        step("5.2 Проверить текст в первой строке в столбце 'Название'", () ->
//                $x("//*[contains(@class, 'jss380')]").shouldHave(text(testName));
//    });

}
//https://smart-predprod.mos.ru/auth/user