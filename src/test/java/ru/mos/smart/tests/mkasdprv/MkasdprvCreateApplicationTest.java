package ru.mos.smart.tests.mkasdprv;

import com.github.javafaker.Faker;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.mkasdprv.Application;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.TasksPage;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class MkasdprvCreateApplicationTest extends TestBase {
    private Object number;

    @Test
    @AllureId("5654")
    @DisplayName("Создание заявки через свагер + запрос")
    @Epic("MKASDPRV (МКА Вывески)")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("mkasdprv"), @Tag("documents")})
    @Feature("Автотесты")
    void createTaskMkasdprv() {

        Faker faker = new Faker();
        number = faker.number().digits(4);
        String randomTestId = "Тестовая заявка MKASDPRV №:" + "KB-" + number;
        Application application = new Application();
        application.create(randomTestId);

        step("Открыть мои задачи на портале, должна появиться заявка Проверить данные заявления", () -> {
            AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginSwagger(), webConfig().passwordSwagger());
            TasksPage.openTaskByTestId(randomTestId);
        });
    }
}
