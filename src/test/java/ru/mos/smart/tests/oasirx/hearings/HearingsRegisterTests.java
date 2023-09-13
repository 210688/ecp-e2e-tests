package ru.mos.smart.tests.oasirx.hearings;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Owner;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.HEARINGS_URL;

@Epic("Регрессионные тесты для проверки базового функционала")
@Feature("Oasirx")
@Story("HEARINGS (Публичные слушания)")
@Owner("Soldatov")
public class HearingsRegisterTests extends TestBase {

    @Test
    @DisplayName("Переход в реестр Публичные слушания")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void goToRegisterHearing() {
    }

    @Test
    @DisplayName("Заголовки колонок в реестре Публичные слушания")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
    void checkHeadersTables() {
        List<String> tableColumnList = Arrays.asList("ПС в работе", "Все ПС", "Мои ПС", "Отчеты", "Заседания комиссий");
        oasirxProjectsPage.checkFilter(HEARINGS_URL, tableColumnList);
    }
}
