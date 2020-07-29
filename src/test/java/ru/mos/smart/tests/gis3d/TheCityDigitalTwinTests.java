package ru.mos.smart.tests.gis3d;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.helpers.DriverHelper.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("Модуль \"GIS\"")
@Story("Проверка открытия \"карты в режиме Цифровой двойник города\"")
@Tag("gis")
@Tag("ecp")
class TheCityDigitalTwinTests extends TestBase {

    @Test
    @Description("Используется тестовый пользователь gis_test c нужными правами")
    @DisplayName("Проверка открытия карты в режиме Цифровой двойник города")
    void mapsCanBeOpened() {
        step ("Авторизация", ()-> {
            openUrlWithAuthorization("", LOGIN_GIS_TEST, PASSWORD_GIS_TEST); //авторизация в системе
        });

        step("Открытие в навигаторе информация - карта", ()-> {
            $(byLinkText("Информация")).click();
            $(byLinkText("Цифровой двойник города")).click();
            switchTo().window(1);
            sleep(5000);
        });
        step("Проверка, что карта загрузилась", ()-> {
            sleep(5000);
            $(byText("Найти адресс")).shouldBe(Condition.visible);
        });
    }
}