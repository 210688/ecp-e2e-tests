package ru.mos.smart.data.enums;

/**
 * Перечисление, представляющее заголовки в реестрах и карточках РинРиф.
 */
public enum HeaderTableRinRif {

    GENERAL_INFORMATION_HEADER("Общая информация"),
    DOCUMENTS_HEADER("Документы"),
    RESULT_HEADER("Результат"),
    EXTERNAL_SYSTEMS_HEADER("Внешние системы"),
    PROCESS_HEADER("Процессы"),
    GENERAL_DATA("Общие сведения"),
    INFORMATION_ZU_AND_OBJECTS("Сведения о ЗУ и объекте");

    private final String value;

    HeaderTableRinRif(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
