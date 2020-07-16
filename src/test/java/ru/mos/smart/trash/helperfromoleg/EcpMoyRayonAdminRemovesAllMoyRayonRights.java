package ru.mos.smart.trash.helperfromoleg;
//package e2e.kronverk.tests.ecp.helperfromoleg   .oleg.ui.helpers;

// EcpMoyRayonAdminRemovesAllMoyRayonRights
//G:\java_project\kronverk_e2e_tests\src\test\java\e2e\kronverk\tests\ecp\helperfromoleg\EcpMoyRayonAdminRemovesAllMoyRayonRights.java

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.tests.TestBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.mos.smart.tests.TestData.LOGIN_s_PRAVAMI;
import static ru.mos.smart.tests.TestData.PASSWORD_s_PRAVAMI;

/*
*  Коллеги, просьба 'steps' и прочие комментарии записывать внутри java блока и всегда сначала (сверху).
*  Это помогает при переносе кусочков вашего кода в другие файлы.
* */

@Story("ЕЦП тесты Мой Район")
@Tag("web")
@Tag("ecp_mr_predprod")
class EcpMoyRayonAdminRemovesAllMoyRayonRights extends TestBase {
    public static boolean Passed, Failed;

    public static int dell15ComfortablePause,
                      dell15HugeComfortablePause;

    // FIXME: убрать неиспользуемые в этом тесте переменные
    public static String lightweightEnterUrl,
                         userDefaultStartEnterUrl,
                         infoPageForMoyRayonUrl,
                         userPageOpenedOnFirstLoginForMoyRayonUrl,
                         mapNewWindowPageForMoyRayonUrl,
                         apgrPageForMoyRayonUrl,
                         apgrPageForMoyRayonUrlRenewedUrl,
                         bazaZnaniyPageSearchForMoyRayonUrl,
                         bazaZnaniyPageSoderjimoeForMoyRayonUrl,
                         bazaZnaniyPageSoderjimoeForMoyRayonRenewedUrl,
                         bazaZnaniyPageJournalForMoyRayonUrl,
                         pageUserSettngSprvchnForMoyRayonUrl,
                         pageUserSettngDelegirForMoyRayonUrl,
                         pageUserSettngPravaDostForMoyRayonUrl,
                         pageUserSettngConstrVitrForMoyRayonUrl,
                         userPageGosuslZadachiForMoyRayonUrl,
                         userPageGosuslVozmForMoyRayonUrl,
                         nonTiedUrl,
                         lastUsedVolatileUserPassword,
                         allMoyRayonAccessRightsPrefix,
                         blockingBusinessProcessMoyRayonAccessRight
                         ;

