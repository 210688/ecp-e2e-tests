package ru.mos.smart.api.mkasdprv;

import io.restassured.http.ContentType;
import ru.mos.smart.api.Authorization;
import ru.mos.smart.api.models.mkasdprv.PguMockRequest;
import ru.mos.smart.utils.FileUtils;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class Application {
    public void create(String name) {
        step("Создаем заявление по API", () -> {
            String requestMessage = FileUtils.readStringFromFile("src/test/resources/files_for_tests/mkasdprv/mkasdprv_request.txt");
            requestMessage = requestMessage.replace("{STREET}", name);

            PguMockRequest request = new PguMockRequest();
            request.setId(0);
            request.setMessage(requestMessage);
            request.setMessageType("string");

            Authorization authorization = new Authorization();

            given()
                    .cookies(authorization.getAuthCookie(webConfig().loginSwagger(), webConfig().passwordSwagger()))
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .post("/app/mkasdprv/order/pgu_status/pgu_mock_request")
                    .then()
                    .statusCode(200);
        });
    }
}
