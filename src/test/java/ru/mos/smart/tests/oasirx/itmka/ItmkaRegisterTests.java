package ru.mos.smart.tests.oasirx.itmka;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class ItmkaRegisterTests extends TestBase {

    @Test
    @AllureId("17062")
    @Story("Itmka")
    @Component("Реестр")
    @DisplayName("Просмотр реестра заявок Управление ИТ МКА")
    @Description("Проверить, что реестр открывается и присутствуют завки - Управления ИТ МКА")
    void openingTheRegisterItmka() {
        sidebarPage.goToItmka();

        step("Открыт раздел Управление ИТ МКА", () ->
                $x("//div/h2[contains(text(),'Управление информатизацией МКА')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//a/span[contains(text(),'В работе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Все заявки')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои заявки')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Отчеты')]").shouldBe(visible);
        });
    }

    @Test
    @AllureId("17063")
    @Story("Itmka")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра заявок Управление ИТ МКА по номеру")
    @Description("Проверить, что происходит поиск карточки реестра заявок - Управление ИТ МКА по номеру")
    void searchingItmkaCardByNumber() {
        sidebarPage
                .goToItmka();

        step("Открыт раздел Управление ИТ МКА", () ->
                $x("//div/h2[contains(text(),'Управление информатизацией МКА')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("ДРБ-017-2021").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("ДРБ-017-2021")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'ДРБ-017-2021')]").shouldBe(visible));
    }
}
