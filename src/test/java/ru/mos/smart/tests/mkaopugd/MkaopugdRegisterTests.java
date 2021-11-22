package ru.mos.smart.tests.mkaopugd;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("MKAOPUGD (МКА ОП УГД)")
@Feature("Работа с реестром УГД")
public class MkaopugdRegisterTests extends TestBase {

    @Test
    @AllureId("3199")
    @DisplayName("Реестр поручений УГД")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("mkaopugd")})
    void registerOfInstructionsUgd() {

        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginSwagger(), webConfig().passwordSwagger());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Реестр поручений УГД");

        step("Реестр содержит по умолчанию колонки:", () -> {
            $x("//th[contains(text(),'№ заседания')]").shouldBe(exist);
            $x("//th[contains(text(),'№ протокола')]").shouldBe(exist);
            $x("//th[contains(text(),'Дата заседания')]").shouldBe(exist);
            $x("//th[contains(text(),'Срок')]").shouldBe(exist);
            $x("//th[contains(text(),'Тип')]").shouldBe(exist);
            $x("//th[contains(text(),'Наименование')]").shouldBe(exist);
            $x("//th[contains(text(),'Кадастровый номер')]").shouldBe(exist);
            $x("//th[contains(text(),'Адрес')]").shouldBe(exist);
            $x("//th[contains(text(),'Статус')]").shouldBe(exist);
        });
    }

    @Test
    @AllureId("3198")
    @DisplayName("Карточка Реестра поручений УГД")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("regres"), @Tag("mkaopugd")})
    void cardOfRegisterUgd() {
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginSwagger(), webConfig().passwordSwagger());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Реестр поручений УГД");

        step("Открыть любую карточку реестра", () -> {
            $(".input-lg").setValue("88").pressEnter();
            $(byLinkText("88")).click();
        });

        step("В карточке присутствуют вкладки:", () -> {
            $x("//span[contains(text(),'Поручение')]").shouldBe(visible);
            $x("//span[contains(text(),'История')]").shouldBe(visible);
            $x("//span[contains(text(),'Техническая информация')]").shouldBe(visible);
        });
    }
}
