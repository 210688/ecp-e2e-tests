package ru.mos.smart.tests.ugd.docs;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.ManualMember;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

import static ru.mos.smart.config.ConfigHelper.webConfig;

@Story("Реестры")
@Feature("DOCS (Реестр документов)")
@Epic("UGD (УГД)")
@Tags({@Tag("predprod"), @Tag("prod"), @Tag("regress"), @Tag("ugd"), @Tag("docs")})
@ManualMember("croc")
public class RegistersTests extends TestBase {
    @Test
    @AllureId("6403")
    @DisplayName("Проверка доступности реестра РД. Акт проверки строительства")
    void actInspectionTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер акта проверки");
            add("Дата акта проверки");
            add("Номер распоряжения");
            add("Дата распоряжения");
            add("Объект");
            add("Вид проверки");
            add("Проверяемая организация");
            add("Предмет проверки");
            add("Результат проверки");
            add("Признак удаления");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("РД. Акт проверки строительства");
        reestrPage
                .checkColumns(columns);
    }

    @Test
    @AllureId("6400")
    @DisplayName("Проверка доступности реестра РД. Извещения об окончании СМР")
    void noticeEndWorksTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер извещения");
            add("Дата извещения");
            add("Единый номер обращения");
            add("Номер обращения");
            add("Дата обращения");
            add("Дата начала итоговой проверки");
            add("Дата окончания итоговой проверки");
            add("Объект");
            add("Дата окончания строительства");
            add("Признак удаления");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("РД. Извещения об окончании СМР");
        reestrPage
                .checkColumns(columns);
    }

    @Test
    @AllureId("6404")
    @DisplayName("Проверка доступности реестра РД. Извещения о начале СМР")
    void noticeBeginWorksTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер извещения");
            add("Дата извещения");
            add("Единый номер обращения");
            add("Номер обращения");
            add("Дата обращения");
            add("Объект");
            add("Признак удаления");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("РД. Извещения о начале СМР");
        reestrPage
                .checkColumns(columns);
    }

    @Test
    @AllureId("6490")
    @DisplayName("Проверка доступности реестра РД. Свидетельства АГР")
    void agrTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер документа");
            add("Дата документа");
            add("Регистрационный номер документа");
            add("Дата регистрации документа");
            add("Наименование объекта");
            add("Адрес объекта");
            add("Округа");
            add("Районы");
            add("Стадия проектирования");
            add("Статус документа");
            add("Признак удаления");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("РД. Свидетельства АГР");
        reestrPage
                .checkColumns(columns);
    }

    @Test
    @AllureId("6492")
    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов. ГПЗУ")
    void gpzuTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер документа");
            add("Дата документа");
            add("Номер заявления");
            add("Дата заявления");
            add("Кадастровый номер земельного участка");
            add("Адрес ЗУ");
            add("Состояние документа");
            add("Организация");
            add("Удален");
            add("Файл");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Реестр оперативных данных документов. ГПЗУ");
        reestrPage
                .checkColumns(columns);
    }

    @Test
    @AllureId("6398")
    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Заключения Мосгоргеотреста")
    void mggtConclusionTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер документа");
            add("Дата документа");
            add("Адрес");
            add("Заказчик");
            add("Признак удаления");
            add("Файл");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Реестр оперативных данных документов. Заключения Мосгоргеотреста");
        reestrPage
                .checkColumns(columns);
    }

    @Test
    @AllureId("6463")
    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Заключения о соответствии")
    void equivalentConclusionTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер документа");
            add("Дата документа");
            add("Номер заявления");
            add("Дата заявления");
            add("Объект");
            add("Организация");
            add("Исполнитель");
            add("Принятое решение");
            add("Удален");
            add("Файл");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Реестр оперативных данных документов. Заключения о соответствии");
        reestrPage
                .checkColumns(columns);
    }

    @Test
    @AllureId("6461")
    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Заключения экспертизы")
    void conclusionExpertiseTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер регистрации в реестре");
            add("Дата регистрации в реестре");
            add("Номер обращения");
            add("Дата обращения");
            add("Номер документа(МГЭ)");
            add("Дата документа(МГЭ)");
            add("Состояние/Результат экспертизы");
            add("Форма экспертизы");
            add("Сведения об объекте");
            add("Стадия проектирования");
            add("Вид строительства");
            add("Функциональное назначение объекта");
            add("Источник финансирования");
            add("Экспертная организация");
            add("Файл");
        }};
        List<String> hiddenColumns = new ArrayList<String>() {{
            add("Удален");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Реестр оперативных данных документов. Заключения экспертизы");
        reestrPage
                .checkColumns(columns, hiddenColumns);
    }

    @Test
    @AllureId("6481")
    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Разрешения на ввод")
    void startupPermissionTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер документа");
            add("Дата документа");
            add("Дата выдачи документа заявителю");
            add("Состояние документа");
            add("Кем выдан");
            add("Номер заявления");
            add("Дата заявления");
            add("Объект");
            add("Организация");
            add("Удален");
            add("Файл");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Реестр оперативных данных документов. Разрешения на ввод");
        reestrPage
                .checkColumns(columns);
    }

    @Test
    @AllureId("6448")
    @DisplayName("Проверка доступности реестра Реестр оперативных данных документов.Разрешения на строительство")
    void constructionPermissionTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер документа");
            add("Дата документа");
            add("Срок действия");
            add("Состояние документа");
            add("Кем выдан");
            add("Номер заявления");
            add("Дата заявления");
            add("Объект");
            add("Организация");
            add("Удален");
            add("Файл");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Реестр оперативных данных документов. Разрешения на строительство");
        reestrPage
                .checkColumns(columns);
    }

    @Test
    @AllureId("6493")
    @DisplayName("Проверка доступности реестра Реестр оперативных данных.Исполнительные чертежи Мосгоргеотреста")
    void mggtExdrawingTest() {
        List<String> columns = new ArrayList<String>() {{
            add("Номер документа");
            add("Дата документа");
            add("Адрес");
            add("Заказчик");
            add("Признак удаления");
            add("Файл");
        }};
        AuthorizationPage.openUrlWithAuthorizationAPI("", webConfig().loginUgd(), webConfig().passwordUgd());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Реестр оперативных данных. Исполнительные чертежи Мосгоргеотреста");
        reestrPage
                .checkColumns(columns);
    }
}