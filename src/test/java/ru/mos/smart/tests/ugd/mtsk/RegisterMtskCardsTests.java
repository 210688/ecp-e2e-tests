package ru.mos.smart.tests.ugd.mtsk;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
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
@Tags({@Tag("mtsk"),@Tag("preprod"),@Tag("prod")})
class RegisterMtskCardsTests extends TestBase {

    @Test
    @DisplayName("Просмотр полной карточки реестра МТСК. Реестр организаций")
    void registerMtskCardsViewing() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        NavigatorPage.reestrPage();
        step("Перейти к реестру МТСК. Реестр организаций", () -> {
            //найти и открыть "МТСК. Реестр организаций"
            $(byName("candidateSearchValue")).setValue("МТСК. Реестр организаций").pressEnter();
            $(byLinkText("МТСК. Реестр организаций")).click();
        });

        step("Открыть полную карточку организации \"Бийскхимстройматериалы\"", () -> {
            //в поле поиска ввести «ООО БИЙСКХИМСТРОЙМАТЕРИАЛЫ»
            $(".form-control").setValue("ООО БИЙСКХИМСТРОЙМАТЕРИАЛЫ").pressEnter();
            //карточка открывается через <a href="/ugd/#/app/organization/19290"></a>
            open("/ugd/#/app/organization/19290");
        });

        step("Проверка открытия карточки", () -> {
            $(byText("Общество с ограниченной ответственностью \"Бийскхимстройматериалы\"")).shouldBe(visible);
        });
    }
}