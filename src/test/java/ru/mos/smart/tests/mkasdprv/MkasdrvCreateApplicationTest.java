package ru.mos.smart.tests.mkasdprv;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.mkasdprv.Application;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.TasksPage;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;
import static ru.mos.smart.utils.RandomUtils.getRandomString;

public class MkasdrvCreateApplicationTest extends TestBase {

    @Test
    @AllureId("4812")
    @DisplayName("Создание заявки через свагер + запрос")
    @Tag("documents")
    @Epic("MKASDPRV (МКА Вывески)")
    @Feature("Автотесты")
    void createApplicationViaApiTest() {
        String randomTestId = "TEST_ID:" + getRandomString(10);
        Application application = new Application();
        application.create(randomTestId);

        step("Открыть мои задачи на портале, должна появиться заявка Проверить данные заявления", () -> {
            AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
            TasksPage.openTaskByTestId(randomTestId);
        });
    }
}
