package ru.mos.smart.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import ru.mos.smart.requests.Authorization;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ApiBasicTestBase {

    public static Authorization authorization;

    @BeforeAll
    public static void init() {
        authorization = new Authorization();
    }
}
