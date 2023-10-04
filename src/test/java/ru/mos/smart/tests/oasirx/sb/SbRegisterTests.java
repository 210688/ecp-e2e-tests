package ru.mos.smart.tests.oasirx.sb;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.enums.Sidebar.SB;

@Epic("OASI")
@Feature("Оасирх")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class SbRegisterTests extends TestBase {

    @Test
    @AllureId("17057")
    @Story("SB")
    @Component("Реестр")
    @DisplayName("Наличие карточек и заголовков в реестре Самострой")
    @Description("Проверить, что реестр Самострой корректно открывается, присутствуют карточки " +
            "включая проверку порядка отображения заголовков")
    void openingTheRegisterSb() {
        List<String> tableColumnList = Arrays.asList("Дата", "Номер", "Округ", "Адрес", "Тип объекта", "Исполнитель", "Статус");
        sidebarPage.clickSidebarMenu(SB);
        oasirxPage.registryContainsCardsHeadersCheck(SB, tableColumnList);
    }

    @Test
    @AllureId("17056")
    @Story("SB")
    @Component("Реестр")
    @DisplayName("Поиск карточки реестра Самострой по номеру")
    @Description("Проверить, что происходит поиск карточки реестра Самострой по номеру")
    void searchingSbCardByNumber() {
        sidebarPage.clickSidebarMenu(SB);
//TODO метод поиска по номеру карточки

/*        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("ОСС-0028-2021").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("ОСС-0028-2021")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'ОСС-0028-2021')]").shouldBe(visible));
*/
    }
}