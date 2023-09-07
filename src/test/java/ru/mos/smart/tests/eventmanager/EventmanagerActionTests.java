package ru.mos.smart.tests.eventmanager;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Epic("UGD")
@Feature("CDP")
@Story("Eventmanager")
@Component("Информация")
@Owner("Soldatov")
@Layer("web")
public class EventmanagerActionTests extends TestBase {

    @Test
    @AllureId("5259")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod")})
    @DisplayName("Проверка доступности реестра Подписки на уведомления о событиях")
    void checkingEventmanagerReestr() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToRegister("Подписки на уведомления о событиях");
        step("Проверить, что открывается  реестр Подписки на уведомления о событиях", () -> {
            $(byText("Подписки на уведомления о событиях")).shouldBe(visible);
        });
    }
}
