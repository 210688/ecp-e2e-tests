package ru.mos.smart.tests.ugd.mtsk;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.mos.smart.tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Epic("Платформа ЕЦП")
@Feature("UGD (УГД)")
//@Suite("LRP")
@Story("Просмтор карточки в реестре МТСК")
@Tag("ugd") @Tag("mtsk")
class RegisterMtskCardsTests extends TestBase {

    @Test
    @DisplayName("Просмотр полной карточки реестра \"МТСК. Реестр организаций\"")
    void RegisterMtskCardsViewing() {
        openUrlWithAuthorization("", LOGIN_UGD, PASSWORD_UGD);

        step("Перейти к реестру МТСК. Реестр организаций", () -> {
            //открыть список реестров
            $(byLinkText("Информация")).click();
            $(byLinkText("Реестры")).click();
            //найти и открыть "МТСК. Реестр организаций"
            $(byName("candidateSearchValue")).setValue("МТСК. Реестр организаций").pressEnter();
            $(byLinkText("МТСК. Реестр организаций")).click();
        });

        step("Открыть полную карточку организации \"Бийскхимстройматериалы\"", () -> {
            //в поле поиска ввести «ООО БИЙСКХИМСТРОЙМАТЕРИАЛЫ»
            $(byClassName("form-control")).setValue("ООО БИЙСКХИМСТРОЙМАТЕРИАЛЫ").pressEnter();
            //карточка открывается через <a href="/ugd/#/app/organization/19290"></a>
            open("https://smart-predprod.mos.ru/ugd/#/app/organization/19290");
        });

        step("Проверка открытия карточки", () -> {
            $(byText("Общество с ограниченной ответственностью \"Бийскхимстройматериалы\"")).shouldBe(visible);
        });
    }
}