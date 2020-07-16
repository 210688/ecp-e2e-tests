package ru.mos.smart.tests.gis;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.MapsPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selenide.$;

@Epic("Платформа ЕЦП")
@Feature("Модуль \"GIS\"")
@Story("Проверка работы функционала  \"подложки\"")
@Tag("GIS")
@Tag("ECP")
class PodlozhkaTests extends TestBase {

    /*
    1 Откроется ссылка карты
    2 Выбрать режим подложки - Спутник
    3 Проверка: Карта поменяла вид на отображение режима подложки со Спутника
    */
    @Test
    @DisplayName("Проверка открытия подложки в режиме спутник")
    @Description("Используется тестовый пользователь gis_test c нужными правами")
    void mapsCanBeOpenedSputnik() {

      //  openUrlWithAuthorizationGIS("/main/#/app/tasks",
       //         "Открытие страницы \"Карта\"");
        MapsPage.Menu();
        MapsPage.VerifyMapsObjectIsOpened();
        $(".btn btn-link").click();
        $("li:nth-child(2)").click();

    }
}

