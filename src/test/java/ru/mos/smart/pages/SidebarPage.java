package ru.mos.smart.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Sidebar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.time.Duration.ofSeconds;

/**
 * Описание навигатора.
 */

public class SidebarPage {

    @Step("В раскрывшемся меню присутствует список {expectedTexts}")
    public void checkSubMenuList(Sidebar menuName, String[] expectedTexts) {
        ElementsCollection subMenuItems = $(byText(menuName.value()))
                .parent().parent()
                .sibling(0)
                .$$("div.name");
        subMenuItems.shouldHave(CollectionCondition.texts(expectedTexts));
    }

    @Step("В боковой панели нажать на {sidebarMenu}")
    public void clickSidebarMenu(Sidebar sidebarMenu) {
        $$("#sidebar_menu>div").find(text(sidebarMenu.value())).should(visible, ofSeconds(10)).click();
    }

    @Step("В раскрывшемся меню {menuName} нажать {subMenuName}")
    public void clickSubMenuList(Sidebar menuName, Sidebar subMenuName) {
        $(byText(menuName.value()))
                .parent().parent()
                .sibling(0)
                .$$("div.name")
                .find(text(subMenuName.value()))
                .shouldBe(visible, ofSeconds(10))
                .click();
    }

    @Step("Проверить наличие списка в меню 'Информация'")
    public void checkInformationMenuContainsRegistries() {
        $(byText("Реестры")).should(visible);
    }

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
