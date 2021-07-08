package ru.mos.smart.swagger;

import com.github.javafaker.Faker;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.AutoMember;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.api.mkasdprv.Application;
import ru.mos.smart.tests.TestBase;

import static io.qameta.allure.Allure.step;

@Layer("api")
public class CreateTaskMkasdprv extends TestBase {

    private Object Number;

    @Test
    @AllureId("5184")
    @DisplayName("Создание заявки через свагер")
    @Tag("documents")
    @Epic("MKASDPRV (МКА Вывески)")
    @Feature("Автотесты")
    @AutoMember("SoldatovKS")
    void CreateTaskMkasdprv() {

        Faker faker = new Faker();
        Number = faker.number().digits(4);
        String randomTestId = "Тестовая заявка MKASDPRV №:" + "KB-" + Number;
        Application application = new Application();
        application.create(randomTestId);

        step("Развернуть МКА_СДП_РВ - Контроллер статусов для ПГУ");
        step("Развернуть /pgu_status/pgu_mock_request");
        step("Вставить запрос который приложен в attach, вместе со скобками заменив скобки которые в запросе и нажать Execute");
        step("Server Responce - Code 200");
        step("Открыть мои задачи на портале, должна появиться заявка Проверить данные заявления");
    }

}
/*
Faker faker = new Faker();
        Number = faker.number().digits(10);
public class MkasdrvCreateApplicationTest extends TestBase {
    @Test
    @AllureId("4812")
    @DisplayName("Создание заявки через свагер + запрос")
    @Tag("documents")
    @Epic("MKASDPRV (МКА Вывески)")
    @Feature("Автотесты")
    void createApplicationViaApiTest() {
        String randomTestId = "TEST_ID:" + RandomUtils.getRandomString(10);
        Application application = new Application();
        application.create(randomTestId);

        step("Открыть мои задачи на портале, должна появиться заявка Проверить данные заявления", () -> {
            AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
            TasksPage.openTaskByTestId(randomTestId);
        });
    }
}


 */