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

import static ru.mos.smart.data.enums.Registers.UGD_DOCS_MGGT_CONCLUSION_DOCUMENT;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("UGD")
@Feature("DOCS (Реестр оперативных данных документов)")
@Owner("soldatovks")
@Tags({@Tag("ugd") ,@Tag("regres")})
public class DocsCardsTests extends TestBase {

    @Test
    @Story("Информация")
    @Component("Реестры")
    @DisplayName("Открытие карточки в реестре оперативных данных документов. Заключения Мосгоргеотреста " +
            "заполненность данными и наличие всех блоков информации")
    @Description("Проверка открытия карточки в реестре оперативных данных Заключения Мосгоргеотреста " +
            "заполненность данными и наличие всех блоков информации")
    void checkOpenCardInRegisterGpzu() {
        List<String> blockColumnList = Arrays.asList("Назначение объекта", "Организации", "Коммуникации");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_DOCS_MGGT_CONCLUSION_DOCUMENT);
        ugdPage.goToRegistryCard(UGD_DOCS_MGGT_CONCLUSION_DOCUMENT);
        ugdPage.checkBlocksInCard(UGD_DOCS_MGGT_CONCLUSION_DOCUMENT, blockColumnList);
    }
}
