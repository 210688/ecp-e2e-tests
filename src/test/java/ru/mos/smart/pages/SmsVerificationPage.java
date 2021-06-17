package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.restassured.RestAssured.given;

public class SmsVerificationPage {
    @Step("Верификация по смс (если этот шаг появился)")
    public static void verifyBySms(String phoneNumber) {
        sleep(1000);
        System.out.println(phoneNumber + "Second");
        if ($("#otp").exists()) {
            String verificationCode = getPhoneCode(phoneNumber);
            $("#otp").val(verificationCode).pressEnter();
        }
        if ($("#sms-code").exists()) {
            String verificationCode = getPhoneCode(phoneNumber);
            $("#sms-code").val(verificationCode).pressEnter();
        }
        if ($("#cfmCode").exists()) {
            String recCode = getPhoneCode(phoneNumber);
            $("#cfmCode").val(recCode).pressEnter();
        }
        if ($("#sms_code").exists()) {
            String recCode = getPhoneCode(phoneNumber);
            $("#sms_code").val(recCode).pressEnter();
        }
    }


    @Step("Получение кода подтверждения по номеру телефона")
    public static String getPhoneCode(String phoneNumber) {
        return given()
                .log().uri()
                .header("Authorization", "Basic c3VkaXItcWE6cVFCVjcwZkk0Yk13")
                .when()
                .get("https://test.krlb.ru/sudir/sms/?mobile=" + phoneNumber + "&latest")
                .then()
                .log().body()
                .extract().path("[0].code");
    }
}