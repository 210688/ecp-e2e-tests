package ru.mos.smart.tests.oasirx.szz;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("SZZ (СЗЗ)")

public class SzzRegisterTests extends TestBase {
    @Test
    @DisplayName("Просмотр реестра СЗЗ")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void openingTheRegisterSzz() {
        LoginPage.openUrlWithAuthorization("", smart().login(), smart().pass());

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
}
