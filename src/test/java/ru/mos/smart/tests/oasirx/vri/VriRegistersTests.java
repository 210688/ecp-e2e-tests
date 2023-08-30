package ru.mos.smart.tests.oasirx.vri;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("VRI (ВРИ)")
@Story("Реестр ВРИ")
public class VriRegistersTests extends TestBase {

    @Test
    @AllureId("7687")
    @DisplayName("Проверка вкладок в реестре ВРИ")
    @Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasirx"), @Tag("vri")})
    void openRegisterVri() {
        List<String> tabs = new ArrayList<String>() {{
            add("ВРИ в работе");
            add("Все ВРИ");
            add("Мои ВРИ");
            add("Срок истекает");
            add("Отчеты");
        }};

        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage
                .goToVri();

        vriPage
                .checkIsOpened()
                .checkHasTabs(tabs);
    }

    @Test
    @AllureId("7686")
    @DisplayName("Поиск карточки реестра ВРИ по номеру")
    @Tags({@Tag("predprod"), @Tag("oasirx"), @Tag("vri")})
    void searchingVriCardByNumber() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
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