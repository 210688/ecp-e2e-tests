package ru.mos.smart.tests.mgz;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("MGZ (Мосгорзаказ)")
@Tag("mgz") @Tag("all_test")
class OpenProjectsCard extends TestBase {

    @Test
    @DisplayName("Открытие карточки проекта МГЗ")
    void openProjectsCard() {
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
    @DisplayName("Задача УДМС")
    void UDM() {
        openUrlWithAuthorization("", LOGIN_MGZ, PASSWORD_MGZ);
        step("Переход в задачу Сформировать ведомость объемов проектных работ, " +
                "календарный план и отправить на утверждение Директором ", () -> {
            open("/mgz/#/app/execution/mgzprojects/1671206" +
                    "/mgzprojectsGenerateVOPRAndCalendarPlan?systemCode=MGZ");
            $(byText("Сформировать ведомость объемов проектных работ, " +
                    "календарный план и отправить на утверждение Директором")).click();
        });
        step("календарный план", () -> {
            $(".nav-item:nth-child(2) span").click();
            $(".ng-input input", 0).val("Дата заключения гос. контракта").pressEnter();
            $(".ng-input input", 1).val("Дата окончания 1").pressEnter();
            $(".ng-input input", 2).val("Дата окончания 2").pressEnter();
            $(".ng-input input", 3).val("Дата окончания 3").pressEnter();
            $(".ng-input input", 4).val("Дата окончания 4").pressEnter();
            $(".ng-input input", 5).val("Дата окончания 5").pressEnter();
            $(byText("Сформировать ведомость объемов проектных работ, " +
                    "календарный план и отправить на утверждение Директ")).shouldBe(visible);
        });
    }
}