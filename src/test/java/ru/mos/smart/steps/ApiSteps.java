package ru.mos.smart.steps;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static ru.mos.smart.config.ConfigHelper.*;
import static ru.mos.smart.helpers.AuthorizationHelper.getAccessToken;
import static ru.mos.smart.helpers.filter.LogFilter.filters;

public class ApiSteps {

    public RequestSpecification apiRequestBearer() {

        return
                given()
                        .filter(filters().withCustomTemplates())
                        .baseUri(getApplicationUrl())
                        .header("Authorization", "Bearer " + getAccessToken())
                        .log().uri()
                        .when();
    }

    public RequestSpecification apiRequestBasic() {

        return
                given()
                        .filter(filters().withCustomTemplates())
                        .baseUri(getWebUrl())
                        .auth()
                        .preemptive()
                        .basic(webConfig().loginRegress(), webConfig().passwordRegress())
                        .log().uri()
                        .when();
    }

    public RequestSpecification apiRequestBasicGeoserver() {

        return
                given()
                        .filter(filters().withCustomTemplates())
                        .baseUri(getWebUrl())
                        .auth()
                        .preemptive()
                        .basic(getLoginGeoserver(), getPasswordGeoserver())
                        .log().uri()
                        .when();
    }
}
