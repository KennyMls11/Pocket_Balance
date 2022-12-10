package org.ada.mypocketbalance.exceptions;

public class ExistingResourceException extends RuntimeException {


    public static final String MESSAGE = "El recurso que se esta intentando crear, ya existe";



    public  ExistingResourceException() {
    }

    public ExistingResourceException(String message) {
        super(message);
    }
}
