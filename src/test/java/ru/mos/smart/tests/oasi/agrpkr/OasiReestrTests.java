package ru.mos.smart.tests.oasi.agrpkr;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.Registers.AGR;
import static ru.mos.smart.data.Registers.PKR;
import static ru.mos.smart.data.Sidebar.INFORMATION;
import static ru.mos.smart.data.Sidebar.REGISTERS;

@Owner("Soldatov")
@Layer("web")
@Epic("OASI")

public class OasiReestrTests extends TestBase {

    @Test
    @Feature("PKR")
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Проверка наличия данных и перехода в реестр Оаси Пкр")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToRegisterOasiPkr() {
        List<String> columnNames = Arrays.asList("Рег. номер", "Дата регистрации", "Адрес объекта", "Статус", "Заявитель",
                "Плановая дата", "Исполнитель", "Номер МПГУ", "Дата подготовки решения", "Получен ответ из БР");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(PKR);
        generalPage.checkTableFilter(PKR, columnNames);
    }

    @Test
    @Feature("AGR")
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Проверка наличия данных и перехода в реестр Оаси АГР")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToRegisterOasiAgr() {
        List<String> columnNames = Arrays.asList("Номер дела", "Наименование  объекта", "Адрес земельного участка", "Рег. номер", "Дата регистрации",
                "Статус", "Заявитель", "Дата оказания ГУ", "Номер МПГУ", "Эксперт ", "Значение объекта", "Кол-во дней в МКА", "Номер и дата комиссии",
                "срок");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(AGR);
        generalPage.checkTableFilter(AGR, columnNames);
    }
}