package ru.mos.smart.tests.mkasdprv;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.enums.Registers.MKASDPRV_ORDER;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;


@Epic("OASI")
@Feature("MKASDPRV")
@Tags({@Tag("mkasdprv"), @Tag("regres")})
public class MkasdprvRegisterTests extends TestBase {

    @Test
    @AllureId("17088")
    @Story("MKASDPRV_ORDER")
    @DisplayName("Наличия карточек")
    @Description("Проверить, что доступен реестр - оказания услуги Вывесок")
    void checkingTheAttributesOfTheRegistry() {
        List<String> tableColumnList = Arrays.asList("Номер заявления", "Дата подачи", "Планируемая дата", "Фактическая дата", "Статус",
                "Решение", "Ответственный","Заявитель", "Адрес", "Номер ПГУ");
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKASDPRV_ORDER);
        generalPage.verifyRegistryContainsCardsAndTableHeaders(MKASDPRV_ORDER, tableColumnList);
    }

    @Test
    @AllureId("17089")
    @Story("MKASDPRV_ORDER")
    @DisplayName("Отображение заголовков в карточке")
    @Description("Проверить, что присутствуют все вкладки и кнопки в реестре")
    void openingRegistryCard() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKASDPRV_ORDER);

        step("В карточке присутствуют вкладки:", () -> {
            $x("//span[contains(text(),'Сведения о заявлении')]").shouldBe(visible);
            $x("//span[contains(text(),'Документы')]").shouldBe(visible);
            $x("//span[contains(text(),'МВ запросы')]").shouldBe(visible);
            $x("//span[contains(text(),'Внешние согласования')]").shouldBe(visible);
            $x("//span[contains(text(),'Заключение')]").shouldBe(visible);
            $x("//span[contains(text(),'Статусы ПГУ')]").shouldBe(visible);
            $x("//span[contains(text(),'ИАИС ОГД')]").shouldBe(visible);
            $x("//span[contains(text(),'Комментарии')]").shouldBe(visible);
            $x("//span[contains(text(),'История БП')]").shouldBe(visible);
        });

        step("В карточке присутствуют кнопки:", () -> {
            $(byText("Назад")).shouldBe(visible);
            $(byText("В реестр")).shouldBe(visible);
            $(byText("Выдать на руки")).shouldBe(visible);
        });
    }
}

