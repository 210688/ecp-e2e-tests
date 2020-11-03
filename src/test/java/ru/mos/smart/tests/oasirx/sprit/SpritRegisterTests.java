package ru.mos.smart.tests.oasirx.sprit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("SPRIT (Выдача СПРИТ)")
@Tag("oasirx") @Tag("sprit")
public class SpritRegisterTests extends TestBase {

    @Test
    @DisplayName("Проверка вкладок раздела \"Выдача СПРИТ\"")
    void checkingSectionOfRegisterSprit() {
        openUrlWithAuthorization("", LOGIN_OSSIG, PASSWORD_OSSIG);

        step("В боковой панели открыть вкладку \"Выдача СПРИТ\"", () -> {
            sleep(10000);
            $(byLinkText("Выдача СПРИТ")).click();
        });

        step("Реестр ВРИ содержит четыре вкладки", () -> {
            $(byText("Запросы в работе")).shouldBe(visible);
            $(byText("Все запросы")).shouldBe(visible);
            $(byText("Мои запросы")).shouldBe(visible);
            $(byText("Витрина")).shouldBe(visible);
        });
    }
}
