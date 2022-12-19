package ru.mos.smart.tests.mkapmii;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.AutoMember;
import ru.mos.smart.tests.ApplicationTestBase;

public class MkapmiiCreateApplicationTest extends ApplicationTestBase {

    @Test
    @DisplayName("Создание заявки через сваггер")
    @Epic("Автотесты")
    @AutoMember("SoldatovKS")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("regres"), @Tag("mkapmii"), @Tag("documents")})
    void createApplicationViaApiTest() {

        Object number = faker.number().digits(4);
        String randomTestId = "Тестовая заявка MKAPMII №:" + "KL-" + number;
        mkapmii.create(randomTestId);
/*       step("Открыть мои задачи на портале, должна появиться заявка Проверить данные заявления", () -> {
            AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().getLoginRegress(), webConfig().getPasswordRegress());
            TasksPage.openTaskByTestId(randomTestId);
        });*/
    }
}
