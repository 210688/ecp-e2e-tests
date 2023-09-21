package ru.mos.smart.tests.oasirx.fcd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.FCD_URL;

@Epic("OASI")
@Feature("Оасирх")
@Story("FCD")
@Component("Реестр")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class FcdRegisterTests extends TestBase {

    @Test
    @AllureId("17068")
    @DisplayName("Наличия данных и перехода в раздел Фасады нежильё")
    @Description("Проверить, что есть данные и происходит переход в раздел Фасады нежильё")
    void goToRegisterEoo() {
        List<String> columnNames = Arrays.asList("Дата", "Номер", "Номер ПГУ", "Адрес", "Исполнитель", "Тип запроса", "Статус");
        sidebarPage.goToSection(FCD_URL);
    }

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @AllureId("17067")
    @DisplayName("Переход в реестр Фасады")
    @Description("Проверить, что происходит переход в реестр Фасады")
    void goToFacades() {
        heading.shouldHave(text("Фасады нежильё"));
    }

    @Test
    @AllureId("17066")
    @DisplayName("Заголовки колонок в реестре Фасады")
    @Description("Проверить, что есть заголовки колонок в реестре Фасады")
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("В работе", "Все", "Мои", "Статистика");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        oasirxProjectsPage.checkFilter(FCD_URL, tableColumnList);
    }
}
