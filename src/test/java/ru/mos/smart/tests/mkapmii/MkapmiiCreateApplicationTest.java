package ru.mos.smart.tests.mkapmii;

import com.github.javafaker.Faker;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.AutoMember;
import ru.mos.smart.api.mkapmii.Mkapmii;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.TasksPage;
import ru.mos.smart.tests.ApplicationTestBase;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

public class MkapmiiCreateApplicationTest extends ApplicationTestBase {

    @Test
    @AllureId("5179")
    @DisplayName("Создание заявки через сваггер")
    @Epic("Автотесты")
    @AutoMember("SoldatovKS")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("regres"), @Tag("mkapmii"), @Tag("documents")})
    void createApplicationViaApiTest() {

        Object number = faker.number().digits(4);
        String randomTestId = "Тестовая заявка MKAPMII №:" + "KL-" + number;
        mkapmii.create(randomTestId);
/*       step("Открыть мои задачи на портале, должна появиться заявка Проверить данные заявления", () -> {
            AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginRegress(), webConfig().passwordRegress());
            TasksPage.openTaskByTestId(randomTestId);
        });*/
    }
}
