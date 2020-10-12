package ru.mos.smart.tests.oasirx.pmt;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("PMT (ПМТ)")
@Tag("oasirx") @Tag("pmt")
class SearchingPmtCardTests extends TestBase {

    @Test
    @AllureId("1000")
    @DisplayName("Поиск ПМТ по названию")
    void searchingPmtCardByName() {
        openUrlWithAuthorization("", LOGIN_PMT, PASSWORD_PMT);

        step("Открытие в навигаторе ПМТ", () -> {
            $(byLinkText("ПМТ")).click();
        });

        step("Перейти во вкладку Все ПМТ", () -> {
            $("#tab2-link").click();
        });

        step("В строке поиска ввести название ПМТ", () -> {
            $(".input-group.ng-dirty").setValue("ПМТ-0044-2020").pressEnter();
        });

        step("Проверка, что в результатах поиска появилось \"Для префектуры\"", () -> {
            $(byText("Для префектуры")).shouldBe(visible);
        });
    }
}
//?/input[@safeclass~'\bform-control\b.*\bng-dirty\b.*\bng-touched\b.*\bng-valid\b']
//ui-view[@id='pmt-module']/app-document-list/div[@class='pmt-styles']/div//app-search-input//form//input[@placeholder='Номер и тип документа, организация, источник']