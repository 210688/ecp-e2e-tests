package ru.mos.smart.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import ru.mos.smart.steps.ApiSteps;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ApiBasicTestBase {

    public static ApiSteps apiSteps;

    @BeforeAll
    public static void init() {
        apiSteps = new ApiSteps();
    }
}
