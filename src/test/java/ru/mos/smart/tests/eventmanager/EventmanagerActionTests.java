package ru.mos.smart.tests.eventmanager;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("EVENTMANAGER (Менеджер событий)")

public class EventmanagerActionTests extends TestBase {

    @Test
    @Tags({@Tag("preprod"), @Tag("eventmanager")})
    @DisplayName("Проверка доступности реестра Подписки на уведомления о событиях")
    void checkingEventmanagerReestr() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());
        NavigatorPage.goToRegister();

        step("Найти и открыть реестр Подписки на уведомления о событиях", () -> {
            $(byName("candidateSearchValue")).setValue("Подписки на уведомления о событиях").pressEnter();
            $(byLinkText("Подписки на уведомления о событиях")).click();
        });

        step("Проверить, что открывается  реестр Подписки на уведомления о событиях", () -> {
            $(byText("Подписки на уведомления о событиях")).shouldBe(visible);
        });
    }
}
