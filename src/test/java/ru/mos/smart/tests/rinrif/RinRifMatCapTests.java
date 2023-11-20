package ru.mos.smart.tests.rinrif;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.APPMATCAP;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("ИАИС РИН")
@Feature("RINRIF")
@Tags({@Tag("rinrif"), @Tag("regres")})
public class RinRifMatCapTests extends TestBase {

    @Test
    @AllureId("16999")
    @Story("MATCAP")
    @Owner("soldatov")
    @DisplayName("Открытие реестра Заявления о выдаче акта по материнскому капиталу")
    @Description("Проверить, что открывается карточка из реестра - Заявления о выдаче акта по материнскому капиталу" +
            "убедится в наличии заголовков и данных в карточке.")
    void checkAttributesOfRinRifMatCapRegistry() {
        List<java.lang.String> columnNames = Arrays.asList("Статус", "Номер заявления", "Дата заявления", "Объект",
                "Плановая дата исполнения", "Заявитель", "Данные ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(APPMATCAP);
        rinrifPage.registryContainsCardsHeadersCheck(APPMATCAP, columnNames);
    }

    @Test
    @AllureId("17000")
    @Story("MATCAP")
    @Owner("soldatov")
    @DisplayName("Открытие карточки реестра Заявления о выдаче акта по материнскому капиталу")
    @Description("Проверить, что открывается карточка из реестра - Заявления о выдаче акта по материнскому капиталу, " +
            "отображение полей в карточке, в карточке присутствуют вкладки")
    void checkAttributesOfRinRifMatCapObjCard() {
        List<String> cardHeaders = Arrays.asList("Общая информация", "Документы", "Акт", "Результат", "Внешние системы",
                "Процесс", "", "", "Общие сведения", "Сведения о ЗУ и объекте");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegistry(APPMATCAP);
        rinrifPage.goToRegistryCard(APPMATCAP);
        rinrifPage.checkAvailabilityHeadersInCard(APPMATCAP, cardHeaders);
    }
}
