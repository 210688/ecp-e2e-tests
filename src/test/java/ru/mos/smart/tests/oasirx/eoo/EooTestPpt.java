package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.ActionsPage;
import ru.mos.smart.pages.ButtonKey;
import ru.mos.smart.pages.EooPagesButton;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.ActionsPage.actionName;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("EOO (Электронные общественные обсуждения)")
@Story("PPT_")
@Tag("oasirx") @Tag("eoo")
public class EooTestPpt extends TestBase {
    @Test
    @DisplayName("0. Добавление ЭОО")
    void addEoo() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        ActionsPage.searchAction(actionName);
        step("0. Добавить ЭОО", () -> {
            $("#description-ctr").setValue("Тестовый релиз"); // ввод надписи в Описание проекта
            $("#prefect-ctr input").setValue("вао").pressEnter(); //ввод округа
            $("#district-ctr input").val("веш").pressEnter();
            $("#source_type-ctr input").val("ППТ").pressEnter();
            $("#assign").click();
        });
    }

    @Test
    @Order(1)
    @DisplayName("1.Определить разработчика материалов")
    void opredRazrabMaterial() {
        LoginPage.openUrlWithAuthorization("/oasirx/eoo/#/app/execution/oasirxeoo/603947", loginEoo, passwordEoo);
        //TasksPages.searchTask(task1);
        //EooPagesButton.takeTask();
        ButtonKey.isVisible(By.xpath("//div/button[text()='Взять в работу']"));
        step("1.Определить разработчика материалов", () -> {
            //$x("//div[descendant::div[contains(text(), 'Определение разработчика материалов')]]//a[@title='Перейти к задаче']").click();
            $("#address-ctr").setValue("Степной поселок").pressEnter();
            $("#responsibleExecutor_code-ctr input").setValue("УППТ").pressEnter();
            $("#responsibleExecutor_login-ctr input").setValue("Электронные Общественные Обсуждения").pressEnter();
            $("#projectType-ctr input").setValue("Конкурсный").pressEnter();
            $("#developer_code-ctr input").setValue("Генплан ГАУ «Научно-исследовательский" +
                    " и проектный институт Генерального плана города Москвы»").pressEnter();
            EooPagesButton.saveButtonNextTask();
        });

    }
}