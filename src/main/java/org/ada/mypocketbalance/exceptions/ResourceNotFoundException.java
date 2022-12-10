package org.ada.mypocketbalance.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public static final String MESSAGE = "El recurso consultado no existe.";

    public ResourceNotFoundException () {
        super(MESSAGE);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
