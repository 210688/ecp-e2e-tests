package ru.mos.smart.tests.ugd.mtsk;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
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
@Tags({@Tag("mtsk"), @Tag("preprod"), @Tag("prod"), @Tag("ugd")})
class RegisterMtskCardsTests extends TestBase {

    @Test
    @DisplayName("Просмотр полной карточки реестра МТСК. Реестр организаций")
    void registerMtskCardsViewing() {
        LoginPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());
        MainPage.InformaciyaAndReestr();
        step("Перейти к реестру МТСК. Реестр организаций", () -> {
            $(byName("candidateSearchValue")).setValue("МТСК. Реестр организаций").pressEnter();
            $(byLinkText("МТСК. Реестр организаций")).click();
        });

        step("Открыть полную карточку организации ООО ТЕПЛОРИУМ", () -> {
            $(".form-control").setValue("ООО ТЕПЛОРИУМ").pressEnter();
            open("/ugd/mtsk/#/app/organization/17171");
        });

        step("Проверка открытия карточки", () -> {
            $(byText("ООО ТЕПЛОРИУМ")).shouldBe(visible);
        });
    }
}