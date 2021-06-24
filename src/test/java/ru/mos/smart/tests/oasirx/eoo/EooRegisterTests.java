package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.AuthorizationPage;
import ru.mos.smart.pages.NavigatorPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.config.ConfigHelper.webConfig;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("EOO (Электронные общественные обсуждения)")
@Story("Реестр ЭОО")
public class EooRegisterTests extends TestBase {

    @Test
    @AllureId("920")
    @DisplayName("01. Добавление ЭОО")
    @Story("PPT (modules)")
    @Feature("EOO (Электронные общественные обсуждения)")
    @Epic("OASIRX (ОАСИ Рефактор-Икс)")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("eoo")})
    void addCartEoo() {
        AuthorizationPage.openUrlWithAuthorization("", webConfig().loginOasirxEoo(), webConfig().passwordOasirxEoo());
        NavigatorPage.goToEoo();
        step("В открывшейся форме выбрать Добавить ЭОО", () ->
                $(byText("Добавить ЭОО")).click());
        step("В открывшейся форме заполнить обязательные поля:", () -> {
            step("Описание проекта – ввести текстовое описание, например, Проект планировки территории.");
            $("#description-ctr").setValue("тестовая заявка");
            step("Округ – выбрать и справочника Округов, может быть выбрано несколько вариантов, например, СЗАО, ЦАО.");
            $("#prefect-ctr").click();
            $(byText("САО")).click();
            step("Район – выбрать из справочника районов, может быть выбрано несколько вариантов, например, Капотня, Замоскворечье.");
            $("#district-ctr").click();
            $(byText("Коптево")).click();
            step("Адресный ориентир – вести текстовое описание адресного ориентира, например, пр-т Мира, д. 123.");
            $("#address-ctr").setValue("Ломоносовский проспект");
            step("Тип исходного проекта – выбрать из справочника одно значение, например, ППТ.");
            $("#source_type-ctr").click();
            $(byText("ППТ")).click();
            step("Ответственное управление – выбрать из списка управлений одно значение, например, УППТ.");
            $("#responsibleExecutor_code-ctr").click();
            $(byText("УППТ")).click();
            step("Исполнитель – выбрать пользователя из списка, этот пользователь становится ответственным исполнителем по проекту, и следующая задача процесса должна быть назначена ему.");
            $("#responsibleExecutor_login-ctr").click();
            $(byText("Учетная для автотестов (autotest_eoo)")).click();
        });
        step("Нажатие кнопки Сохранить и перейти к формированию процесса.", () ->
                $("#assign").click());
        step("Осуществляется переход в задачу ЭОО" , () ->
                $(byText("Этап")));
    }

    @Test
    @DisplayName("Поиск карточки реестра ЭОО по номеру")
    @Tags({@Tag("preprod"), @Tag("oasirx"), @Tag("eoo")})
    void searchingEooCardByNumber() {

        AuthorizationPage.openUrlWithAuthorization("", webConfig().logins(), webConfig().password());

        step("Из боковой панели перейти в раздел ЭОО", () -> {
            $x("//span[text()='ЭОО']").waitUntil(visible, 10000);
            $x("//span[text()='ЭОО']").click();
        });

        step("Открыт раздел Общественные обсуждения", () ->
                $x("//div/h2[contains(text(),'Общеcтвенные обcуждения')]").shouldBe(visible));

        step("В строке поиска ввести номер карточки", () ->
                $x("//div/input[contains(@class,'form-control')]").setValue("ПЗЗ-00016-2021-ЭОО").pressEnter());

        step("Открыть найденную карточку", () ->
                $$(byText("ПЗЗ-00016-2021-ЭОО")).find(visible).click());

        step("Проверить, что карточка открылась", () ->
                $x("//div/h2[contains(text(),'ПЗЗ-00016-2021-ЭОО')]").shouldBe(visible));
    }
}
