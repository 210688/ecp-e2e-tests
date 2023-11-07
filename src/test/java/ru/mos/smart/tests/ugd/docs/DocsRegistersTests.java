
package ru.mos.smart.tests.ugd.docs;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.enums.Registers.*;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("UGD")
@Feature("DOCS (Реестр оперативных данных документов)")
@Owner("soldatovks")
@Tags({@Tag("ugd") ,@Tag("regres")})
public class DocsRegistersTests extends TestBase {

    @Test
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Наличие карточек и заголовков оперативных данных документов. ГПЗУ")
    @Description("Проверка корректного открытия реестра оперативных данных документов. ГПЗУ: " +
            "проверка наличия карточек и заголовков таблицы")
    void checkDataRegisterGPZU() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Номер заявления", "Дата заявления",
                "Кадастровый номер земельного участка", "Адрес ЗУ", "Состояние документа", "Организация",
                "Удален", "Файл", "Наличие жилищного строительства");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_DOCS_GPZU_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_GPZU_DOCUMENT, columnNames);
    }

    @Test
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Заключения Мосгоргеотреста")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Заключения Мосгоргеотреста: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterMggt() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Адрес", "Заказчик",
                "Признак удаления", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_DOCS_MGGT_CONCLUSION_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_MGGT_CONCLUSION_DOCUMENT, columnNames);
    }

    @Test
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Заключения о соответствии")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Заключения о соответствии: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterEquivalentConclusion() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Номер заявления", "Дата заявления",
                "Объект", "Организация", "Исполнитель", "Принятое решение", "Удален", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_DOCS_EQUIVALENT_CONCLUSION_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_EQUIVALENT_CONCLUSION_DOCUMENT, columnNames);
    }

    @Test
    @Story("Информация")
    @Component("Реестры")
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
        reestrPage.goToRegister(UGD_DOCS_CONCLUSION_EXPERTISE_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_CONCLUSION_EXPERTISE_DOCUMENT, columnNames);
    }

    @Test
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Исполнительные чертежи Мосгоргеотреста")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Исполнительные чертежи Мосгоргеотреста: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterMggtExdrawingDocuments() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Адрес", "Заказчик",
                "Признак удаления", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_DOCS_MGGT_EXDRAWING_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_MGGT_EXDRAWING_DOCUMENT, columnNames);
    }

    @Test
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Разрешения на ввод")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Разрешения на ввод: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterStartupPermission() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Дата выдачи документа заявителю",
                "Состояние документа", "Кем выдан", "Номер заявления", "Дата заявления", "Объект", "Организация", "Статус ГКУ/ГРП", "Удален", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_DOCS_STARTUP_PERMISSION_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_STARTUP_PERMISSION_DOCUMENT, columnNames);
    }

    @Test
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Разрешения на строительство")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Разрешения на строительство: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterConstructionPermission() {
        List<java.lang.String> columnNames = Arrays.asList("Номер документа", "Дата документа", "Срок действия", "Состояние документа",
                "Кем выдан", "Номер заявления", "Дата заявления", "Объект", "Организация", "Удален", "Файл");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_DOCS_CONSTRUCTION_PERMISSION_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_CONSTRUCTION_PERMISSION_DOCUMENT, columnNames);
    }

    @Test
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Наличие карточек и заголовков реестра оперативных данных документов. Титульные списки")
    @Description("Проверка корректного открытия реестра оперативных данных документов. Титульные списки: " +
            "наличие карточек и заголовков таблицы")
    void checkDataRegisterTitleDocuments() {
        List<java.lang.String> columnNames = Arrays.asList("Номер", "Год", "Форма", "Письмо ДЭПиР", "Объект", "Округ/Район",
                "Государственный заказчик", "Заказчик", "Состояние", "Программа Правительства Москвы");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_DOCS_TITLE_DOCUMENT);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_DOCS_TITLE_DOCUMENT, columnNames);
    }
}

