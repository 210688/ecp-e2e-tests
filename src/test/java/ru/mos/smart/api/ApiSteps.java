package ru.mos.smart.api;

import io.restassured.response.ValidatableResponse;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiSteps {

    public void checkStatusService(ValidatableResponse response) {
        step("Проверка статуса сервиса", () -> {
            String res = response.extract().body().path("status");
            assertThat(res).isEqualTo("UP");
        });
    }

    public void checkStatusCode(ValidatableResponse response) {
        step("Проверка кода ответа от сервиса", () -> {
            parameter("Code", response.extract().statusCode());
            assertThat(response.extract().statusCode()).isEqualTo(200);
        });
    }

    public void getUri(String url) {
        parameter("getUri", url);
    }
}