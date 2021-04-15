package ru.mos.smart.tests.oasirx.pmt;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("PMT (ПМТ)")
class PmtRegisterTests extends TestBase {

    @Test
    @DisplayName("Просмотр реестра ПМТ")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void openingTheRegisterPMT() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());

        step("Из боковой панели перейти в раздел ПМТ", () ->
            $x("//span[text()='ПМТ']").click());

        step("Открыт раздел Межевание территорий", () ->
            $x("//div/h2[contains(text(),'Межевание территорий')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//span[contains(text(),'ПМТ в работе')]").shouldBe(visible);
            $x("//span[contains(text(),'Все ПМТ')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Поиск ПМТ по номеру")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("regress")
    void searchingPmtCardByNumber() {
        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());

        step("Открытие в навигаторе ПМТ", () -> $x("//span[text()='ПМТ']").click());

        step("В строке поиска ввести номер ПМТ", () ->
            $x("//div/input[contains(@class,'form-control')]").setValue("ПМТ-0096-2020").pressEnter());

        step("Открыть найденную карточку", () ->
            $x("//a[@href='#/app/pmt/2d5b2530-80dc-45ea-b684-8dc0649b5a10']").click());

        step("Проверить, что карточка открылась", () ->
            $x("//div/h2[contains(text(),'ПМТ-0096-2020')]").shouldBe(visible));
    }
}
