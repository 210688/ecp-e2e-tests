package ru.mos.smart.tests.mkasdprv;

import e2e.kronverk.utils.RandomUtils;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.Authorization;
import ru.mos.smart.api.models.mkasdprv.PguMockRequest;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;
import ru.mos.smart.utils.FileUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class MkasdrvCreateApplicationTest extends TestBase {
    @Test
    @AllureId("4812")
    @DisplayName("Создание заявки через свагер + запрос")
    @Tag("documents")
    @Epic("MKASDPRV (МКА Вывески)")
    @Feature("Автотесты")
    void createApplicationViaApiTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        step("Создаем заявление по API", () -> {
            String requestMessage = FileUtils.readStringFromFile("src/test/resources/files_for_tests/pgu_mock_request.txt");
            requestMessage = requestMessage.replace("{STREET}", randomTestId);

            PguMockRequest request = new PguMockRequest();
            request.setId(0);
            request.setMessage(requestMessage);
            request.setMessageType("string");

            given()
                    .cookies(Authorization.getAuthCookie(webConfig().loginMka(), webConfig().passwordMka()))
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .post("/app/mkasdprv/order/pgu_status/pgu_mock_request")
                    .then()
                    .statusCode(200);
        });

        step("Открыть мои задачи на портале, должна появиться заявка Проверить данные заявления", () -> {
            AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
            $("#my-task-showcase").shouldBe(visible, Duration.ofSeconds(15));
            $x("//*[@id='my-task-showcase']//*[contains(text(), '" + randomTestId + "')]").click();
        });
    }
}
