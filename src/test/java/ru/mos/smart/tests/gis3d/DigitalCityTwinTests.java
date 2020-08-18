package ru.mos.smart.tests.gis3d;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("Платформа ЕЦП")
@Feature("GIS 3D (Картографическое обеспечение, Конструктор)")
@Story("Проверка работы карты в режиме Цифровой двойник")
@Tag("gis") @Tag("gis3d")
class DigitalCityTwinTests extends TestBase {

    @Test
    @Description("Используется тестовый пользователь gis_test c нужными правами")
    @DisplayName("Проверка открытия карты в режиме Цифровой двойник")
    void mapsCanBeOpened() {
        openUrlWithAuthorization("", LOGIN_GIS_TEST, PASSWORD_GIS_TEST);

        step("Открытие в навигаторе Информация > Цифровой двойник", ()-> {
            $(byLinkText("Информация")).click();
            $(byLinkText("Цифровой двойник")).click();
        });

        step("Проверка, что карта загрузилась", ()-> {
            switchTo().window(1);
            $(byText("Найти адрес"))
                    .waitUntil(visible, 10000).shouldBe(Condition.visible);
        });
    }
}