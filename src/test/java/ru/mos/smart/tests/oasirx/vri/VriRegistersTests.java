package ru.mos.smart.tests.oasirx.vri;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("VRI (ВРИ)")
@Story("Реестр ВРИ")
public class VriRegistersTests extends TestBase {

    @Test
    @DisplayName("Проверка вкладок в реестре ВРИ")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("vri")})
    void openRegisterVri() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел ВРИ", () ->
                $x("//span[text()='ВРИ']").click());

        step("Открыт раздел ВРИ", () ->
                $x("//div/h2[contains(text(),'ВРИ')]").shouldBe(visible));

        step("Реестр ВРИ содержит пять вкладок", () -> {
            $(byText("ВРИ в работе")).shouldBe(visible);
            $(byText("Все ВРИ")).shouldBe(visible);
            $(byText("Мои ВРИ")).shouldBe(visible);
            $(byText("Срок истекает")).shouldBe(visible);
            $(byText("Отчеты")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Поиск карточки реестра ВРИ по номеру")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("vri")})
    void searchingVriCardByNumber() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел ВРИ", () -> {
            $x("//span[text()='ВРИ']").waitUntil(visible, 10000);
            $x("//span[text()='ВРИ']").click();
        });

        step("Открыт раздел ВРИ", () ->
                $x("//div/h2[contains(text(),'ВРИ')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("ВРИ-0035-2021").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("ВРИ-0035-2021")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'ВРИ-0035-2021')]").shouldBe(visible));
    }
}