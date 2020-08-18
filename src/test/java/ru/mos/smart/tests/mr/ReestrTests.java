package ru.mos.smart.tests.mr;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.mos.smart.tests.TestBase;


@Epic("Платформа ЕЦП")
@Feature("Модуль \"Мой район\"")
@Story("Проверка работы функционала \"Информация-Реестры\"")
@Tag("MR")
@Tag("ECP")
class ReestrTests extends TestBase {
    @Test
    @Issue("KRLB-1")
    @DisplayName("Проверка просмотра реестра")
    @Description("Группы доступа, название которых начинается на MR_ " +
            "кроме MR_BPM_CHECK_MOS, MR_OBJECT_MOS, MR_OBJECT_PUBLIC_MOS")
    void reestrShoudBeFoundInSearch() {
        String reestr = "Объекты капитального строительства";

//        openUrlWithAuthorization("/main/#/app/catalog-registers",
//                "Открытие страницы \"Информация-Реестры\"");
//
//        catalogRegistersPage.searchReestr(reestr);
//
//        catalogRegistersPage.verifyReestrIsFound(reestr);
    }

}
