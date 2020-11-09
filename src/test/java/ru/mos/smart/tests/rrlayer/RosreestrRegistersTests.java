package ru.mos.smart.tests.rrlayer;

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
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("RRLAYER (Росреестр)")
@Feature("Поиск записи в реестре \"Росреестр. Земельные участки\"")
@Tag("rrlayer")
public class RosreestrRegistersTests extends TestBase {

    @Test
    @DisplayName("02.Поиск \"Росреестр. Земельные участки\"")
    void openRosreestrZemUch() {
        LoginPage.openUrlWithAuthorization("", LOGIN_OSSIG, PASSWORD_OSSIG);
        //MainPage.otkrytReestr();

        step("Перейти в раздел \"Реестры\"", () -> {
            $(byLinkText("Информация")).click();
            $(byLinkText("Реестры")).click();
        });

        step("В списке реестров найти и открыть \"Росреестр. Земельные участки\"", () -> {
            $(byName("candidateSearchValue")).setValue("Росреестр. Земельные участки").pressEnter();
            $(byLinkText("Росреестр. Земельные участки")).click();
        });

        step("Реестр открывается, присутствует список", () -> {
            $(byText("Росреестр. Земельные участки")).shouldBe(visible);
        });
    }
}