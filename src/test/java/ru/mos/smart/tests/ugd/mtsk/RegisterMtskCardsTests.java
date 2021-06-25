package ru.mos.smart.tests.ugd.mtsk;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.pages.ReestrPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("UGD (УГД)")
@Feature("MTSK (Московский территориальный строительный каталог)")
@Tags({@Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("ugd"), @Tag("mtsk")})
class RegisterMtskCardsTests extends TestBase {

    @Test
    @AllureId("1065")
    @DisplayName("Просмотр полной карточки реестра МТСК. Реестр организаций")
    void registerMtskCardsViewing() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginUgd(), webConfig().passwordUgd());
        NavigatorPage.goToRegister();
        ReestrPage.open("МТСК. Реестр организаций");

        step("Открыть полную карточку организации \"Бийскхимстройматериалы\"", () -> {
            $(".form-control").setValue("ООО БИЙСКХИМСТРОЙМАТЕРИАЛЫ").pressEnter();
            $(byLinkText("Общество с ограниченной ответственностью \"Бийскхимстройматериалы\"")).click();
        });

        step("Проверка открытия карточки", () -> {
            $(byText("Общество с ограниченной ответственностью \"Бийскхимстройматериалы\"")).shouldBe(visible);
        });
    }
}