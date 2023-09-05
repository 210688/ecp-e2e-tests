package ru.mos.smart.data;

public enum Sidebar {

    SERVICESANDFUNCTION("Госуслуги и функции"),
    TASK("Задачи"),
    ACTIONS("Возможности"),
    INFORMATION("Информация"),
    REGISTER("Реестры"),
    SETTINGS("Настройки"),
    REFERENCEBOOKS("Справочники");

    private final String value;

    Sidebar(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
