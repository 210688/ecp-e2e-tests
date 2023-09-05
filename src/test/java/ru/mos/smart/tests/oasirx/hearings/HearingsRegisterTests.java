package ru.mos.smart.tests.oasirx.hearings;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeOasirx.HEARINGS_URL;

@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Oasirx")
@Story("HEARINGS (Публичные слушания)")
@Owner("Soldatov")
@Layer("web")
public class HearingsRegisterTests extends TestBase {

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("hearings"), @Tag("regressions")})
    @DisplayName("Переход в реестр Публичные слушания")
    void goToRegisterHearing() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        //urlPage.goToHearings();
        //reestrPage.searchField();
    }

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("hearings"), @Tag("regressions")})
    @DisplayName("Заголовки колонок в реестре Публичные слушания")
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("ПС в работе", "Все ПС", "Мои ПС", "Отчеты", "Заседания комиссий");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        //urlPage.goToHearings();
        //reestrPage.searchField();
        oasirxProjectsPage.checkFilter(HEARINGS_URL, tableColumnList);
    }
}
