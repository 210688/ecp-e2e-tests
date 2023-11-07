package ru.mos.smart.helpers.junit;

public class CustomAssertionError extends AssertionError {

    public CustomAssertionError (String message) {
        super(message);
    }
}
