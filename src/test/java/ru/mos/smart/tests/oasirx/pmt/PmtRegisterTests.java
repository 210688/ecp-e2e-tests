package ru.mos.smart.tests.oasirx.pmt;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.enums.Sidebar.PMT;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
class PmtRegisterTests extends TestBase {

    @Test
    @AllureId("17059")
    @Story("PMT")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре Межевание территорий")
    @Description("Проверить, что реестр Межевание территорий корректно открывается, " +
            "включая проверку порядка отображения заголовков")
    void openingTheRegisterPMT() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Округ", "Районы", "Адрес",
                "Название работы", "Цель проекта", "Исполнитель", "Статус");
        sidebarPage.clickSidebarMenu(PMT);
        oasirxPage.registryContainsCardsHeadersCheck(PMT, tableColumnList);



/*        step("В разделе присутствуют вкладки:", () -> {
            $x("//span[contains(text(),'ПМТ в работе')]").shouldBe(visible);
            $x("//span[contains(text(),'Все ПМТ')]").shouldBe(visible);
        });*/
    }

    @Test
    @AllureId("17058")
    @Story("PMT")
    @Component("Реестр")
    @DisplayName("Поиск ПМТ по номеру")
    @Description("Проверить, что происходит поиск по номеру в реестре")
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
