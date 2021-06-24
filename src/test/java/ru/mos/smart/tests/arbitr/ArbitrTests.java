package ru.mos.smart.tests.arbitr;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;


@Layer("web")
@Epic("ARBITR (Арбитраж)")
public class ArbitrTests extends TestBase {

    @Test
    @DisplayName("Загрузка модуля Поиск дел")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("arbitr")})
    void loadingModulePoiskDel() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Перейти в раздел Поиск судебных дел", () -> $(byLinkText("Информация"))
                .click());

        step("Раздел открывается", () -> $(byLinkText("Поиск судебных дел"))
                .click());

        step("На странице есть поле Участник дела для ввода названия, ИНН, ОГРН, ФИО", () -> {
            $("#member").shouldBe(visible);
        });

        step("На странице есть поле для ввода номера дела", () -> {
            $("#case_number").shouldBe(visible);
        });

        step("На странице есть чек-бокс Арбитражный суд", () -> {
            $(byText("Арбитражный суд")).shouldBe(visible);
        });

        step("На странице есть чек-бокс Суд общей юрисдикции", () -> {
            $(byText("Суд общей юрисдикции")).shouldBe(visible);
        });

        step("Присутствует поле Дата регистрации дела с...по", () -> {
            $(byText("Дата регистрации дела с")).shouldBe(visible);
        });

        step("Присутствуют кнопки Найти и Очистить", () -> {
            $x("//div/button[contains(text(),'Найти')]").shouldBe(visible);
            $x("//div/button[contains(text(),'Очистить')]").shouldBe(visible);
        });
    }
}
