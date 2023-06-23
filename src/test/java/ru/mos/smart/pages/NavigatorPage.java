package ru.mos.smart.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.data.reestrUrl.RegisterObjectTypeMain.*;

/**
 * Описание навигатора.
 */

public class NavigatorPage {

    private final SelenideElement canvas = $(".mapboxgl-canvas");
    private final SelenideElement city = $("#city");
    private final SelenideElement task = $("#sidebar_header");
    private final SelenideElement myTask = $(".font-bold.hidden-xs");
    private final SelenideElement searchTask = $(byName("search"));

    @Step("Проверить наличие задач в списке")
    public void checkPageTask() {
        open(TASK_URL);
        myTask.shouldHave(text("Мои задачи"));
        searchTask.shouldBe(visible);
    }

    @Step("Переход в реестр {registerName}")
    public void goToRegister(String registerName) {
        open(REGISTER_URL);
        $(byName("candidateSearchValue")).setValue(registerName).pressEnter();
        $(byText(registerName)).click();
    }

/*    @Step("В Навигаторе открыть раздел {sectionName}")
    public void goToSection(String sectionName) {
        open(sectionName);
    }*/

    @Step("В Навигаторе открыть раздел {sectionName}")
    public void goToSection(String sectionName) {
        $$("cdp-sidebar div").get(8).click();
        $(byText(sectionName)).click();
    }




    @Step("Переход в задачи пользователя")
    public void goToTasks() {
        $$("cdp-sidebar div").get(4).click();
        $(byText("Задачи")).click();
    }



    @Step("В Навигаторе открыть раздел справочник")
    public void goToSpravochnik() {
        $$("cdp-sidebar div").get(49).click();
        $(byText("Справочники")).click();
    }

    @Step("Переход в Возможности")
    public void goToOpportunities() {
        $$("cdp-sidebar div").get(4).click();
        $(byText("Возможности")).click();
    }


    @Step("Переход в карту Цифровой двойник")
    public void goToMapsCD() {
        open(MAP_CD);
        city.should(visible, Duration.ofSeconds(40));
    }

    @Step("Проверить, что в реестрах  присутствует список задач")
    public void checkRegisterTask() {
        $(withText("Реестры")).should(visible);
    }

    @Step("Проверить, что в Возможностях присутствует список задач")
    public void checkOpportunitiesTask() {
        $(withText("Возможности")).should(visible);
    }

    @Step("Проверить, что в задачах пользователя присутствует список задач")
    public void checkUserTask() {
        $(withText("Проверить данные заявления")).should(visible);
    }







    public NavigatorPage gotoChessboard() {
        step("В навигаторе открыть раздел Информация -> Дашборды -> Оперативный мониторинг за ходом переселения", () -> {
            $(byText("Информация")).click();
            $(byText("Дашборды")).click();
            $(("a[href='/ssr/chessboard/']")).click();
            switchTo().window(1);
        });
        return this;
    }

    public NavigatorPage goToSprit() {
        step("В навигаторе открыть раздел Выдача СПРИТ", () ->
                $(("a[href='/oasirx/sprit/#/app/sprit/list']")).click());

        return this;
    }




    public NavigatorPage goToItmka() {
        step("Из боковой панели перейти в раздел Управление ИТ МКА", () ->
                $x("//span[text()='Управление ИТ МКА']").click());
        return this;
    }

    public NavigatorPage goToViolations() {
        step("Из боковой панели перейти в раздел Нарушения ОГД", () ->
                $x("//span[text()='Нарушения ОГД']").click());

        return this;
    }

    public NavigatorPage goToPkl() {
        step("Из боковой панели перейти в раздел ПКЛ", () ->
                $x("//span[text()='ПКЛ']").click());

        return this;
    }

    public NavigatorPage goToPmt() {
        step("Из боковой панели перейти в раздел ПМТ", () ->
                $x("//span[text()='ПМТ']").click());

        return this;
    }

    public NavigatorPage goToSzz() {
        step("Из боковой панели перейти в раздел СЗЗ", () ->
                $x("//span[text()='СЗЗ']").click());

        return this;
    }

    public void goToVri() {
        step("Из боковой панели перейти в раздел ВРИ", () ->
                $x("//span[text()='ВРИ']").click());

    }


}
