package ru.mos.smart.tests.oasirx.elma;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import java.util.Arrays;
import java.util.List;

import static ru.mos.smart.config.ConfigHelper.getLoginRegress;
import static ru.mos.smart.config.ConfigHelper.getPasswordRegress;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeOasirx.ELMA_URL;
import static ru.mos.smart.pages.AuthorizationPage.openUrlWithAuthorizationAPI;

@Owner("Soldatov")
@Layer("web")
@Epic("Проверки реестров по подсистемам")
@Feature("ОАСИРХ")
@Story("Реестр")
public class ElmaRegisterTests extends TestBase {

    @Test
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("oasirx"), @Tag("crd"), @Tag("oasirxReestr")})
    @DisplayName("Проверка наличия данных и перехода в раздел Соответствие проектной документации СППК")
    void goToRegisterElma() {
        List<String> columnNames = Arrays.asList("Дата", "Номер", "Номер МГГТ", "Название", "Статус");
        openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        navigatorPage.goToSection(ELMA_URL);
        reestrPage.searchField();
        reestrPage.checkFieldData(ELMA_URL, columnNames);
    }
}
