package ru.mos.smart.tests.mkaopugd;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Epic("MKAOPUGD (МКА ОП УГД)")
@Feature("Работа с реестром УГД")
public class MkaopugdRegisterTests extends TestBase {

    @Test
    @DisplayName("Реестр поручений УГД")
    @Tags({@Tag("mkaopugd"),@Tag("preprod"),@Tag("prod")})
    void registerOfInstructionsUgd() {

        LoginPage.openUrlWithAuthorization("", webConfig().log(), webConfig().passwords());
        MainPage.InformaciyaAndReestr();

        step("Найти и открыть Реестр поручений УГД", () -> {
            $(byName("candidateSearchValue")).setValue("Реестр поручений УГД").pressEnter();
            $x("//span[contains(text(),'Реестр поручений УГД')]").click();
        });

        step("В таблице карточек УГД присутствуют колонки:", () -> {
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
    @DisplayName("Карточка Реестра поручений УГД")
    @Tags({@Tag("mkaopugd"),@Tag("preprod"),@Tag("prod")})
    void cardOfRegisterUgd() {
        LoginPage.openUrlWithAuthorization("", webConfig().log(), webConfig().passwords());
        MainPage.InformaciyaAndReestr();

        step("Найти и открыть Реестр поручений УГД", () -> {
            $(byName("candidateSearchValue")).setValue("Реестр поручений УГД").pressEnter();
            $x("//span[contains(text(),'Реестр поручений УГД')]").click();
        });

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
