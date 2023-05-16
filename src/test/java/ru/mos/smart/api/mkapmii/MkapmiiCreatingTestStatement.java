package ru.mos.smart.api.mkapmii;

import io.restassured.http.ContentType;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.helpers.utils.FileUtils;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.mos.smart.helpers.AuthorizationHelper.getAccessToken;

public class MkapmiiCreatingTestStatement {
    public void create(String name, String serviceNumber) {
        step("Создаем заявление по API", () -> {
            //String requestMessage = FileUtils.readStringFromFile("src/test/resources/files_for_tests/mkapmii/mkapmii_request.xml");
            String requestMessage = FileUtils.readStringFromFile("src/test/resources/files_for_tests/mkapmii/pgu_mock_request.json");
            requestMessage = requestMessage.replace("{STREET}", name)
            .replace("{SERVICENUMBER}", serviceNumber);

        /*    PguMockRequest request = new PguMockRequest();
            request.setId(0);
            request.setMessage(requestMessage);
            request.setMessageType("string");*/
            given()
                    .baseUri(ConfigHelper.getApplicationUrl())
                    .header("Authorization", "Bearer " + getAccessToken())
                    .log().uri()
                    .contentType(ContentType.JSON)
                    .body(requestMessage)
                    .when()
                    .post("app/mkapmii/order/pgu/pgu_mock_request")
                    .then()
                    .statusCode(200);
        });
    }
}
