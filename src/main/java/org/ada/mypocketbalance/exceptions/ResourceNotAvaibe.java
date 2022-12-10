package org.ada.mypocketbalance.exceptions;

public class ResourceNotAvaibe extends RuntimeException {

    public static final String MESSAGE = "El recurso que se esta intentando crear, no existe ";



    public ResourceNotAvaibe() {
    }

    public ResourceNotAvaibe(String message) {
        super(message);
    }

}

