package ru.mos.smart.tests.mr;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mos.smart.annotations.Layer;
import ru.mos.smart.tests.TestBase;

@Layer("web")
@Epic("RAYON (Мой район)")
class ReestrTests extends TestBase {

    @Test
    @Issue("KRLB-1")
    @Disabled("")
    @DisplayName("Проверка просмотра реестра")
    @Description("Группы доступа, название которых начинается на MR_ " +
            "кроме MR_BPM_CHECK_MOS, MR_OBJECT_MOS, MR_OBJECT_PUBLIC_MOS")
    void reestrShoudBeFoundInSearch() {
        String reestr = "Объекты капитального строительства";
    }
}
