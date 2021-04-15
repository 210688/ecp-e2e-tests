package ru.mos.smart.tests.oasirx.crd;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("CRD (Согласование документов)")
@Story("Работа с реестром и карточкой СД")
public class CrdRegisterTests extends TestBase {

    @Test
    @DisplayName("Открытие реестра СД")
    @Tags({@Tag("allmodules"), @Tag("prod"), @Tag("predprod"), @Tag("regress")})
    void openingTheRegisterCRD() {

        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());

        step("Из боковой панели перейти в раздел СД", () ->
                $(byText("СД")).click());

        step("Открыт раздел СД", () ->
                $(byText("СД")).shouldBe(visible));

        step("Отображается список согласований. Присутствуют разделы:", () -> {
            $(byText("В работе")).shouldBe(visible);
            $(byText("Все")).shouldBe(visible);
            $(byText("Созданные мной")).shouldBe(visible);
            $(byText("Мои")).shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Поиск карточки реестра СД по номеру")
    @Tags({@Tag("allmodules"), @Tag("predprod"), @Tag("regress")})
    void searchingCrdCardByNumber() {

        LoginPage.openUrlWithAuthorization("", webConfig().login_podsistem(), webConfig().password_podsistem());

        step("Из боковой панели перейти в раздел СД", () ->
                $(byText("СД")).click());

        step("Открыт раздел СД", () ->
                $(byText("СД")).shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//input[@type='search']").setValue("СД-0015-2021").pressEnter());

        step("Открыть найденную карточку", () ->
                $x("//a/[@href='#/app/crd/f1703056-4463-41d3-a863-55309b8fc37d']").click());

        step("Проверить, что карточка открылась", () ->
                $(byText("СД-0015-2021")).shouldBe(visible));
    }
}
