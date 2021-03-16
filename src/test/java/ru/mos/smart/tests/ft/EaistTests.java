package ru.mos.smart.tests.ft;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

@Layer("web")
@Epic("FT (Электронная приемка по ФТ)")
@Feature("EAIST (ЕАИСТ)")
public class EaistTests extends TestBase {

    @Test
    @DisplayName("Проверка реестров ЕАИСТ")
    @Tag("allModules")
    @Tag("prod")
    @Tag("predprod")
    @Tag("regress")
    void reestrEaistCanBeOpened() {
        LoginPage.openUrlWithAuthorization("", smart().login(), smart().passwords());
        MainPage.InformaciyaAndReestr();

        step("В поисковой строке ввести ЕАИСТ", () -> {
            $(byName("candidateSearchValue")).setValue("ЕАИСТ").pressEnter();
        });

        step("Найдены реестры", () -> {
            $(byText("Реестр заказчиков ЕАИСТ")).shouldBe(visible);
            $(byText("Реестр контрактов ЕАИСТ")).shouldBe(visible);
            $(byText("Реестр поставщиков ЕАИСТ")).shouldBe(visible);
            $(byText("Реестр этапов контрактов ЕАИСТ")).shouldBe(visible);
        });
    }
}
