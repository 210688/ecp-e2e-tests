package ru.mos.smart.tests.platform;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.mos.smart.data.enums.Sidebar.REFERENCE_BOOKS;
import static ru.mos.smart.data.enums.Sidebar.SETTINGS;

@Epic("Регрессионные тесты платформы (функционал)")
@Feature("Работа со справочниками")
@Tag("regressing")
public class DictTests extends TestBase {

    @Test
    @AllureId("18151")
    @Owner("Soldatov")
    @DisplayName("Работоспособность раздела Справочники")
    @Description("Проверка, что в справочнике присутствуют Системные справочники")
    void goToSystemDict() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictPage.checkListSystemDict();
    }

    @Test
    @AllureId("17964")
    @Owner("Soldatov")
    @DisplayName("Проверка работоспособности раздела Справочники")
    @Description("Проверка открытия системного справочника возможности и наличие данных")
    void goToCardInSystemDict() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictPage.goToSystemDict();
        dictPage.checkListActions();
    }

    @Test
    @AllureId("17965")
    @Owner("Soldatov")
    @DisplayName("Выгрузка системного справочника")
    @Description("Проверка работы экспорта справочника в JSON файл")
    void downloadSystemDict() throws FileNotFoundException {
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictPage.goToSystemDict();
        File downloadedFile = $x("//button[@title='Экспорт справочника в JSON файл']").download();
        assertThat(downloadedFile.getName()).matches(".*_Actions_complete\\.json");
    }
}
