package ru.mos.smart.tests.ugd.ssr;


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

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("UGD (УГД)")
@Feature("SSR (Суперсервис реновации ССР)")
public class SsrRegisresTests extends TestBase {

    @Test
    @DisplayName("Проверка доступности реестра ССР. Реестр жителей")
    @Tags({@Tag("ssr"), @Tag("preprod"), @Tag("prod")})
    void openRegisterSsrReestrZhiteli() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());
        NavigatorPage.goToRegister();

        step("Найти и открыть реестр ССР. Реестр жителей", () -> {
            $(byName("candidateSearchValue")).setValue("ССР. Реестр жителей").pressEnter();
            $x("//span[contains(text(),'ССР. Реестр жителей')]").click();
        });

        step("Реестр содержит по умолчанию такие колонки, как:", () -> {
            $x("//th[contains(text(),'Фамилия, имя, отчество')]").shouldBe(exist);
            $x("//th[contains(text(),'Дата рождения')]").shouldBe(exist);
            $x("//th[contains(text(),'Адрес отселяемого дома')]").shouldBe(exist);
            $x("//th[contains(text(),'Номер квартиры')]").shouldBe(exist);
            $x("//th[contains(text(),'Статус обогащения из ПФР')]").shouldBe(exist);
            $x("//th[contains(text(),'Дата обогащения из ПФР')]").shouldBe(exist);
            $x("//th[contains(text(),'Статус обогащения из ЕЛК')]").shouldBe(exist);
            $x("//th[contains(text(),'Дата обогащения из ЕЛК')]").shouldBe(exist);
        });
    }

    @Test
    @DisplayName("Проверка доступности реестра ССР. Реестр отселяемых домов")
    @Tags({@Tag("ssr"), @Tag("preprod"), @Tag("prod")})
    void openRegisterSsrReestrOtselDomov() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());
        NavigatorPage.goToRegister();

        step("Найти и открыть реестр ССР. Реестр отселяемых домов", () -> {
            $(byName("candidateSearchValue")).setValue("ССР. Реестр отселяемых домов").pressEnter();
            $x("//span[contains(text(),'ССР. Реестр отселяемых домов')]").click();
        });

        step("Реестр содержит по умолчанию такие колонки, как:", () -> {
            $x("//th[contains(text(),'UNOM')]").shouldBe(exist);
            $x("//th[contains(text(),'Адрес')]").shouldBe(exist);
            $x("//th[contains(text(),'Номер дома')]").shouldBe(exist);
            $x("//th[contains(text(),'Административный округ')]").shouldBe(exist);
            $x("//th[contains(text(),'Год постройки')]").shouldBe(exist);
            $x("//th[contains(text(),'Скоро начнется переселение дома')]").shouldBe(exist);
            $x("//th[contains(text(),'Статус обогащения')]").shouldBe(exist);
            $x("//th[contains(text(),'Дата обогащения')]").shouldBe(exist);
            $x("//th[contains(text(),'Количество SsoId')]").shouldBe(exist);
            $x("//th[contains(text(),'Количество квартир')]").shouldBe(exist);
        });
    }

    @Test
    @DisplayName("Проверка доступности реестр ССР. Реестр центров информирования по переселению жителей")
    @Tags({@Tag("ssr"), @Tag("preprod"), @Tag("prod")})
    void openRegisterSsrReestrcentrovInf() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());
        NavigatorPage.goToRegister();

        step("Найти и открыть реестр ССР. Реестр центров информирования по переселению жителей", () -> {
            $(byName("candidateSearchValue"))
                    .setValue("ССР. Реестр центров информирования по переселению жителей").pressEnter();
            $x("//span[contains(text(),'ССР. Реестр центров информирования по переселению жителей')]")
                    .click();
        });

        step("Реестр содержит по умолчанию такие колонки, как:", () -> {
            $x("//th[contains(text(),'Адрес центра переселения (округ, район)')]").shouldBe(exist);
            $x("//th[contains(text(),'Отселяемых домов')]").shouldBe(exist);
            $x("//th[contains(text(),'Заселяемых домов')]").shouldBe(exist);
            $x("//th[contains(text(),'Дата открытия центра')]").shouldBe(exist);
            $x("//th[contains(text(),'Дата закрытия центра')]").shouldBe(exist);
            $x("//th[contains(text(),'Статус')]").shouldBe(exist);
        });
    }
}
