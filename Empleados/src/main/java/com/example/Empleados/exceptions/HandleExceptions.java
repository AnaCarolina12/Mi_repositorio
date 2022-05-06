package com.example.Empleados.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptions {

  @ExceptionHandler(NoContentException.class)
  public ResponseEntity<ErrorObject> handlerNoContentException(NoContentException e) {
    ErrorObject errorObject = new ErrorObject();
    errorObject.setMessage(e.getMessage());
    errorObject.setStatusCode(HttpStatus.NO_CONTENT.value());
    errorObject.setHttpStatus(HttpStatus.NO_CONTENT);

    return new ResponseEntity<>(errorObject, HttpStatus.OK);
    //representa una respuesta HTTP, con encabezado , cuerpo y estado

  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorObject> handlerNotFoundException(NotFoundException e) {
    ErrorObject errorObject = new ErrorObject();
    errorObject.setMessage(e.getMessage());
    errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
    errorObject.setHttpStatus(HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);

  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorObject> handlerBadRequestException(BadRequestException e) {
    ErrorObject errorObject = new ErrorObject();
    errorObject.setMessage(e.getMessage());
    errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
    errorObject.setHttpStatus(HttpStatus.BAD_REQUEST);

    return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);

  }
}
