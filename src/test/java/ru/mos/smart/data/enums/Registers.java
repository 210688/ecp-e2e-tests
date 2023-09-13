package ru.mos.smart.data.enums;

public enum Registers {

    AKTS_PROVEROK("Акты проверок"),
    CHANGE_CONSTRUCTION_BUILDING("Внесение изменений в разрешения на строительство"),
    PERMISSIONS_OBJECT_OPERATION("Разрешения на ввод объекта в эксплуатацию"),
    BUILDING_PERMIT("Разрешения на строительство"),
    ALL_OBJECTS("Все объекты"),
    ALL_OBJECTS_SNOS("Все объекты сноса"),
    All_ORGANIZATION("Все организации"),
    NARUSHENIYA("Нарушения"),
    POSTANOVLENIYA("Постановления"),
    All_INSPECTION_DECISIONS("Все решения о проверке"),
    PROTOKOLS("Протоколы"),
    DEMOLITIONS("Уведомления о завершении сноса"),
    PLANNED_DEMOLITION_NOTICES("Уведомления о планируемом сносе"),
    MODIFICATION_OBJECT_OPERATION("Внесение изменений в разрешения ввод объекта в эксплуатацию"),
    RINRIF_MATCAP("Заявления о выдаче акта по материнскому капиталу"),
    TZ_LABORATORIES("ТЗ лаборатории"),
    AEROFOTO("Данные аэрофотосъемки"),
    PKR("Запросы на оформление Паспортов колористических решений (ПКР)"),
    AGR("Запросы на оформление свидетельств об утверждении архитектурно-градостроительных решений (АГР)"),
    OASI_BLAGO_PRO("Проекты благоустройства (согласование проектов)"),
    EVENTMANAGER("Подписки на уведомления о событиях"),
    OASI_FACADES_PFD("Проекты изменений фасадов зданий (жилые)"),
    MKAOPUGD_ORDER("Реестр поручений УГД"),
    MKAPMII_ORDER("Реестр оказания услуги по размещению инженерных изысканий"),
    MKASDPRV_ORDER("Реестр оказания услуги Вывесок"),
    MRGP("Перечень программ"),
    MR_PROGRAM_OBJ("Объекты по программе Мой район"),
    MR_PROGRAM_ORDER("Поручения Мэра по программе Мой район"),
    UGD_UPSD("УПСД. Решения об утверждении проектной документации"),
    UGD_OATI("ОАТИ. Уведомления"),
    EAIST("Реестр заказчиков ЕАИСТ");


    private final String value;

    Registers(String value) {
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
