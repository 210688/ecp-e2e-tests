package ru.mos.smart.tests.oasirx.violation;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.concurrent.atomic.AtomicReference;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Epic("OASI")
@Feature("ОАСИРХ")
@Story("violation")
@Component("Реестр")
public class ViolationRegisterTests extends TestBase {

    @Test
    @AllureId("17052")
    @DisplayName("Просмотр раздела Нарушения ОГД")
    void openingTheRegisterViolation() {
        sidebarPage
                .goToViolations();

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
    @AllureId("17053")
    @DisplayName("Поиск карточки реестра Нарушения ОГД по номеру")
    void searchingViolationCardByNumber() {
        sidebarPage
                .goToViolations();

        step("Открыт раздел Административные правонарушения", () ->
                $x("//div/h2[contains(text(),'Административные правонарушения')]").shouldBe(visible));

        AtomicReference<String> card = new AtomicReference<>("");

        step("Получаем номер существующей карточки", () -> {
            $(".viewtable").$$("tr").shouldHave(sizeGreaterThan(0));
            card.set($(".viewtable").$("a").getText());
        });

        step("В строке поиска ввести номер карточки", () ->
                $("input.form-control").setValue(card.get()).pressEnter());

        step("Карточка должна быть видна в результатах поиска", () ->
                $$("app-violation-filtered-list").findBy(visible).shouldHave(text(card.get())));
    }
}
