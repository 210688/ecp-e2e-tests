package ru.mos.smart.tests.oasirx.sb;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("SB (Самострой)")

public class SbRegisterTests extends TestBase {
    @Test
    @DisplayName("Просмотр реестра Самострой")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void openingTheRegisterSb() {
        LoginPage.openUrlWithAuthorization("", webConfig().login(), webConfig().passwords());

        step("Из боковой панели перейти в раздел Самострой", () ->
            $x("//span[text()='Самострой']").click());

        step("Открыт раздел Самострой", () ->
            $x("//div/h2[contains(text(),'Самострой')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//a/span[contains(text(),'В работе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Вcе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Справка МГК')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Справка ГЗК')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Поиск карточки реестра Самострой по номеру")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("regress")
    void searchingSbCardByNumber() {
        LoginPage.openUrlWithAuthorization("", webConfig().login(), webConfig().passwords());

        step("Из боковой панели перейти в раздел Самострой", () -> {
            $x("//span[text()='Самострой']").waitUntil(visible, 10000);
            $x("//span[text()='Самострой']").click();
        });

        step("Открыт раздел Самострой", () ->
            $x("//div/h2[contains(text(),'Самострой')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
            $x("//div/input[contains(@class,'form-control')]").setValue("ОСС-0028-2021").pressEnter());

        step("Открыть найденную карточку", () ->
            $$(byText("ОСС-0028-2021")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
            $x("//div/h2[contains(text(),'ОСС-0028-2021')]").shouldBe(visible));
    }
}