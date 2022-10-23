package ru.mos.smart.tests.regressions.app;

import io.qameta.allure.*;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.tests.ApiBearerTestBase;

import static io.qameta.allure.Allure.parameter;
import static org.hamcrest.Matchers.equalTo;

@Epic("Проверка микросервисов")
public class AuthTests extends ApiBearerTestBase {

/*    @Test
    @Layer("api")
    @Owner("SoldatovKS")
    @Description("Данные о пользователе, из-под которого идет запрос")
    @DisplayName("/auth/user/testovyi_us [GET]")
    @Links(value = {@Link(name = "predprod", url = "https://smart-predprod.mos.ru/auth/user"),
            @Link(name = "prod", url = "https://smart.mos.ru/auth/user")})
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions"), @Tag("api")})
    void authUserTest() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .get("/auth/user")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200)

                .body("name", equalTo(ConfigHelper.getUsername()))
                .body("principal.user.userLogin", equalTo(ConfigHelper.getUsername()));
    }*/

    @Test
    void UsersGroupTest() {
        ValidatableResponse response = apiSteps.apiRequestBearer()
                .post("/mdm/api/v1/users/userGroups/map")
                .then()
                .log().body();

        parameter("Code", response.extract().statusCode());

        response.statusCode(200);
    }
}