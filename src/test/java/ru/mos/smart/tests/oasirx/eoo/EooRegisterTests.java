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
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

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

        LoginPage.openUrlWithAuthorization("", smart().login(), smart().pass());

        step("Из боковой панели перейти в раздел ЭОО", () ->
            $x("//span[text()='ЭОО']").click());

        step("Открыт раздел Общественные обсуждения", () ->
            $(byText("Общественные обсуждения")).shouldBe(visible));

        step("Отображается список карточек. Присутствуют разделы:", () -> {
            $x("//span[contains(text(),'ЭОО в работе')]").shouldBe(visible);
            $x("//span[contains(text(),'Вcе ЭОО')]").shouldBe(visible);
            $x("//span[contains(text(),'Мои ЭОО')]").shouldBe(visible);
            $x("//span[contains(text(),'Рабочие группы')]").shouldBe(visible);
            $x("//span[contains(text(),'Статиcтика')]").shouldBe(visible);
            $x("//span[contains(text(),'Предложения')]").shouldBe(visible);
        });
    }
}
