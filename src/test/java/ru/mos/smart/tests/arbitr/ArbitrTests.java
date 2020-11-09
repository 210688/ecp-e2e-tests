package ru.mos.smart.tests.arbitr;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("ARBITR (Арбитраж)")
@Feature("")
@Tag("arbitr")
public class ArbitrTests extends TestBase {

    @Test
    @DisplayName("Загрузка модуля \"Поиск дел\"")
    void loadingModulePoiskDel() {
        openUrlWithAuthorization("", LOGIN_OSSIG, PASSWORD_OSSIG);

        step("Перейти в раздел \"Арбитраж\"", () -> {
            $(byLinkText("Информация")).click();
            $(byLinkText("Арбитраж")).click();
        });

        step("Раздел открывается", () -> {
            $(byText("Арбитраж")).shouldBe(visible);
        });
    }
}
