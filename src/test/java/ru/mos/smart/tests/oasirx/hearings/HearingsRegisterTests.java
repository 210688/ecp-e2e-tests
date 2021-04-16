package ru.mos.smart.tests.oasirx.hearings;

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
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("HEARINGS (Публичные слушания)")
public class HearingsRegisterTests extends TestBase {

    @Test
    @DisplayName("Просмотр раздела Публичные слушания")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void openingTheRegisterHearings() {
        LoginPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел Публичные слушания", () ->
            $x("//span[text()='Публичные слушания']").click());

        step("Открыт раздел Публичные слушания", () ->
            $x("//div/h2[contains(text(),'Публичные слушания')]").shouldBe(visible));

        step("В разделе присутствуют вкладки:", () -> {
            $x("//a/span[contains(text(),'ПС в работе')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Все ПС')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Мои ПС')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Отчеты')]").shouldBe(visible);
            $x("//a/span[contains(text(),'Заседания комиссий')]").shouldBe(visible);
        });
    }
}
