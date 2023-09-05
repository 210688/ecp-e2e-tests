package ru.mos.smart.data;

public enum  RegisterObjectTypeDrone {

    AEROFOTO("Данные аэрофотосъемки");

    private final String droneDescription;

    RegisterObjectTypeDrone(String droneDescription) {
        this.droneDescription = droneDescription;
    }

    public String getDroneDescription() {
        return droneDescription;
    }
}
