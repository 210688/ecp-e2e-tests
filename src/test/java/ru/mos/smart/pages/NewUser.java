package ru.mos.smart.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NewUser {

    public void createNewUser() {
        $(byName("acc")).val("testusser");
        $(byName("fio")).val("Иванов Иван Иваныч");
        $(byName("snls")).val("27716959228");
        $(byName("arvo")).val("Тестировщик");
        $(byName("eml")).val("temp@mail.ru");
        $(byName("phn")).val("81262541212");
        $(byName("search")).val("KRLB").pressEnter();
        $(byText("Кронверк Лаб")).click();
        $(".has-spinner").click();
        $(byText("Иванов Иван Иваныч")).should(visible);


    }
}
