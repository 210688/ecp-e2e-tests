//
//package ru.mos.smart.tests.ugd.docs;
//
//import io.qameta.allure.*;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Tags;
//import org.junit.jupiter.api.Test;
//import ru.mos.smart.helpers.annotations.Component;
//import ru.mos.smart.helpers.annotations.Layer;
//import ru.mos.smart.pages.AuthorizationPage;
//import ru.mos.smart.tests.TestBase;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
//import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
//import static ru.mos.smart.data.enums.Registers.INSPECTIONACT;
//import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
//import static ru.mos.smart.data.enums.Sidebar.REGISTERS;
//
//@Epic("UGD")
//@Feature("DOCS (Реестр документов)")
//@Owner("soldatovks")
//@Tags({@Tag("ugd") ,@Tag("regres")})
//public class RegistersTests extends TestBase {
//
//    @Test
//    @Story("Информация")
//    @Component("Реестры")
//    @DisplayName("Проверка доступности реестра РД. Акт проверки строительства")
//    @Description("Проверить, что реестр РД. Акт проверки строительства - открывается")
//    void actInspectionTest() {
//        List<java.lang.String> columnNames = Arrays.asList("Номер акта", "Дата акта", "Место проведения проверки",
//                "Результат проверки", "Специалист УН", "ЕРКНМ");
//        List<String> columns = new ArrayList<String>() {{
//            add("Номер акта проверки");
//            add("Дата акта проверки");
//            add("Номер распоряжения");
//            add("Дата распоряжения");
//            add("Объект");
//            add("Вид проверки");
//            add("Проверяемая организация");
//            add("Предмет проверки");
//            add("Результат проверки");
//            add("Признак удаления");
//        }};
//        sidebarPage.clickSidebarMenu(INFORMATION);
//        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
//        reestrPage.goToRegister(INSPECTIONACT);
//
//        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
//        reestrPage
//                .goToRegister("РД. Акт проверки строительства");
//        reestrPage
//                .checkColumns(columns);
//    }
//
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
