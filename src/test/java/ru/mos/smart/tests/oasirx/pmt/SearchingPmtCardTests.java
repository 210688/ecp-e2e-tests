package ru.mos.smart.tests.oasirx.pmt;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("OASIRX (ОАСИ Рефактор-Икс)")
//@Suite("PMT")
@Story("Поиск карточки ПМТ")
@Tag("oasirx") @Tag("pmt")
class SearchingPmtCardTests extends TestBase {

    @Test
    @DisplayName("Поиск ПМТ по названию")
    void SearchingPmtCardByName() {
        openUrlWithAuthorization("", LOGIN_PMT, PASSWORD_PMT);

        step("Открытие в навигаторе ПМТ", () -> {
            $(byLinkText("ПМТ")).click();
        });

        step("Перейти во вкладку Все ПМТ", () -> {
            $(byId("tab2-link")).click();
        });

        step("В строке поиска ввести название ПМТ", () -> {
            $(byClassName("form-control")).setValue("Для префектуры").pressEnter();
        });

        step("Проверка результата поиска", () -> {
            $(byText("Для префектуры")).shouldBe(visible);
        });
    }
}
