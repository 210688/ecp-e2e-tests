package ru.mos.smart.tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.steps.ApiSteps;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.qameta.allure.Allure.parameter;
import static ru.mos.smart.helpers.AuthorizationHelper.getAccessToken;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ApiTestBase {
    protected static ApiSteps apiSteps;
    static String environment;
    private static String propertiesFile;

    @BeforeAll
    public static void init() {
        if (System.getProperty("environment") == null) System.setProperty("environment", "predprod"); // its needed for config

        environment = System.getProperty("environment");
        propertiesFile = environment + ".properties";

        //copyFile("src/test/resources/config" + propertiesFile,
        //"build/allure-results/environment.properties");

        apiSteps = new ApiSteps();
        getAccessToken();
    }

    @BeforeEach
    public void beforeEach() {
        attachPropertiesFile();
        parameter("ENVIRONMENT", System.getProperty("environment"));
        parameter("application.url", ConfigHelper.getApplicationUrl());
    }

    public void attachPropertiesFile() {
        Path content = Paths.get("src/test/resources/config/" + propertiesFile);
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment(propertiesFile, is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
