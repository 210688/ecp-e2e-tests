package ru.mos.smart.api.models.mkasdprv;

public class PguMockRequest {
    private Integer id;
    private String message;
    private String messageType;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageType() {
        return messageType;
    }
}
