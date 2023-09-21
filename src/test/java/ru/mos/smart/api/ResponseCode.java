package ru.mos.smart.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.AssertionsForClassTypes;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;


public class ResponseCode {

    public void checkStatusService(ValidatableResponse response) {
        step("Проверка статуса сервиса", () -> {
            String res = response.extract().body().path("status");
            assertThat(res).isEqualTo("UP");
        });
    }

    @Step("Ожидаемый код ответа = {expectedCode}")
    public void checkResponseCode(int actualCode, int expectedCode) {
        AssertionsForClassTypes.assertThat(actualCode)
                .overridingErrorMessage(
                        format("Актуальный код ответа (%s) не совпадает с ожидаемым (%s)",
                                actualCode, expectedCode)
                )
                .isEqualTo(expectedCode);
    }

    public void getUri(String url) {
        parameter("getUri", url);
    }
}