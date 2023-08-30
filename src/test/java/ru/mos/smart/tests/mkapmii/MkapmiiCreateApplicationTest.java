package ru.mos.smart.tests.mkapmii;

import com.github.javafaker.Faker;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.mkapmii.MkapmiiCreatingTestStatement;
import ru.mos.smart.helpers.annotations.AutoMember;

public class MkapmiiCreateApplicationTest {

    @Test
    @AllureId("5179")
    @DisplayName("Создание заявки через сваггер")
    @Epic("Автотесты")
    @AutoMember("SoldatovKS")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("regres"), @Tag("mkapmii"), @Tag("documents")})
    void createApplicationViaApiTest() {

        Faker faker = new Faker();
        MkapmiiCreatingTestStatement mkapmii = new MkapmiiCreatingTestStatement();

        Object number = faker.number().digits(4);
        String randomTestId = "Тестовая заявка MKAPMII №:" + "KL-" + number;
        mkapmii.create(randomTestId);
/*       step("Открыть мои задачи на портале, должна появиться заявка Проверить данные заявления", () -> {
            AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().getLoginRegress(), webConfig().getPasswordRegress());
            TasksPage.openTaskByTestId(randomTestId);
        });*/
    }
}
