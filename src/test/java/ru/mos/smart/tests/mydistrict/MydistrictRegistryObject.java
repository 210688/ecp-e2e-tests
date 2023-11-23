package ru.mos.smart.tests.mydistrict;


import io.qameta.allure.AllureId;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.MydistrictPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static ru.mos.smart.data.enums.Registers.IZS_ZAV;
import static ru.mos.smart.data.enums.Registers.MR_PROGRAM_OBJ;
import static ru.mos.smart.data.enums.Sidebar.*;

public class MydistrictRegistryObject extends TestBase {


    @Test
    @AllureId("10734")
    @Tag("regres")
    void checkAttributesOfMydistrictRegistryObject() {

        sidebarPage.clickSidebarMenu(MY_RAYON);
        sidebarPage.clickSubMenuList(MY_RAYON, REGISTERS_OBJECTS);
        mydistrictPage.tableContainingColumnNames();
        mydistrictPage.nameObjectsUnderMyDistrictProgram();
        mydistrictPage.exportToExcelButton();
        mydistrictPage.testingMultisearchWithPlaceholderTextFromAttributes();
        mydistrictPage.checkThatTheFindButtonIsActive();
        mydistrictPage.checkThatTheResetButtonIsActive();
        mydistrictPage.makeSureTheAdvancedSearchButtonIsActive();
        mydistrictPage.checkThatTheColumnVisibilityButtonIsActive();
        mydistrictPage.checkThatTheMaximumNumberOfRecordsPerPageIs25();
        mydistrictPage.checkThatThePaginationFieldIsVisible();
        mydistrictPage.checkThatTheTotalNumberOfRecordsCounterIsTotalRecords();
        mydistrictPage.checkingHorizontalAndVerticalScrolling();
        mydistrictPage.testingAdvancedSearchWithButtonDisplay();
        mydistrictPage.checkTheVisibilityOfElementsInTheColumnVisibilityButton();


    }

}




