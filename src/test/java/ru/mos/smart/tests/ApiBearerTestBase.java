
package ru.mos.smart.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import ru.mos.smart.steps.ApiSteps;

import static ru.mos.smart.helpers.AuthorizationHelper.getAccessToken;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ApiBearerTestBase {

    //public static String environment;
    public static ApiSteps apiSteps;

    @BeforeAll
    public static void init() {
        apiSteps = new ApiSteps();
        getAccessToken();

        //environment = System.getProperty("environment");
    }
}

