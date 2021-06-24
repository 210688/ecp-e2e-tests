package ru.mos.smart.tests.oasirx.pkl;

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
@Feature("PKL")

public class PklRegisterTests extends TestBase {
    @Test
    @DisplayName("Просмотр реестра ПКЛ")
    @Tags({@Tag("preprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("pkl")})
    void openingTheRegisterPkl() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел ПКЛ", () ->
                $x("//span[text()='ПКЛ']").click());

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
    @DisplayName("Поиск карточки реестра ПКЛ по номеру")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("pkl")})
    void searchingPklCardByNumber() {

        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел ПКЛ", () -> {
            $x("//span[text()='ПКЛ']").waitUntil(visible, 10000);
            $x("//span[text()='ПКЛ']").click();
        });

        step("Открыт раздел ПКЛ", () ->
                $x("//div/h2[contains(text(),'ПКЛ')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("ПК-0016-2021-ПКЛ").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("ПК-0016-2021-ПКЛ")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'ПК-0016-2021-ПКЛ')]").shouldBe(visible));
    }
}
