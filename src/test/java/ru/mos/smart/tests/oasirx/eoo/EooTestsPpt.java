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
            $("#address-ctr").setValue("Степной поселок").pressEnter();
            $("#responsibleExecutor_code-ctr input").setValue("УППТ").pressEnter();
            $("#responsibleExecutor_login-ctr input").setValue("Электронные Общественные Обсуждения").pressEnter();
            $("#projectType-ctr input").setValue("Конкурсный").pressEnter();
            $("#developer_code-ctr input").setValue("Генплан ГАУ «Научно-исследовательский" +
                    " и проектный институт Генерального плана города Москвы»").pressEnter();
            saveButtonNextTask();
            $(".level-0:nth-child(4) .pull-right > .fa").click();
            takeTask();
        });
        step("3. Внесение информации о проведении", () -> {
            $(".ng-input input").setValue("Не более одного месяца").pressEnter();
            $("#notification_date-ctr input").setValue("21.09.2020");
            $("#calculateDate").click();
            saveButtonNextTask();
            switchTask();
            takeTask();
        });
        step("4. Подготовить материалы для ЭОО");
        $("input[type=file]", 0).uploadFile(new File("src/test/resources/images/423438.jpg"));
        $("input[type=file]", 3).uploadFile(new File("src/test/resources/images/13446.doc")); //Текст для размещения на АГ
        $("input[type=file]", 4).uploadFile(new File("src/test/resources/images/456459.jpg")); //Границы проведения ЭОО
        $("input[type=file]", 5).uploadFile(new File("src/test/resources/images/56457.pdf")); //Утверждаемая часть
        saveButtonNextTask();
        switchTask();
        takeTask();

    }


    @Test
    @DisplayName("Откр")
    void openEoooooo() {
        openUrlWithAuthorization("/oasirx/eoo/#/app/eoo/aa0dd05a-1378-4b70-ad04-3c2dfa5bd5e9", LOGIN_EOO, PASSWORD_EOO);
        $(".fa-lg", 1).click();
        $(".ng-input input").setValue("Не более одного месяца").pressEnter();
        $("#notification_date-ctr input").setValue("21.09.2020");
        $("#calculateDate").click();
    }

}