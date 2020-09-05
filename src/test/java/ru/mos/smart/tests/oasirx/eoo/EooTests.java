package ru.mos.smart.tests.oasirx.eoo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.pages.LoginPage.openUrlWithAuthorization;

@Layer("web")
@Epic("OASIRX (ОАСИ Рефактор-Икс)")
@Feature("EOO (Электронные общественные обсуждения)")
@Tag("oasirx") @Tag("eoo")
class EooTests extends TestBase {

    @Test
    @DisplayName("Проверка открытия формы подачи \"Подать заявку на участие в конкурсе ЛРП\"")
    void openTheApplicationFormLrp() {
        openUrlWithAuthorization("", LOGIN_EOO, PASSWORD_EOO);

    }

}
