package ru.mos.smart.tests.mkasdprv;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.enums.Registers.MKASDPRV_ORDER;
import static ru.mos.smart.data.enums.Sidebar.INFORMATION;
import static ru.mos.smart.data.enums.Sidebar.REGISTERS;


@Epic("OASI")
@Feature("Mkasdprv")
@Story("Mkasdprv_order")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class MkasdprvRegisterTests extends TestBase {

    @Test
    @AllureId("17088")
    @DisplayName("Наличия карточек")
    @Description("Проверить, что доступен реестр - оказания услуги Вывесок")
    void checkingTheAttributesOfTheRegistry() {
        sidebarPage.clickSidebarMenu(INFORMATION);
        sidebarPage.clickSubMenuList(INFORMATION, REGISTERS);
        reestrPage.goToRegister(MKASDPRV_ORDER);

        step("В реестре присутствуют поля:", () -> {
            $x("//th[contains(text(),'Номер заявления')]").shouldBe(exist);
            $x("//th[contains(text(),'Планируемая дата')]").shouldBe(exist);
            $x("//th[contains(text(),'Фактическая дата')]").shouldBe(exist);
            $x("//th[contains(text(),'Статус')]").shouldBe(exist);
            $x("//th[contains(text(),'Решение')]").shouldBe(exist);
            $x("//th[contains(text(),'Ответственный')]").shouldBe(exist);
            $x("//th[contains(text(),'Заявитель')]").shouldBe(exist);
            $x("//th[contains(text(),'Адрес')]").shouldBe(exist);
            $x("//th[contains(text(),'Номер ПГУ')]").shouldBe(exist);
        });
    }

    @Test
    @AllureId("17089")
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

