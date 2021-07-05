package ru.mos.smart.tests.mkapmii;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.mkapmii.Mkapmii;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.TasksPage;
import ru.mos.smart.tests.TestBase;
import ru.mos.smart.utils.RandomUtils;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class MkapmiiCreateApplicationTest extends TestBase {
    @Test
    @AllureId("5179")
    @DisplayName("Создание заявки через сваггер")
    @Epic("Автотесты")
    void createApplicationViaApiTest() {
        String randomTestId = "TEST_ID: " + RandomUtils.getRandomString(10);
        Mkapmii mkapmii = new Mkapmii();
        mkapmii.create(randomTestId);

        step("Открыть мои задачи на портале, должна появиться заявка Проверить данные заявления", () -> {
            AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
            TasksPage.openTaskByTestId(randomTestId);
        });
    }
}
