package ru.mos.smart.tests.mkapmii;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.api.mkapmii.MkapmiiCreatingTestStatement;
import ru.mos.smart.helpers.annotations.AutoMember;
import ru.mos.smart.helpers.junit.OnPreprodOnly;

public class MkapmiiCreateApplicationTest {

    @Test
    @OnPreprodOnly
    @DisplayName("Создание заявки через сваггер")
    @Epic("OASI")
    @Feature("MKAPMII")
    @Story("MKAPMII")
    @AutoMember("SoldatovKS")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void createApplicationViaApiTest() {

        Faker faker = new Faker();
        MkapmiiCreatingTestStatement mkapmii = new MkapmiiCreatingTestStatement();

        Object number = faker.number().digits(4);
        String randomTestId = "Тестовая заявка MKAPMII №:" + "KL-" + number;
        mkapmii.create(randomTestId);
    }
}