    static {
        // использовать в assertTrue(Passed);
        Passed = true;
        // использовать в assertTrue(Failed);
        Failed = false;
        // наблюдение: повторный login после logout в ручном режиме может не отрабатывать, поэтому ввожу перем-ю:
        // почти чистый url с точки зрения "с этого url вход после выхода сработал бы". Значение ещё буду редактировать.
        // имеется ввиду, что state и прочие параметры значимые для последующих редиректов не завязаны на предыдущий вход.
        nonTiedUrl="https://smart-id-predprod.mos.ru/iam/auth/realms/smart/protocol/openid-connect/auth?client_id=smart-app&redirect_uri=https%3A%2F%2Fsmart-predprod.mos.ru%2Foauth%2Fcallback&response_type=code&scope=openid+email+profile&state=41c0869c-bfa1-4aea-bdaa-0db5eb1dd9a7";
        // набор url стартовых с различным откликом от UI.
        lightweightEnterUrl = "https://smart-predprod.mos.ru/main/#/app/versions";     // Настр.->Компоненты
        userDefaultStartEnterUrl = lightweightEnterUrl;
        userPageGosuslZadachiForMoyRayonUrl = "https://smart-predprod.mos.ru/main/#/app/tasks"; // госусл. и ф-ии->задачи
        userPageGosuslVozmForMoyRayonUrl = "https://smart-predprod.mos.ru/main/#/app/actions";  // госусл. и ф-ии->возможности
        userPageOpenedOnFirstLoginForMoyRayonUrl = userPageGosuslZadachiForMoyRayonUrl;
        infoPageForMoyRayonUrl = "https://smart-predprod.mos.ru/main/#/app/catalog-registers"; // Инф-я->Реестры
        mapNewWindowPageForMoyRayonUrl = "https://smart-predprod.mos.ru/map/#/map;onMode3D=true"; // Инф-я->Карта
                                                                                                  // у mr_test нет прав
        apgrPageForMoyRayonUrl = "https://smart-predprod.mos.ru/apgr/#/app/apgr_showcase"; // АПГР не откр. нов. окно,
                                                                                           // показывает "spinner",
                                                                                           // доп. изменений на странице
                                                                                           // можно ждать вечно (когда нет спец.прав).
        apgrPageForMoyRayonUrlRenewedUrl = "https://smart-predprod.mos.ru/apgr/#/app/apgr_showcase"; // куда из apgrPageForMoyRayonUrl переход
        bazaZnaniyPageSearchForMoyRayonUrl = "https://smart-predprod.mos.ru/apgr/#/app/bz/search";   // База зн.-> Поиск
        bazaZnaniyPageSoderjimoeForMoyRayonUrl = "https://smart-predprod.mos.ru/apgr/#/app/bz/nsiDict"; // База зн.-> Cодержимое
        bazaZnaniyPageSoderjimoeForMoyRayonRenewedUrl = "https://smart-predprod.mos.ru/apgr/#/app/bz/nsiDict";  // куда из bazaZnaniyPageSoderjimoeForMoyRayonUrl переход
        bazaZnaniyPageJournalForMoyRayonUrl = "https://smart-predprod.mos.ru/apgr/#/app/bz/journal"; // База зн.-> Журнал Изменений
        pageUserSettngSprvchnForMoyRayonUrl = "https://smart-predprod.mos.ru/main/#/app/dicts/system"; // Настройки -> Справочники
        pageUserSettngDelegirForMoyRayonUrl = "https://smart-predprod.mos.ru/main/#/app/dicts/delegate"; // Настр-ки->Делегирование
        pageUserSettngPravaDostForMoyRayonUrl = "https://smart-predprod.mos.ru/extras/#/app/requests/permissions-showcase"; // Настр->Права доступа
        pageUserSettngConstrVitrForMoyRayonUrl = "https://smart-predprod.mos.ru/extras/#/app/showcase-builder/list"; // Настр.->Констр. витрин

        // то, что относится к правам
        allMoyRayonAccessRightsPrefix = "MR_";
        blockingBusinessProcessMoyRayonAccessRight = "MR_OBJECT_MOS"; // права, у моего района, которые при добавление блокируют
                                                        // пользователю (напр. mr_test) все поля и он ни чего не может
                                                        //  писать и добалять в бизнес процессах

        // у volatile_mr это право было, в то время как специально я его не ставил.
        // Но войти в ЕЦП под volatile_mr по прежнему можно (хоть и без этого права)
        // probablyRequiredRight = "SYS_COMMON_ACCESS"; // описание: "Доступ к ресурсам ЕЦП"


        // набор пауз для удобства отладки
        dell15ComfortablePause = 3; // секунд мне комфортно для полуручного прогона кажд.шаг
        dell15HugeComfortablePause = 12; // секунд мне комфортно перед переходом в другой тест при ручной отладке

    }

    void pauseForHuman() {
        sleep(1000* dell15ComfortablePause);
    }

    void pauseForHumanBeforeQuitFromTest() {
        /*
         лучше бы спрашивать hotkey с консоли или из браузера
         асинхронно получать hotkey и ждать его тут.
        */
        sleep(1000* dell15HugeComfortablePause);
    }

    public void pressLogout() {
        //pauseForHumanBeforeQuitFromTest();
        $(By.linkText("Выйти")).click();
    }

    public void loginAs(String login, String password) {
        $(byText("Войти по логину и паролю")).click();
        $("#username").setValue(login);
        $("#password").setValue(password);
        $("#kc-login").click();
    }

