package ru.mos.smart.tests.oasirx.fcd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeOasirx.FCD_URL;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationAPI;

@Epic("Проверки реестров по подсистемам")
@Feature("ОАСИРХ")
@Story("Реестр")
@Layer("web")
@Owner("Soldatov")
public class FcdRegisterTests extends TestBase {

        @Test
        @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("oasirxReestr")})
        @DisplayName("Проверка наличия данных и перехода в раздел Фасады нежильё")
        void goToRegisterEoo() {
            List<String> columnNames = Arrays.asList("Дата", "Номер", "Номер ПГУ", "Адрес", "Исполнитель", "Тип запроса", "Статус");
            openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
            sidebarPage.goToSection(FCD_URL);
            //reestrPage.searchField();
            //reestrPage.checkFieldData(FCD_URL, columnNames);
        }

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @AllureId("12537")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("oasirxCard")})
    @DisplayName("Переход в реестр Фасады")
    void goToFacades() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        //urlPage.goToFacades();
        heading.shouldHave(text("Фасады нежильё"));
    }

    @Test
    @AllureId("12536")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("oasirxCard")})
    @DisplayName("Заголовки колонок в реестре Фасады")
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("В работе", "Все", "Мои", "Статистика");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
       //urlPage.goToFacades();
        //reestrPage.searchField();
        oasirxProjectsPage.checkFilter(FCD_URL, tableColumnList);
    }
}
