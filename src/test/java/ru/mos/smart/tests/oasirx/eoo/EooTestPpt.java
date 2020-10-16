package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.EooComponents;
import ru.mos.smart.pages.LoginPage;
import ru.mos.smart.pages.MainPage;
import ru.mos.smart.pages.TasksPages;
import ru.mos.smart.tests.TestBase;

import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.TasksPages.*;


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
        MainPage.dobavitEoo();
        step("0. Добавить ЭОО", () -> {
            $(byLinkText("Добавить ЭОО")).click();
            //$x("//div//a[@href='/#/app/eoo/create/eoo']").click();
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
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        TasksPages.searchTask(task1);
        EooComponents.buttonTakeTask();
        step("1.Определить разработчика материалов", () -> {
            $("#responsibleExecutor_code-ctr input").setValue("УППТ").pressEnter();
            $("#responsibleExecutor_login-ctr input").setValue("Электронные Общественные Обсуждения").pressEnter();
            $("#projectType-ctr input").setValue("Конкурсный").pressEnter();
            $("#developer_code-ctr input").setValue("Генплан ГАУ «Научно-исследовательский" +
                    " и проектный институт Генерального плана города Москвы»").pressEnter();
            EooComponents.saveButtonNextTask();
        });
    }

    @Test
    @Order(2)
    @DisplayName("2.Внести информацию о проведении")
    void infoOProvedenii() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        TasksPages.searchTask(task2);
        $(by("uisref", ".app.eoo.eoo")).click();
        EooComponents.buttonTakeTask();
        step("2.Внести информацию о проведении", () -> {
            $(".ng-input input").setValue("Не более одного месяца").pressEnter();
            $("#notification_date-ctr input").setValue("15.10.2020");
            $("#calculateDate").click();
            EooComponents.saveButtonNextTask();
        });
    }

    @Test
    @Order(3)
    @DisplayName("3.Подготовить материалы для ЭОО")
    void materialInEoo() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        TasksPages.searchTask(task3);
        EooComponents.buttonTakeTask();
        step("3. Подготовка материалов для ЭОО", () -> {
            sleep(5000);
            $("input[type=file]", 0).uploadFile(new File("src/test/resources/images/423438.jpg"));
            sleep(5000);
            $("input[type=file]", 3).uploadFile(new File("src/test/resources/images/13446.doc")); //Текст для размещения на АГ
            sleep(5000);
            $("input[type=file]", 4).uploadFile(new File("src/test/resources/images/456459.jpg")); //Границы проведения ЭОО
            sleep(5000);
            $("input[type=file]", 5).uploadFile(new File("src/test/resources/images/56457.pdf")); //Утверждаемая часть
            sleep(5000);
            EooComponents.saveButtonNextTask();
        });
    }

    @Test
    @Order(4)
    @DisplayName("4.Проверить материалы для ЭОО")
    void proverkaMaterialaEoo() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        TasksPages.searchTask(task4);
        //EooPagesButton.buttonTakeTask();
        step("4. Проверка материалов для ЭОО", () -> {
            $("#docAgreeContent_confirmRounds_sectorChiefCheckConfirm-ctr-wrapper .ui-chkbox-icon").click();
            $("#docAgreeContent_confirmRounds_zamChiefCheckConfirm-ctr-wrapper .ui-chkbox-icon").click();
            EooComponents.saveButtonNextTask();
        });
    }

    @Test
    @Order(5)
    @DisplayName("5.Подготовить решение по материалам (руководитель)") //зайти и самим проставить руководителя
    void podgotovkaResheniya1() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        TasksPages.searchTask(task5);
        //EooPagesButton.buttonTakeTask();
        step("5.Подготовить решение по материалам (руководитель)", () -> {
            $("#detailView-ctr .right").click();
            $("#executeBy-ctr .ui-radiobutton-label").click();
            $("#approved-ctr .right").click();
            $("#save").click();
            EooComponents.saveButtonNextTask();
        });
    }

    @Test
    @Order(6)
    @DisplayName("5.Подготовить решение по материалам (руководитель)") //зайти и самим проставить руководителя
    void podgotovkaReshenya2() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        TasksPages.searchTask(task5);
        //EooPagesButton.buttonTakeTask();
        step("5.Подготовить решение по материалам (руководитель)", () -> {
            $("#detailView-ctr .right").click();
            $("#executeBy-ctr .ui-radiobutton-label").click();
            $("#approved-ctr .right").click();
            $("#save").click();
            EooComponents.saveButtonNextTask();
        });
    }

    @Test
    @Order(7)
    @DisplayName("7. Согласовать материалы для ЭОО (начальник управления)") //зайти и самим проставить руководителя
    void soglasovMaterialEooNach() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        TasksPages.searchTask(task6);
        //EooPagesButton.buttonTakeTask();
        step("7. Согласовать материалы для ЭОО (начальник управления)", () -> {
            $("#approved").click();
        });
    }

    @Test
    @Order(8)
    @DisplayName("8. Согласовать материалы (зам. пред.)") //зайти и самим проставить руководителя
    void soglasovMaterialZamPred() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        TasksPages.searchTask(task7);
        //EooPagesButton.buttonTakeTask();
        step("8.Согласовать материалы (зам. пред.)", () -> {
            $("#approved").click();
        });
    }

    @Test
    @Order(9)
    @DisplayName("9. Согласовать материалы (зам. пред. ЭОО)") //зайти и самим проставить руководителя
    void soglasovMaterialZamPredEoo() {
        LoginPage.openUrlWithAuthorization("", loginEoo, passwordEoo);
        TasksPages.searchTask(task8);
        //EooPagesButton.buttonTakeTask();
        step("9.Согласовать материалы (зам. пред. ЭОО)", () -> {
            $("#approved").click();
        });
    }

    @Test
    @Order(9)
    @DisplayName("9. Согласовать материалы (зам. пред. ЭОО)") //зайти и самим проставить руководителя
    void soglasov() {
        LoginPage.openUrlWithAuthorization("/oasirx/eoo/#/app/eoo/ac8d0ea8-9271-411c-bc3e-3d6af06e176b", loginEoo, passwordEoo);
        $(byText("Определение разработчика материалов")).parent().parent().$(("fa fa-edit")).click();
        $((".fa-edit")).setValue("Электронные").click();
        //EooPagesButton.buttonTakeTask();
        $(byText("Определение разработчика материалов")).parent().parent().$((".fa-edit")).click();
        step("9.Согласовать материалы (зам. пред. ЭОО)", () -> {
            $("#approved").click();


        });
    }
}



