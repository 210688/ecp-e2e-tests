package ru.mos.smart.tests.mkapmii;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.mkapmii.MkapmiiCreatingTestStatement;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.junit.OnPreprodOnly;

@Epic("OASI")
@Feature("MKAPMII")
public class MkapmiiCreateApplicationTest {

    @Test
    @OnPreprodOnly
    @AllureId("17101")
    @Story("Mkapmii")
    @Component("Работа с заявкой")
    @DisplayName("Создание тестовой заявки Mkapmii через swagger")
    @Description("Проверить, что создаётся тестовая заявка Mkapmii через swagger")
    @Tags({@Tag("mkapmii"), @Tag("regres")})
    void createApplicationViaApiTest() {

        Faker faker = new Faker();
        MkapmiiCreatingTestStatement mkapmii = new MkapmiiCreatingTestStatement();
        Object number = faker.number().digits(4);
        String randomTestId = "Тестовая заявка MKAPMII №:" + "KL-" + number;
        mkapmii.create(randomTestId);
    }
}
