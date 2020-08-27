package ru.mos.smart.tests.mgz;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("MGZ (Мосгорзаказ)")
@Tag("mgz_refactor") @Tag("all_test")
class TestProjectRelease extends TestBase {

    @Test
    @DisplayName("Запуск процесса Тест релиза 7.8")
    void MgzStartProcess() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);

        step("В боковом меню открыть вкладку \"Проекты\"", () -> {
            open("/mgz/#/app/start/process/");
        });

        step("В строке поиска ввести название проекта", () -> {
            $(".ng-input input").setValue("2.4.1 Формирование комплекта документов " +
                    "для расчета НМЦК на ПИР")
                    .pressEnter();
        });

        step("В строке поиска ввести название проекта", () -> {
            $(".ng-input input", 1).setValue("Тест релиза 7.8");
            sleep(1000);
            $(".ng-input input", 1).pressEnter();
        });

        step("В строке назначить задачи выбрать на текущего пользователя", () -> {
            $("input[type=radio]", 1).parent().click();
            sleep(1000);
            $(byText("Запустить процесс")).click();
        });
    }

    @Test
    @DisplayName("Выбрать функцию УДМС")
    void UDMS() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);
        step("Переход в задачу Выбрать функцию УДМС", () -> {
            $("#my-task-showcase").$(byText("Выбрать функцию УДМС")).click();
        });

        step("УДМС выступает в функции технического заказчика? Выбрать Да", () -> {
            $("input[type=radio]").parent().click();
        });

        step("Нажать кнопку Завершить задачу", () -> {
            $("button[type=submit]").click();
        });
    }

    @Test
    @DisplayName("Сформировать ведомость объемов проектных работ," +
            "календарный план и отправить на утверждение Директором")
    void GenerateVOPRAndCalendarPlan() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);
        step("Переход в задачу Сформировать ведомость объемов проектных работ, " +
                "календарный план и отправить на утверждение Директором", () -> {
            $("#my-task-showcase").$(byText("Сформировать ведомость объемов проектных работ, " +
                    "календарный план и отправить на утверждение Директором")).click();
        });

        step("Перейти на вкладку календарный план", () -> {
            $(".nav-item:nth-child(2) span").click();
            $(".ng-input input", 0).val("Дата заключения гос. контракта").pressEnter();
            $(byText("" +
                    "Оказание услуг и работы по сбору исходных данных " +
                    "в необходимом и достаточном объеме для проектирования. " +
                    "Проведение инженерных изысканий."))
                    .parent().$("input[type=number]", 0).setValue("37");
            $(byText("Оказание услуг и работы по сбору исходных данных " +
                    "в необходимом и достаточном объеме для проектирования. " +
                    "Проведение инженерных изысканий."))
                    .parent().$("input[type=number]", 1).setValue("10");
            $(".ng-input input", 1).val("Дата окончания 1").pressEnter();
            $(byText("Получение технических условий для проектирования" +
                    " объекта, составление задания на проектирование, " +
                    "оказание услуг и работ технического заказчика на период " +
                    "проектирования объекта (проектная документация)." +
                    " Оказание услуг по направлению проектной документации" +
                    " на гос. экспертизу."))
                    .parent().$("input[type=number]", 0).setValue("58");
            $(byText("Получение технических условий для проектирования" +
                    " объекта, составление задания на проектирование, " +
                    "оказание услуг и работ технического заказчика на период " +
                    "проектирования объекта (проектная документация)." +
                    " Оказание услуг по направлению проектной документации" +
                    " на гос. экспертизу."))
                    .parent().$("input[type=number]", 1).setValue("20");
            $(".ng-input input", 2).val("Дата окончания 2").pressEnter();
            $(byText("Корректировка по замечаниям гос. экспертизы. Получение" +
                    " положительного заключения государственной экспертизы," +
                    " передача его для выпуска Решения об утверждении" +
                    " проектной документации, включая сводный сметный" +
                    " расчет.")).parent().$("input[type=number]", 0).setValue("25");
            $(byText("Корректировка по замечаниям гос. экспертизы. Получение" +
                    " положительного заключения государственной экспертизы," +
                    " передача его для выпуска Решения об утверждении" +
                    " проектной документации, включая сводный сметный" +
                    " расчет.")).parent().$("input[type=number]", 1).setValue("20");
            $(".ng-input input", 3).val("Дата окончания 3").pressEnter();
            $(byText("Оказание услуг и работы технического заказчика на" +
                    " период проектирования объекта в объеме, необходимом" +
                    " и достаточном для обеспечения строительства (рабочая" +
                    " документация).")).parent().$("input[type=number]", 0).setValue("4");
            $(byText("Оказание услуг и работы технического заказчика на" +
                    " период проектирования объекта в объеме, необходимом" +
                    " и достаточном для обеспечения строительства (рабочая" +
                    " документация).")).parent().$("input[type=number]", 1).setValue("30");
           $(".ng-input input", 4).val("Дата окончания 4").pressEnter();
           $(byText("Передача гос. заказчику утвержденной проектной" +
                   " документации и других документов, по Акту приема-" +
                   "передачи.")).parent().$("input[type=number]", 0).setValue("37");
            $(byText("Передача гос. заказчику утвержденной проектной" +
                    " документации и других документов, по Акту приема-" +
                    "передачи.")).parent().$("input[type=number]", 1).setValue("20");
        });

        step("Перейти на вкладку Ведомость объемов проектных работ", () -> {
            $(".nav-item:nth-child(3) span").click();
        });

        step("Открыть вкладку Добавить элемент", () -> {
            $(".pull-left.control-buttons").click();
            $(".form-group:nth-child(1) .ng-dirty").val("1.");
            $(".form-group:nth-child(2) .form-control").setValue("Имя параграфа");
            $(".form-group:nth-child(3) .form-control").setValue("Заголовок левого столбца");
            $(".form-group:nth-child(4) .form-control").setValue("Заголовок правого столбца");
            $("button[type=submit]").click();
            $(byText("Сформировать ведомость")).shouldBe(Condition.visible);
        });

    }
}

