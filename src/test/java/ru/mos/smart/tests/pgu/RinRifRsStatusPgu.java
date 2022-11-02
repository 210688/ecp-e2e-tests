package ru.mos.smart.tests.pgu;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.helpers.utils.FileUtils;
import ru.mos.smart.tests.ApplicationTestBase;

import java.io.IOException;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.mos.smart.config.ConfigHelper.*;
import static ru.mos.smart.helpers.AuthorizationHelper.getAccessToken;

public class RinRifRsStatusPgu extends ApplicationTestBase {

    @Test
    @Tag("pgu")
    void statusPgu() throws IOException {
        String eno = getEnoList();
        String date = getDateList();
        String pgu = getPguForText();
        String pguSystem = getPguSystem();

        step("Отправка статуса 103099", () -> {
            String requestMessage = FileUtils.readStringFromFile("src/test/resources/files_for_tests/pgu/SendStatusForPgu.txt");
            requestMessage = requestMessage.replace("{ENO}", eno);
            requestMessage = requestMessage.replace("{DATE}", date);
            requestMessage = requestMessage.replace("{PGUFORTEXT}", pgu);
            System.out.println(eno);
            System.out.println(date);
            System.out.println(pgu);
            String response = given()
                    .baseUri(ConfigHelper.getApplicationUrl())
                    .header("Authorization", "Bearer " + getAccessToken())
                    .contentType(ContentType.JSON)
                    .body(requestMessage)
                    .log().body()
                    .when()
                    .post("app/sys/bus/v2/asyncbus/{pgu_system}/sys_StatusForPgu6.1", pguSystem)
                    .then()
                    .statusCode(200)
                    .extract().response().body().asString();
            System.out.println("Check for SQL = " + response);
        });
    }
}