package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import ru.mos.smart.helpers.AllureAttachments;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class DictsPage {

    ElementsCollection dicts = $$(".table-responsive tr");

    @Step("Проверка, что присутствуют справочники")
    public void checkDicts() {
        dicts.shouldHave(sizeGreaterThan(0));
        AllureAttachments.attachScreenshot("Список справочников");
    }

}
