package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.tests.TestBase;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.EooPagesButton.*;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("EOO (Электронные общественные обсуждения)")
@Story("ППТ")
@Tag("oasirx") @Tag("eoo")
class EooTestsPpt extends TestBase {
    @Test
    @DisplayName("0.0. Открытие вкладки ЭОО из навигатора")
    void openEoo() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        step("Открытие в навигаторе ЭОО", () -> {
            $(byLinkText("ЭОО")).click();
            $(byText("Общеcтвенные обcуждения")).shouldBe(visible);
        });

        step("0. Добавить ЭОО", () -> {
            $(byLinkText("Добавить ЭОО")).click();
            $("#description-ctr").setValue("Тестовый релиз"); // ввод надписи в Описание проекта
            $("#prefect-ctr input").setValue("вао").pressEnter(); //ввод округа
            $("#district-ctr input").val("веш").pressEnter();
            $("#source_type-ctr input").val("ППТ").pressEnter();
            $("#assign").click();
            switchTask(0);
            takeTask();
        });

        step("1. Определение разработчика материалов", () -> {
            $("#address-ctr").setValue("Степной поселок").pressEnter();
            $("#responsibleExecutor_code-ctr input").setValue("УППТ").pressEnter();
            $("#responsibleExecutor_login-ctr input").setValue("Электронные Общественные Обсуждения").pressEnter();
            $("#projectType-ctr input").setValue("Конкурсный").pressEnter();
            $("#developer_code-ctr input").setValue("Генплан ГАУ «Научно-исследовательский" +
                    " и проектный институт Генерального плана города Москвы»").pressEnter();
            saveButtonNextTask();
            switchTask(1);
            takeTask();
        });

        step("2. Внесение информации о проведении", () -> {
            $(".ng-input input").setValue("Не более одного месяца").pressEnter();
            $("#notification_date-ctr input").setValue("22.09.2020");
            $("#calculateDate").click();
            saveButtonNextTask();
            switchTask(2);
            takeTask();
        });

        step("3. Подготовка материалов для ЭОО", () -> {
            $("input[type=file]", 0).uploadFile(new File("src/test/resources/images/423438.jpg"));
            $("input[type=file]", 3).uploadFile(new File("src/test/resources/images/13446.doc")); //Текст для размещения на АГ
            $("input[type=file]", 4).uploadFile(new File("src/test/resources/images/456459.jpg")); //Границы проведения ЭОО
            $("input[type=file]", 5).uploadFile(new File("src/test/resources/images/56457.pdf")); //Утверждаемая часть
            saveButtonNextTask();
            switchTask(3);
            takeTask();
        });

        step("4. Проверка материалов для ЭОО", () -> {
            $("#docAgreeContent_confirmRounds_sectorChiefCheckConfirm-ctr-wrapper .ui-chkbox-icon").click();
            $("#docAgreeContent_confirmRounds_zamChiefCheckConfirm-ctr-wrapper .ui-chkbox-icon").click();
            saveButtonNextTask();
            switchTask(4);
            takeTask();
        });

        step("5. Подготовка решения руководителем УОС", () -> {
            $("#detailView-ctr .right").click();
            $("#executeBy-ctr .ui-radiobutton-label").click();
            $("#approved-ctr .right").click();
            $("#save").click();
            switchTask(5);
            takeTask();


        });
    }


   @Test
   @DisplayName("1. Подготовка решения руководителем УОС")
  void openEolo() {
       LoginPage.openUrlWithAuthorization("/oasirx/eoo/#/app/eoo/6b9b0ea8-9ad5-49ae-96a9-4c60c10dfc94", loginEoo, passwordEoo);
        step("Подготовка решения руководителем УОС", () -> {
            switchTask(4);
            $("#detailView-ctr .right").click();
            $("#executeBy-ctr .ui-radiobutton-label").click();
            $("#approved-ctr .right").click();
       });
   }
}
