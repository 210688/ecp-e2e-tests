package ru.mos.smart.tests.platform;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.ApiBearerTestBase;

import static ru.mos.smart.requests.Authorization.apiRequestBearer;

@Epic("Регрессионные тесты платформы (функционал)")
@Feature("Проверка работоспособности сервиса mail")
@Tag("regressing")
public class MailTests extends ApiBearerTestBase {

    @Test
    @AllureId("18072")
    @Owner("Soldatov")
    @DisplayName("Получение документа заданного типа по идентификатору")
    @Description("")
    void mailDocumentTypeCodTests() {
        Response response = apiRequestBearer()
                .get("/app/sys/mail/documentTypes/MAIL")
                .then()
                .extract().response();

        responseCode.checkResponseCode(response.statusCode(), 200);
    }
}
