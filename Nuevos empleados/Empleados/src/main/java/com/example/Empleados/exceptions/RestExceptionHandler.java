package com.example.Empleados.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice:anotación que permite manejar las excepciones de nuestra aplicación
// en un componente de manejo global
@ControllerAdvice
public class RestExceptionHandler {

    //@ExceptionHandler: anotacion usada en métodos para
    //devolver el contenido de una respuesta personalizada al usuario
    @ExceptionHandler
    public ResponseEntity<ErrorObject> handlerNoContentException(NoContentException e){
        ErrorObject errorObject= new ErrorObject();
        errorObject.setMessage(e.getMessage());
        errorObject.setStatusCode(HttpStatus.NO_CONTENT.value());
        errorObject.setHttpStatus(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(errorObject,HttpStatus.OK);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handlerNotFoundException(NotFoundException e){
        ErrorObject errorObject= new ErrorObject();
        errorObject.setMessage(e.getMessage());
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setHttpStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(errorObject,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handlerBadRequestException(BadRequestException e){
        ErrorObject errorObject= new ErrorObject();
        errorObject.setMessage(e.getMessage());
        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorObject.setHttpStatus(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(errorObject,HttpStatus.BAD_REQUEST);

    }

}
