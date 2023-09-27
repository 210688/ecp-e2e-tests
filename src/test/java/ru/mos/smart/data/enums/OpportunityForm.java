package ru.mos.smart.data.enums;

public enum OpportunityForm {

    CREATE_CARD_AEROFOTO( "Создать карточку аэросъемки"),
    FEEDBACK_FORM( "Инициировать обращение в техническую поддержку"),
    OATI_TASK("Направить новое уведомление ОАТИ о проведении работ");


    private final String value;

    OpportunityForm(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

   @Override
    public String toString() {
        return value;
    }
}
