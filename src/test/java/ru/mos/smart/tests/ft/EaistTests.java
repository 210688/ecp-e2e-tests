package ru.mos.smart.tests.ft;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("FT (Электронная приемка по ФТ)")
@Tag("EAIST (ЕАИСТ)")
@Tag("eaist")

public class EaistTests extends TestBase {

    @Test
    @DisplayName("Проверка реестров ЕАИСТ")
    void mapsCanBeOpened() {
        LoginPage.openUrlWithAuthorization("", LOGIN_OSSIG, PASSWORD_OSSIG);

        step("Перейти \"Информация\" -> \"Реестры\"", ()-> {
            $(byLinkText("Информация")).click();
            $(byLinkText("Реестры")).click();
        });

        step("В поисковой строке ввести \"ЕАИСТ\"", () -> {
            $(".form-control").setValue("ЕАИСТ").pressEnter();
        });

        step("Найдены реестры", () -> {
            $(byText("Реестр заказчиков ЕАИСТ")).shouldBe(visible);
            $(byText("Реестр контрактов ЕАИСТ")).shouldBe(visible);
            $(byText("Реестр поставщиков ЕАИСТ")).shouldBe(visible);
            $(byText("Реестр этапов контрактов ЕАИСТ")).shouldBe(visible);
        });
    }
}
