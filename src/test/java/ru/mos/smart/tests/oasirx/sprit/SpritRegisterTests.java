package ru.mos.smart.tests.oasirx.sprit;

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
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("SPRIT (Выдача СПРИТ)")
public class SpritRegisterTests extends TestBase {

    @Test
    @DisplayName("Проверка вкладок раздела Выдача СПРИТ")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void checkingSectionOfRegisterSprit() {
        LoginPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("В боковой панели открыть вкладку Выдача СПРИТ", () ->
            $x("//span[text()='Выдача СПРИТ']").click());

        step("Открыт раздел СПРИТ", () ->
            $x("//div/h2[contains(text(),'СПРИТ')]").shouldBe(visible));

        step("Реестр Выдача СПРИТ содержит четыре вкладки:", () -> {
            $x("//a/span[contains(text(),'Запросы в работе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Все запросы')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои запросы')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Витрина')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Поиск карточки реестра СПРИТ по номеру")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("regress")
    void searchingSpritCardByNumber() {
        LoginPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел СПРИТ", () -> {
            $x("//span[text()='Выдача СПРИТ']").waitUntil(visible, 10000);
            $x("//span[text()='Выдача СПРИТ']").click();
        });

        step("Открыт раздел СПРИТ", () ->
            $x("//div/h2[contains(text(),'СПРИТ')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
            $x("//div/input[contains(@class,'form-control')]").setValue("ЛГР-0083-2020").pressEnter());

        step("Открыть найденную карточку", () ->
            $$(byText("ЛГР-0083-2020")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
            $x("//div/h2[contains(text(),'ЛГР-0083-2020')]").shouldBe(visible));
    }
}
