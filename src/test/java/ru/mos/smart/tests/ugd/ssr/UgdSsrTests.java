
package ru.mos.smart.tests.ugd.ssr;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.AutoMember;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Registers.*;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;

@Epic("UGD")
@Feature("Ugd")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("ugd"), @Tag("ssr")})
@AutoMember("soldatovks")
public class UgdSsrTests extends TestBase {

    @Test
    @AllureId("18005")
    @Story("Ssr")
    @Component("Реестры")
    @Description("Реестр отселяемых домов")
    @DisplayName("Проверка доступности реестра ССР. Реестр отселяемых домов")
    void ugdSsrRealEstateCatalogTest() {
        List<String> columnNames = Arrays.asList("UNOM", "Адрес", "Номер дома", "Административный округ", "Год постройки",
                "Скоро начнется переселение дома", "Статус обогащения", "Дата обогащения", "Количество SsoId", "Количество квартир", "Статус дома"
        );
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_SSR_REAL);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_SSR_REAL, columnNames);
    }

    @Test
    @AllureId("18007")
    @Story("Ssr")
    @Component("Реестры")
    @Description("Реестр жителей")
    @DisplayName("Проверка доступности реестра ССР. Реестр жителей")
    void ugdSsrPersonCatalogTest() {
        List<String> columnNames = Arrays.asList("Фамилия, имя, отчество", "Дата рождения", "Адрес отселяемого дома", "Номер квартиры",
                "Статус обогащения из ПФР", "Дата обогащения из ПФР", "Статус обогащения из ЕЛК", "Дата обогащения из ЕЛК"
        );
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_SSR_PERSON);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_SSR_PERSON, columnNames);
    }

    @Test
    @AllureId("18006")
    @Story("Ssr")
    @Component("Реестры")
    @DisplayName("Наличие карточек и заголовков в реестре Центр информирования по переселению жителей")
    @Description("Проверка корректности открытия реестра Центр информирования по переселению жителей, наличие карточек" +
            " и отображения заголовков таблицы")
    void ugdSsrCipCatalog() {
        List<String> columnNames = Arrays.asList("Адрес центра переселения (округ, район)", "Отселяемых домов", "Заселяемых домов",
                "Дата открытия центра", "Дата закрытия центра", "Статус");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(UGD_SSR_CIP);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(UGD_SSR_CIP, columnNames);
    }
}


