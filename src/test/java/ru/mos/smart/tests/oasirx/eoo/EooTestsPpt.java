package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.EooPagesButton.*;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("EOO (Электронные общественные обсуждения)")
@Story("ППТ")
@Tag("oasirx") @Tag("eoo")
class EooTestsPpt extends TestBase {

    @Test
    @DisplayName("1. Открытие вкладки ЭОО из навигатора")
    void openEoo() {
        openUrlWithAuthorization("", LOGIN_EOO, PASSWORD_EOO);
        step("Открытие в навигаторе ЭОО", () -> {
            $(byLinkText("ЭОО")).click();
            $(byText("Общеcтвенные обcуждения")).shouldBe(visible);
        });
        step("1. Добавить ЭОО", () -> {
            $(byLinkText("Добавить ЭОО")).click();
            $("#description-ctr").setValue("Тестовый релиз"); // ввод надписи в Описание проекта
            $("#prefect-ctr input").setValue("вао").pressEnter(); //ввод округа
            $("#district-ctr input").val("веш").pressEnter();
            $("#source_type-ctr input").val("ППТ").pressEnter();
            $("#assign").click();
            switchTask();
            takeTask();
        });
        step("2. Определить разработчика материалов ", () -> {
            $("#address-ctr").setValue("Степной поселок").click();
            $("#responsibleExecutor_code-ctr input").setValue("УППТ").click();
            $("#responsibleExecutor_login-ctr input").setValue("Электронные Общественные Обсуждения").click();
            $("#projectType-ctr input").setValue("Конкурсный").click();
            $("#developer_code-ctr input").setValue("Генплан ГАУ «Научно-исследовательский" +
                    " и проектный институт Генерального плана города Москвы»").click();
            switchTask();
            takeTask();
        });
        step("3. Внесение информации о проведении", () -> {
            $(".ng-input input").setValue("Не более одного месяца").pressEnter();
            $("#notification_date-ctr input").setValue("21.09.2020");
            $("#calculateDate").click();
            $("#next").click();
            switchTask();
            takeTask();
        });
    }

    @Test
    @DisplayName("Откр")
    void openEoooooo() {
        openUrlWithAuthorization("/oasirx/eoo/#/app/execution/oasirxeoo/555144", LOGIN_EOO, PASSWORD_EOO);
        $("input[type=file]").uploadFile(new File("src/test/resources/images/1.jpg"));
        $(byText("Подготовить материалы д")).shouldBe(visible);

    }
}