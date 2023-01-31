package ru.mos.smart.tests.oasirx.hearings;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
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
import static ru.mos.smart.data.RegisterObjectType.HEARINGS;

@Epic("OASIRX")
@Feature("HEARINGS (Публичные слушания)")
@Layer("web")
@Owner("SoldatovKS")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("hearings"), @Tag("regressions")})
public class HearingsRegisterTests extends TestBase {

    @Test
    @DisplayName("Переход в реестр Публичные слушания")
    @Description("Проверить переход в реестр")
    void goToRegisterHearing() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToHearings();
        reestrPage.searchField(HEARINGS);
    }

    @Test
    @DisplayName("Заголовки колонок в реестре Публичные слушания")
    @Description("Проверить заголовки колонок")
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("ПС в работе", "Все ПС", "Мои ПС", "Отчеты", "Заседания комиссий");
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        urlPage.goToHearings();
        reestrPage.searchField(HEARINGS);
        oasirxProjectsPage.checkFilter(HEARINGS, tableColumnList);
    }
}
