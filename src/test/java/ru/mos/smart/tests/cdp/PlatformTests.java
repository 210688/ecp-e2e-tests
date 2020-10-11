package ru.mos.smart.tests.cdp;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

public class PlatformTests {

}
    @Layer("web")
    @Epic("CDP (ЕЦП_платформа)")
    @Tag("cdp")
    class SupportRequest extends TestBase {

    @Test
    @Description("Используется тестовый пользователь 89 c нужными правами")
    @DisplayName("Проверка отправки уведомления в тех подержку")
    void SupportRequestForward() {
        openUrlWithAuthorization("", LOGIN_FEEDBACK, PASSWORD_FEEDBACK); //авторизация в системе
        step("Открытие ссылки Инициировать обращение в техническую поддержку", () -> {

});
    }
}
