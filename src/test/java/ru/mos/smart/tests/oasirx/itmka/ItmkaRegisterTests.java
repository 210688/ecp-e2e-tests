package ru.mos.smart.tests.oasirx.itmka;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
@Feature("ОАСИРХ")
@Story("itmka")
@Component("Реестр")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class ItmkaRegisterTests extends TestBase {

    @Test
    @AllureId("17062")
    @DisplayName("Просмотр реестра заявок Управление ИТ МКА")
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
    @DisplayName("Поиск карточки реестра заявок Управление ИТ МКА по номеру")
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
