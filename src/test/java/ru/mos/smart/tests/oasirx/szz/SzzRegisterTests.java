package ru.mos.smart.tests.oasirx.szz;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("SZZ (СЗЗ)")

public class SzzRegisterTests extends TestBase {
    @Test
    @DisplayName("Просмотр реестра СЗЗ")
    @Tags({@Tag("preprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("szz")})
    void openingTheRegisterSzz() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел СЗЗ", () ->
                $x("//span[text()='СЗЗ']").click());

        step("Открыт раздел СЗЗ", () ->
                $x("//div/h2[contains(text(),'Реестр CЗЗ')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//a/span[contains(text(),'СЗЗ в работе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Вcе СЗЗ')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои СЗЗ')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои задачи')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Статистика')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Поиск карточки реестра СЗЗ по номеру")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("szz")})
    void searchingSzzCardByNumber() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел СЗЗ", () -> {
            $x("//span[text()='СЗЗ']").waitUntil(visible, 10000);
            $x("//span[text()='СЗЗ']").click();
        });

        step("Открыт раздел СПРИТ", () ->
                $x("//div/h2[contains(text(),'Реестр CЗЗ')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("СЗЗ-000271-2020").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("СЗЗ-000271-2020")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'СЗЗ-000271-2020')]").shouldBe(visible));
    }
}
