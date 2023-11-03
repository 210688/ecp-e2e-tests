
package ru.mos.smart.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import ru.mos.smart.api.ResponseCode;
import ru.mos.smart.requests.Authorization;

import static ru.mos.smart.helpers.AuthorizationHelper.getAccessToken;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ApiBearerTestBase {

    public static Authorization authorization;
    protected final ResponseCode responseCode = new ResponseCode();

    @BeforeAll
    public static void init() {
        authorization = new Authorization();
        getAccessToken();
    }
}