    // FIXME: развить до класса и перетащить в отд. Java файл
    public void logDebugFileMessage(String messageMarker, String messageToFile, String osFileFullPath) {
        if (osFileFullPath == null) {
            osFileFullPath = "/tmp/java-tests-output";
        }

        String theFileName = osFileFullPath;
        String messageFinally = "\n===> " + messageMarker + "'String value' is '" + messageToFile + "' .\n";

        // Кусок с выводом через FileWriter в debug запуске
        FileWriter filewriter;
        try {
            // filewriter будет дописывать в файл без overwrite, в асинке (несколько тестов в один файл) каша будет,
            // но на 1 браузер вполне сойдёт.
            filewriter = new FileWriter(theFileName, true);

            filewriter.write(messageFinally); // так как вывод System.out трудно найти в selenid при дебаге .
            filewriter.close(); // вывод println не попадёт в файл, пока он не закрыт, так как процесс
            // прибивается в момент завершения отладки вместе с его файловым кэшем
        } catch (IOException exception) {
            System.out.println("IO error: " + exception);
            exception.printStackTrace();
        }
    }

    // FIXME: развить до класса и перетащить в отд. Java файл вместе с связанной ф-ией
    public void logDebugFileMessageDefaultFile(String messageMarker, String messageToFile) {
        logDebugFileMessage( messageMarker,  messageToFile, "/tmp/java-tests-output");
    }

    public void logDebugConsoleMessage(String messageMarker, String messageToDisplay) {

        String messageToDebug = "\n===> " + messageMarker + "'String value' is '" + messageToDisplay + "' .";
        System.out.println(messageToDebug); // это видно в debug, но хотелось бы покрасить текст конечно.
    }

    public void logDebugHTMLFromSelenideElement(String messageMarker, SelenideElement elementToDump) {
        //elementToDump передавать в виде '$("selector")', использоваться будет аналогично строке ниже:
        //System.out.println($("[ng-click=\"ctrl.gen()\"]"));

        // это всё видно в debug, но хотелось бы покрасить текст конечно.
        String messagePrefix  = "\n>--==> " + messageMarker + "'HTML value' is:";
        String messagePostfix = ">--==> " + messageMarker + "'HTML value' end.";
        System.out.println(messagePrefix);
        System.out.println(elementToDump);
        System.out.println(messagePostfix);
    }

    public  void  logDebugFileAndConsole(String messageMarker, String messageToLog) {
    logDebugConsoleMessage(messageMarker, messageToLog);
        logDebugFileMessageDefaultFile(messageMarker, messageToLog);
    }

    public String constructPropertiesUrlForSpecificUser(String userAccountingName) {
        /*
        // "https://smart-predprod.mos.ru/main/#/app/dicts/usersnsi" - выбор пользователя через форму
        // https://smart-predprod.mos.ru/main/#/app/dicts/usernsi/volatile_mr - выбранный пользователь
        //  "volatile_mr", это его "Учетное имя" согласно терминологии "Мой Район". */
        return "https://smart-predprod.mos.ru/main/#/app/dicts/usernsi/" + userAccountingName;
    }

    public void pressSetPasswordButton() {
        // ".btn-danger" - кнопка с изображением ключа красного цвета для задания пароля.
        $(".btn-danger").should(exist).click();
    }

    public SelenideElement clickSearchRightsField() {
        // ".btn-danger" - кнопка с изображением ключа красного цвета для задания пароля.
        $("input[name='search']").should(exist).click();
        // возвращаем SelenideElement чтобы продолжал работать pipeline через точку
        return $("input[name='search']");
    }

    public SelenideElement clickSaveRightsButton() {
        // кнопка 'Сохранить изменения' в меню редактирования прав пользователя
        String saveButtonSelector = "button[ng-class=\"{'btn-default': $ctrl.inSaving == true , '': $ctrl.inSaving == false }\"]";
        SelenideElement accessOperationButtonSave = $(saveButtonSelector);
        //logDebugHTMLFromSelenideElement( "кнопка 'Сохранить изменения' ", accessOperationButtonSave );
        accessOperationButtonSave.should(exist).click();
        // возвращаем SelenideElement чтобы продолжал работать pipeline через точку (можно и void, но пусть будет так)
        return accessOperationButtonSave;
    }

