package ru.mos.smart.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.data.Sidebar;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

/**
 * Описание навигатора.
 */

public class SidebarPage {

    private final SelenideElement canvas = $(".mapboxgl-canvas");
    private final SelenideElement city = $("#city");
    private final SelenideElement task = $("#sidebar_header");
    private final SelenideElement myTask = $(".font-bold.hidden-xs");
    private final SelenideElement searchTask = $(byName("search"));

    @Step("Проверить, что в раскрывшемся меню присутствует список {expectedTexts}")
    public void checkSubMenuList(Sidebar menuName, String[] expectedTexts) {
        ElementsCollection subMenuItems = $(byText(menuName.value()))
                .parent().parent()
                .sibling(0)
                .$$("div.name");
        subMenuItems.shouldHave(CollectionCondition.texts(expectedTexts));
    }

    @Step("Нажать на меню {sidebarMenu}")
    public void clickSidebarMenu(Sidebar sidebarMenu) {
        $$("#sidebar_menu>div").find(text(sidebarMenu.value())).click();
    }

    @Step("В раскрывшемся меню {menuName} нажать {subMenuName}")
    public void clickSubMenuList(Sidebar menuName, Sidebar subMenuName) {
        $(byText(menuName.value()))
                .parent().parent()
                .sibling(0)
                .$$("div.name")
                .find(text(subMenuName.value()))
                .click();
    }

    @Step("В боковой панели присутствует список элементов")
    public void checkFillingSidebarMenu() {
        $$("#sidebar_menu").shouldBe();
    }














    @Step("Проверить наличие задач в списке")
    public void checkPageTask() {
        myTask.shouldHave(text("Мои задачи"));
        searchTask.shouldBe(visible);
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







    public SidebarPage gotoChessboard() {
        step("В навигаторе открыть раздел Информация -> Дашборды -> Оперативный мониторинг за ходом переселения", () -> {
            $(byText("Информация")).click();
            $(byText("Дашборды")).click();
            $(("a[href='/ssr/chessboard/']")).click();
            switchTo().window(1);
        });
        return this;
    }

    public SidebarPage goToSprit() {
        step("В навигаторе открыть раздел Выдача СПРИТ", () ->
                $(("a[href='/oasirx/sprit/#/app/sprit/list']")).click());

        return this;
    }




    public SidebarPage goToItmka() {
        step("Из боковой панели перейти в раздел Управление ИТ МКА", () ->
                $x("//span[text()='Управление ИТ МКА']").click());
        return this;
    }

    public SidebarPage goToViolations() {
        step("Из боковой панели перейти в раздел Нарушения ОГД", () ->
                $x("//span[text()='Нарушения ОГД']").click());

        return this;
    }

    public SidebarPage goToPkl() {
        step("Из боковой панели перейти в раздел ПКЛ", () ->
                $x("//span[text()='ПКЛ']").click());

        return this;
    }

    public SidebarPage goToPmt() {
        step("Из боковой панели перейти в раздел ПМТ", () ->
                $x("//span[text()='ПМТ']").click());

        return this;
    }

    public SidebarPage goToSzz() {
        step("Из боковой панели перейти в раздел СЗЗ", () ->
                $x("//span[text()='СЗЗ']").click());

        return this;
    }

    public void goToVri() {
        step("Из боковой панели перейти в раздел ВРИ", () ->
                $x("//span[text()='ВРИ']").click());

    }


}
