package org.ada.mypocketbalance.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends  RuntimeException {

    @ExceptionHandler(ExistingResourceException.class)
    public ResponseEntity handleException(ExistingResourceException e) {

        return new ResponseEntity(ExistingResourceException.MESSAGE,
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleException(ResourceNotFoundException e) {

        return new ResponseEntity(e.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotAvaibe.class)
    public ResponseEntity handleException(ResourceNotAvaibe e) {

        return new ResponseEntity(e.getMessage(),
                HttpStatus.CONFLICT);
    }

}

/*crear la excepcion particular para que al consultar un producto q no exista o del q no tenemos stock suficiente me arroje un conflic y no un not found ej: 409 CONFLICT*/


