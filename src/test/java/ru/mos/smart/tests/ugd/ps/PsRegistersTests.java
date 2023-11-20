package ru.mos.smart.tests.ugd.ps;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.UGD_PS_CAPITAL_CONSTRUCTION_OBJECT;
import static ru.mos.smart.data.enums.Registers.UGD_PS_CAPITAL_CONSTRUCTION_PROJECT;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("UGD")
@Feature("Ugd")
@Owner("soldatovks")
@Tags({@Tag("ugd") ,@Tag("regres")})
public class PsRegistersTests extends TestBase {

    @Test
    @Story("Ps")
    @Component("Реестры")
    @AllureId("18034")
    @DisplayName("Наличие карточек и заголовков в реестре Цифровые паспорта объектов капитального строительства")
    @Description("Проверка корректного открытия реестра Цифровые паспорта объектов капитального строительства: " +
            "проверка наличия карточек и заголовков таблицы")
    void checkDataRegisterCapitalConstructionObjects() {
        List<String> columnNames = Arrays.asList("Адрес и наименование", "Коммерческое наименование проекта", "Уникальный номер объекта",
                "Проект строительства", "Вид работ/Статус", "Источник финансирования/Застройщик", "Плановый срок ввода", "Особые отметки",
                "Удален", "Статус надзорного дела");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_PS_CAPITAL_CONSTRUCTION_OBJECT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_PS_CAPITAL_CONSTRUCTION_OBJECT, columnNames);
    }

    @Test
    @Story("Ps")
    @Component("Реестры")
    @AllureId("18033")
    @DisplayName("Наличие карточек и заголовков в реестре Цифровые паспорта проектов строительства")
    @Description("Проверка корректного открытия реестра Цифровые паспорта проектов строительства: " +
            "проверка наличия карточек и заголовков таблицы")
    void checkDataRegisterConstructionProject() {
        List<String> columnNames = Arrays.asList("Адрес и наименование", "Коммерческое наименование проекта", "Уникальный идентификатор",
                "Вид работ/Статус", "Источник финансирования/Застройщик", "Плановый срок ввода",
                "Особые отметки", "Включен в реестр строек", "Удален");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_PS_CAPITAL_CONSTRUCTION_PROJECT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_PS_CAPITAL_CONSTRUCTION_PROJECT, columnNames);
    }
}
