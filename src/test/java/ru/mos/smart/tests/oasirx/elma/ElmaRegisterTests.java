package ru.mos.smart.tests.oasirx.elma;

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
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("ELMA (ЭЛМА)")
public class ElmaRegisterTests extends TestBase {

    @Test
    @DisplayName("Просмотр раздела Соответствие СП (МГГТ)")
    @Tag("allModules")
    @Tag("prod")
    @Tag("predprod")
    @Tag("regress")
    void openingTheRegisterELMA() {

        LoginPage.openUrlWithAuthorization("", smart().login(), smart().pass());

        step("Из боковой панели перейти в раздел Соответствие СП (МГГТ)", () ->
                $x("//span[text()='Соответствие СП (МГГТ)']").click());

        step("Открыт раздел Соответствие проектной документации СППК", () ->
                $(byText("Соответствие проектной документации СППК"))
                        .shouldBe(visible));

        step("Отображается список запросов. Присутствуют разделы:", () -> {
            $x("//span[contains(text(),'Запросы в работе')]").shouldBe(visible);
            $x("//span[contains(text(),'Все запросы')]").shouldBe(visible);
            $x("//span[contains(text(),'Мои запросы')]").shouldBe(visible);
            $x("//span[contains(text(),'Срок истекает')]").shouldBe(visible);
            $x("//span[contains(text(),'Отчёты')]").shouldBe(visible);
            $x("//span[contains(text(),'ЭДО')]").shouldBe(visible);
        });
    }
}
