
package ru.mos.smart.tests.ugd.docs;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.*;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("UGD")
@Feature("Ugd")
@Owner("soldatovks")
@Tags({@Tag("ugd") ,@Tag("regres")})
public class DocsRegistersTests extends TestBase {

    @Test
    @Story("Docs")
    @Component("Реестры")
    @AllureId("18038")
    @DisplayName("Наличие карточек и заголовков в реестре оперативных данных документов. ГПЗУ")
    @Description("Проверка корректного открытия реестра оперативных данных документов. ГПЗУ: " +
            "проверка наличия карточек и заголовков таблицы")
    void checkDataRegisterGPZU() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Номер заявления", "Дата заявления",
                "Кадастровый номер земельного участка", "Адрес ЗУ", "Состояние документа", "Организация",
                "Удален", "Файл", "Наличие жилищного строительства");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_DOCS_GPZU_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_GPZU_DOCUMENT, columnNames);
    }

    @Test
    @Story("Docs")
    @Component("Реестры")
    @AllureId("18037")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Заключения Мосгоргеотреста")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Заключения Мосгоргеотреста: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterMggt() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Адрес", "Заказчик",
                "Признак удаления", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_DOCS_MGGT_CONCLUSION_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_MGGT_CONCLUSION_DOCUMENT, columnNames);
    }

    @Test
    @Story("Docs")
    @Component("Реестры")
    @AllureId("18036")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Заключения о соответствии")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Заключения о соответствии: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterEquivalentConclusion() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Номер заявления", "Дата заявления",
                "Объект", "Организация", "Исполнитель", "Принятое решение", "Удален", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_DOCS_EQUIVALENT_CONCLUSION_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_EQUIVALENT_CONCLUSION_DOCUMENT, columnNames);
    }

    @Test
    @Story("Docs")
    @Component("Реестры")
    @AllureId("18042")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Заключения экспертизы")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Заключения экспертизы: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterExpertiseConclusion() {
        List<java.lang.String> columnNames = Arrays.asList("Номер регистрации в реестре", "Дата регистрации в реестре", "Номер обращения",
                "Дата обращения", "Номер документа(МГЭ)", "Дата документа(МГЭ) ", "Состояние/Результат экспертизы", "Форма экспертизы",
                "Сведения об объекте", "Стадия проектирования", "Вид строительства", "Функциональное назначение объекта", "Источник финансирования",
                "Экспертная организация", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_DOCS_CONCLUSION_EXPERTISE_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_CONCLUSION_EXPERTISE_DOCUMENT, columnNames);
    }

    @Test
    @Story("Docs")
    @Component("Реестры")
    @AllureId("18039")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Исполнительные чертежи Мосгоргеотреста")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Исполнительные чертежи Мосгоргеотреста: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterMggtExdrawingDocuments() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Адрес", "Заказчик",
                "Признак удаления", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_DOCS_MGGT_EXDRAWING_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_MGGT_EXDRAWING_DOCUMENT, columnNames);
    }

    @Test
    @Story("Docs")
    @Component("Реестры")
    @AllureId("18040")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Разрешения на ввод")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Разрешения на ввод: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterStartupPermission() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Дата выдачи документа заявителю",
                "Состояние документа", "Кем выдан", "Номер заявления", "Дата заявления", "Объект", "Организация", "Статус ГКУ/ГРП", "Удален", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_DOCS_STARTUP_PERMISSION_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_STARTUP_PERMISSION_DOCUMENT, columnNames);
    }

    @Test
    @Story("Docs")
    @Component("Реестры")
    @AllureId("18041")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Разрешения на строительство")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Разрешения на строительство: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterConstructionPermission() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Срок действия", "Состояние документа",
                "Кем выдан", "Номер заявления", "Дата заявления", "Объект", "Организация", "Удален", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_DOCS_CONSTRUCTION_PERMISSION_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_CONSTRUCTION_PERMISSION_DOCUMENT, columnNames);
    }

    @Test
    @Story("Docs")
    @Component("Реестры")
    @AllureId("18035")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Титульные списки")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Титульные списки: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterTitleDocuments() {
        List<java.lang.String> columnNames = Arrays.asList("Номер", "Год", "Форма", "Письмо ДЭПиР", "Объект", "Округ/Район",
                "Государственный заказчик", "Заказчик", "Состояние", "Программа Правительства Москвы");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(UGD_DOCS_TITLE_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_TITLE_DOCUMENT, columnNames);
    }
}
