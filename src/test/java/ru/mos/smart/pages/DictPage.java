package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.mos.smart.helpers.AllureAttachments.attachScreenshot;

public class DictPage {

    private String dictName;

    private final SelenideElement
            search = $(By.name("filterinput")),
            exportDictionary = $(".fa-upload");

    private final ElementsCollection
            dicts = $$(".table-responsive tr"),
            dict = $$(".table-responsive"),
            listSystemDict = $$(".table-hover > tbody > tr");

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("Проверить наличие системных справочников")
    public void verifySystemDictionariesExistence() {
        dicts.shouldHave(sizeGreaterThan(1));
        attachScreenshot("Список системных справочников");
    }

    @Step("Проверить наличие данных в справочнике")
    public void checkListActions() {
        dicts.shouldHave(sizeGreaterThan(1));
        attachScreenshot("Скриншот справочника");
    }

    public void exportDictionary() throws FileNotFoundException {
        step("Экспорт справочника в формате JSON", () -> {
            File downloadedFile = exportDictionary.download();
            step("Проверить экспорт файла в формате JSON");
            assertThat(downloadedFile.getName()).matches(".*_complete\\.json");
        });
    }



    @Step("Поиск справочника")
    public void searchDicts() {
        search.val("AdminGroupsList");
        dict.find(visible).shouldHave(text("Административные группы прав доступа"));
    }

    @Step("Перейти в системный справочник {dictName}")
    public void goToSystemDict() {
        listSystemDict.shouldHave(sizeGreaterThan(1)
                .because("Ожидалось, что справочник содержит хотя-бы один системный справочник"));

        int randomIndex = new Random().nextInt(9) + 1;
        SelenideElement randomCard = listSystemDict.get(randomIndex).$$("td").get(1).$("a");
        String dictName = randomCard.text();
        String linkName = randomCard.getAttribute("href");
        randomCard.click();
        assert linkName != null;
        addAttachment("Ссылка на системный справочник " + dictName, linkName);
    }
}
