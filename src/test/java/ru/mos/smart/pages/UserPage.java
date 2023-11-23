package ru.mos.smart.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.addAttachment;
import static ru.mos.smart.helpers.AllureAttachments.attachScreenshot;

public class UserPage {

    private final SelenideElement
            searchUser = $(byName("candidateSearchValue")),
            userLogin = $(".description");

    private final ElementsCollection
            userListTable = $$(".table-hover > tbody > tr");

    @Step("Поиск пользователя")
    public void searchUser() {
        searchUser.val("user").pressEnter();
    }

    @Step("Проверить список пользователей")
    public void userList() {
        userListTable.shouldHave(sizeGreaterThan(1));
        attachScreenshot("Список пользователей");
    }

    @Step("Открыть карточку пользователя")
    public void goToUserCard() {
        userListTable.shouldHave(sizeGreaterThan(1)
                .because("Ожидалось, что список пользователей содержит хотя-бы одного пользователя"));

        int randomIndex = new Random().nextInt(9) + 1;
        SelenideElement randomCard = userListTable.get(randomIndex).$$("td").get(1).$("a");
        String userName = randomCard.text();
        String linkName = randomCard.getAttribute("href");
        randomCard.click();
        assert linkName != null;
        addAttachment("Ссылка на карточку пользователя " + userName, linkName);
    }

    @Step("Проверить открытие карточки пользователя")
    public void checkCardUser() {
        userLogin.shouldHave(text("Логин")).should(visible);
        attachScreenshot("Карточка пользователя");
    }
}
