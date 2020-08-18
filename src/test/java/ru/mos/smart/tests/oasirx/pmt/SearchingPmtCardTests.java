package ru.mos.smart.tests.oasirx.pmt;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("PMT (ПМТ)")
@Tag("oasirx") @Tag("pmt") @Tag("all_tests")
class SearchingPmtCardTests extends TestBase {

    @Test
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
            $("#form-control").setValue("Для префектуры").pressEnter();
        });

        step("Проверка, что в результатах поиска появилось \"Для префектуры\"", () -> {
            $(byText("Для префектуры")).shouldBe(visible);
        });
    }
}
