package ru.mos.smart.tests.oasirx.elma;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Component;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.data.registry.RegisterObjectTypeOasirx.ELMA_URL;

@Owner("Soldatov")
@Epic("OASI")
@Feature("ОАСИРХ")
@Story("elma")
@Component("Реестр")
@Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regressions")})
public class ElmaRegisterTests extends TestBase {

    @Test
    @AllureId("17072")
    @DisplayName("Проверка наличия данных и перехода в раздел Соответствие проектной документации СППК")
    void goToRegisterElma() {
        List<String> columnNames = Arrays.asList("Дата", "Номер", "Номер МГГТ", "Название", "Статус");
        sidebarPage.goToSection(ELMA_URL);
    }
}
