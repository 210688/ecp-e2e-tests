package ru.mos.smart.data.enums;

import static ru.mos.smart.config.ConfigHelper.IS_STAGE;

public enum Sidebar {

    SERVICES_AND_FUNCTION( "Госуслуги и функции"),
    TASK( "Задачи"),
    OPPORTUNITIES(IS_STAGE ? "Возможности LCS" : "Возможности"),
    INFORMATION( "Информация"),
    REGISTERS(IS_STAGE ? "Реестры LCS" : "Реестры"),
    SETTINGS("Настройки"),
    REFERENCE_BOOKS( "Справочники"),
    MAPS3D("Цифровой двойник"),
    MAP( "Карта");

    private final String value;

    Sidebar(String value) {
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
