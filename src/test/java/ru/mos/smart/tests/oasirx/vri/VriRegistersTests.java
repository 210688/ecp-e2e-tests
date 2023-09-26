package ru.mos.smart.tests.oasirx.vri;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Epic("OASI")
@Feature("Оасирх")
public class VriRegistersTests extends TestBase {

    @Test
    @AllureId("17048")
    @Story("VRI")
    @Component("Реестр")
    @DisplayName("Просмотр вкладок в реестре ВРИ")
    @Description("Проверить, что вкладки в реестре ВРИ - открываются")
    void openRegisterVri() {
        List<String> tabs = new ArrayList<String>() {{
            add("ВРИ в работе");
            add("Все ВРИ");
            add("Мои ВРИ");
            add("Срок истекает");
            add("Отчеты");
        }};
        sidebarPage
                .goToVri();

        vriPage
                .checkIsOpened()
                .checkHasTabs(tabs);
    }

    @Test
    @AllureId("17047")
    @Story("VRI")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра ВРИ по номеру")
    @Description("Проверить, что происходит поиск карточки реестра ВРИ по номеру")
    void searchingVriCardByNumber() {
        step("Из боковой панели перейти в раздел ВРИ", () -> {
            $x("//span[text()='ВРИ']").shouldBe(visible, Duration.ofSeconds(10));
            $x("//span[text()='ВРИ']").click();
        });

        step("Открыт раздел ВРИ", () ->
                $x("//div/h2[contains(text(),'ВРИ')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("ВРИ-0035-2021").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("ВРИ-0035-2021")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'ВРИ-0035-2021')]").shouldBe(visible));
    }
}