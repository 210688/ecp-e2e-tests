package ru.mos.smart.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SmsVerificationPage {
    @Step("Верификация по смс (если этот шаг появился)")
    public static void verifyBySms(String phoneNumber) {
        sleep(1000);
        System.out.println(phoneNumber + "Second");
        if ($("#sms-code").exists()) {
            String verificationCode = new AccountVerification().getPhoneCode(phoneNumber);
            $("#sms-code").val(verificationCode).pressEnter();
        }
        if ($("#cfmCode").exists()) {
            String recCode = new AccountVerification().getPhoneCode(phoneNumber);
            $("#cfmCode").val(recCode).pressEnter();
        }
        if ($("#sms_code").exists()) {
            String recCode = new AccountVerification().getPhoneCode(phoneNumber);
            $("#sms_code").val(recCode).pressEnter();
        }
    }
}