package ru.mos.smart.tests.oasi.blago;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("BLAGO (ОАСИ Благоустройство)")
public class BlagoRegistersTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия реестров")
    @Tags({@Tag("blago"),@Tag("predprod"),@Tag("prod")})
    void checkingBlagoRegisters() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());
        NavigatorPage.reestrPage();

        step("Выполнить поиск по Проекты благоустройства", () -> {
            $(byName("candidateSearchValue")).setValue("Проекты благоустройства").pressEnter();
        });

        step("Найдены реестры", () -> {
            $(byText("Проекты благоустройства (подготовка инженерно-топографического плана)")).shouldBe(visible);
            $(byText("Проекты благоустройства (подготовка ситуационного плана)")).shouldBe(visible);
            $(byText("Проекты благоустройства (рассмотрение концепции)")).shouldBe(visible);
            $(byText("Проекты благоустройства (согласование изменения границ)")).shouldBe(visible);
            $(byText("Проекты благоустройства (согласование проектов)")).shouldBe(visible);
        });
    }
}
