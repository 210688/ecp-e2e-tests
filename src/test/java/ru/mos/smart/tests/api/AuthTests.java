package ru.mos.smart.tests.api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.helpers.AuthorizationHelper;

import static io.qameta.allure.Allure.parameter;
import static org.hamcrest.Matchers.equalTo;

@Layer("api")
@Feature("auth")
public class AuthTests extends AuthorizationHelper {

    @Test
    @Description("Данные о пользователе, из-под которого идет запрос")
    @DisplayName("/auth/user [GET]")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void authUserTest() {
        ValidatableResponse response = apiSteps.apiRequest()
                .get("/auth/user")
                .then()
                .log().body();


        parameter("Code", response.extract().statusCode());

        response.statusCode(200)

                .body("name", equalTo(ConfigHelper.getUsername()))
                .body("principal.user.userLogin", equalTo(ConfigHelper.getUsername()));
    }
}
