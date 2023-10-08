package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mos.smart.helpers.AllureAttachments;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DictsPage {

    SelenideElement search =  $(By.name("filterinput"));
    ElementsCollection dicts = $$(".table-responsive tr");
    ElementsCollection dict = $$(".table-responsive");

    @Step("Наличие справочников")
    public void checkDicts() {
        dicts.shouldHave(sizeGreaterThan(0));
        AllureAttachments.attachScreenshot("Список справочников");
    }

    @Step("Поиск справочника")
    public void searchDicts() {
        search.val("AdminGroupsList");
        dict.find(visible).shouldHave(text("Административные группы прав доступа"));
    }
}
