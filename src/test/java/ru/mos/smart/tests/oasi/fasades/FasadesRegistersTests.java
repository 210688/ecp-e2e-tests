package ru.mos.smart.tests.oasi.fasades;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.config.ConfigHelper;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("FASADES (ОАСИ Фасады)")
public class FasadesRegistersTests extends TestBase {

    @Test
    @DisplayName("Проверка перехода к реестру Проекты изменений фасадов зданий (жилые)")
    @Tag("allModules")
    @Tag("prod")
    void openRegisterFasadesZhil() {
        LoginPage.openUrlWithAuthorization("", ConfigHelper.getUsername(), ConfigHelper.getPassword());
        MainPage.InformaciyaAndReestr();

        step("В строке поиска найти реестр Проекты изменений фасадов зданий (жилые).", () -> {
            $(byName("candidateSearchValue")).setValue("Проекты изменений фасадов зданий (жилые)").pressEnter();
            $(byLinkText("Проекты изменений фасадов зданий (жилые)")).click();
        });

        step("Реестр открывается, присутствует список", () -> {
            $(byText("Проекты изменений фасадов зданий (жилые)")).shouldBe(visible);
        });
    }
}
