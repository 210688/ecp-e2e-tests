package ru.mos.smart.tests.oasi.blago;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASI (ОАСИ)")
@Feature("BLAGO (ОАСИ Благоустройство)")
public class BlagoRegistersTests extends TestBase {

    @Test
    @AllureId("2716")
    @DisplayName("Проверка наличия реестров")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("regres"), @Tag("oasi"), @Tag("blago")})
    void checkingBlagoRegisters() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginOasirx(), webConfig().passwordOasirx());
        navigatorPage
                .goToRegister();
        reestrPage
                .search("Проекты благоустройства");

        step("Должны быть найдены Проекты благоустройства", () ->
                $(".search-result-table tbody").$$("tr").shouldHave(sizeGreaterThan(0)));

    }
}
