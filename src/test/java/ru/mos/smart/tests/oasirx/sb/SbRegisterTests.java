package ru.mos.smart.tests.oasirx.sb;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

@Epic("OASI")
@Feature("Оасирх")
@Story("SB")
@Component("Реестр")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class SbRegisterTests extends TestBase {

    @Test
    @AllureId("17057")
    @DisplayName("Просмотр реестра Самострой")
    @Description("Проверить, что открывается реестр Самострой")
    void openingTheRegisterSb() {

        step("Из боковой панели перейти в раздел Самострой", () ->
                $x("//span[text()='Самострой']").click());

        step("Открыт раздел Самострой", () ->
                $x("//div/h2[contains(text(),'Самострой')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//a/span[contains(text(),'В работе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Вcе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Справка МГК')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Справка ГЗК')]").shouldBe(visible);
        });
    }

    @Test
    @AllureId("17056")
    @DisplayName("Поиск карточки реестра Самострой по номеру")
    @Description("Проверить, что происходит поиск карточки реестра Самострой по номеру")
    void searchingSbCardByNumber() {

        step("Из боковой панели перейти в раздел Самострой", () -> {
            $x("//span[text()='Самострой']").should(visible, Duration.ofSeconds(10));
            ;
            $x("//span[text()='Самострой']").click();
        });

        step("Открыт раздел Самострой", () ->
                $x("//div/h2[contains(text(),'Самострой')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("ОСС-0028-2021").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("ОСС-0028-2021")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'ОСС-0028-2021')]").shouldBe(visible));
    }
}