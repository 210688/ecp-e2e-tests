package ru.mos.smart.tests.oasirx.crd;

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
@Feature("CRD (Согласование документов)")
@Story("Работа с реестром и карточкой СД")
public class CrdRegisterTests extends TestBase {

    @Test
    @DisplayName("Открытие реестра СД")
    @Tag("allModules")
    @Tag("prod")
    @Tag("predprod")
    @Tag("regress")
    void openingTheRegisterCRD() {

        LoginPage.openUrlWithAuthorization("", smart().login(), smart().pass());

        step("Из боковой панели перейти в раздел СД", () ->
            $x("//span[text()='СД']").click());

        step("Открыт раздел СД", () ->
            $x("//div/h2[contains(text(),'СД')]").shouldBe(visible));

        step("Отображается список согласований. Присутствуют разделы:", () -> {
            $x("//span[contains(text(),'В работе')]").shouldBe(visible);
            $x("//span[contains(text(),'Все')]").shouldBe(visible);
            $x("//span[contains(text(),'Созданные мной')]").shouldBe(visible);
            $x("//span[contains(text(),'Мои')]").shouldBe(visible);
        });
    }
}
