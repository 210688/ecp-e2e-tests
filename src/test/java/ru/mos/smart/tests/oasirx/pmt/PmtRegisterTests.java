package ru.mos.smart.tests.oasirx.pmt;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("PMT (ПМТ)")
class PmtRegisterTests extends TestBase {

    @Test
    @DisplayName("Просмотр реестра ПМТ")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void openingTheRegisterPMT() {
        sidebarPage
                .goToPmt();

        step("Открыт раздел Межевание территорий", () ->
                $x("//div/h2[contains(text(),'Межевание территорий')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//span[contains(text(),'ПМТ в работе')]").shouldBe(visible);
            $x("//span[contains(text(),'Все ПМТ')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Поиск ПМТ по номеру")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void searchingPmtCardByNumber() {
        sidebarPage
                .goToPmt();

        AtomicReference<String> card = new AtomicReference<>("");

        step("Получаем номер существующей карточки", () -> {
            $(".viewtable").$$("tr").shouldHave(sizeGreaterThan(0));
            card.set($(".viewtable").$("a").getText());
        });

        step("В строке поиска ввести номер ПМТ", () ->
                $("input.form-control").setValue(card.get()).pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText(card.get())).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $("h2").shouldHave(text(card.get())));
    }
}
