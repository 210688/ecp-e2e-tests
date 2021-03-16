package ru.mos.smart.tests.mkasdprv;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.smart;

@Epic("MKASDPRV (МКА Вывески)")
@Feature("Работа с реестрами")
public class MkasdprvRegisterTests extends TestBase {

    @Test
    @DisplayName("Проверка атрибутивного состава реестра")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("prod")
    @Tag("regress")
    void checkingTheAttributesOfTheRegistry() {
        LoginPage.openUrlWithAuthorization("", smart().login(), smart().passwords());
        MainPage.InformaciyaAndReestr();

        step("Найти и открыть реестр Реестр оказания услуги Вывесок", () -> {
            $(byName("candidateSearchValue")).setValue("Реестр оказания услуги Вывесок").pressEnter();
            $x("//span[contains(text(),'Реестр оказания услуги Вывесок')]").click();
        });

        step("В реестре присутствуют поля:", () -> {
            $x("//th[contains(text(),'Номер заявления')]").shouldBe(exist);
            $x("//th[contains(text(),'Планируемая дата')]").shouldBe(exist);
            $x("//th[contains(text(),'Фактическая дата')]").shouldBe(exist);
            $x("//th[contains(text(),'Статус')]").shouldBe(exist);
            $x("//th[contains(text(),'Решение')]").shouldBe(exist);
            $x("//th[contains(text(),'Ответственный')]").shouldBe(exist);
            $x("//th[contains(text(),'Заявитель')]").shouldBe(exist);
            $x("//th[contains(text(),'Адрес')]").shouldBe(exist);
            $x("//th[contains(text(),'Номер ПГУ')]").shouldBe(exist);
        });
    }

    @Test
    @DisplayName("Открытие карточки реестра")
    @Tag("allModules")
    @Tag("predprod")
    @Tag("regress")
    void openingRegistryCard() {
        LoginPage.openUrlWithAuthorization("", smart().login(), smart().passwords());
        MainPage.InformaciyaAndReestr();

        step("Найти и открыть реестр Реестр оказания услуги Вывесок", () -> {
            $(byName("candidateSearchValue")).setValue("Реестр оказания услуги Вывесок").pressEnter();
            $x("//span[contains(text(),'Реестр оказания услуги Вывесок')]").click();
        });

        step("Открыть любую карточку реестра", () -> {
            $(".input-lg").setValue("КВ-2021-109").pressEnter();
            $(byLinkText("КВ-2021-109")).click();
        });

        step("В карточке присутствуют вкладки:", () -> {
            $x("//span[contains(text(),'Сведения о заявлении')]").shouldBe(visible);
            $x("//span[contains(text(),'Документы')]").shouldBe(visible);
            $x("//span[contains(text(),'МВ запросы')]").shouldBe(visible);
            $x("//span[contains(text(),'Внешние согласования')]").shouldBe(visible);
            $x("//span[contains(text(),'Заключение')]").shouldBe(visible);
            $x("//span[contains(text(),'Статусы ПГУ')]").shouldBe(visible);
            $x("//span[contains(text(),'ИАИС ОГД')]").shouldBe(visible);
            $x("//span[contains(text(),'Комментарии')]").shouldBe(visible);
            $x("//span[contains(text(),'История БП')]").shouldBe(visible);
        });

        step("В карточке присутствуют кнопки:", () -> {
            $(byText("Назад")).shouldBe(visible);
            $(byText("В реестр")).shouldBe(visible);
            $(byText("Выдать на руки")).shouldBe(visible);
        });
    }
}

