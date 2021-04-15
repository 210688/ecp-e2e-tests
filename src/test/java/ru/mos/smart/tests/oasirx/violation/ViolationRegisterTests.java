package ru.mos.smart.tests.oasirx.violation;

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
@Feature("VIOLATION (Нарушения ОГД)")

public class ViolationRegisterTests extends TestBase {
    @Test
    @DisplayName("Просмотр раздела Нарушения ОГД")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void openingTheRegisterViolation() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());

        step("Из боковой панели перейти в раздел Нарушения ОГД", () ->
            $x("//span[text()='Нарушения ОГД']").click());

        step("Открыт раздел Административные правонарушения", () ->
            $x("//div/h2[contains(text(),'Административные правонарушения')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//a/span[contains(text(),'АП в работе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Все АП')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои АП')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Срок АП истекает')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Поиск карточки реестра Нарушения ОГДпо номеру")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("regress")
    void searchingViolationCardByNumber() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());

        step("Из боковой панели перейти в раздел Нарушения ОГД", () -> {
            $x("//span[text()='Нарушения ОГД']").waitUntil(visible, 10000);
            $x("//span[text()='Нарушения ОГД']").click();
        });

        step("Открыт раздел Административные правонарушения", () ->
                $x("//div/h2[contains(text(),'Административные правонарушения')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("АП-0001-2021").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("АП-0001-2021")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'АП-0001-2021')]").shouldBe(visible));
    }
}
