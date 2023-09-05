package ru.mos.smart.tests.oasi.agrpkr;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTER;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeOasi.AGR;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeOasi.PKR;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationAPI;

@Owner("Soldatov")
@Layer("web")
@Epic("Проверки реестров по подсистемам")
@Feature("ОАСИ")
@Story("Реестр")
public class OasiReestrTests extends TestBase {

    @Test
    @AllureId("14335")
    @DisplayName("Проверка наличия данных и перехода в реестр Оаси Пкр")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasiReestr")})
    void goToRegisterOasiPkr() {
        List<String> columnNames = Arrays.asList("Рег. номер", "Дата регистрации", "Адрес объекта", "Статус", "Заявитель",
                "Плановая дата", "Исполнитель", "Номер МПГУ", "Дата подготовки решения", "Получен ответ из БР");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTER);
        reestrPage.goToRegister(PKR);
/*        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        reestrPage.checkFilter(PKR, columnNames);*/
    }

    @Test
    @AllureId("14336")
    @DisplayName("Проверка наличия данных и перехода в реестр Оаси АГР")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasiReestr")})
    void goToRegisterOasiAgr() {
        List<String> columnNames = Arrays.asList("Номер дела", "Наименование  объекта", "Адрес земельного участка", "Рег. номер", "Дата регистрации",
                "Статус", "Заявитель", "Дата оказания ГУ", "Номер МПГУ", "Эксперт ", "Значение объекта", "Кол-во дней в МКА", "Номер и дата комиссии",
                "срок");
        openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        reestrPage.goToRegister(AGR);
/*        reestrPage.searchField();
        reestrPage.columnsAndFilterButton();
        reestrPage.checkFilter(AGR, columnNames);*/
    }
}