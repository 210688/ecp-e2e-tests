package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;
import ru.mos.smart.helpers.AllureAttachments;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DronePage {

    private final SelenideElement editCard = $x("//button[contains(text(),'Редактировать')]");
    private final SelenideElement deleteCard = $x("//button[contains(text(),'Удалить')]");
    private final SelenideElement repeatApplication = $x("//button[contains(text(),'Повторить заявку')]");
    private final ElementsCollection blockFromCard = $$(".card__info-column > details");
    private final ElementsCollection formCard = $$(".card__info-column > details");

    private void switchToWindow() {
        switchTo().window(1);
    }

    @Step("В карточке содержатся кнопки: Редактировать, Сформировать, Повторить заявку")
    public void checkButtonCard() {
        editCard.should(visible);
        deleteCard.should(visible);
        repeatApplication.should(visible);
    }

    @Step("В карточке {registerName} присутствуют заголовки {list}")
    public void checkingCardHeaders(Registers registerName, List<String> list) {
        verifyTableHeaders(list);
        attachScreenshot(registerName);
        verifyTableFieldData();
    }

    private void verifyTableHeaders(List<String> list) {
        String table = String.join(", ", list);
        blockFromCard.shouldHave(textsInAnyOrder(list));
    }

    private void attachScreenshot(Registers registerName) {
        AllureAttachments.attachScreenshot("Скриншот карточки" + " " + registerName.value());
    }

    private void verifyTableFieldData() {
        formCard.shouldHave(size(4));
    }
}
