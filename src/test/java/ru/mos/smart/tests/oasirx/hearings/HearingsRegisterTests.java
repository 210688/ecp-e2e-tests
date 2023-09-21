package ru.mos.smart.tests.oasirx.hearings;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.HEARINGS_URL;

@Epic("OASI")
@Feature("Оасирх")
@Story("Hearings")
@Component("Реестр")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class HearingsRegisterTests extends TestBase {

    @Test
    @AllureId("17064")
    @DisplayName("Переход в реестр Публичные слушания")
    @Description("Проверить, что происходит переход в реестр - Публичные слушания")
    void goToRegisterHearing() {
    }

    @Test
    @AllureId("17065")
    @DisplayName("Заголовки колонок в реестре Публичные слушания")
    @Description("Проверить, что есть заголовки колонок в реестре - Публичные слушания")
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("ПС в работе", "Все ПС", "Мои ПС", "Отчеты", "Заседания комиссий");
        oasirxProjectsPage.checkFilter(HEARINGS_URL, tableColumnList);
    }
}
