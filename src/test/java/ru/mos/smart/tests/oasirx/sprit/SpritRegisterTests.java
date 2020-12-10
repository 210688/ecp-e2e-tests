package ru.mos.smart.tests.oasirx.sprit;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("SPRIT (Выдача СПРИТ)")
public class SpritRegisterTests extends TestBase {

    @Test
    @DisplayName("Проверка вкладок раздела Выдача СПРИТ")
    @Tag("allModules")
    @Tag("prod")
    void checkingSectionOfRegisterSprit() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsers(), ConfigHelper.getPas());

        step("В боковой панели открыть вкладку Выдача СПРИТ", () -> {
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
