package ru.mos.smart.tests.mkapmii;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.pages.ReestrPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;
import static com.codeborne.selenide.Condition.visible;

public class MkapmiiRegisterTests extends TestBase {
    @Test
    @AllureId("5189")
    @DisplayName("Проверка UI реестр оказания услуг по размещению инженерных изысканий")
    @Tags({@Tag("stage"), @Tag("regress")})
    @Epic("Автотесты")
    @Feature("Реестр и карточка заявления")
    void checkingTheAttributesOfTheRegistry() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginMka(), webConfig().passwordMka());
        NavigatorPage.goToRegister();
        ReestrPage.open("Реестр оказания услуги по размещению инженерных изысканий");
        step("Проверить, что в форме содержится поле для поиска", () ->{
            $(".search-form input").shouldBe(visible);
        });
        step("Содержатся кнопки: 'Настройка отображения колонок', 'Фильтр'", () ->{
            $(".fa.fa-bars").shouldBe(visible);
            $(".fa.fa-filter").shouldBe(visible);
        });
        step("Содержится таблица с озаглавленными столбцами", () -> {
            $(".search-result-table tr").$$("th").filter(visible).shouldHave(textsInAnyOrder(
                    "Номер заявления",
                    "Дата подачи",
                    "Планируемая дата оказания",
                    "Фактическая дата оказания",
                    "Статус",
                    "Решение",
                    "Ответственный",
                    "Заявитель",
                    "Адрес",
                    "Номер ПГУ",
                    "Вид"
            ));
        });
    }
}
