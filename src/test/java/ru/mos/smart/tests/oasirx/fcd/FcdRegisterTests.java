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
import static ru.mos.smart.data.RegisterObjectType.FCD;

@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Oasirx")
@Story("Fcd")
@Owner("Soldatov")
@Layer("web")
public class FcdRegisterTests extends TestBase {

    private final SelenideElement heading = $(".ng-binding");

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("regressions")})
    @DisplayName("Переход в реестр Фасады")
    void goToFacades() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToFacades();
        heading.shouldHave(text("Фасады нежильё"));
    }

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("regressions")})
    @DisplayName("Заголовки колонок в реестре Фасады")
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("В работе", "Все", "Мои", "Статистика");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToFacades();
        reestrPage.searchField();
        oasirxProjectsPage.checkFilter(FCD, tableColumnList);
    }
}
