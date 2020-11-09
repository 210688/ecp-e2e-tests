package ru.mos.smart.tests.oasirx.vri;

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
@Feature("VRI (ВРИ)")
@Story("Реестр ВРИ")
@Tag("oasirx") @Tag("vri")
public class VriRegistersTests extends TestBase{

    @Test
    @DisplayName("Проверка вкладок в реестре ВРИ")
    void openRegisterVri() {
        openUrlWithAuthorization("", LOGIN_OSSIG, PASSWORD_OSSIG);

        step("В боковой панели открыть вкладку \"ВРИ\"", () -> {
            sleep(10000);
            $(byLinkText("ВРИ")).click();
        });

        step("Реестр ВРИ содержит пять вкладок", () -> {
            $(byText("ВРИ в работе")).shouldBe(visible);
            $(byText("Все ВРИ")).shouldBe(visible);
            $(byText("Мои ВРИ")).shouldBe(visible);
            $(byText("Срок истекает")).shouldBe(visible);
            $(byText("Отчеты")).shouldBe(visible);
        });
    }
}