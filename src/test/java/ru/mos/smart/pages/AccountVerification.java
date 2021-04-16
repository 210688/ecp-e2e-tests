package ru.mos.smart.pages;

import io.qameta.allure.Step;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class AccountVerification {

    @Step("Получение кода подтверждения по номеру телефона")
    public static String getPhoneCode(String phoneNumber) {
        String response = given()
                .log().uri()
                .header("Authorization", "Basic c3VkaXItcWE6cVFCVjcwZkk0Yk13")
                .when()
                .get("https://test.krlb.ru/sudir/sms/?mobile=" + phoneNumber + "&latest")
                .then()
                .log().body()
                .extract().path("message[0]");
        int msgl = response.length();
        int start = msgl - 6;
        int end = msgl;
        char[] code = new char[end - start];
        response.getChars(start, end, code, 0);

        return Arrays.toString(code)
                .replace(",", "")
                .replace(" ", "")
                .replace("[", "")
                .replace("]", "");

//        return response.replaceAll("Код подтверждения: ", "")
//                .replaceAll("Код для восстановления доступа к учетной записи: ", "");
    }
}

