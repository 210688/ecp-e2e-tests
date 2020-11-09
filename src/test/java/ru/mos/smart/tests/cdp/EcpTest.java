package ru.mos.smart.tests.cdp;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("CDP (ЕЦП_платформа)")
@Tag("cdp")
public class EcpTest extends TestBase {

    @Test
    @DisplayName("Проверка открытия реестра")
    void openReestr() {
        LoginPage.openUrlWithAuthorization("", LOGIN_OSSIG, PASSWORD_OSSIG);
        step("Открытие реестра", () -> {
            $(byLinkText("Информация")).click();
            $(byLinkText("Реестры")).click();
            $(byText("Реестры")).shouldBe(Condition.visible);
        });
    }
}