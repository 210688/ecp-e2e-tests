package ru.mos.smart.tests.mgz;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.pages.CalendarPlanPage;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.CalendarPlanPage.*;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;
import static ru.mos.smart.pages.VedomostProektnihRabot.*;

@Layer("web")
@Epic("MGZ (Мосгорзаказ)")
@Tag("mgz_refactor") @Tag("all_test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestProjectRelease extends TestBase {

    @Test
    @Order(1)
    @DisplayName("Запуск процесса Тест релиза 7.8")
    void mgzStartProcess() {
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
            sleep(5000);
            $(".ng-input input", 1).pressEnter();
        });

        step("В строке назначить задачи выбрать на текущего пользователя", () -> {
            $("input[type=radio]", 1).parent().click();
            sleep(5000);
            $(byText("Запустить процесс")).click();
        });
    }

    @Test
    @Order(2)
    @DisplayName("Выбрать функцию УДМС")
    void selectUDMSFunction() {
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
    @Order(3)
    @DisplayName("Сформировать ведомость объемов проектных работ," +
            "календарный план и отправить на утверждение Директором")
    void generateVOPRAndCalendarPlan() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);
        step("Переход в задачу Сформировать ведомость объемов проектных работ, " +
                "календарный план и отправить на утверждение Директором", () -> {
            $("#my-task-showcase").$(byText("Сформировать ведомость объемов проектных работ, " +
                    "календарный план и отправить на утверждение Директором")).click();
        });

        step("Перейти на вкладку календарный план", () -> {
            $(".nav-item:nth-child(2) span").click();
            $(".ng-input input", 0).val("Дата заключения гос. контракта").pressEnter();
            setTableCellValue(okazanieUslug, 0, "37");
            setTableCellValue(okazanieUslug, 1, "10");
            $(".ng-input input", 1).val("Дата окончания 1").pressEnter();
            setTableCellValue(poluchenieTechnicheskihUslovii, 0, "58");
            setTableCellValue(poluchenieTechnicheskihUslovii, 1, "20");
            $(".ng-input input", 2).val("Дата окончания 2").pressEnter();
            setTableCellValue(korrektirovkaPoZamechaniyam, 0, "25");
            setTableCellValue(korrektirovkaPoZamechaniyam, 1, "20");
            $(".ng-input input", 3).val("Дата окончания 3").pressEnter();
            setTableCellValue(OkazanieUslug, 0, "4");
            setTableCellValue(OkazanieUslug, 1, "30");
            $(".ng-input input", 4).val("Дата окончания 4").pressEnter();
            setTableCellValue(PeredachaGosZakazciku, 0, "37");
            setTableCellValue(PeredachaGosZakazciku, 1, "20");
        });

        step("Перейти на вкладку Ведомость объемов проектных работ", () -> {
            $(".nav-item:nth-child(3) span").click();
        });

        step("Открыть вкладку Добавить элемент", () -> {
            $(".pull-left.control-buttons").click(); // $(byText("Добавить элемент")).click()
            setParagrafCellValue(NomerParagrafa, "input", "1.");
            setInputTextBox(ImyaParagrafa, "input", "Имя параграфа");
            setInputTextBox(ZagolovokLevogoStolbca, "input", "Заголовок левого столбца");
            setInputTextBox(ZagolovokPravogoStolbca, "input", "Заголовок правого столбца");
            $(byText("Добавить")).click();
            ;
        });

        step("Открыть вкладку Добавить элемент", () -> {
            $(byText("Добавить элемент")).click();
            setParagrafCellValue(NomerParagrafa, "input", "1.1.");
            $(".form-group:nth-child(2) .form-control").click();
            $(".form-group:nth-child(2) .form-control").val("тест");
            $(byText("Комментарий к пункту: 1.")).parent().parent().$("textarea").setValue("Комментарий к пункту: 1.");
            $(byText("Добавить")).click();
            $(byText("Завершить задачу")).click();
        });
    }

    @Test
    @Order(4)
    @DisplayName("Проверить и согласовать ведомость" +
            " объемов проектных работ и календарный план")
    void generateVedomstAndKalendarPlan() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);
        step("Переход в задачу Проверить и согласовать ведомость объемов проектных работ и календарный план", () -> {
            $("#my-task-showcase").$(byText("Проверить и согласовать ведомость объемов" +
                    " проектных работ и календарный план")).click();
        });

        step("Перейти на вкладку календарный план", () -> {
            $(".nav-item:nth-child(2) span").click();
            $("tr:nth-child(1) .ng-valid").setValue("Не согласую");
            $(".active .btn-danger").click();
            $(".nav-item:nth-child(3) span").click();
            $(".glyphicon").click();
            $(".comment-modal .btn-success").click();
            $(".active .btn-danger").click();
            $(byText("Завершить задачу")).click();
        });
    }

    @Test
    @Order(5)
    @DisplayName("Сформировать ведомость объемов проектных работ календарный план" +
            " и отправить на утверждение Директором")
    void generateVOPRAndCalendarPlannn() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);
        step("Переход в задачу Сформировать ведомость объемов проектных работ, " +
                "календарный план и отправить на утверждение Директором", () -> {
            $("#my-task-showcase").$(byText("Сформировать ведомость объемов проектных работ, " +
                    "календарный план и отправить на утверждение Директором")).click();
        });

        step("Перейти на вкладку календарный план", () -> {
            $(".nav-item:nth-child(2) span").click();
            setTableCellValue(CalendarPlanPage.OkazanieUslug, 0, "60");
            $(byText("Завершить задачу")).click();
        });
    }

    @Test
    @Order(6)
    @DisplayName("Проверить и согласовать ведомость" +
            " объемов проектных работ и календарный план")
    void generateVedomstAndKalendarPlann() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);
        step("Переход в задачу Проверить и согласовать ведомость объемов проектных работ и календарный план", () -> {
            $("#my-task-showcase").$(byText("Проверить и согласовать ведомость объемов" +
                    " проектных работ и календарный план")).click();
        });

        step("Перейти на вкладку календарный план", () -> {
            $(".nav-item:nth-child(2) span").click();
            $(".active .btn-primary").click();
            $(".nav-item:nth-child(3) span").click();
            $(".active .btn-primary").click();
            $(byText("Завершить задачу")).click();
        });


    }


}