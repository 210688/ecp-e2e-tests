package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("EOO (Электронные общественные обсуждения)")
@Story("Реестр ЭОО")
public class EooRegisterTests extends TestBase {

    @Test
    @DisplayName("Просмотр реестра ЭОО")
    @Tag("allModules")
    @Tag("prod")
    @Tag("predprod")
    @Tag("regress")
    void openingTheRegisterELMA() {
        LoginPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел ЭОО", () ->
            $x("//span[text()='ЭОО']").click());

        step("Открыт раздел Общественные обсуждения", () ->
            $x("//div/h2[contains(text(),'Общеcтвенные обcуждения')]").shouldBe(visible));

        step("Отображается список карточек. Присутствуют вкладки:", () -> {
            $x("//span[contains(text(),'ЭОО в работе')]").shouldBe(visible);
            $x("//span[contains(text(),'Вcе ЭОО')]").shouldBe(visible);
            $x("//span[contains(text(),'Мои ЭОО')]").shouldBe(visible);
            $x("//span[contains(text(),'Рабочие группы')]").shouldBe(visible);
            $x("//span[contains(text(),'Статиcтика')]").shouldBe(visible);
            $x("//span[contains(text(),'Предложения')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Поиск карточки реестра ЭОО по номеру")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("regress")
    void searchingEooCardByNumber() {

        LoginPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел ЭОО", () -> {
            $x("//span[text()='ЭОО']").waitUntil(visible, 10000);
            $x("//span[text()='ЭОО']").click();
        });

        step("Открыт раздел Общественные обсуждения", () ->
            $x("//div/h2[contains(text(),'Общеcтвенные обcуждения')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
            $x("//div/input[contains(@class,'form-control')]").setValue("ПЗЗ-00016-2021-ЭОО").pressEnter());

        step("Открыть найденную карточку", () ->
            $$(byText("ПЗЗ-00016-2021-ЭОО")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
            $x("//div/h2[contains(text(),'ПЗЗ-00016-2021-ЭОО')]").shouldBe(visible));
    }
}
