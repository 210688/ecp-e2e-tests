package ru.mos.smart.tests.oasirx.fcd;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
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
import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.FCD_URL;

@Epic("Проверки реестров по подсистемам")
@Feature("ОАСИРХ")
@Story("Реестр")
@Layer("web")
@Owner("Soldatov")
public class FcdRegisterTests extends TestBase {

        @Test
        @DisplayName("Проверка наличия данных и перехода в раздел Фасады нежильё")
        @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
        void goToRegisterEoo() {
            List<String> columnNames = Arrays.asList("Дата", "Номер", "Номер ПГУ", "Адрес", "Исполнитель", "Тип запроса", "Статус");
            sidebarPage.goToSection(FCD_URL);
        }

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @DisplayName("Переход в реестр Фасады")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToFacades() {
        heading.shouldHave(text("Фасады нежильё"));
    }

    @Test
    @DisplayName("Заголовки колонок в реестре Фасады")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("В работе", "Все", "Мои", "Статистика");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        oasirxProjectsPage.checkFilter(FCD_URL, tableColumnList);
    }
}
