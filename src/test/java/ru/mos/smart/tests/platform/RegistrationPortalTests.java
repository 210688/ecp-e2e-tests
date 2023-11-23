package ru.mos.smart.tests.platform;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;

import static ru.mos.smart.data.enums.Sidebar.SETTINGS;
import static ru.mos.smart.data.enums.Sidebar.USER;

@Epic("Регрессионные тесты платформы (функционал)")
@Feature("Регистрация на портале")
@Tag("regressing")
public class RegistrationPortalTests extends TestBase {

    @Test
    @AllureId("17960")
    @Owner("Soldatov")
    @DisplayName("Ручное создание пользователя")
    @Description("Проверить регистрацию нового пользователя")
    void goToSystemDict() {
        sidebarPage.clickSidebarMenu(SETTINGS);
        sidebarPage.clickSubMenuList(SETTINGS, USER);
        generalPage.createUser();
        newUser.createNewUser(); //TODO не понятны права для регистрации получаю 403 ошибку
    }
}
