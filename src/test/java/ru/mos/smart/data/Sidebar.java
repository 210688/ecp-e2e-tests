package ru.mos.smart.data;

public enum Sidebar {

    SERVICES_AND_FUNCTION("services_and_function", "Госуслуги и функции"),
    TASK("task", "Задачи"),
    ACTIONS("actions", "Возможности"),
    INFORMATION("information", "Информация"),
    REGISTERS("registers", "Реестры"),
    SETTINGS("settings", "Настройки"),
    REFERENCE_BOOKS("reference_book", "Справочники"),
    MAPS3D("map3d", "Цифровой двойник"),
    MAP("map", "Карта");

    private final String value;
    private final String ruName;

    Sidebar(String value, String ruName) {
        this.value = value;
        this.ruName = ruName;
    }

    public String ruName() {
        return ruName;
    }

    public String value() {
        return value;
    }
}
