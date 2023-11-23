package ru.mos.smart.tests.platform;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.io.FileNotFoundException;

import static ru.mos.smart.data.enums.Sidebar.*;

@Epic("Регрессионные тесты платформы (функционал)")
@Feature("Работа со справочниками")
@Tag("regressing")
public class DictTests extends TestBase {

    @Test
    @AllureId("18151")
    @Owner("Soldatov")
    @DisplayName("Проверить наличие системных справочников")
    @Description("Проверить, что в справочнике присутствуют Системные справочники")
    void goToSystemDict() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictPage.verifySystemDictionariesExistence();
    }

    @Test
    @AllureId("17964")
    @Owner("Soldatov")
    @DisplayName("Открытие карточки системного справочника")
    @Description("Проверить функционал открытия системного справочника и убедиться в заполненности справочника данными")
    void goToCardInSystemDict() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictPage.verifySystemDictionariesExistence();
        dictPage.goToSystemDict();
        dictPage.checkListActions();
    }

    @Test
    @AllureId("17965")
    @Owner("Soldatov")
    @DisplayName("Экспорт справочника в JSON файл")
    @Description("Проверить работу функционала экспорта справочника в JSON файл")
    void downloadSystemDict() throws FileNotFoundException {
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, REFERENCE_BOOKS);
        dictPage.goToSystemDict();
        dictPage.exportDictionary();
        //File downloadedFile = $(".fa-upload").download();
        //$x("//button[@title='Экспорт справочника в JSON файл']").download();
        //assertThat(downloadedFile.getName()).matches(".*_complete\\.json");
    }

    @Test
    @AllureId("17962")
    @Owner("Soldatov")
    @DisplayName("Проверка функционала получения данных пользователей")
    @Description("Проверить работу функционала открытия карточки пользователя через интерфейс поиска пользователей")
    void checkSearchUser() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, USER);
        userPage.searchUser();
        userPage.userList();
        userPage.goToUserCard();
        userPage.checkCardUser();
    }
}
