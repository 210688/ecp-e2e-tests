package ru.mos.smart.tests.mkasdprv;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.mkasdprv.Application;
import ru.mos.smart.helpers.junit.OnPreprodOnly;
import ru.mos.smart.tests.TestBase;

public class MkasdprvCreateApplicationTest extends TestBase {

    @Test
    @OnPreprodOnly
    @DisplayName("Создание заявки через свагер + запрос")
    @Epic("OASI")
    @Feature("MKASDPRV")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void createTaskMkasdprv() {

        Faker faker = new Faker();
        Object number = faker.number().digits(4);
        String randomTestId = "Тестовая заявка MKASDPRV №:" + "KB-" + number;
        Application application = new Application();
        application.create(randomTestId);
    }
}