//    @Test
//   ("6400")
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра РД. Извещения об окончании СМР")
//    @Description("Проверить, что реестр РД. Извещения об окончании СМР - открывается")
//    void noticeEndWorkSmrTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер извещения");
//            add("Дата извещения");
//            add("Единый номер обращения");
//            add("Номер обращения");
//            add("Дата обращения");
//            add("Дата начала итоговой проверки");
//            add("Дата окончания итоговой проверки");
//            add("Объект");
//            add("Дата окончания строительства");
//            add("Признак удаления");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("РД. Извещения об окончании СМР");
//        reestrPage
//                .checkColumns(columns);
//    }
//
//    @Test
//   ("6404")
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра РД. Извещения о начале СМР")
//    @Description("Проверить, что реестр РД. Извещения о начале СМР  - открывается")
//    void noticeBeginWorkSmrTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер извещения");
//            add("Дата извещения");
//            add("Единый номер обращения");
//            add("Номер обращения");
//            add("Дата обращения");
//            add("Объект");
//            add("Признак удаления");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("РД. Извещения о начале СМР");
//        reestrPage
//                .checkColumns(columns);
//    }
//
//    @Test
//   ("6490")
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра РД. Свидетельства АГР")
//    @Description("Проверить, что реестр РД. Свидетельства АГР - открывается")
//    void agrTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер документа");
//            add("Дата документа");
//            add("Регистрационный номер документа");
//            add("Дата регистрации документа");
//            add("Наименование объекта");
//            add("Адрес объекта");
//            add("Округа");
//            add("Районы");
//            add("Стадия проектирования");
//            add("Статус документа");
//            add("Признак удаления");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("РД. Свидетельства АГР");
//        reestrPage
//                .checkColumns(columns);
//    }
//
//    @Test
//   ("6492")
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов. ГПЗУ")
//    @Description("Проверить, что реестр оперативных данных документов. ГПЗУ  - открывается")
//    void gpzuTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер документа");
//            add("Дата документа");
//            add("Номер заявления");
//            add("Дата заявления");
//            add("Кадастровый номер земельного участка");
//            add("Адрес ЗУ");
//            add("Состояние документа");
//            add("Организация");
//            add("Удален");
//            add("Файл");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("Реестр оперативных данных документов. ГПЗУ");
//        reestrPage
//                .checkColumns(columns);
//    }
//
//    @Test
//   ("6398")
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Заключения Мосгоргеотреста")
//    @Description("Проверить, что реестр оперативных данных документов.Заключения Мосгоргеотреста  - открывается")
//    void mggtTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер документа");
//            add("Дата документа");
//            add("Адрес");
//            add("Заказчик");
//            add("Признак удаления");
//            add("Файл");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("Реестр оперативных данных документов. Заключения Мосгоргеотреста");
//
//        reestrPage
//                .checkColumns(columns);
//    }
//
//    @Test
//   ("6463")
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Заключения о соответствии")
//    @Description("Проверить, что реестр оперативных данных документов.Заключения о соответствии - открывается")
//    void equivalentConclusionTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер документа");
//            add("Дата документа");
//            add("Номер заявления");
//            add("Дата заявления");
//            add("Объект");
//            add("Организация");
//            add("Исполнитель");
//            add("Принятое решение");
//            add("Удален");
//            add("Файл");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("Реестр оперативных данных документов. Заключения о соответствии");
//        reestrPage
//                .checkColumns(columns);
//    }
//
//    @Test
//   ("6461")
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Заключения экспертизы")
//    @Description("Проверить, что реестр оперативных данных документов.Заключения экспертизы - открывается")
//    void conclusionExpertiseTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер регистрации в реестре");
//            add("Дата регистрации в реестре");
//            add("Номер обращения");
//            add("Дата обращения");
//            add("Номер документа(МГЭ)");
//            add("Дата документа(МГЭ)");
//            add("Состояние/Результат экспертизы");
//            add("Форма экспертизы");
//            add("Сведения об объекте");
//            add("Стадия проектирования");
//            add("Вид строительства");
//            add("Функциональное назначение объекта");
//            add("Источник финансирования");
//            add("Экспертная организация");
//            add("Файл");
//        }};
//        List<String> hiddenColumns = new ArrayList<String>() {{
//            add("Удален");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("Реестр оперативных данных документов. Заключения экспертизы");
//
//        reestrPage
//                .checkColumns(columns, hiddenColumns);
//    }
//
//    @Test
//   ("6481")
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Разрешения на ввод")
//    @Description("Проверить, что реестр оперативных данных документов.Разрешения на ввод  - открывается")
//    void startupPermissionTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер документа");
//            add("Дата документа");
//            add("Дата выдачи документа заявителю");
//            add("Состояние документа");
//            add("Кем выдан");
//            add("Номер заявления");
//            add("Дата заявления");
//            add("Объект");
//            add("Организация");
//            add("Удален");
//            add("Файл");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("Реестр оперативных данных документов. Разрешения на ввод");
//
//        reestrPage
//                .checkColumns(columns);
//    }
//
//    @Test
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Разрешения на строительство")
//    @Description("Проверить, что реестр оперативных данных документов.Разрешения на строительство - открывается")
//    void constructionPermissionTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер документа");
//            add("Дата документа");
//            add("Срок действия");
//            add("Состояние документа");
//            add("Кем выдан");
//            add("Номер заявления");
//            add("Дата заявления");
//            add("Объект");
//            add("Организация");
//            add("Удален");
//            add("Файл");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("Реестр оперативных данных документов. Разрешения на строительство");
//        reestrPage
//                .checkColumns(columns);
//    }
//
//    @Test
//    @Layer("web")
//    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("docs")})
//    @DisplayName("Проверка доступности реестра Реестр оперативных данных.Исполнительные чертежи Мосгоргеотреста")
//    @Description("Проверить, что реестр оперативных данных.Исполнительные чертежи Мосгоргеотреста - открывается")
//    void mggtExdrawingTest() {
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер документа");
//            add("Дата документа");
//            add("Адрес");
//            add("Заказчик");
//            add("Признак удаления");
//            add("Файл");
//        }};
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("Реестр оперативных данных. Исполнительные чертежи Мосгоргеотреста");
//        reestrPage
//                .checkColumns(columns);
//    }
//}
//*/
