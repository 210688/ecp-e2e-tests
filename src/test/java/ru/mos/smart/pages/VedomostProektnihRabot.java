package ru.mos.smart.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VedomostProektnihRabot {

    public static String
            NomerParagrafa = "Номер параграфа",
            ImyaParagrafa = "Имя параграфа",
            ZagolovokLevogoStolbca = "Заголовок левого столбца",
            ZagolovokPravogoStolbca = "Заголовок правого столбца";

    public static void setParagrafCellValue(String titleText, String input, String val) {
        $(byText(titleText))
                .parent().parent().$("input").val(val);
    }

    public static void setInputTextBox(String titleText, String input, String value) {
        $(byText(titleText))
                .parent().parent().$("input").setValue(value);
    }
}
