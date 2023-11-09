package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.mos.smart.data.enums.Registers;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class MydistrictPage {

    //   ElementsCollection blocks = $$("div.ag-center-cols-container");


    private final ElementsCollection
            headersInCard = $$(".ag-header.ag-focus-managed.ag-pivot-off");


    @Step("Доступность заголовков {list} и наличие данных в карточке {registerName}")
    public void checkAvailabilityHeadersInCard(List<String> list) {
        //   switchToWindow();
        headersInCard(list);
        //     generalInformationInCard();
        //   attachScreenshot(registerName);
    }

    private void headersInCard(List<String> expectedHeaders) {
        String headers = String.join(", ", expectedHeaders);
        headersInCard.shouldHave(texts(expectedHeaders));
    }

    @Step("Проверка наименования:Объекты по программе Мой район")
    public void nameObjectsUnderMyDistrictProgram() {
        step("Проверка наименования:Объекты по программе Мой район", () -> {
            $(".bs-text-ex__h3.ng-star-inserted").shouldBe();
        });
    }

    @Step("Проверка, что активная кнопка Экспорт в Excel")
    public void exportToExcelButton() {
        step("Проверка, что активная кнопка Экспорт в Excel", () -> {
            $(".d-flex.flex-row.justify-content-end").shouldBe();
        });
    }

}
