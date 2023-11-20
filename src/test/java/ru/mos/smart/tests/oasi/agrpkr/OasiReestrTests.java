package ru.mos.smart.tests.oasi.agrpkr;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.AGR;
import static ru.mos.smart.data.enums.Registers.PKR;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;


@Epic("OASI")
@Feature("OASI")
@Tags({@Tag("oasi"), @Tag("regres")})
public class OasiReestrTests extends TestBase {

    @Test
    @AllureId("17080")
    @Owner("Soldatov")
    @Story("Pkr")
    @Component("Реестры")
    @DisplayName("Отображение реестра ПКР на наличие заголовков и карточек оформления Паспортов колористических решений")
    @Description("Проверить, что корректно открывается и доступности реестра ПКР, включая проверку порядка отображения заголовков и карточек")
    void goToRegisterOasiPkr() {
        List<String> columnNames = Arrays.asList("Рег. номер", "Дата регистрации", "Адрес объекта", "Статус", "Заявитель",
                "Плановая дата", "Исполнитель", "Номер МПГУ", "Дата подготовки решения", "Получен ответ из БР");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(PKR);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(PKR, columnNames);
    }

    @Test
    @AllureId("17081")
    @Owner("Soldatov")
    @Story("Agr")
    @Component("Реестры")
    @DisplayName("Отображение реестра АГР на наличие заголовков и карточек свидетельств")
    @Description("Проверить, что в реестре присутствуют заголовки и карточки свидетельств")
    void goToRegisterOasiAgr() {
        List<String> columnNames = Arrays.asList("Номер дела", "Наименование  объекта", "Адрес земельного участка", "Рег. номер", "Дата регистрации",
                "Статус", "Заявитель", "Дата оказания ГУ", "Номер МПГУ", "Эксперт ",
                "Значение объекта", "Кол-во дней в МКА", "План. дата на комиссии","Номер и дата комиссии", "срок");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(AGR);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(AGR, columnNames);
    }
}