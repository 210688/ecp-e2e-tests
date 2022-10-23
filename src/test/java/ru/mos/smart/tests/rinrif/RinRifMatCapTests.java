package ru.mos.smart.tests.rinrif;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Epic("Автотесты")
public class RinRifMatCapTests extends TestBase {

    @Test
    @DisplayName("Проверка реестра Заявления о выдаче акта по материнскому капиталу")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("prod"), @Tag("rinrif")})
    void checkAttributesOfRinRifMatCapRegistry() {
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginMr(), webConfig().passwordMr());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Заявления о выдаче акта по материнскому капиталу");
        step("Проверить, что в форме содержится поле для поиска", () -> {
            $(".search-form").$("input").shouldBe(visible);
            $(".search-form").$("button.btn-search").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка', 'Фильтр'", () -> {
            $(".container-btn").$("button.btn-default").shouldBe(visible);
            $(".container-btn").$("button.btn-white").shouldBe(visible);
        });
        step("Доступен список объектов", () -> {
            $("table").$$("th").shouldHave(sizeGreaterThan(1));
        });
    }

    @Test
    @DisplayName("Проверка карточки реестра Заявления о выдаче акта по материнскому капиталу")
    @Layer("web")
    @Tags({@Tag("stage"), @Tag("predprod"), @Tag("regres"), @Tag("rinrif")})
    void checkAttributesOfRinRifMatCapObjCard() {
        String statementNumber = "09-МК-179/21-(0)-0";
        AuthorizationPage.openUrlWithAuthorizationAPI(webConfig().loginMr(), webConfig().passwordMr());
        navigatorPage
                .goToRegister();
        reestrPage
                .open("Заявления о выдаче акта по материнскому капиталу");

        step("Открыть любую карточку реестра", () -> {
            $("input.input-lg").setValue(statementNumber).pressEnter();
            $("table").$("tbody").$(byText(statementNumber)).click();
        });

        ElementsCollection fieldNames = $$(".col-lg-6.col-md-6.col-sm-12");
        step("Проверить, что в шапке карточки отображаются поля (сведения в них могут отсутствовать)", () -> {
            fieldNames.get(0).$("b").shouldHave(text("Заявитель:"));
            fieldNames.get(1).$("b").shouldHave(text("Срок:"));
            fieldNames.get(2).$("b").shouldHave(text("Представитель заявителя:"));
            fieldNames.get(3).$("b").shouldHave(text("Исполнено:"));
            fieldNames.get(4).$("b").shouldHave(text("Ответственный исполнитель:"));
            $(".col-lg-12.col-md-12.col-sm-12").$("b").shouldHave(text("Результат:"));
        });

        ElementsCollection tabsList = $("ul.nav.nav-tabs").$$("li.nav-item");
        step("В карточке присутствуют вкладки:", () -> {
            tabsList.get(0).shouldHave(text("Общая информация"));
            tabsList.get(1).shouldHave(text("Документы"));
            tabsList.get(2).shouldHave(text("Акт"));
            tabsList.get(3).shouldHave(text("Результат"));
            tabsList.get(4).shouldHave(text("Внешние системы"));
            tabsList.get(5).shouldHave(text("Процесс"));
            tabsList.get(6).$("a[title='JSON']").shouldBe(visible);
            tabsList.get(7).$("a[title='История изменений']").shouldBe(visible);
        });
    }
}
