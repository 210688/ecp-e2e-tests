package ru.mos.smart.api.mkapmii;

import io.restassured.http.ContentType;
import ru.mos.smart.api.Authorization;
import ru.mos.smart.api.models.mkasdprv.PguMockRequest;
import ru.mos.smart.utils.FileUtils;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class Mkapmii {
    public void create(String name) {
        step("Создаем заявление по API", () -> {
            String requestMessage = FileUtils.readStringFromFile("src/test/resources/files_for_tests/mkapmii/pgu_mock_request.txt");
            requestMessage = requestMessage.replace("{STREET}", name);

            PguMockRequest request = new PguMockRequest();
            request.setId(0);
            request.setMessage(requestMessage);
            request.setMessageType("string");

            Authorization authorization = new Authorization();

            given()
                    .cookies(authorization.getAuthCookie(webConfig().loginMka(), webConfig().passwordMka()))
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .post("/app//mkapmii/order/pgu/pgu_mock_request")
                    .then()
                    .statusCode(200);
        });
    }
}