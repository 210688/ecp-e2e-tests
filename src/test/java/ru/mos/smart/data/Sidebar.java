package ru.mos.smart.data;

public enum Sidebar {

    SERVICES_AND_FUNCTION( "Госуслуги и функции"),
    TASK( "Задачи"),
    ACTIONS("Возможности"),
    INFORMATION( "Информация"),
    REGISTERS( "Реестры"),
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
