package ru.mos.smart.steps;

import io.restassured.specification.RequestSpecification;
import ru.mos.smart.config.ConfigHelper;

import static io.restassured.RestAssured.given;
import static ru.mos.smart.LogFilter.LogFilter.filters;
import static ru.mos.smart.config.ConfigHelper.webConfig;
import static ru.mos.smart.helpers.AuthorizationHelper.getAccessToken;

public class ApiSteps {

    public RequestSpecification apiRequestBearer() {

        return
                given()
                        .filter(filters().withCustomTemplates())
                        .baseUri(ConfigHelper.getApplicationUrl())
                        .header("Authorization", "Bearer " + getAccessToken())
                        .log().uri()
                        .when();
    }


    public RequestSpecification apiRequestBasic() {

        return
                given()
                        .filter(filters().withCustomTemplates())
                        .baseUri(ConfigHelper.getWebUrl())
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
                        .baseUri(ConfigHelper.getWebUrl())
                        .auth()
                        .preemptive()
                        .basic(webConfig().loginGeoserver(), webConfig().passwordGeoserver())
                        .log().uri()
                        .when();
    }
}