    @Test
//    @Order(3)
    /* Release Candidate.
     * снять все установленные у пользователя права начинающиеся на MR_ */
    @Description("снять все права (MR_*) у volatile пользователя (админский набор прав есть).")
    void uiMrRoleMrAdminRemoveAllAccessRightsForVolatileUser() {
    /*
    * Вынесено в отдельный файл и класс для упрощения дальнейшего переиспользования.
    * Предполагается дальнейший code refactoring - см. 'FIXME'.
    *
    * Steps: 1. войти под администратором Мой Район на легковесный url
    *        2. перейти на url редактирования конкретного пользователя
    *        3. поставить фильтр "MR_" в поисковике прав
    *        4. по одному найти каждый check box div и если он отмечен как включённый (право установлено) - выключить.
    *        5. нажать кнопку сохранения изменений.
    * */


        //open(userDefaultStartEnterUrl);
        open(lightweightEnterUrl);
        //loginAs(MR_ADMIN_USER, PASSWORD_MR_ADMIN);
        loginAs(LOGIN_s_PRAVAMI, PASSWORD_s_PRAVAMI);

        pauseForHuman(); // дать увидеть реакцию на логин человеку

        // переход на url где задают пароль конкретному пользователю,
        // оттуда же переход на смену прав.
        //open(constructPropertiesUrlForSpecificUser(MR_VOLATILE_USER));
//        open(constructPropertiesUrlForSpecificUser(LOGIN_MR_TEST));
        open(constructPropertiesUrlForSpecificUser("soldatovks"));

        SelenideElement userRightsSearchField = clickSearchRightsField();
//        userRightsSearchField.setValue(allMoyRayonAccessRightsPrefix); // Ставим MR_ в поисковой строке
        userRightsSearchField.setValue("OASI_AGR_"); // Ставим OASI_AGR_ в поисковой строке

        // все DIV отображающие чекбокс
        ElementsCollection accessOperationCheckBoxes = $$("div[ng-class=\"{checked:($ctrl.nodeItem.checked)}\"]");

        int foundElements = accessOperationCheckBoxes.size();
        logDebugConsoleMessage("array size:", String.valueOf(foundElements));

        boolean foundSomeRightsToDisable = false;
        // отфильтровать чекбоксы с правами уже имеющимися
        // (из тех что на MR_* часть может быть уже выбрана)
        // и снять их.
        for ( SelenideElement entry: accessOperationCheckBoxes
        ) {
            String entryText = entry.getAttribute("class"); // debug thing, 2remove
            logDebugConsoleMessage("checkbox getAttribute('class')", entryText); // debug thing, 2remove
            entry.scrollTo(); // if the test is running slower than expected - this one line could also be commented out.
            pauseForHuman();
            try {
                //entry.click(); // тут click работает нормально только на DIV целиком, кликнуть на input нельзя
                String classWhereToSearchForPattern =  entry.getAttribute("class");
                // dump entry to debug window
                logDebugHTMLFromSelenideElement("found element", entry);
                // у div-чекбокса с установленным правом в 'class' js код платформы
                // подставляет эту строку
                boolean theAccessRightIsAlreadySet = Pattern.matches("checked", classWhereToSearchForPattern);
                if (theAccessRightIsAlreadySet)  {
                    foundSomeRightsToDisable = true;
                    logDebugConsoleMessage("already set: ", "--?-"); // debug thing, 2remove
                    //entry.click();
                } else { logDebugConsoleMessage("already set: ", "inverseclick"); // debug thing, 2remove
                         entry.click();
                     }
            } catch (Exception exception) { // ignore unavailable for click checkboxes - pass exception, but log.
                System.out.println("Exception. Can't click() on '" + entry.name() + "' .");
                //exception.printStackTrace();
            }
        } // foreach // их находится 116 штук (collection size), нужных может быть меньше.

        logDebugConsoleMessage("after try/catch block ", "----"); // debug thing, 2remove

        // нажать на Сохранить изменения
        if (foundSomeRightsToDisable) {
            logDebugConsoleMessage("Changes made. ", "--YES--"); // debug thing, 2remove
            clickSaveRightsButton();
        } else {
            // попытка сохранить в этом случае отдаст 402
            logDebugConsoleMessage("Changes made. ", "--NO--"); // debug thing, 2remove
        }

        // logout
        pressLogout();

        //pauseForHumanBeforeQuitFromTest();
        assertTrue(Passed);
    }

}