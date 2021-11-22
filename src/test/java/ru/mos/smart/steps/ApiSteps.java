package ru.mos.smart.steps;


import io.restassured.specification.RequestSpecification;
import ru.mos.smart.config.ConfigHelper;

import static io.restassured.RestAssured.given;
import static ru.mos.smart.LogFilter.LogFilter.filters;
import static ru.mos.smart.helpers.AuthorizationHelper.getAccessToken;

public class ApiSteps {
    public RequestSpecification apiRequest() {

        return
                given()
                        .filter(filters().withCustomTemplates())
                        .baseUri(ConfigHelper.getApplicationUrl())
                        .header("Authorization", "Bearer " + getAccessToken())
                        .log().uri()
                        .when();
    }
}
