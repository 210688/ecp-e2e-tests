package ru.mos.smart.tests.oasirx.pkl;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class PklRegisterTests extends TestBase {

    @Test
    @AllureId("17061")
    @Story("PKL")
    @Component("Реестр")
    @DisplayName("Просмотр реестра ПКЛ")
    @Description("Проверить, что открывается реестр ПКЛ")
    void openingTheRegisterPkl() {
        sidebarPage
                .goToPkl();

        step("Открыт раздел ПКЛ", () ->
                $x("//div/h2[contains(text(),'ПКЛ')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//a/span[contains(text(),'В работе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Все')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Ожидает')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Статистика')]").shouldBe(visible);
        });
    }

    @Test
    @AllureId("17060")
    @Story("PKL")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра ПКЛ по номеру")
    @Description("Проверить, что происходит поиск карточки реестра ПКЛ по номеру")
    void searchingPklCardByNumber() {
        sidebarPage
                .goToPkl();

        step("Открыт раздел ПКЛ", () ->
                $x("//div/h2[contains(text(),'ПКЛ')]").shouldBe(visible));

        AtomicReference<String> card = new AtomicReference<>("");

        step("Получаем номер существующей карточки", () -> {
            $(".viewtable").$$("tr").shouldHave(sizeGreaterThan(0));
            card.set($(".viewtable").$("a").getText());
        });

        step("В строке поиска ввести номер карточки", () ->
                $("input.form-control").setValue(card.get()).pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText(card.get())).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $("h2").shouldHave(text(card.get())));
    }
}
