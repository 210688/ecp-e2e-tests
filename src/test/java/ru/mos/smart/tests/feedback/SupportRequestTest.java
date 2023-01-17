package ru.mos.smart.tests.feedback;

import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.helpers.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.*;

@Layer("web")
@Epic("FEEDBACK (Форма обратной связи)")
public class SupportRequestTest extends TestBase {

    @Test
    @AllureId("1145")
    @Description("Данная проверка отправляет письмо в тех поддержку, " +
            "запускать на определеных средах.")
    @DisplayName("Возможность инициировать обращение в техническую поддержку.")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("feedback")})
    void SupportRequestForward() {
        AuthorizationPage.openUrlWithAuthorizationAPI(getLoginRegress(), getPasswordRegress());
        actionsPage
                .goToActions("Инициировать обращение в техническую поддержку");

        step("Заполнение поля Тип обращения", () -> {
            $x("//input[@role='combobox']").click();
            $x("//span[contains(text(),'Технические вопросы')]").click();
        });
        step("Заполнение поля Тема обращения", () -> {
            $(".ng-select-taggable input").click();
            $(".ng-select-taggable input").val("Не заходит на главную страницу").pressEnter();
        });
        step("Заполнение поля Ссылка на страницу с ошибкой", () -> {
            $(byName("pageUrl")).setValue(webConfig().webUrl());
            $x("//div/button[contains(text(),'Отправить')]").click();
        });
    }
}




